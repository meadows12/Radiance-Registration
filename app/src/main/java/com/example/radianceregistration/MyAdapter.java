package com.example.radianceregistration;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Iterator;
import java.util.List;

public class MyAdapter extends PagerAdapter {

    Context context;
    List<Event> eventList;

    public MyAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container,int position,@NonNull Object object)
    {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);

        ImageView event_image = (ImageView)view.findViewById(R.id.event_image);
        final TextView event_title = (TextView)view.findViewById(R.id.event_title);

        event_image.setImageResource(eventList.get(position).getImage());
        event_title.setText(eventList.get(position).getName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(event_title.getText().toString()=="CODE WARS") {
                    Toast.makeText(context, "Will give Description", Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(new Intent(context, SecondPage.class));


                }
                else if(event_title.getText().toString()=="RECODE IT") {
                    Toast.makeText(context, "Will give Description2", Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(new Intent(context, ThirdPage.class));
                }
                else if(event_title.getText().toString()=="QUIZ MASTER") {
                    Toast.makeText(context, "Will give Description3", Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(new Intent(context, ForthPage.class));
                }
                else if(event_title.getText().toString()=="SHUTTER UP") {
                    Toast.makeText(context, "Will give Description4", Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(new Intent(context, FifthPage.class));
                }
            }
        });

        container.addView(view);
        return view;
    }

}
