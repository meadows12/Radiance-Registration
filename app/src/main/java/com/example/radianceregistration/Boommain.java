package com.example.radianceregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.nightonke.boommenu.Animation.BoomEnum;
import com.nightonke.boommenu.Animation.EaseEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.List;

public class Boommain extends AppCompatActivity {
    List<String> stringlist = new ArrayList<>();
    BoomMenuButton bbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boommain);
        bbb = findViewById(R.id.bbb);
        bbb.setBoomEnum(BoomEnum.PARABOLA_2);
        bbb.setShowRotateEaseEnum(EaseEnum.EaseOutBack);
        bbb.setUse3DTransformAnimation(true);

        datado();

        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        CardAdapter cardAdapter =  new CardAdapter(stringlist,getBaseContext());
        pager.setAdapter(cardAdapter);

        for (int i = 0; i < bbb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder();

            switch (i) {
                case 0:
                    builder.normalText("REGISTER")
                            .normalTextColor(R.color.black)
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
                            .normalColorRes(R.color.colorAccent)
                            .normalTextColor(R.color.black)
                            .listener(new OnBMClickListener() {
                                @Override
                                public void onBoomButtonClick(int index) {
                                    HandleBoomMenuClick(index);
                                }
                            });
                    break;
                case 2:
                    builder.normalText("CONTACT US")
                            .normalTextColor(R.color.black)
                            .normalColorRes(R.color.colorAccent)
                            .listener(new OnBMClickListener() {
                                @Override
                                public void onBoomButtonClick(int index) {
                                    HandleBoomMenuClick(index);
                                }
                            });
                    break;
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
                    intent = new Intent(this, Registration.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(this, Main4Activity.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(this, Main5Activity.class);
                    startActivity(intent);

                    break;
                default:
            }
        }
    }

    private void datado() {

        stringlist.add("arhbabrhdbsjkablkjewbqiluwbn cnx vnl ZLjehiqwulehuiebfjal");
        stringlist.add("jrghareuygqtahyvhjad");
        stringlist.add("uirhbvaehb nmbm,ae");
        stringlist.add("awkbhjwabnvkyawgej,ea");
    }
}
