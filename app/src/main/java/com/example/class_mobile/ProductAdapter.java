package com.example.class_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<SubProduct>{
    private Context mContext;
    private int mResourece;

    public ProductAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SubProduct> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResourece = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResourece,parent,false);

        ImageView imageView = convertView.findViewById(R.id.image);

        TextView txtName = convertView.findViewById(R.id.txtName);

        imageView.setImageResource(getItem(position).getImage());

        txtName.setText(getItem(position).getName());

        return convertView;
    }
}
