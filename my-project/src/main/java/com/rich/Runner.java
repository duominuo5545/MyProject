package com.rich;

/**
 * Created by hanwang206326 on 16/1/27.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("execute");
            });
        } finally {
            System.out.println("finally");
        }
    }

    private static void execute(Runner1 runner1) {
        runner1.run();
    }

    private static interface Runner1 {
        public void run();
    }
}
