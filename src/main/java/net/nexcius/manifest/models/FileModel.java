package net.nexcius.manifest.models;

import com.google.gson.Gson;
import net.nexcius.manifest.util.GsonFactory;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Nex on 18.04.2015.
 */
public class FileModel {
    private String path;
    private long size;
    private String checksum;


    public FileModel(String path, long size, String checksum) {
        this.path = path;
        this.size = size;
        this.checksum = checksum;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
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
        Gson gson = GsonFactory.getGsonInstance();
        return gson.toJson(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(path).
                append(size).
                append(checksum).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FileModel))
            return false;
        if (obj == this)
            return true;

        FileModel rhs = (FileModel) obj;
        return new EqualsBuilder().
                append(path, rhs.path).
                append(size, rhs.size).
                append(checksum, rhs.checksum).
                isEquals();
    }

    public static class FileModelBuilder {
        public static FileModel getObjectFromJSON(String json) {
            Gson gson = GsonFactory.getGsonInstance();
            return gson.fromJson(json, FileModel.class);
        }


        /**
         * Generates a FileModel object from a define file
         * @param filePath The relative file path of the file
         * @return The object representing the file data
         * @throws IOException
         */
        public static FileModel getObjectFromFile(String filePath) throws IOException {
            File inFile = new File(filePath);
            long size = inFile.length();

            FileInputStream fis = new FileInputStream(inFile);
            String checksum = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
            fis.close();

            return new FileModel(filePath, size, checksum);
        }
    }

}
