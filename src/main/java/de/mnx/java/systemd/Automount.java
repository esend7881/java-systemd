/*
 * Java-systemd implementation
 * Copyright (c) 2016 Markus Enax
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of either the GNU Lesser General Public License Version 2 or the
 * Academic Free Licence Version 2.1.
 *
 * Full licence texts are included in the COPYING file with this program.
 */

package de.mnx.java.systemd;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;

import de.mnx.java.systemd.interfaces.AutomountInterface;

public class Automount extends Unit {

    public static final String SERVICE_NAME = Systemd.SERVICE_NAME + ".Automount";
    public static final String UNIT_SUFFIX = ".automount";

    private final Properties properties;

    private Automount(final DBusConnection dbus, final AutomountInterface iface, final String name) throws DBusException {
        super(dbus, iface, name);

        this.properties = Properties.create(dbus, iface.getObjectPath(), SERVICE_NAME);
    }

    static Automount create(final DBusConnection dbus, String name) throws DBusException {
        name = Unit.normalizeName(name, UNIT_SUFFIX);

        String objectPath = Unit.OBJECT_PATH + Systemd.escapePath(name);
        AutomountInterface iface = dbus.getRemoteObject(Systemd.SERVICE_NAME, objectPath, AutomountInterface.class);

        return new Automount(dbus, iface, name);
    }

    @Override
    public AutomountInterface getInterface() {
        return (AutomountInterface) super.getInterface();
    }

    public String getWhere() {
        return properties.getString("Where");
    }

    public long getDirectoryMode() {
        return properties.getLong("DirectoryMode");
    }

    public String getResult() {
        return properties.getString("Result");
    }

}
