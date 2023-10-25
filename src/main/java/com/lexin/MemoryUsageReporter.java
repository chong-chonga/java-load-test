package com.lexin;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JVM内存使用状况报告器
 * @author huanglexin
 * @version 1.0
 * @date 2023/10/2414:34
 */
public class MemoryUsageReporter implements Runnable {

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MemoryUsageReporter.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.lang.management.MemoryUsage mu = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();

            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");

            print(ft.format(dNow) + " -> Init", mu.getInit());
            print("Used", mu.getUsed());
            print("Committed", mu.getCommitted());
            print("Max", mu.getMax());

            System.out.println();
        }

    }

    private void print(String name, double value) {
        System.out.print(name + ": " + Math.round(value / 1024 / 1024) + "M ");
    }
}
