package me.day06.practice;

import java.util.Arrays;

class JsonTable {
    int ROW_NUM;
    int COL_NUM;
    String[] colnums;
    String[][] data;

    public JsonTable(int ROW_NUM, int COL_NUM) {
        this.ROW_NUM = ROW_NUM;
        this.COL_NUM = COL_NUM;
        colnums = new String[COL_NUM];
        data = new String[ROW_NUM][COL_NUM];
    }

    public void print() {
        System.out.println();
        System.out.println("\n---------------------------------------------------------------------------------------------");
        for (int i = 0; i < colnums.length; i++) {
            System.out.printf("| %20s ", colnums[i]);
        }
        System.out.printf("|");
        System.out.println("\n---------------------------------------------------------------------------------------------");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("| %20s ", data[i][j]);
            }
            System.out.printf("|");
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "JsonTable{" +
                "ROW_NUM=" + ROW_NUM +
                ", COL_NUM=" + COL_NUM +
                ", colnums=" + Arrays.toString(colnums) +
                ", data=" + Arrays.deepToString(data) +
                '}';
    }
}

public class Practice07 {
    public static void main(String[] args) {
        final String JSON_STRING =
                "{\n" +
                    "\t\"name\": \"Molecule Man\",\n" +
                    "\t\"age\": 29,\n" +
                    "\t\"secretIdentity\": \"Dan Jukes\",\n" +
                    "\t\"powers\": \"Radiation resistance\"\n" +
                    "},\n" +
                    "{\n" +
                    "\t\"name\": \"Madame Uppercut\",\n" +
                    "\t\"age\": 39,\n" +
                    "\t\"secretIdentity\": \"Jane Wilson\",\n" +
                    "\t\"powers\": \"Damage resistance\"\n" +
                    "},\n" +
                    "{\n" +
                    "\t\"name\": \"Eternal Flame\",\n" +
                    "\t\"age\": 1000000,\n" +
                    "\t\"secretIdentity\": \"Unknown\",\n" +
                    "\t\"powers\": \"Heat Immunity\"\n" +
                "}";

        JsonTable jsonTable = parseJsonStringtoTable(JSON_STRING);
        jsonTable.print();
        System.out.println("jsonTable = " + jsonTable);
    }
    public static JsonTable parseJsonStringtoTable(String JSON_STRING) {
        final int ROW_NUM = 3;
        final int COL_NUM = 4;
        JsonTable jsonTable = new JsonTable(ROW_NUM, COL_NUM);

        int count = 0;
        String[] jsonStrings = JSON_STRING.split(",");
        for (int i = 0; i < jsonStrings.length; i++) {
            jsonStrings[i] = jsonStrings[i].replace("{", "");
            jsonStrings[i] = jsonStrings[i].replace("}", "");
            jsonStrings[i] = jsonStrings[i].strip();
            String[] jsonStringsSplit = jsonStrings[i].split(":");
            String name = jsonStringsSplit[0].strip();
            String data = jsonStringsSplit[1].strip();

            int row = count / COL_NUM;
            int col = count % COL_NUM;
            if (name.charAt(0) == '\"' && name.charAt(name.length()-1) == '\"') {
                jsonTable.colnums[col] = name.split("\"")[1];
            } else {
                jsonTable.colnums[col] = name;
            }

            if (data.charAt(0) == '\"' && data.charAt(data.length()-1) == '\"') {
                jsonTable.data[row][col] = data.split("\"")[1];
            } else {
                jsonTable.data[row][col] = data;
            }
            count++;
        }
        return jsonTable;
    }
}
