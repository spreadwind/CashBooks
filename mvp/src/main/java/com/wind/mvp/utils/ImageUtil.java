package com.wind.mvp.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.wind.mvp.network.RequestManager;

/**
 * Created by H on 2017/10/23.
 * Volley自身的图片加载功能
 */

public class ImageUtil {
    public static void loadImage(String url, ImageView iv, int placeHolder, int errorHolder) {
        ImageLoader loader = new ImageLoader(
                RequestManager.getInstance().getRequestQueue(), new BitmapCache());
        if (iv instanceof NetworkImageView) {
            ((NetworkImageView) iv).setDefaultImageResId(placeHolder);
            ((NetworkImageView) iv).setErrorImageResId(errorHolder);
            ((NetworkImageView) iv).setImageUrl(url, loader);
        } else {
            ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv,
                    placeHolder, errorHolder);
            loader.get(url, listener);
        }
    }

    private static class BitmapCache implements ImageLoader.ImageCache {
        private LruCache<String, Bitmap> cache;
        private final int maxSize = 10 * 1024 * 1024;//缓存大小设为10M

        BitmapCache() {
            cache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getByteCount() / 1024;
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return cache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            cache.put(url, bitmap);
        }
    }

}
