package com.cdz.jn;

public class Util {
    public static final Util getInstance() {
        return Instance.util;
    }

    private Util() {

    }

    private static class Instance {
        private static Util util = new Util();
    }
}
