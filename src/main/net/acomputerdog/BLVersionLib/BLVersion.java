package net.acomputerdog.BLVersionLib;

/**
 * Represents a BlazeLoader version.
 */
public class BLVersion {
    private final String mcVersion;
    private final String blVersion;
    private final String dlURL;

    /**
     * Creates a new BLVersion.
     *
     * @param mcVersion The Minecraft version string
     * @param blVersion The BlazeLoader version string
     * @param dlURL     The download URL of this BlazeLoader version
     */
    public BLVersion(String mcVersion, String blVersion, String dlURL) {
        this.mcVersion = mcVersion == null ? "" : mcVersion;
        this.blVersion = blVersion == null ? "" : blVersion;
        this.dlURL = dlURL == null ? "" : dlURL;
    }

    public String getMcVersion() {
        return mcVersion;
    }

    public String getBlVersion() {
        return blVersion;
    }

    public String getDownloadURL() {
        return dlURL;
    }

    @Override
    public int hashCode() {
        return mcVersion.hashCode() + blVersion.hashCode() + dlURL.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof BLVersion)) return false;
        BLVersion other = (BLVersion) obj;
        return this.blVersion.equals(other.blVersion) && this.mcVersion.equals(other.mcVersion) && this.dlURL.equals(other.dlURL);
    }

    @Override
    public String toString() {
        return mcVersion + "_" + blVersion + "=" + dlURL;
    }
}
