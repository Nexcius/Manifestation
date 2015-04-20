package net.nexcius.manifest.models;

import com.google.gson.Gson;
import net.nexcius.manifest.util.Version;

import java.util.ArrayList;

/**
 * Created by Nex on 18.04.2015.
 */
public class VersionModel {
    private Version version;
    private int size;
    private ArrayList<String> install;
    private ArrayList<String> remove;
    private ArrayList<ContentModel> content;

    public VersionModel(Version version, int size) {
        this.version = version;
        this.size = size;
        this.install = new ArrayList<String>();
        this.remove = new ArrayList<String>();
        this.content = new ArrayList<ContentModel>();
    }

    public VersionModel(Version version, int size, ArrayList<String> install, ArrayList<String> remove, ArrayList<ContentModel> content) {
        this.version = version;
        this.size = size;
        this.install = install;
        this.remove = remove;
        this.content = content;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<String> getInstall() {
        return install;
    }

    public ArrayList<String> getRemove() {
        return remove;
    }

    public ArrayList<ContentModel> getContent() {
        return content;
    }

    public void addInstall(String path) {
        install.add(path);
    }

    public void addRemove(String path) {
        remove.add(path);
    }

    public void addContent(ContentModel contentModel) {
        content.add(contentModel);
    }

    public String getJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }


}
