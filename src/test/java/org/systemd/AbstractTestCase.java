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

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.Vector;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.UInt64;
import org.freedesktop.dbus.Variant;
import org.freedesktop.dbus.exceptions.DBusException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.systemd.interfaces.ManagerInterface;
import org.systemd.interfaces.PropertyInterface;
import org.testng.Assert;

public class AbstractTestCase {

    @Mock
    protected DBusConnection dbus;

    @Mock
    protected ManagerInterface miface;

    @Mock
    protected PropertyInterface piface;

    @InjectMocks
    protected Systemd systemd;

    public void setup() {
        MockitoAnnotations.initMocks(this);

        try {
            Mockito.when(dbus.getRemoteObject(Systemd.SERVICE_NAME, Systemd.OBJECT_PATH, ManagerInterface.class)).thenReturn(miface);
            Mockito.when(dbus.getRemoteObject(Systemd.SERVICE_NAME, Systemd.OBJECT_PATH, PropertyInterface.class)).thenReturn(piface);
        }
        catch (DBusException e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    protected void setupPropertyMocks(Class<?> iface, String serviceName, String[] propertyNames) {
        try {
            for (String propertyName : propertyNames) {
                Method method = null;

                try {
                    method = iface.getMethod("get" + propertyName);
                }
                catch (NoSuchMethodException e1) {
                    try {
                        method = iface.getMethod("is" + propertyName);
                    }
                    catch (NoSuchMethodException e2) {
                        Assert.fail(e1.getMessage() + "/" + e2.getMessage());
                    }
                }

                if (method != null) {
                    Class<?> returnType = method.getReturnType();
                    Type genericReturnType = method.getGenericReturnType();

                    Mockito.when(piface.getProperty(serviceName, propertyName)).then(new Answer<Variant<?>>() {

                        @Override
                        public Variant<?> answer(InvocationOnMock invocation) throws Throwable {
                            if (returnType == boolean.class) {
                                return new Variant<>(Boolean.TRUE);
                            }
                            else if (returnType == byte.class) {
                                return new Variant<>(Byte.MAX_VALUE);
                            }
                            else if (returnType == short.class) {
                                return new Variant<>(Short.MAX_VALUE);
                            }
                            else if (returnType == int.class) {
                                return new Variant<>(Integer.MAX_VALUE);
                            }
                            else if (returnType == long.class) {
                                return new Variant<>(Long.MAX_VALUE);
                            }
                            else if (returnType == BigInteger.class) {
                                return new Variant<>(new UInt64(0));
                            }
                            else if (returnType == float.class) {
                                return new Variant<>(Float.MAX_VALUE);
                            }
                            else if (returnType == double.class) {
                                return new Variant<>(Double.MAX_VALUE);
                            }
                            else if (returnType == String.class) {
                                return new Variant<>(propertyName);
                            }
                            else if (returnType == Vector.class) {
                                ParameterizedType paramType = (ParameterizedType) genericReturnType;
                                String typeName = paramType.getActualTypeArguments()[0].getTypeName();

                                if (typeName.equals(String.class.getName())) {
                                    return new Variant<>(new String[] { "foo", "bar" }, "as");
                                }
                                else {
                                    return new Variant<>(null);
                                }
                            }
                            else {
                                return new Variant<>(Mockito.mock(returnType));
                            }
                        }

                    });
                }
            }
        }
        catch (SecurityException e) {
            Assert.fail(e.getMessage(), e);
        }
    }

}