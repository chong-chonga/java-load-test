package com.lexin;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huanglexin
 * @version 1.0
 * @date 2023/10/2414:34
 */
public class Load {

    private int sleepMillis = 0;
    private int mode = 1;

    private final int DEFAULT_MODE = 1;

    public Load(int sleepMillis, int mode) {
        this.sleepMillis = sleepMillis;
        this.mode = mode;
    }

    public void run() throws InterruptedException {
        long start = System.currentTimeMillis();
        try {
            switch (mode) {
                case DEFAULT_MODE:
                    simple();
                    break;
                default:
                    System.out.println("Unknown load mode: " + mode);
            }

        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        System.out.println("total time = " + (System.currentTimeMillis() - start) + ", ms");
        System.out.println("done");

    }

    private void simple() throws InterruptedException, OutOfMemoryError {
        // 消耗2GB内存
        int n = 2 * 1024 * 1024 / 8;
        List<String[]> garbage = new LinkedList();
        for (int i = 0; i < n; i++) {
            String[] str = new String[1024];
            garbage.add(str);
            // 每轮循环 8 KB
            if (i % 100 == 0) {
                Thread.sleep(sleepMillis);
            }
        }
    }

}
