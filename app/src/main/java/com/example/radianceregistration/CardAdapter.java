package com.example.radianceregistration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class CardAdapter extends PagerAdapter {

    List<String> stringlist;
    Context context;
    LayoutInflater layoutInflater;



    public CardAdapter(List<String> stringlist, Context context) {
        this.stringlist = stringlist;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stringlist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.carditem,container,false);
        TextView txt = (TextView)view.findViewById(R.id.carditemin);
        txt.setText(stringlist.get(position));
        container.addView(view);
        return view;
    }
}
