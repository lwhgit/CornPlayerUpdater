package com.lwh8762.cornupdater;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionComparator {

    private String version = null;
    private int[] versionNumbers = null;

    public VersionComparator(String version) throws VersionParsingException{
        Pattern versionRegexp = Pattern.compile("([0-9][.]?)+");
        Matcher matcher = versionRegexp.matcher(version);
        if (matcher.find()) {
            this.version = version;
            versionNumbers = Arrays.stream(version.split("[.]")).mapToInt(Integer::parseInt).toArray();
        } else {
            throw new VersionParsingException(version);
        }
    }

    public boolean isLargerThen(VersionComparator o) {
        int tmp = Math.min(this.versionNumbers.length, o.versionNumbers.length);
        for (int i = 0;i < tmp;i ++) {
            if (this.versionNumbers[i] > o.versionNumbers[i]) {
                return true;
            }
        }
        return false;
    }

    public class VersionParsingException extends Exception {
        public VersionParsingException(String str) {
            super("The string is not version. String: " + str);
        }
    }
}
