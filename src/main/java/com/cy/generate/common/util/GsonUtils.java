package com.cy.generate.common.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 23:56
 */
public class GsonUtils {
    private static Gson gson = null;

    static {
        gson = new GsonBuilder().disableHtmlEscaping().create();
        //todo yyyy-MM-dd // HH:mm:ss
    }


    public static synchronized Gson newInstance() {
        if (gson == null) {
            gson = new GsonBuilder().disableHtmlEscaping().create();
        }
        return gson;
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T toBean(String json, Class<T> clz) {
        return gson.fromJson(json, clz);
    }

    public static <T> Map<String, T> toMap(String json, Class<T> clz) {
        Map<String, T> map = gson.fromJson(json, new TypeToken<Map<String, T>>() {
        }.getType());
        Map<String, T> result = new HashMap<>();
        for (String key : map.keySet()) {
            result.put(key, gson.fromJson((String) map.get(key), clz));
        }
        return result;
    }

    public static Map<String, Object> toMap(String json) {
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
        }.getType());
        return map;
    }

    public static <T> List<T> toList(String json, Class<T> clz) {
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        List<T> list = new ArrayList<>();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, clz));
        }
        return list;
    }
}
