package com.yuan.cardview.thread.wait;

public class Express {
    public final static String CITY = "ShangHai";
    private int km = 0;
    private String site;

    Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void waitKm() {
        while (km < 100) {
            try {
                System.out.println("里程检测中...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("检测到里程改变" + km);
    }

    public synchronized void updateKm(int km) {
        this.km = km;
        notifyAll();
    }

    public synchronized void waitSite() {
        while (CITY.equalsIgnoreCase(site)) {
            try {
                System.out.println("站点检测中...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("检测到站点改变" + site);
    }

    public synchronized void updateSite(String site) {
        this.site = site;
        notifyAll();
    }

}
