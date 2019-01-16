package com.lwh8762.cornupdater;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrentVersionChecker {
    private static final String CHANGE_PATH = "D:\\Program Files\\CORNPlayerW.x64\\Changes.txt";

    private String version = null;

    public CurrentVersionChecker() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(CurrentVersionChecker.CHANGE_PATH));
        String text = br.readLine();
        Pattern versionRegexp = Pattern.compile("([0-9][.]?)+");
        Matcher matcher = versionRegexp.matcher(text);
        matcher.find();
        version = matcher.group();
    }

    public String getVersion() {
        return version;
    }
}
