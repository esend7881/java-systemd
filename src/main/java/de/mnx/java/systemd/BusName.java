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

import de.mnx.java.systemd.interfaces.BusNameInterface;

public class BusName extends Unit {

    public static final String SERVICE_NAME = Systemd.SERVICE_NAME + ".BusName";
    public static final String UNIT_SUFFIX = ".busname";

    private final Properties properties;

    private BusName(final DBusConnection dbus, final BusNameInterface iface, final String name) throws DBusException {
        super(dbus, iface, name);

        this.properties = Properties.create(dbus, iface.getObjectPath(), SERVICE_NAME);
    }

    static BusName create(final DBusConnection dbus, String name) throws DBusException {
        name = Unit.normalizeName(name, UNIT_SUFFIX);

        String objectPath = Unit.OBJECT_PATH + Systemd.escapePath(name);
        BusNameInterface iface = dbus.getRemoteObject(Systemd.SERVICE_NAME, objectPath, BusNameInterface.class);

        return new BusName(dbus, iface, name);
    }

    @Override
    public BusNameInterface getInterface() {
        return (BusNameInterface) super.getInterface();
    }

    public boolean isAcceptFileDescriptors() {
        return properties.getBoolean("AcceptFileDescriptors");
    }

    public boolean isActivating() {
        return properties.getBoolean("Activating");
    }

    public long getControlPID() {
        return properties.getLong("ControlPID");
    }

    public String getName() {
        return properties.getString("Name");
    }

    public String getResult() {
        return properties.getString("Result");
    }

    public long getTimeoutUSec() {
        return properties.getLong("TimeoutUSec");
    }

}
