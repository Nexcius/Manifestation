package models;

import org.junit.Assert;
import net.nexcius.manifest.models.FileModel;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Nex on 21.04.2015.
 */
public class FileModelTest {

    @Test
    public void testFileModelEquals() {
        FileModel fm1 = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFF");
        FileModel fm2 = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFF");
        FileModel fm3 = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFFgggg");

        Assert.assertNotEquals(fm1, fm3);
        Assert.assertEquals(fm1, fm2);
    }

    @Test
    public void testFileModelHash() throws IOException {
        FileModel fm1 = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFF");
        FileModel fm2 = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFF");
        FileModel fm3 = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFFgggg");

        Assert.assertNotEquals(fm1.hashCode(), fm3.hashCode());
        Assert.assertEquals(fm1.hashCode(), fm2.hashCode());
    }

    @Test
    public void testFileModelJsonOutput() {
        FileModel fm = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFF");
        Assert.assertEquals(fm.getJSON(), "{\"path\":\"filename.txt\",\"size\":332,\"checksum\":\"aaaabbbbCCCCDDDeeeFFF\"}");
    }

    @Test
    public void testFileModelLoadFromJson() {
        FileModel fm1 = new FileModel("filename.txt", 332, "aaaabbbbCCCCDDDeeeFFF");
        FileModel fm2 = FileModel.FileModelBuilder.getObjectFromJSON("{\"path\":\"filename.txt\",\"size\":332,\"checksum\":\"aaaabbbbCCCCDDDeeeFFF\"}");

        Assert.assertEquals(fm1, fm2);
    }

}
