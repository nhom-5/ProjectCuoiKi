package com.example.thanhnguyen.currencyconversion;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {

    EditText chieucao;
    EditText cannang;
    Button btn;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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
                    if(ketqua <18.5){
                        textview.setText(String.valueOf(ketqua + "\n Thiếu Cân"));
                    }
                    if(ketqua >18.5 &&ketqua<22.99){
                        textview.setText(String.valueOf(ketqua + "\n Bình Thường"));
                    }
                    if(ketqua >23.0&&ketqua<24.99){
                        textview.setText(String.valueOf(ketqua + "\n Thừa Cân"));
                    }
                    if(ketqua >=25.0){
                        textview.setText(String.valueOf(ketqua + "\n Béo Phì"));
                    }
                    if(ketqua >25.0&&ketqua<29.99){
                        textview.setText(String.valueOf(ketqua + "\n Béo Phì Độ 1"));
                    }
                    if(ketqua >30.0&&ketqua<39.99){
                        textview.setText(String.valueOf(ketqua + "\n Béo Phì Độ 2"));
                    }
                    if(ketqua >=40.0){
                        textview.setText(String.valueOf(ketqua + "\n Béo Phì Độ 3"));
                    }
                }
            }
        });
    }
}
