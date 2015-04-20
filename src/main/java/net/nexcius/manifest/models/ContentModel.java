package net.nexcius.manifest.models;

import com.google.gson.Gson;

/**
 * Created by Nex on 18.04.2015.
 */
public class ContentModel {
    private String source;
    private String dest;
    int size;
    private String checksum;

    public ContentModel(String source, String dest, int size, String checksum) {
        this.source = source;
        this.dest = dest;
        this.size = size;
        this.checksum = checksum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
