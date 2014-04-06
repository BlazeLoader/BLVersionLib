package net.acomputerdog.BLVersionLib;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * A version list loaded from a file
 */
public class StreamVersionList implements VersionList {
    private static final String REGEX_UNDERSCORE = Pattern.quote("_");

    private final BLVersion newestVersion;
    private final Map<String, BLVersion> allVersions = new HashMap<String, BLVersion>();

    public StreamVersionList(InputStream in) {
        try {
            Properties prop = new Properties();
            prop.load(in);
            for (Object obj : prop.keySet()) {
                String version = (String) obj;
                if (!"newest".equals(version)) {
                    String[] parts = version.split(REGEX_UNDERSCORE);
                    if (parts.length >= 2) {
                        allVersions.put(version, new BLVersion(parts[0], parts[1], prop.getProperty(version)));
                    }
                }
            }
            newestVersion = allVersions.get(prop.getProperty("newest", ""));
        } catch (Exception e) {
            throw new RuntimeException("Unable to load version list!", e);
        }
    }

    /**
     * Gets all BL versions from this VersionList
     *
     * @return Return an Array of BLVersions containing all versions from this list.  Should be ordered the
     */
    @Override
    public Map<String, BLVersion> getVersions() {
        return allVersions;
    }

    /**
     * Gets the newest BLVersion from this list
     *
     * @return Return the newest BLVersion from this list.
     */
    @Override
    public BLVersion getNewestVersion() {
        return newestVersion;
    }

    /**
     * Gets all BLVersions that support the specified MC version
     *
     * @param mcVer The version string to look for
     * @return Return an Array of BLVersions containing the versions that support the specified MC version
     */
    @Override
    public Map<String, BLVersion> getVersionsByMC(String mcVer) {
        Map<String, BLVersion> mcVers = new HashMap<String, BLVersion>();
        for (Object obj : mcVers.keySet()) {
            String versionName = (String) obj;
            if (versionName.split(REGEX_UNDERSCORE)[0].equals(mcVer)) {
                mcVers.put(versionName, allVersions.get(versionName));
            }
        }
        return mcVers;
    }

}
