package net.nexcius.manifest;

import com.google.gson.Gson;
import net.nexcius.manifest.models.FileModel;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        FileModel fm = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFF");

        System.out.println(fm.getJSON());
    }
}
