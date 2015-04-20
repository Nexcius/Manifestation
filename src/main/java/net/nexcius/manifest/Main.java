package net.nexcius.manifest;

import com.google.gson.Gson;
import net.nexcius.manifest.models.ContentModel;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<ContentModel> a = new ArrayList<ContentModel>();
        a.add(new ContentModel("AAA", "BBB", 123, "XXXX"));
        a.add(new ContentModel("AAA", "BBB", 123, "XXXX"));

        Gson g = new Gson();

        System.out.println(g.toJson(a));
    }
}
