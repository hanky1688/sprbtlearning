package com.hanky.base.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class Json {

    public static final Gson gson = new GsonBuilder().create();

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

}
