package com.company.logic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeserializeObj {

    public static List<DeserializeNameList> getNamelist(String file) {

        List<DeserializeNameList> result = null;
        String wDir = System.getProperty("user.dir");


        try (Reader reader = new FileReader(wDir + "/" + file)){
            Type nameListType = new TypeToken<ArrayList<DeserializeNameList>>(){}.getType();
            result = new Gson().fromJson(reader, nameListType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void setNamelist(List<DeserializeNameList> namelist) throws IOException {
        String wDir = System.getProperty("user.dir");

        String json = new Gson().toJson(namelist);

        try(Writer writer = new FileWriter(wDir + "/" + "nameObjList.json")){
            new Gson().toJson(namelist, writer);
            System.out.println("wrote to file");
        }

    }

    public static void main(String[] args) {

        List<DeserializeNameList> nameDez = getNamelist("nameObjList.json");



        System.out.println(nameDez.get(1).getFirstname());
    }
}





