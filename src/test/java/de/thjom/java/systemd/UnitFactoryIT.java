package de.thjom.java.systemd;

import de.thjom.java.systemd.types.UnitFileType;
import lombok.val;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class UnitFactoryIT {

    @Test
    @Ignore
    public void test() throws Exception {
        val dir = Files.createTempDirectory("units");
        val unitFile = Files.createFile(Paths.get(dir.toString(), "test-unit.service"));
        val unitFactory = UnitFactory.builder()
                .unitFile(new UnitFileType(unitFile.toString(), ""))
                .build();

        unitFactory.generateFile();
        unitFactory.startUnit();
    }
}
