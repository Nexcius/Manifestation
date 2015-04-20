package net.nexcius.manifest.util;

/**
 * Created by Nex on 18.04.2015.
 */
public class Version implements Comparable<Version> {
    private String version;

    public Version(String version) {
        setVersion(version);
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        if(version == null)
            throw new IllegalArgumentException("Version can not be null");
        if(!version.matches("[0-9]+(\\.[0-9]+)*"))
            throw new IllegalArgumentException("Invalid version format");
        this.version = version;
    }

    public int compareTo(Version that) {
        if(that == null) {
            return 1;
        }

        String[] thisParts = this.getVersion().split("\\.");
        String[] thatParts = that.getVersion().split("\\.");
        int length = Math.max(thisParts.length, thatParts.length);
        for(int i = 0; i < length; i++) {
            int thisPart = i < thisParts.length ?
                    Integer.parseInt(thisParts[i]) : 0;
            int thatPart = i < thatParts.length ?
                    Integer.parseInt(thatParts[i]) : 0;
            if(thisPart < thatPart)
                return -1;
            if(thisPart > thatPart)
                return 1;
        }
        return 0;
    }
}
