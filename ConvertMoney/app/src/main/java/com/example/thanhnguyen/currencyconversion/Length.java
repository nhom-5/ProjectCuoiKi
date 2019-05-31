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

public class Length extends AppCompatActivity {

    String ketqua1 = "", ketqua2 = "";
    String result;
    float et1;
    EditText edit1;
    TextView edit2,select1, select2;
    Button btn;
    String arr[]={
            "Km",
            "M",
            "Dm",
            "Cm",
            "Mm",
            "Hải lý",
            "inch",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
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
                Toast.makeText(Length.this, "Bạn chưa chọn đơn vị", Toast.LENGTH_SHORT).show();
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
                if ((edit1.getText().toString()).equals("")) {
                    Toast.makeText(Length.this, "Bạn chưa nhập giá trị cần chuyển đổi", Toast.LENGTH_SHORT).show();
                } else {
                    //kết quả 1 giảm dần

                    //doi don vi hai ly giam dan
                    if (ketqua1.equals("Hải lý") && ketqua2.equals("Km")) {
                        et1 = 1852 * Float.parseFloat(edit1.getText().toString()) / 1000;

                    }
                    else if (ketqua1.equals("Hải lý") && ketqua2.equals("M")) {
                        et1 = 1852 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if (ketqua1.equals("Hải lý") && ketqua2.equals("Dm")) {
                        et1 = 1852 * 10 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if (ketqua1.equals("Hải lý") && ketqua2.equals("Cm")) {
                        et1 = 1852 * 100 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if (ketqua1.equals("Hải lý") && ketqua2.equals("Mm")) {
                        et1 = 1852 * 1000 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if (ketqua1.equals("Hải lý") && ketqua2.equals("inch")) {
                        et1 = 1852 * 10000 * Float.parseFloat(edit1.getText().toString()) / 254;


                    }

                    //doi tu inch giam dan
                    else if (ketqua1.equals("inch") && ketqua2.equals("Km")) {
                        et1 = 254 * Float.parseFloat(edit1.getText().toString()) / (10000*1000);

                    }
                    else if (ketqua1.equals("inch") && ketqua2.equals("M")) {
                        et1 = 254 * Float.parseFloat(edit1.getText().toString()) / 10000;

                    }
                    else if (ketqua1.equals("inch") && ketqua2.equals("Dm")) {
                        et1 = 254 * Float.parseFloat(edit1.getText().toString()) / 1000;

                    }
                    else if (ketqua1.equals("inch") && ketqua2.equals("Cm")) {
                        et1 = 254 * Float.parseFloat(edit1.getText().toString()) / 100;

                    }
                    else if (ketqua1.equals("inch") && ketqua2.equals("Mm")) {
                        et1 = 254 * Float.parseFloat(edit1.getText().toString()) / 10;

                    }
                    else if (ketqua1.equals("inch") && ketqua2.equals("Hải lý")) {
                        et1 = 254 * Float.parseFloat(edit1.getText().toString()) / (10000*1852);

                    }

                    //doi tu km

                    else if (ketqua1.equals("Km") && ketqua2.equals("Mm")) {
                        et1 = 1000 * 1000 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if (ketqua1.equals("Km") && ketqua2.equals("Cm")) {
                        et1 = 1000 * 100 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if (ketqua1.equals("Km") && ketqua2.equals("Dm")) {
                        et1 = 1000 * 10 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if ((ketqua1.equals("Km") && ketqua2.equals("M")) || (ketqua1.equals("M") && ketqua2.equals("Mm"))) {
                        et1 = 1000 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if ((ketqua1.equals("M") && ketqua2.equals("Dm")) || (ketqua1.equals("Dm") && ketqua2.equals("Cm")) || (ketqua1.equals("Cm") && ketqua2.equals("Mm"))) {
                        et1 = 10 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if ((ketqua1.equals("M") && ketqua2.equals("Cm")) || (ketqua1.equals("Dm") && ketqua2.equals("Mm"))) {
                        et1 = 100 * Float.parseFloat(edit1.getText().toString());

                    }
                    else if ((ketqua1.equals("Km") && ketqua2.equals("Km")) || (ketqua1.equals("M") && ketqua2.equals("M")) || (ketqua1.equals("Cm") && ketqua2.equals("Cm")) || (ketqua1.equals("Dm") && ketqua2.equals("Dm")) || (ketqua1.equals("Mm") && ketqua2.equals("Mm")) || (ketqua1.equals("inch") && ketqua2.equals("inch")) || (ketqua1.equals("Hải lý") && ketqua2.equals("Hải lý"))) {
                        Toast.makeText(Length.this, "Cùng đơn vị thì đổi cái giề ?", Toast.LENGTH_SHORT).show();
                    }
                    //kết quả 1 tăng dần

                    //doi hai ly tang dan

                    else if (ketqua1.equals("Km") && ketqua2.equals("Hải lý")) {
                        et1 = 1000 * Float.parseFloat(edit1.getText().toString()) / 1852;

                    }
                    else if (ketqua1.equals("M") && ketqua2.equals("Hải lý")) {
                        et1 = Float.parseFloat(edit1.getText().toString()) / 1852;

                    }
                    else if (ketqua1.equals("Dm") && ketqua2.equals("Hải lý")) {
                        et1 = 10 * Float.parseFloat(edit1.getText().toString()) / 1852;

                    }
                    else if (ketqua1.equals("Cm") && ketqua2.equals("Hải lý")) {
                        et1 = 100 * Float.parseFloat(edit1.getText().toString()) / 1852;

                    }
                    else if (ketqua1.equals("Mm") && ketqua2.equals("Hải lý")) {
                        et1 = 1000 * Float.parseFloat(edit1.getText().toString()) / 1852;

                    }

                    //doi inch tang dan

                    else if (ketqua1.equals("Km") && ketqua2.equals("inch")) {
                        et1 = 1000 * 10000 * Float.parseFloat(edit1.getText().toString()) / 254;

                    }
                    else if (ketqua1.equals("M") && ketqua2.equals("inch")) {
                        et1 = 10000 * Float.parseFloat(edit1.getText().toString()) / 254;

                    }
                    else if (ketqua1.equals("Dm") && ketqua2.equals("inch")) {
                        et1 = 10000 * Float.parseFloat(edit1.getText().toString()) / (254 * 10);

                    }
                    else if (ketqua1.equals("Cm") && ketqua2.equals("inch")) {
                        et1 = 10000 * Float.parseFloat(edit1.getText().toString()) / (254 * 100);

                    }
                    else if (ketqua1.equals("Mm") && ketqua2.equals("inch")) {
                        et1 = 10000 * Float.parseFloat(edit1.getText().toString()) / (254 * 1000);

                    }

                    // doi km tang dan
                    else if (ketqua1.equals("Mm") && ketqua2.equals("Km")) {
                        et1 = Float.parseFloat(edit1.getText().toString()) / (1000 * 1000);

                    }
                    else if (ketqua1.equals("Cm") && ketqua2.equals("Km")) {
                        et1 = Float.parseFloat(edit1.getText().toString()) / (1000 * 100);

                    }
                    else if (ketqua1.equals("Dm") && ketqua2.equals("Km")) {
                        et1 = Float.parseFloat(edit1.getText().toString()) / (1000 * 10);

                    }
                    else if ((ketqua1.equals("M") && ketqua2.equals("Km")) || (ketqua1.equals("Mm") && ketqua2.equals("M"))) {
                        et1 = Float.parseFloat(edit1.getText().toString()) / 1000;

                    }
                    else if ((ketqua1.equals("Mm") && ketqua2.equals("Dm")) || (ketqua1.equals("Cm") && ketqua2.equals("M"))) {
                        et1 = Float.parseFloat(edit1.getText().toString()) / 100;

                    }
                    else if ((ketqua1.equals("Mm") && ketqua2.equals("Cm")) || (ketqua1.equals("Cm") && ketqua2.equals("Dm")) || (ketqua1.equals("Dm") && ketqua2.equals("M"))) {
                        et1 = Float.parseFloat(edit1.getText().toString()) / 10;

                    }
//
                    result = Float.toString(et1);
                    if(result.split("\\.0").length == 1){

                        edit2.setText(result.split("\\.0")[0]);
                    }
                    else{
                        edit2.setText(result);
                    }
                }

            }
        });
    }
}
