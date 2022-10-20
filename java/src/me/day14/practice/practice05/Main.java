package me.day14.practice.practice05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{\n" +
                "  \"name\": \"Madame Uppercut\",\n" +
                "  \"age\": 39,\n" +
                "  \"secretIdentity\": \"Jane Wilson\",\n" +
                "  \"powers\": [\n" +
                "    \"Million tonne punch\",\n" +
                "    \"Damage resistance\",\n" +
                "    \"Superhuman reflexes\"\n" +
                "  ]\n" +
                "}";

        Map<String, Object> jsonMap = parseJsonString(jsonString);
        jsonMap.keySet().stream().forEach(k -> {
            System.out.println("key = " + k);
            System.out.println("value = " + jsonMap.get(k));
            System.out.println();
        });

    }

    public static Map<String, Object> parseJsonString(String jsonString) {
        String[] jsonArr = jsonString.replaceAll("[{}\\[\\]\\s\"]", "").split(",");

        String key = "";
        String value = "";
        String saveKey = "";
        List<String> values = new LinkedList<>();
        Map<String, Object> jsonMap = new HashMap<>();
        for (int i = 0; i < jsonArr.length; i++) {
            if (jsonArr[i].contains(":")) {
                if (values.size() > 1) {
                    jsonMap.put(saveKey, values);
                }
                saveKey = "";
                values = new LinkedList<>();

                int idx = jsonArr[i].indexOf(":");
                key = jsonArr[i].substring(0, idx);
                value = jsonArr[i].substring(idx + 1);

                jsonMap.put(key, value);
                values.add(value);
            } else {
                saveKey = key;
                values.add(jsonArr[i]);
            }
        }
        if (values.size() > 1) {
            jsonMap.put(saveKey, values);
        }

        return jsonMap;
    }
}
