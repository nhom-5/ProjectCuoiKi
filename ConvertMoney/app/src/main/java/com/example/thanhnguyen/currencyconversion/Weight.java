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

public class Weight extends AppCompatActivity {

    private String ketqua1 = "", ketqua2 = "";
    double et1;
    long et2;
    EditText edit1;
    TextView edit2, select1, select2;
    Button btn;
    String arr[]={
            "Tấn",
            "Tạ",
            "Kg",
            "g"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Spinner spin1=(Spinner) findViewById(R.id.FormList);
        select1 = findViewById(R.id.select1);
        select2 = findViewById(R.id.select2);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spin1.setAdapter(adapter);
        Spinner spin2=(Spinner) findViewById(R.id.ToList);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spin2.setAdapter(adapter);

        //bắt sự kiện
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ketqua1 = arr[position];
                select1.setText(ketqua1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Weight.this, "Bạn chưa chọn đơn vị", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Weight.this, "Bạn chưa nhập giá trị cần chuyển đổi", Toast.LENGTH_SHORT).show();
                }
                else {
                    //kết quả 1 giảm dần
                    if ((ketqua1.equals("Tấn") && ketqua2.equals("Tạ")) || (ketqua1.equals("Tạ") && ketqua2.equals("Kg")) || (ketqua1.equals("Kg") && ketqua2.equals("g"))) {
                        et2 = (long) 100 * Integer.parseInt(edit1.getText().toString());
                        edit2.setText(String.valueOf(et2));
                    }
                    if ((ketqua1.equals("Tấn") && ketqua2.equals("Kg")) || (ketqua1.equals("Tạ") && ketqua2.equals("g"))) {
                        et2 = (long) 100 * 100 * Integer.parseInt(edit1.getText().toString());
                        edit2.setText(String.valueOf(et2));
                    }
                    if ((ketqua1.equals("Tấn") && ketqua2.equals("g"))) {
                        et2 = (long) 100 * 100 * 100 * Integer.parseInt(edit1.getText().toString());
                        edit2.setText(String.valueOf(et2));
                    }
                    if ((ketqua1.equals("Tấn") && ketqua2.equals("Tấn")) || (ketqua1.equals("Tạ") && ketqua2.equals("Tạ")) || (ketqua1.equals("Kg") && ketqua2.equals("Kg")) || (ketqua1.equals("g") && ketqua2.equals("g"))) {
                        Toast.makeText(Weight.this, "Cùng đơn vị thì đổi cái giề ?", Toast.LENGTH_SHORT).show();
                    }
                    //kết quả 1 tăng dần
                    if ((ketqua1.equals("g") && ketqua2.equals("Kg")) || (ketqua1.equals("Kg") && ketqua2.equals("Tạ")) || (ketqua1.equals("Tạ") && ketqua2.equals("Tấn"))) {
                        et1 = (double) Integer.parseInt(edit1.getText().toString()) / 100;
                        edit2.setText(String.valueOf(et1));
                    }
                    if ((ketqua1.equals("g") && ketqua2.equals("Tạ")) || (ketqua1.equals("Kg") && ketqua2.equals("Tấn"))) {
                        et1 = (double) Integer.parseInt(edit1.getText().toString()) / Math.pow(100, 2);
                        edit2.setText(String.valueOf(et1));
                    }
                    if ((ketqua1.equals("g") && ketqua2.equals("Tấn"))) {
                        et1 = (double) Integer.parseInt(edit1.getText().toString()) / Math.pow(100, 3);
                        edit2.setText(String.valueOf(et1));
                    }
                }

            }
        });
    }
}
