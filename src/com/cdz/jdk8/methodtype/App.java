package com.cdz.jdk8.methodtype;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;


public class App {
    public static void main(String[] args) throws Throwable {
        Object o = new PrintStrem();
        getMH(o).invoke("2222");

    }

    public static MethodHandle getMH(Object receiver) {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        try {
            return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
