package com.leobilha.covinfo.dicas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.leobilha.covinfo.R;

public class OQuePrecisoSaber extends AppCompatActivity implements View.OnClickListener {

    private CardView covid, sintomas, transmitido, diagnostico, proteger, doente,
                    servicoSaude, fakeNews, painelCovid, appSus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_que_preciso_saber);

        covid = (CardView) findViewById(R.id.cvCOVID);
        sintomas = (CardView) findViewById(R.id.cvSintomas);
        transmitido = (CardView) findViewById(R.id.cvTransmissao);
        diagnostico = (CardView) findViewById(R.id.cvDiagnostico);
        proteger = (CardView) findViewById(R.id.cvProteger);
        doente = (CardView) findViewById(R.id.cvDoente);
        servicoSaude = (CardView) findViewById(R.id.cvServicoSaude);
        fakeNews = (CardView) findViewById(R.id.cvFakeNews);
        painelCovid = (CardView) findViewById(R.id.cvPainel);
        appSus = (CardView) findViewById(R.id.cvAppCoronaSUS);

        covid.setOnClickListener(this);
        sintomas.setOnClickListener(this);
        transmitido.setOnClickListener(this);
        diagnostico.setOnClickListener(this);
        proteger.setOnClickListener(this);
        doente.setOnClickListener(this);
        servicoSaude.setOnClickListener(this);
        fakeNews.setOnClickListener(this);
        painelCovid.setOnClickListener(this);
        appSus.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()) {
            case R.id.cvCOVID:
                i = new Intent(this, CardCovid19.class);
                startActivity(i);
                break;
            case R.id.cvSintomas:
                i = new Intent(this, CardSintomas.class);
                startActivity(i);
                break;
            case R.id.cvTransmissao:
                i = new Intent(this, CardTransmissao.class);
                startActivity(i);
                break;
            case R.id.cvDiagnostico:
                i = new Intent(this, CardDiagnostico.class);
                startActivity(i);
                break;
            case R.id.cvProteger:
                i = new Intent(this, CardProteger.class);
                startActivity(i);
                break;
            case R.id.cvDoente:
                i = new Intent(this, CardDoente.class);
                startActivity(i);
                break;
            case R.id.cvServicoSaude:
                i = new Intent(this, CardPainelLeitos.class);
                startActivity(i);
                break;
            case R.id.cvFakeNews:
                i = new Intent(this, CardFakeNews.class);
                startActivity(i);
                break;
            case R.id.cvPainel:
                i = new Intent(this, CardPainel.class);
                startActivity(i);
                break;
            case R.id.cvAppCoronaSUS:
                i = new Intent(this, CardAppCoronaSus.class);
                startActivity(i);
                break;

            default:
                break;

        }
    }
}

