package net.acomputerdog.BLVersionLib;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Interface representing a BL version list.
 */
public abstract class VersionList {
    public static final String REGEX_UNDERSCORE = Pattern.quote("_");

    /**
     * Gets all BL versions from this VersionList
     *
     * @return Return an Array of BLVersions containing all versions from this list.  Should be ordered the
     */
    public abstract Map<String, BLVersion> getVersions();

    /**
     * Gets the newest BLVersion from this list
     *
     * @return Return the newest BLVersion from this list.
     */
    public abstract BLVersion getNewestVersion();

    /**
     * Gets all BLVersions that support the specified MC version
     *
     * @param mcVer The version string to look for
     * @return Return an Array of BLVersions containing the versions that support the specified MC version
     */
    public Map<String, BLVersion> getVersionsByMC(String mcVer) {
        Map<String, BLVersion> mcVers = new HashMap<String, BLVersion>();
        for (Object obj : mcVers.keySet()) {
            String versionName = (String) obj;
            if (versionName.split(REGEX_UNDERSCORE)[0].equals(mcVer)) {
                mcVers.put(versionName, getVersions().get(versionName));
            }
        }
        return mcVers;
    }
}
