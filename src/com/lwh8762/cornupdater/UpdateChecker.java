package com.lwh8762.cornupdater;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateChecker {
    private static final String URL = "https://cornplayer.com/main/";
    private static final String UPDATE_INFO_SELECTOR = "#tie-block_514 > div > div.mag-box-container > ul > li > div > h3 > a";

    private String version = null;

    public UpdateChecker() throws IOException {
        Document document = Jsoup.connect(UpdateChecker.URL).get();
        Element element = document.select(UpdateChecker.UPDATE_INFO_SELECTOR).get(0);
        String text = element.text();
        Pattern versionRegexp = Pattern.compile("([0-9][.]?)+");
        Matcher matcher = versionRegexp.matcher(text);
        matcher.find();
        version = matcher.group();
    }

    public String getVersion() {
        return version;
    }
}
