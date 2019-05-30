package com.example.thanhnguyen.currencyconversion;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowResultBMI extends AppCompatActivity {

    ArrayList<Object> arrayDataKH;
    Cursor cursor;
    SQLite data;
    ListView list;
    Button timkiem, load, back;
    EditText ngaykt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result_bmi);

        list = findViewById(R.id.list);
        timkiem = findViewById(R.id.btnTimkiem);
        load = findViewById(R.id.btnLoad);
        back = findViewById(R.id.btnSua);
        ngaykt = findViewById(R.id.ngaykt);

        data = new SQLite(ShowResultBMI.this, "BMI_Manage.sqlite", null, 1);
        LoadData();

        timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ngaykt.getText().toString().trim().equals("")) {
                    arrayDataKH = new ArrayList<>();
                    Cursor cursor = data.TruyVanTraVe("Select * from BMI where ngay like '%" + ngaykt.getText().toString().trim() + "%'");
                    while (cursor.moveToNext()) {
                        arrayDataKH.add(new Object(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                    }
                    BMIAdapter adapter = new BMIAdapter(ShowResultBMI.this, R.layout.item, arrayDataKH);
                    list.setAdapter(adapter);
                } else {
                    LoadData();
                }
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadData();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getIntent());
                String resultNgay = intent.getStringExtra("resultNgay");
                String bmi = intent.getStringExtra("bmi");
                String result = intent.getStringExtra("result");

                final Dialog dialog = new Dialog(ShowResultBMI.this);
                dialog.setTitle("So sánh kết quả");
                dialog.setContentView(R.layout.activity_sosanh);
                TextView ngaynow = dialog.findViewById(R.id.ngaynow);
                TextView bminow = dialog.findViewById(R.id.bminow);
                TextView kqnow = dialog.findViewById(R.id.kqnow);
                TextView ngaypast = dialog.findViewById(R.id.ngaypast);
                TextView bmipast = dialog.findViewById(R.id.bmipast);
                TextView kqpast = dialog.findViewById(R.id.kqpast);

                ngaynow.setText(resultNgay);
                bminow.setText(bmi);
                kqnow.setText(result);
                ngaypast.setText(arrayDataKH.get(position).getNgay());
                bmipast.setText(arrayDataKH.get(position).getBmi());
                kqpast.setText(arrayDataKH.get(position).getKetqua());
                dialog.show();

            }
        });
    }

    private void LoadData() {
        arrayDataKH = new ArrayList<>();
        cursor = data.TruyVanTraVe("Select * From BMI");
        while (cursor.moveToNext()) {
            arrayDataKH.add(new Object(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
        BMIAdapter adapter = new BMIAdapter(ShowResultBMI.this, R.layout.itembmi, arrayDataKH);
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);
    }
}
