package com.example.radianceregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class Cardcontent extends AppCompatActivity {
    HorizontalInfiniteCycleViewPager viewPager;
    List<Event> eventList = new ArrayList<>();
    TextView eventsname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardcontent);

        initData();
        eventsname = findViewById(R.id.event_title);
        viewPager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.view_pager);
        MyAdapter adapter = new MyAdapter(this, eventList);
        viewPager.setAdapter(adapter);

    }

    private void initData() {
        eventList.add(new Event("CODE WARS", R.drawable.codewar));
        eventList.add(new Event("RECODE IT", R.drawable.recodeit));
        eventList.add(new Event("QUIZ MASTER", R.drawable.pic3));
        eventList.add(new Event("SHUTTER UP", R.drawable.up));
    }

    public void onClick(View view) {
//        if(view.getId() == R.id.event_image)
//        {
//            Intent intent = new Intent(this,SecondPage.class);
//            startActivity(intent);
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
//        }
     /*   switch(view.getId())
        {
            case R.id.event_image:
                Intent intent = new Intent(this,SecondPage.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
                    break;
            case 2:Intent intent1 = new Intent(this,ThirdPage.class);
                    startActivity(intent1);
                    overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
                    break;
            case 3:Intent intent2 = new Intent(this,ForthPage.class);
                    startActivity(intent2);
                    overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
                    break;
            case 4:Intent intent3 = new Intent(this,SecondPage.class);
                    startActivity(intent3);
                    overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
                    break;

        }*/
        //    String txt=eventsname.getText().toString();

      /* eventList.contains()
        if (eventList.get(m).getName() == "CODE WARS") {
            Intent intent = new Intent(this, SecondPage.class);
            startActivity(intent);
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

        }
        else if (eventList.get(m).getName() == "RECODE IT") {
            Intent intent = new Intent(this, ThirdPage.class);
            startActivity(intent);
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

        }
        else if (eventList.get(m).getName() == "QUIZ MASTER") {
            Intent intent = new Intent(this, ForthPage.class);
            startActivity(intent);
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

        }

    }*/
    }
}
