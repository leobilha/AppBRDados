package com.leobilha.covinfo.home;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.leobilha.covinfo.R;

public class Sobre extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        TextView textView =(TextView)findViewById(R.id.leoBilha);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.linkedin.com/in/leonardo-bilha-terragno-614943124/'>Leonardo Terragno</a>";
        textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));


    }
}
