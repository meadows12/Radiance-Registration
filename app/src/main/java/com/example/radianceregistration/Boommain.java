package com.example.radianceregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.nightonke.boommenu.Animation.BoomEnum;
import com.nightonke.boommenu.Animation.EaseEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.List;

public class Boommain extends AppCompatActivity {
    List<Event> eventList = new ArrayList<>();
    BoomMenuButton bbb;
    ImageView pascw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boommain);
        bbb = findViewById(R.id.bbb);
//        pascw=findViewById(R.id.pasc);
        bbb.setBoomEnum(BoomEnum.PARABOLA_2);
        bbb.setShowRotateEaseEnum(EaseEnum.EaseOutBack);
        bbb.setUse3DTransformAnimation(true);

        datado();

        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        CardAdapter cardAdapter =  new CardAdapter(eventList,getBaseContext());
        pager.setAdapter(cardAdapter);

        for (int i = 0; i < bbb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder();

            switch (i) {
                case 0:
                    builder.normalText("REGISTER")
                            .normalImageRes(R.drawable.ic_edit)
                            .imagePadding(new Rect(15,15,15,15))
                            .normalTextColor(R.color.black)
                            .highlightedTextColor(R.color.blue)
                            .normalColorRes(R.color.colorAccent)
                            .listener(new OnBMClickListener() {
                                @Override
                                public void onBoomButtonClick(int index) {
                                    HandleBoomMenuClick(index);
                                }
                            });
                    break;
                case 1:
                    builder.normalText("ABOUT US")
                            .normalImageRes(R.drawable.ic_aboutus)
                            .imagePadding(new Rect(15,15,15,15))
                            .normalColorRes(R.color.colorAccent)
                            .normalTextColor(R.color.black)
                            .highlightedTextColor(R.color.blue)
                            .listener(new OnBMClickListener() {
                                @Override
                                public void onBoomButtonClick(int index) {
                                    HandleBoomMenuClick(index);
                                }
                            });
                    break;
                case 2:
                    builder.normalText("CONTACT US")
                            .normalImageRes(R.drawable.ic_contactus)
                            .imagePadding(new Rect(15,15,15,15))
                            .normalTextColor(R.color.black)
                            .normalColorRes(R.color.colorAccent)
                            .highlightedTextColor(R.color.blue)
                            .listener(new OnBMClickListener() {
                                @Override
                                public void onBoomButtonClick(int index) {
                                    HandleBoomMenuClick(index);
                                }
                            });
                    break;
                case 3:
                    builder.normalText("VOLUNTEER SIGN IN")
                            .normalImageRes(R.drawable.ic_sign)
                            .imagePadding(new Rect(15,15,15,15))
                            .normalTextColor(R.color.black)
                            .normalColorRes(R.color.colorAccent)
                            .highlightedTextColor(R.color.blue)
                            .listener(new OnBMClickListener() {
                                @Override
                                public void onBoomButtonClick(int index) {
                                    HandleBoomMenuClick(index);
                                }
                            });

                default:
            }
            bbb.addBuilder(builder);


        }
    }

    private void HandleBoomMenuClick(int index) {
        if (index < bbb.getPiecePlaceEnum().pieceNumber()) {
            Intent intent;

            switch (index) {
                case 0:
                    intent = new Intent(this, nonvolunteer.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(this, Main4Activity.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(this, Main5Activity.class);
                    startActivity(intent);
                case 3:
                    intent = new Intent(this,Sign.class);
                    startActivity(intent);
                    break;
                default:
            }
        }
    }

    private void datado() {

        eventList.add(new Event("CODE WARS", R.drawable.circlecodewar));
        eventList.add(new Event("RECODE IT", R.drawable.circlerecode));
        eventList.add(new Event("QUIZ MASTER", R.drawable.quiz_mastericon));
        eventList.add(new Event("SHUTTER UP", R.drawable.circleshutter));
    }
}
