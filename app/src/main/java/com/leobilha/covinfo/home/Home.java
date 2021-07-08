package com.leobilha.covinfo.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leobilha.covinfo.HospitaisProximos;
import com.leobilha.covinfo.R;
import com.leobilha.covinfo.dicas.OQuePrecisoSaber;
import com.leobilha.covinfo.linhadotempo.LinhaDoTempo;
import com.leobilha.covinfo.noticias.Noticias;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements Adapter.SelectedBotao, View.OnClickListener{

    private TextView tvTotalMortes, tvTotalConfirmados, tvTotalRecuperados;
    private ProgressBar progressBar;
    private CardView cardAtualizar, cardDetalhes;

    Toolbar toolbar;
    RecyclerView recyclerView;

    List<Botoes> botoesList = new ArrayList<>();

    String [] botoes = {"Disque Saúde 136", "O que preciso saber?", "Locais de Saúde\nPróximos", "Linha do Tempo\nCOVID-19", "Últimas Notícias"};

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (verificaConexao()){
            trace("Carregando dados...");
        }else{
            trace("Verifique sua conexão com a rede.");
        }

        tvTotalMortes = (TextView) findViewById(R.id.totalMortes);
        tvTotalConfirmados = (TextView) findViewById(R.id.totalConfirmados);
        tvTotalRecuperados = (TextView) findViewById(R.id.totalRecuperados);
        progressBar = (ProgressBar) findViewById(R.id.progress_circular_home);

        cardAtualizar = (CardView) findViewById(R.id.card1);
        cardDetalhes = (CardView) findViewById(R.id.card2);

        cardAtualizar.setOnClickListener(this);
        cardDetalhes.setOnClickListener(this);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.home);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        recyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        for (String s:botoes){
            Botoes botoes = new Botoes(s);

            botoesList.add(botoes);
        }

        adapter = new Adapter(botoesList, this);

        recyclerView.setAdapter(adapter);

        getDadosAtualizados();
        
    }

    public boolean verificaConexao() {
        boolean lblnRet = false;
        try
        {
            ConnectivityManager cm = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
                lblnRet = true;
            } else {
                lblnRet = false;
            }
        }catch (Exception e) {
            trace(e.getMessage());
        }
        return lblnRet;
    }

    public void toast (String msg){
        Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show ();
    }

    public void trace (String msg){
        Log.d ("teste", msg);
        toast (msg);
    }

    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){
            case R.id.card1:
                progressBar.setVisibility(View.GONE);
                Toast.makeText(this, "Os dados são atualizados a cada 10 minutos...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card2:
                intent = new Intent(this, HomeDetalhes.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        Intent i;

        switch (id) {
            case R.id.action_sobre : i = new Intent(this, Sobre.class); startActivity(i); break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void getDadosAtualizados() {

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://disease.sh/v2/countries/BRA?yesterday=true&strict=true&allowNull=true";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressBar.setVisibility(View.GONE);

                try {

                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvTotalMortes.setText(jsonObject.getString("deaths"));
                    tvTotalConfirmados.setText(jsonObject.getString("cases"));
                    tvTotalRecuperados.setText(jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Erro de Resposta!", error.toString());
            }
        });

       queue.add(stringRequest);

    }

    public void selecionandoBotao(Botoes botoes) {

        if (botoes == botoesList.get(0)) {
            String numTelefone = "136";

            Uri uri = Uri.parse("tel:"+numTelefone);

            Intent i = new Intent(Intent.ACTION_DIAL, uri);
            if(ActivityCompat.checkSelfPermission(Home.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Home.this, new String[] {Manifest.permission.CALL_PHONE}, 1);
                return;
            }
                startActivity(i);
        } else if (botoes == botoesList.get(1)) {
            startActivity(new Intent(Home.this, OQuePrecisoSaber.class));
        } else if (botoes == botoesList.get(2)) {
            startActivity(new Intent(Home.this, HospitaisProximos.class));
        } else if (botoes == botoesList.get(3)) {
            startActivity(new Intent(Home.this, LinhaDoTempo.class));
        } else if (botoes == botoesList.get(4)) {
            startActivity(new Intent(Home.this, Noticias.class));
        }


    }




}
