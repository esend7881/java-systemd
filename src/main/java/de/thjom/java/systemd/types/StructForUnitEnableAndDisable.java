package de.thjom.java.systemd.types;

import org.freedesktop.dbus.Struct;
import org.freedesktop.dbus.annotations.Position;

public final class StructForUnitEnableAndDisable extends Struct {
    @Position(0)
    public final String a;
    @Position(1)
    public final String b;
    @Position(2)
    public final String c;

    public StructForUnitEnableAndDisable(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}