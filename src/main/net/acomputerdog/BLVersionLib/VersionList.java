package net.acomputerdog.BLVersionLib;

import java.util.Map;

/**
 * Interface representing a BL version list.
 */
public interface VersionList {

    /**
     * Gets all BL versions from this VersionList
     *
     * @return Return an Array of BLVersions containing all versions from this list.  Should be ordered the
     */
    public Map<String, BLVersion> getVersions();

    /**
     * Gets the newest BLVersion from this list
     *
     * @return Return the newest BLVersion from this list.
     */
    public BLVersion getNewestVersion();

    /**
     * Gets all BLVersions that support the specified MC version
     *
     * @param mcVer The version string to look for
     * @return Return an Array of BLVersions containing the versions that support the specified MC version
     */
    public Map<String, BLVersion> getVersionsByMC(String mcVer);
}
