package com.cdz.keyboard;

import java.awt.*;
import java.awt.event.KeyEvent;

public class App {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Thread t1 = new Thread(new Worker());
        t1.start();
    }

    private static class Worker implements Runnable {
        private Integer[] keyCodes = {KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F, KeyEvent.VK_G, KeyEvent.VK_C};
        private Robot robot;

        Worker() {
            try {
                this.robot = new Robot();
                this.robot.setAutoDelay(2000);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < keyCodes.length; i++) {
                    robot.keyPress(keyCodes[i]);
                    robot.keyRelease(keyCodes[i]);
                }
            }
        }
    }
}

