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

package de.mnx;

import org.freedesktop.dbus.exceptions.DBusException;

import de.mnx.java.systemd.Manager;
import de.mnx.java.systemd.Service;
import de.mnx.java.systemd.Systemd;

public class Playground {

    private Playground() {
        // Do nothing (static class)
    }

    public static void introspect(final Manager manager) throws DBusException {
        System.out.println(manager.introspect());
        System.out.println(manager.getService("cronie.service").introspect());
    }

    public static void properties(final Manager manager) throws DBusException  {
        System.out.println("Architecture: " + manager.getArchitecture());

        System.out.println("ConfirmSpawn: " + manager.isConfirmSpawn());
        System.out.println("ControlGroup: " + manager.getControlGroup());
        System.out.println("DefaultBlockIOAccounting: " + manager.isDefaultBlockIOAccounting());
        System.out.println("DefaultCPUAccounting: " + manager.isDefaultCPUAccounting());
        System.out.println("DefaultLimitAS: " + manager.getDefaultLimitAS());
        System.out.println("DefaultLimitCORE: " + manager.getDefaultLimitCORE());
        System.out.println("DefaultLimitCPU: " + manager.getDefaultLimitCPU());
        System.out.println("DefaultLimitDATA: " + manager.getDefaultLimitDATA());
        System.out.println("DefaultLimitFSIZE: " + manager.getDefaultLimitFSIZE());
        System.out.println("DefaultLimitLOCKS: " + manager.getDefaultLimitLOCKS());
        System.out.println("DefaultLimitMEMLOCK: " + manager.getDefaultLimitMEMLOCK());
        System.out.println("DefaultLimitMSGQUEUE: " + manager.getDefaultLimitMSGQUEUE());
        System.out.println("DefaultLimitNICE: " + manager.getDefaultLimitNICE());
        System.out.println("DefaultLimitNOFILE: " + manager.getDefaultLimitNOFILE());
        System.out.println("DefaultLimitNPROC: " + manager.getDefaultLimitNPROC());
        System.out.println("DefaultLimitRSS: " + manager.getDefaultLimitRSS());
        System.out.println("DefaultLimitRTPRIO: " + manager.getDefaultLimitRTPRIO());
        System.out.println("DefaultLimitRTTIME: " + manager.getDefaultLimitRTTIME());
        System.out.println("DefaultLimitSIGPENDING: " + manager.getDefaultLimitSIGPENDING());
        System.out.println("DefaultLimitSTACK: " + manager.getDefaultLimitSTACK());
        System.out.println("DefaultMemoryAccounting: " + manager.isDefaultMemoryAccounting());
        System.out.println("DefaultRestartUSec: " + manager.getDefaultRestartUSec());
        System.out.println("DefaultStandardError: " + manager.getDefaultStandardError());
        System.out.println("DefaultStandardOutput: " + manager.getDefaultStandardOutput());
        System.out.println("DefaultStartLimitBurst: " + manager.getDefaultStartLimitBurst());
        System.out.println("DefaultStartLimitInterval: " + manager.getDefaultStartLimitInterval());
        System.out.println("DefaultTasksAccounting: " + manager.isDefaultTasksAccounting());
        System.out.println("DefaultTasksMax: " + manager.getDefaultTasksMax());
        System.out.println("DefaultTimeoutStartUSec: " + manager.getDefaultTimeoutStartUSec());
        System.out.println("DefaultTimeoutStopUSec: " + manager.getDefaultTimeoutStopUSec());
        System.out.println("DefaultTimerAccuracyUSec: " + manager.getDefaultTimerAccuracyUSec());
        System.out.println("Environment: " + manager.getEnvironment());
        System.out.println("ExitCode: " + manager.getExitCode());
        System.out.println("Features: " + manager.getFeatures());
        System.out.println("FinishTimestamp: " + manager.getFinishTimestamp());
        System.out.println("FinishTimestampMonotonic: " + manager.getFinishTimestampMonotonic());
        System.out.println("FirmwareTimestamp: " + manager.getFirmwareTimestamp());
        System.out.println("FirmwareTimestampMonotonic: " + manager.getFirmwareTimestampMonotonic());
        System.out.println("GeneratorsFinishTimestamp: " + manager.getGeneratorsFinishTimestamp());
        System.out.println("GeneratorsFinishTimestampMonotonic: " + manager.getGeneratorsFinishTimestampMonotonic());
        System.out.println("GeneratorsStartTimestamp: " + manager.getGeneratorsStartTimestamp());
        System.out.println("GeneratorsStartTimestampMonotonic: " + manager.getGeneratorsStartTimestampMonotonic());
        System.out.println("InitRDTimestamp: " + manager.getInitRDTimestamp() + " (" + Systemd.timestampToDate(manager.getInitRDTimestamp()) + ")");
        System.out.println("InitRDTimestampMonotonic: " + manager.getInitRDTimestampMonotonic());
        System.out.println("KernelTimestamp: " + manager.getKernelTimestamp() + " (" + Systemd.timestampToDate(manager.getKernelTimestamp()) + ")");
        System.out.println("KernelTimestampMonotonic: " + manager.getKernelTimestampMonotonic());
        System.out.println("LoaderTimestamp: " + manager.getLoaderTimestamp());
        System.out.println("LoaderTimestampMonotonic: " + manager.getLoaderTimestampMonotonic());
        System.out.println("LogLevel: " + manager.getLogLevel());
        System.out.println("LogTarget: " + manager.getLogTarget());
        System.out.println("NFailedJobs: " + manager.getNFailedJobs());
        System.out.println("NFailedUnits: " + manager.getNFailedUnits());
        System.out.println("NInstalledJobs: " + manager.getNInstalledJobs());
        System.out.println("NJobs: " + manager.getNJobs());
        System.out.println("NNames: " + manager.getNNames());
        System.out.println("Progress: " + manager.getProgress());
        System.out.println("RuntimeWatchdogUSec: " + manager.getRuntimeWatchdogUSec());
        System.out.println("SecurityFinishTimestamp: " + manager.getSecurityFinishTimestamp() + " (" + Systemd.timestampToDate(manager.getSecurityFinishTimestamp()) + ")");
        System.out.println("SecurityFinishTimestampMonotonic: " + manager.getSecurityFinishTimestampMonotonic());
        System.out.println("SecurityStartTimestamp: " + manager.getSecurityStartTimestamp() + " (" + Systemd.timestampToDate(manager.getSecurityStartTimestamp()) + ")");
        System.out.println("SecurityStartTimestampMonotonic: " + manager.getSecurityStartTimestampMonotonic());
        System.out.println("ShowStatus: " + manager.isShowStatus());
        System.out.println("SystemState: " + manager.getSystemState());
        System.out.println("Tainted: " + manager.getTainted());
        System.out.println("TimerSlackNSec: " + manager.getTimerSlackNSec());
        System.out.println("UnitPath: " + manager.getUnitPath());
        System.out.println("UnitsLoadFinishTimestamp: " + manager.getUnitsLoadFinishTimestamp());
        System.out.println("UnitsLoadFinishTimestampMonotonic: " + manager.getUnitsLoadFinishTimestampMonotonic());
        System.out.println("UnitsLoadStartTimestamp: " + manager.getUnitsLoadStartTimestamp());
        System.out.println("UnitsLoadStartTimestampMonotonic: " + manager.getUnitsLoadStartTimestampMonotonic());
        System.out.println("UserspaceTimestamp: " + manager.getUserspaceTimestamp() + " (" + Systemd.timestampToDate(manager.getUserspaceTimestamp()) + ")");
        System.out.println("UserspaceTimestampMonotonic: " + manager.getUserspaceTimestampMonotonic());
        System.out.println("Version: " + manager.getVersion());
        System.out.println("Virtualization: " + manager.getVirtualization());
    }

    public static void methods(final Manager manager) throws DBusException  {
//        System.out.println();
//
//        for (UnitFileType unitFile : manager.listUnitFiles()) {
//            System.out.println(unitFile.getSummary());
//        }

//        System.out.println();
//
//        for (UnitType unit : manager.listUnits()) {
//            System.out.println(unit.getSummary());
//
//            if (unit.getUnitName().endsWith(".service") && unit.getSubState().equals("running")) {
//                Service service = manager.getService(unit.getUnitName());
//                System.out.println(" Runtime statistics:");
//                System.out.println("  MainPID: " + service.getMainPID());
//            }
//
//            System.out.println();
//        }

        System.out.println();

        Service polkit = manager.getService("polkit");
        System.out.println("'polkit' properties:");
        System.out.println("Environment: " + polkit.getEnvironment());
        System.out.println("MainPID: " + polkit.getMainPID());
        System.out.println("Type: " + polkit.getType());

        System.out.println();

        Service cronie = manager.getService("cronie");
        System.out.println("'cronie' properties (unit interface):");
        System.out.println("ActiveEnterTimestamp: " + cronie.getActiveEnterTimestamp());
        System.out.println("ActiveEnterTimestampMonotonic: " + cronie.getActiveEnterTimestampMonotonic());
        System.out.println("ActiveExitTimestamp: " + cronie.getActiveExitTimestamp());
        System.out.println("ActiveExitTimestampMonotonic: " + cronie.getActiveExitTimestampMonotonic());
        System.out.println("ActiveState: " + cronie.getActiveState());
        System.out.println("After: " + cronie.getAfter());
        System.out.println("AllowIsolate: " + cronie.isAllowIsolate());
        System.out.println("AssertResult: " + cronie.isAssertResult());
        System.out.println("AssertTimestamp: " + cronie.getAssertTimestamp());
        System.out.println("AssertTimestampMonotonic: " + cronie.getAssertTimestampMonotonic());
        System.out.println("Asserts: " + cronie.getAsserts());
        System.out.println("Before: " + cronie.getBefore());
        System.out.println("BindsTo: " + cronie.getBindsTo());
        System.out.println("BoundBy: " + cronie.getBoundBy());
        System.out.println("CanIsolate: " + cronie.canIsolate());
        System.out.println("CanReload: " + cronie.canReload());
        System.out.println("CanStart: " + cronie.canStart());
        System.out.println("CanStop: " + cronie.canStop());
        System.out.println("ConditionResult: " + cronie.getConditionResult());
        System.out.println("ConditionTimestamp: " + cronie.getConditionTimestamp());
        System.out.println("ConditionTimestampMonotonic: " + cronie.getConditionTimestampMonotonic());
        System.out.println("Conditions: " + cronie.getConditions());
        System.out.println("ConflictedBy: " + cronie.getConflictedBy());
        System.out.println("Conflicts: " + cronie.getConflicts());
        System.out.println("ConsistsOf: " + cronie.getConsistsOf());
        System.out.println("DefaultDependencies: " + cronie.hasDefaultDependencies());
        System.out.println("Description: " + cronie.getDescription());
        System.out.println("Documentation: " + cronie.getDocumentation());
        System.out.println("DropInPaths: " + cronie.getDropInPaths());
        System.out.println("Following: " + cronie.getFollowing());
        System.out.println("FragmentPath: " + cronie.getFragmentPath());
        System.out.println("Id: " + cronie.getId());
        System.out.println("IgnoreOnIsolate: " + cronie.isIgnoreOnIsolate());
        System.out.println("InactiveEnterTimestamp: " + cronie.getInactiveEnterTimestamp());
        System.out.println("InactiveEnterTimestampMonotonic: " + cronie.getInactiveEnterTimestampMonotonic());
        System.out.println("InactiveExitTimestamp: " + cronie.getInactiveExitTimestamp());
        System.out.println("InactiveExitTimestampMonotonic: " + cronie.getInactiveExitTimestampMonotonic());
        System.out.println("Job: " + cronie.getJob());
        System.out.println("JobTimeoutAction: " + cronie.getJobTimeoutAction());
        System.out.println("JobTimeoutRebootArgument: " + cronie.getJobTimeoutRebootArgument());
        System.out.println("JobTimeoutUSec: " + cronie.getJobTimeoutUSec());
        System.out.println("JoinsNamespaceOf: " + cronie.getJoinsNamespaceOf());
        System.out.println("LoadError: " + cronie.getLoadError());
        System.out.println("LoadState: " + cronie.getLoadState());
        System.out.println("Names: " + cronie.getNames());
        System.out.println("NeedDaemonReload: " + cronie.isNeedDaemonReload());
        System.out.println("NetClass: " + cronie.getNetClass());
        System.out.println("OnFailure: " + cronie.getOnFailure());
        System.out.println("OnFailureJobMode: " + cronie.getOnFailureJobMode());
        System.out.println("PartOf: " + cronie.getPartOf());
        System.out.println("PropagatesReloadTo: " + cronie.getPropagatesReloadTo());
        System.out.println("RefuseManualStart: " + cronie.isRefuseManualStart());
        System.out.println("RefuseManualStop: " + cronie.isRefuseManualStop());
        System.out.println("ReloadPropagatedFrom: " + cronie.getReloadPropagatedFrom());
        System.out.println("RequiredBy: " + cronie.getRequiredBy());
        System.out.println("Requires: " + cronie.getRequires());
        System.out.println("RequiresMountsFor: " + cronie.getRequiresMountsFor());
        System.out.println("Requisite: " + cronie.getRequisite());
        System.out.println("RequisiteOf: " + cronie.getRequisiteOf());
        System.out.println("SourcePath: " + cronie.getSourcePath());
        System.out.println("StopWhenUnneeded: " + cronie.isStopWhenUnneeded());
        System.out.println("SubState: " + cronie.getSubState());
        System.out.println("Transient: " + cronie.isTransient());
        System.out.println("TriggeredBy: " + cronie.getTriggeredBy());
        System.out.println("Triggers: " + cronie.getTriggers());

        System.out.println("WantedBy: " + cronie.getWantedBy());
        System.out.println("Wants: " + cronie.getWants());

        System.out.println();

        System.out.println("'cronie' properties (service interface):");
        System.out.println("ControlGroup: " + cronie.getControlGroup());
        System.out.println("Environment: " + cronie.getEnvironment());
        System.out.println("ExecReload: " + cronie.getExecReload());
        System.out.println("ExecStart: " + cronie.getExecStart());
        System.out.println("ExecStartPost: " + cronie.getExecStartPost());
        System.out.println("ExecStartPre: " + cronie.getExecStartPre());
        System.out.println("ExecStop: " + cronie.getExecStop());
        System.out.println("ExecStopPost: " + cronie.getExecStopPost());
        System.out.println("MainPID: " + cronie.getMainPID());
        System.out.println("Result: " + cronie.getResult());
        System.out.println("SELinuxContext: " + cronie.getSELinuxContext());
        System.out.println("StandardError: " + cronie.getStandardError());
        System.out.println("StandardInput: " + cronie.getStandardInput());
        System.out.println("StandardOutput: " + cronie.getStandardOutput());
        System.out.println("Type: " + cronie.getType());

        System.out.println();

        System.out.println("'cronie' methods (unit interface, work only with privileges):");
//        System.out.println("Start: " + cronie.start(Mode.FAIL));
//        System.out.println("Stop: " + cronie.stop(Mode.FAIL));

//        System.out.println(manager.dump());
    }

    public static void main(String[] args) {
        Systemd systemd = new Systemd();

        try {
            systemd.connect();

//            introspect(systemd.getManager());
            properties(systemd.getManager());
            methods(systemd.getManager());
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
        finally {
            systemd.disconnect();

            System.exit(0);
        }
    }

}
