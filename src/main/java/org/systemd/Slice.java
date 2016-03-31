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

package org.systemd;

import java.math.BigInteger;
import java.util.List;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.systemd.interfaces.SliceInterface;
import org.systemd.types.BlockIOBandwidth;
import org.systemd.types.BlockIODeviceWeight;
import org.systemd.types.DeviceAllowControl;

public class Slice extends Unit {

    public static final String SERVICE_NAME = Systemd.SERVICE_NAME + ".Slice";
    public static final String UNIT_SUFFIX = ".slice";

    private final Properties properties;

    private Slice(final DBusConnection dbus, final SliceInterface iface, final String name) throws DBusException {
        super(dbus, iface, name);

        this.properties = Properties.create(dbus, iface.getObjectPath(), SERVICE_NAME);
    }

    static Slice create(final DBusConnection dbus, String name) throws DBusException {
        name = Unit.normalizeName(name, UNIT_SUFFIX);

        String objectPath = Unit.OBJECT_PATH + Systemd.escapePath(name);
        SliceInterface iface = dbus.getRemoteObject(Systemd.SERVICE_NAME, objectPath, SliceInterface.class);

        return new Slice(dbus, iface, name);
    }

    @Override
    public SliceInterface getInterface() {
        return (SliceInterface) super.getInterface();
    }

    public boolean isBlockIOAccounting() {
        return properties.getBoolean("BlockIOAccounting");
    }

    public List<BlockIODeviceWeight> getBlockIODeviceWeight() {
        return BlockIODeviceWeight.list(properties.getVector("BlockIODeviceWeight"));
    }

    public List<BlockIOBandwidth> getBlockIOReadBandwidth() {
        return BlockIOBandwidth.list(properties.getVector("BlockIOReadBandwidth"));
    }

    public BigInteger getBlockIOWeight() {
        return properties.getBigInteger("BlockIOWeight");
    }

    public List<BlockIOBandwidth> getBlockIOWriteBandwidth() {
        return BlockIOBandwidth.list(properties.getVector("BlockIOWriteBandwidth"));
    }

    public boolean isCPUAccounting() {
        return properties.getBoolean("CPUAccounting");
    }

    public BigInteger getCPUShares() {
        return properties.getBigInteger("CPUShares");
    }

    public String getControlGroup() {
        return properties.getString("ControlGroup");
    }

    public List<DeviceAllowControl> getDeviceAllow() {
        return DeviceAllowControl.list(properties.getVector("DeviceAllow"));
    }

    public String getDevicePolicy() {
        return properties.getString("DevicePolicy");
    }

    public boolean isMemoryAccounting() {
        return properties.getBoolean("MemoryAccounting");
    }

    public BigInteger getMemoryLimit() {
        return properties.getBigInteger("MemoryLimit");
    }

    public String getSlice() {
        return properties.getString("Slice");
    }

}
