package net.acomputerdog.BLVersionLib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Central wrapper class for BLVersionLib
 */
public class VersionLib {
    private static final Map<String, BLVersion> versionMap;
    private static final List<BLVersion> allVersions;
    private static final BLVersion newest;

    static {
        try {
            VersionList vl = new OnlineVersionList();
            versionMap = vl.getVersions();
            newest = vl.getNewestVersion();
            allVersions = new ArrayList<BLVersion>();
            for (BLVersion ver : versionMap.values()) {
                allVersions.add(ver);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize VersionLib!", e);
        }
    }

    public static BLVersion getNewestVersion() {
        return newest;
    }

    public static Map<String, BLVersion> getVersionMap() {
        return versionMap;
    }

    public static List<BLVersion> getAllVersions() {
        return allVersions;
    }
}
