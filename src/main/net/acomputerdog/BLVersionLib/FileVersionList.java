package net.acomputerdog.BLVersionLib;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * A VersionList that is loaded from a file.
 */
public class FileVersionList extends StreamVersionList {
    public FileVersionList(File source) throws FileNotFoundException {
        super(new BufferedInputStream(new FileInputStream(source)));
    }
}
