package com.company.logic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeserializeObj {

    public static List<DeserializeNameList> getNamelist(String file) {

//        List<DeserializeNameList> nameListArr = new ArrayList<>();
        List<DeserializeNameList> deslist = null;
        String wDir = System.getProperty("user.dir");


        try (Reader reader = new FileReader(wDir + "/" + file)){
            Type nameListType = new TypeToken<ArrayList<DeserializeNameList>>(){}.getType();
            deslist = new Gson().fromJson(reader, nameListType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return deslist;
    }

    public static void main(String[] args) {

        List<DeserializeNameList> nameDez = getNamelist("nameObjList.json");



        System.out.println(nameDez.get(1).getFirstname());
    }
}





