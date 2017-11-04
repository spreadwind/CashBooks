package com.wind.cashbook;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wind.mvp.utils.LogUtil;

public class AddCostActivity extends AppCompatActivity {
    private static final String TAG = "AddCostActivity";
    private EditText edtMoney;
    private EditText edtNote;
    private TextView txtDate;
    private TextView txtType;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cost);
//        ButterKnife.bind(this);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


        edtMoney = (EditText) this.findViewById(R.id.edt_add_money);
        edtNote = (EditText) this.findViewById(R.id.edt_add_note);
        txtDate = (TextView) this.findViewById(R.id.txt_add_date);
        txtType = (TextView) this.findViewById(R.id.txt_add_type);

        Button btnSave = (Button) findViewById(R.id.btn_save);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addCostData();
                Toast.makeText(AddCostActivity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (AddCostActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
           }
        });
        //点击类型文本，进入选择类型界面
      /*  txtType.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AddCostActivity.this, DailyActivity.class);
                startActivityForResult(intent, 1);
            }
        });*/

        /*
         *选择日期，默认为当天，当点击另选其它时间
         */
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH) + 1;
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        txtDate.setText(year + "-" + month + "-" + day);
        //点击日期文本，进入更改日期界面
        txtDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AddCostActivity.this, DateActivity.class);
                startActivityForResult(intent,2);
            }
        });

    }
        //接收返回的类型\时间
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String type = data.getStringExtra("type_return");
                    LogUtil.d(TAG, type);
                    txtType.setText(type);
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    String date = data.getStringExtra("date_return");
                    LogUtil.d(TAG, date);
                    txtDate.setText(date);
                }
                break;
            default:
        }
    }
    private void addCostData() {
        //往数据库添加数据
   /*     Daily daily = new Daily();
        daily.setType(txtType.getText().toString());
        daily.setMoney(edtMoney.getText().toString());
        daily.setDate(txtDate.getText().toString());
        daily.setNote(edtNote.getText().toString());
        daily.save();
        daily.notify();*/
    }
}
