package com.allogica.ChallengeConversorMoedas.JsonManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

public class JsonWorkerPersonalized <T> {
    private Gson gson;

    public JsonWorkerPersonalized() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public T convertToObject(String jsonData, Class<T> clazz) {
        return gson.fromJson(jsonData, clazz);
    }

    public List<T> convertToList(String jsonData, Class<T> clazz) {
        Type listType = TypeToken.getParameterized(List.class, clazz).getType();
        return gson.fromJson(jsonData, listType);
    }

    public List<T> convertToList(BufferedReader reader, Class<T> clazz) {
        Type listType = TypeToken.getParameterized(List.class, clazz).getType();
        return gson.fromJson(reader, listType);
    }

    public String convertToJson(T object) {
        return gson.toJson(object);
    }

    public String convertToJson(List<T> listinha) {
        return gson.toJson(listinha);
    }

    public String convertToJson(Set<T> listinha) {
        return gson.toJson(listinha);
    }
}
