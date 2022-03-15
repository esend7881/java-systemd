package de.thjom.java.systemd;

import de.thjom.java.systemd.types.UnitFileType;
import lombok.val;
import org.testng.annotations.Test;

import java.io.File;

/**
 * ITCase test, run outside of maven to help in development.
 */
public class UnitFactoryITCase {

    @Test
    public void test() throws Exception {
        val unitFactory = UnitFactory.builder()
                .unitFile(new UnitFileType(File.createTempFile("test-unit", ".service").getPath(), ""))
                .build();

        unitFactory.generateFile();
        unitFactory.startUnit();
    }
}
