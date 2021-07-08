package com.leobilha.covinfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParser {

    private HashMap<String, String> parserJsonObject(JSONObject object) {
        // Inicializa hash map
        HashMap<String, String> datalist = new HashMap<>();

        try {
            // Pega o nome do objeto
            String nome = object.getString("name");
            // Pega latitude do objeto
            String latitude = object.getJSONObject("geometry").getJSONObject("location").getString("lat");
            // Pega longitude do objeto
            String longitude = object.getJSONObject("geometry").getJSONObject("location").getString("lng");
            // Puxa o valor do hash map
            datalist.put("name", nome);
            datalist.put("lat", latitude);
            datalist.put("lng", longitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Retorna hash map
        return datalist;
    }

    private List<HashMap<String, String>> parserJsonArray(JSONArray jsonArray) {
        // Inicializa hash map lista
        List<HashMap<String, String >> dataList = new ArrayList<>();
        for (int i =0; i<jsonArray.length(); i++) {
            try {
                //Inicializa hash map
                HashMap<String,String > data = parserJsonObject((JSONObject) jsonArray.get(i));
                // Adiciona dados no hash mapa lista
                dataList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        // Retorna hash mapa list
        return dataList;
    }

    public List<HashMap<String, String >> parseResult(JSONObject object) {
        // Inicializa json array
        JSONArray jsonArray = null;
        // Get result array
        try {
            jsonArray = object.getJSONArray("results");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Retorna array
        return parserJsonArray(jsonArray);
    }
}
