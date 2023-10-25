package com.lexin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author huanglexin
 * @version 1.0
 * @date 2023/10/2414:33
 */
public class Main {

    private static int DEFAULT_SLEEP_MILLIS = 10;

    private static int DEFAULT_MODE = 1;


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Press <Enter> to start the gc test");
        System.out.println("test start, args:" + Arrays.toString(args));
        int sleepMillis = DEFAULT_SLEEP_MILLIS;
        if (args.length > 0) {
            sleepMillis = Integer.parseInt(args[0]);
        }
        int loadMode = DEFAULT_MODE;
        if (args.length > 1) {
            loadMode = Integer.parseInt(args[1]);
        }
        new Thread(new MemoryUsageReporter()).start();

        while (true) {
            // 命令行控制每一轮的测试开始
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            Load test = new Load(sleepMillis, loadMode);
            test.run();
            test = null;
            Thread.sleep(10000);
        }
    }

    public class XXXDTO {

    }
}