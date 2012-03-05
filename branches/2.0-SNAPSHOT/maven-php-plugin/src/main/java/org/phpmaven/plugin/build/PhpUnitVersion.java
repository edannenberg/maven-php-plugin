package org.phpmaven.plugin.build;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PHPUnit version.
 * 
 * @author Erik Dannenberg
 */
public class PhpUnitVersion {

    private int major = 0;
    private int minor = 0;
    private int patch = 0;
    private boolean stableRelease = true;

    public PhpUnitVersion(String phpUnitVersion) {
        Pattern pattern = Pattern.compile("([0-9]+).([0-9]+).([0-9]+)([A-Za-z0-9]*)");
        Matcher matcher = pattern.matcher(phpUnitVersion);
        if (matcher.find()) {
            major = Integer.parseInt(matcher.group(1));
            minor = Integer.parseInt(matcher.group(2));
            patch = Integer.parseInt(matcher.group(3));
            if (matcher.group(4) != null) {
                stableRelease = false;
            }
        }
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getPatch() {
        return patch;
    }

    public boolean isStableRelease() {
        return stableRelease;
    }

}
