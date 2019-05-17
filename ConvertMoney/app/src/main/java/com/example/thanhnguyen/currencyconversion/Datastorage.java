package com.example.thanhnguyen.currencyconversion;

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

public class Datastorage extends AppCompatActivity {

    String ketqua1 = "", ketqua2 = "";
    double et1;
    long et2;
    EditText edit1;
    TextView edit2, select1, select2;
    Button btn;
    String arr[] = {
            "GB",
            "MB",
            "KB",
            "Byte",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datastore);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
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
                Toast.makeText(Datastorage.this, "Bạn chưa chọn đơn vị", Toast.LENGTH_SHORT).show();
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
                //ngoại lệ
                if ((edit1.getText().toString()).equals("")){
                    Toast.makeText(Datastorage.this, "Bạn chưa nhập giá trị cần chuyển đổi", Toast.LENGTH_SHORT).show();
                }
                else {
                    //kết quả 1 giảm dần
                    if ((ketqua1.equals("GB") && ketqua2.equals("MB")) || (ketqua1.equals("MB") && ketqua2.equals("KB")) || (ketqua1.equals("KB") && ketqua2.equals("Byte"))) {
                        et2 = (long) 1024 * Integer.parseInt(edit1.getText().toString());
                        edit2.setText(String.valueOf(et2));
                    }
                    if ((ketqua1.equals("GB") && ketqua2.equals("GB")) || (ketqua1.equals("MB") && ketqua2.equals("MB")) || (ketqua1.equals("KB") && ketqua2.equals("KB")) || (ketqua1.equals("Byte") && ketqua2.equals("Byte"))) {
                        Toast.makeText(Datastorage.this, "Cùng đơn vị thì đổi cái giề ?", Toast.LENGTH_SHORT).show();
                    }
                    if ((ketqua1.equals("GB") && ketqua2.equals("KB")) || (ketqua1.equals("MB") && ketqua2.equals("Byte"))) {
                        et2 = (long) 1024 * 1024 * Integer.parseInt(edit1.getText().toString());
                        edit2.setText(String.valueOf(et2));
                    }
                    if ((ketqua1.equals("GB") && ketqua2.equals("Byte"))) {
                        et2 = (long) 1024 * 1024 * 1024 * Integer.parseInt(edit1.getText().toString());
                        edit2.setText(String.valueOf(et2));
                    }
                    //kết quả 1 tăng dần
                    if ((ketqua1.equals("Byte") && ketqua2.equals("KB")) || (ketqua1.equals("KB") && ketqua2.equals("MB")) || (ketqua1.equals("MB") && ketqua2.equals("GB"))) {
                        et1 = (double) Integer.parseInt(edit1.getText().toString()) / 1024;
                        edit2.setText(String.valueOf(et1));
                    }
                    if ((ketqua1.equals("Byte") && ketqua2.equals("MB")) || (ketqua1.equals("KB") && ketqua2.equals("GB"))) {
                        et1 = (double) Integer.parseInt(edit1.getText().toString()) / Math.pow(1024, 2);
                        edit2.setText(String.valueOf(et1));
                    }
                    if ((ketqua1.equals("Byte") && ketqua2.equals("GB"))) {
                        et1 = (double) Integer.parseInt(edit1.getText().toString()) / Math.pow(1024, 3);
                        edit2.setText(String.valueOf(et1));
                    }
                }
            }
        });


    }
}
