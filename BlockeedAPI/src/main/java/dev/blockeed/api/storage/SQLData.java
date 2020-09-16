package dev.blockeed.api.storage;

/*
 * Copyright (c) Blockeed | All rights reserved
 *
 * Do not change the code!
 *
 */

public class SQLData {

    private Object object;

    public SQLData(String string) {
        this.object=string;
    }

    public SQLData(Integer integer) {
        this.object=integer;
    }

    public SQLData(boolean bool) {
        this.object=bool;
    }

    public SQLData(double d) {
        this.object=d;
    }

    public SQLData(long l) {
        this.object=l;
    }

    public String getAsString() {
        return String.valueOf(object);
    }

    public Integer getAsInt() {
        return Integer.valueOf(getAsString());
    }

    public boolean getAsBoolean() {
        return Boolean.valueOf(getAsString());
    }

    public double getAsDouble() {
        return Double.valueOf(getAsString());
    }

    public long getAsLong() {
        return Long.valueOf(getAsString());
    }

}
