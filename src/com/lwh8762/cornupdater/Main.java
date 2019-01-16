package com.lwh8762.cornupdater;

import java.io.IOException;

public class Main {

    private CurrentVersionChecker currentVersionChecker = null;
    private UpdateChecker updateChecker = null;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try {
            currentVersionChecker = new CurrentVersionChecker();
            updateChecker = new UpdateChecker();

            boolean tmp = new VersionComparator(updateChecker.getVersion()).isLargerThen(new VersionComparator(currentVersionChecker.getVersion()));

            System.out.println(currentVersionChecker.getVersion());
            System.out.println(updateChecker.getVersion());
            System.out.println(tmp);

            if (tmp) {
                Runtime.getRuntime().exec("D:\\Program Files\\CORNPlayerW.x64\\Updater.x64.exe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (VersionComparator.VersionParsingException e) {
            e.printStackTrace();
        }
    }
}
