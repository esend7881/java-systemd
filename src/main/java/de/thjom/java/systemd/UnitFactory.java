package de.thjom.java.systemd;

import de.thjom.java.systemd.types.UnitFileType;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.freedesktop.dbus.exceptions.DBusException;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@Slf4j
@Data
@Builder
public class UnitFactory {
    @NonNull
    private final UnitFileType unitFile;
    /**
     * Fills out [Unit] section of file.
     */
    private final Map<Unit.Property, String> unitPropertyMap = new LinkedHashMap<>();
    /**
     * Fills out [Service] section of file.
     */
    private final Map<Unit.Property, String> servicePropertyMap = new LinkedHashMap<>();
    /**
     * Fills out [Install] section of file.
     */
    private final Map<InterfaceAdapter.AdapterProperty, String> installPropertyMap = new LinkedHashMap<>();

    /**
     * WIP: Fleshing this out. Experimenting with dbus manager.
     * @return
     * @throws IOException
     */
    public int startUnit() throws IOException, DBusException {
        val out = Systemd.get().getManager().enableUnitFiles(List.of(unitFile.getPath()), true, true);
        return 0;
    }

    public void generateFile() throws IOException {
        try (val fw = new PrintWriter(new BufferedWriter(new FileWriter(unitFile.getPath())))) {
            if (!unitPropertyMap.isEmpty()) {
                fw.println("[Unit]");
                unitPropertyMap.forEach(writeLine(fw));
                fw.println();
            }
            if (!servicePropertyMap.isEmpty()) {
                fw.println("[Service]");
                servicePropertyMap.forEach(writeLine(fw));
                fw.println();
            }
            if (!installPropertyMap.isEmpty()) {
                fw.println("[Install]");
                installPropertyMap.forEach(writeLine(fw));
                fw.println();
            }
        }
    }

    private BiConsumer<InterfaceAdapter.AdapterProperty, String> writeLine(@NonNull final PrintWriter writer) {
        return (prop, val) -> writer.printf("%s=%s%n", prop, val);
    }
}
