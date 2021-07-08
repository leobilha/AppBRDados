package com.leobilha.covinfo.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leobilha.covinfo.R;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeDetalhes extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView populacaoHoje, mortes, mortesHoje, casos, casosHoje, recuperados, recuperadosHoje,
                    ativo, criticos, casoPorPessoa, mortePorPessoa, testePorPessoa, teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detalhes);

        populacaoHoje = (TextView) findViewById(R.id.populacao);

        mortes = (TextView) findViewById(R.id.totalMortesDetalhes);
        mortesHoje = (TextView) findViewById(R.id.mortesHojeDetalhes);
        casos = (TextView) findViewById(R.id.totalConfirmadosDetalhes);
        casosHoje = (TextView) findViewById(R.id.casosHoje);
        recuperados = (TextView) findViewById(R.id.totalRecuperadosDetalhes);
        recuperadosHoje = (TextView) findViewById(R.id.totalRecuperadosHoje);
        ativo = (TextView) findViewById(R.id.casosAtivos);
        criticos = (TextView) findViewById(R.id.criticos);
        casoPorPessoa = (TextView) findViewById(R.id.umCasoPorPessoa);
        mortePorPessoa = (TextView) findViewById(R.id.umaMortePorPessoa);
        testePorPessoa = (TextView) findViewById(R.id.umTestePorPessoa);
        teste = (TextView) findViewById(R.id.testes);

        progressBar = (ProgressBar) findViewById(R.id.progress_circular_home_detalhes);

        getDadosAtualizados();


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

                    populacaoHoje.setText(jsonObject.getString("population"));
                    mortes.setText(jsonObject.getString("deaths"));
                    mortesHoje.setText(jsonObject.getString("todayDeaths"));
                    casos.setText(jsonObject.getString("cases"));
                    casosHoje.setText(jsonObject.getString("todayCases"));
                    recuperados.setText(jsonObject.getString("recovered"));
                    recuperadosHoje.setText(jsonObject.getString("todayRecovered"));
                    ativo.setText(jsonObject.getString("active"));
                    criticos.setText(jsonObject.getString("critical"));
                    casoPorPessoa.setText(jsonObject.getString("oneCasePerPeople"));
                    mortePorPessoa.setText(jsonObject.getString("oneDeathPerPeople"));
                    testePorPessoa.setText(jsonObject.getString("oneTestPerPeople"));
                    teste.setText(jsonObject.getString("tests"));



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
}
