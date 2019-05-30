package com.example.thanhnguyen.currencyconversion;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Temperature extends AppCompatActivity {

    String ketqua1 = "", ketqua2 = "";
    float et1;
    float et2;
    EditText edit1;
    TextView edit2, select1, select2;
    Button btn;
    String arr[]={
            "C",
            "K",
            "F"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Spinner spin1 = (Spinner) findViewById(R.id.FormList);
        select1 = findViewById(R.id.select1);
        select2 = findViewById(R.id.select2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                        this,
                        R.layout.support_simple_spinner_dropdown_item, arr
                );
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spin1.setAdapter(adapter);
        Spinner spin2 = (Spinner) findViewById(R.id.ToList);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        adapter1.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spin2.setAdapter(adapter1);

        //bắt sự kiện
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ketqua1 = arr[position];
                select1.setText(ketqua1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Temperature.this, "Bạn chưa chọn đơn vị", Toast.LENGTH_SHORT).show();
                ketqua1 = "";
            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ketqua2 = arr[position];
                select2.setText(ketqua2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ketqua2 = "";
            }
        });

        edit1 = findViewById(R.id.nhap1);
        edit2 = findViewById(R.id.nhap2);
        btn = findViewById(R.id.convert);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((edit1.getText().toString()).equals("")){
                    Toast.makeText(Temperature.this, "Bạn chưa nhập giá trị cần chuyển đổi", Toast.LENGTH_SHORT).show();
                }
                else {
                    Float cc = Float.parseFloat(edit1.getText().toString());
                    //Đổi từ F sang C và ngược lại
                    if (ketqua1.equals("F") && ketqua2.equals("C")) {
                        et2 = (float) ((cc-32)/1.8);
                        edit2.setText(String.valueOf(et2));
                    }
                    if (ketqua1.equals("C") && ketqua2.equals("F")) {
                        et2 = (float) (cc*1.8+32);
                        edit2.setText(String.valueOf(et2));
                    }
                    //Đổi từ F sang K và ngược lại
                    if (ketqua1.equals("F") && ketqua2.equals("C")) {
                        et2 = (float) ((cc-32)/1.8+273.15);
                        edit2.setText(String.valueOf(et2));
                    }
                    if (ketqua1.equals("K") && ketqua2.equals("F")) {
                        et2 = (float) ((cc-273.15)*1.8+32);
                        edit2.setText(String.valueOf(et2));
                    }
                    //Đổi từ C sang K
                    if (ketqua1.equals("K") && ketqua2.equals("C")) {
                        et2 = (float) (cc-273.15);
                        edit2.setText(String.valueOf(et2));
                    }
                    if (ketqua1.equals("C") && ketqua2.equals("K")) {
                        et2 = (float) ((cc-273.15)*1.8+32);
                        edit2.setText(String.valueOf(et2));
                    }
                    if ((ketqua1.equals("F") && ketqua2.equals("F")) || (ketqua1.equals("C") && ketqua2.equals("C")) || (ketqua1.equals("K") && ketqua2.equals("K"))) {
                        Toast.makeText(Temperature.this, "Cùng đơn vị thì đổi cái giề ?", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
