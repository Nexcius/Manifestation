package net.nexcius.manifest.util;

import com.google.gson.Gson;

/**
 * Created by Nex on 21.04.2015.
 */
public class GsonFactory {
    private static Gson gson = null;

    public static Gson getGsonInstance() {
        if(gson == null) {
            gson = new Gson();
        }

        return gson;
    }
}
