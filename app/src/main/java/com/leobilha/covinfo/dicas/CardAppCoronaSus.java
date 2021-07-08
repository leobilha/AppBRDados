package com.leobilha.covinfo.dicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.leobilha.covinfo.R;

public class CardAppCoronaSus extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_app_corona_sus);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(
                "https://play.google.com/store/apps/details?id=br.gov.datasus.guardioes"));
        intent.setPackage("com.android.vending");
        startActivity(intent);

    }

}
