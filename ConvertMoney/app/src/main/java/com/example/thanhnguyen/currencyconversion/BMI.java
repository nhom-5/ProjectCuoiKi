package com.example.thanhnguyen.currencyconversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class BMI extends AppCompatActivity {

    EditText chieucao;
    EditText cannang;
    Button btn;
    TextView textview;
    SQLite data;
    String[] BMI;
    Calendar c = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        data = new SQLite(BMI.this, "BMI_Manage.sqlite", null, 1);
        data.TruyVanKhongTraVe("Create Table If not exists BMI(id Integer Primary Key Autoincrement , ngay Varchar , bmi Varchar, ketqua Varchar)");

        chieucao = findViewById(R.id.nhapcao);
        cannang = findViewById(R.id.nhapki);
        btn = findViewById(R.id.nut);
        textview = findViewById(R.id.showketqua);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((chieucao.getText().toString()).equals("") || (cannang.getText().toString()).equals("")) {
                    Toast.makeText(BMI.this, "Bạn chưa nhập giá trị cần chuyển đổi", Toast.LENGTH_SHORT).show();
                }
                else{
                    Float cc = Float.parseFloat(chieucao.getText().toString());
                    Float cn = Float.parseFloat(cannang.getText().toString());
                    double ketqua;
                    ketqua = (cn/Math.pow(cc,2))*10000;
                    String bmi = String.format("%.2f", ketqua);
                    if(ketqua <18.5){
                        textview.setText(String.valueOf(bmi + "\n Thiếu Cân"));
                    }
                    if(ketqua >18.5 &&ketqua<22.99){
                        textview.setText(String.valueOf(bmi + "\n Bình Thường"));
                    }
                    if(ketqua >23.0&&ketqua<24.99){
                        textview.setText(String.valueOf(bmi + "\n Thừa Cân"));
                    }
                    if(ketqua >=25.0){
                        textview.setText(String.valueOf(bmi + "\n Béo Phì"));
                    }
                    if(ketqua >25.0&&ketqua<29.99){
                        textview.setText(String.valueOf(bmi + "\n Béo Phì Độ 1"));
                    }
                    if(ketqua >30.0&&ketqua<39.99){
                        textview.setText(String.valueOf(bmi + "\n Béo Phì Độ 2"));
                    }
                    if(ketqua >=40.0){
                        textview.setText(String.valueOf(bmi + "\n Béo Phì Độ 3"));
                    }
                }
            }
        });
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ketqua = textview.getText().toString();
                BMI = ketqua.split("\n");

                data.TruyVanKhongTraVe("Insert into BMI values (null, '"  + showCalendar(c) + "','" + BMI[0] + "','" + BMI[1] + "')");

                Intent activitymoi =new Intent(BMI.this,ShowResultBMI.class);
                activitymoi.putExtra("resultNgay", showCalendar(c));
                activitymoi.putExtra("bmi", BMI[0]);
                activitymoi.putExtra("result", BMI[1]);
                startActivity(activitymoi);
            }
        });
    }

    public static String showCalendar(Calendar c) {
        int year = c.get(Calendar.YEAR);

        // Trả về giá trị từ 0 - 11
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
//        int millis = c.get(Calendar.MILLISECOND);

        return " " + day + "-" + (month + 1) + "-" + year //
                + "\n" + hour + ":" + minute;
    }
}
