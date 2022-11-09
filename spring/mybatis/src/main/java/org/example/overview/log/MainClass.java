package org.example.overview.log;

import org.example.overview.log.job.CustomCronTrigger;

public class MainClass {
    public static void main(String[] args) {
//        LogExample logExample = new LogExample();
//        logExample.printLog();

        CustomCronTrigger customCronTrigger = new CustomCronTrigger();
        customCronTrigger.start();
    }
}
