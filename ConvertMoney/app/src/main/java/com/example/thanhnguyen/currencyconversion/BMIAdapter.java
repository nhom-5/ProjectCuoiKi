package com.example.thanhnguyen.currencyconversion;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BMIAdapter extends ArrayAdapter<Object> {
    Activity context;
    int resource;
    List<Object> objects;

    /**
     * @param context
     * @param resource
     * @param objects
     */
    public BMIAdapter(Activity context, int resource, List<Object> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView ngay = (TextView) row.findViewById(R.id.ngay);
        TextView bmi = (TextView) row.findViewById(R.id.bmi);
        TextView ketqua = (TextView) row.findViewById(R.id.kq);
        /** Set data to row*/
        final Object ob = this.objects.get(position);
        ngay.setText(ob.getNgay());
        bmi.setText(ob.getBmi());
        ketqua.setText(ob.getKetqua());

        return row;
    }
}
