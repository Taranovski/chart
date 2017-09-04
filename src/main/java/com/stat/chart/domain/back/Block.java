package com.stat.chart.domain.back;

/**
 * Created by Titan on 04.09.2017.
 */
public class Block {
    private int height;
    private String hash;
    private long time;
    private boolean main_chain;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isMain_chain() {
        return main_chain;
    }

    public void setMain_chain(boolean main_chain) {
        this.main_chain = main_chain;
    }
}
