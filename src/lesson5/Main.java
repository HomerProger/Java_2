package lesson5;

import java.util.Arrays;

public class Main implements Runnable {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    static void withOutFlow(int size) {
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) 1.0;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    static void withFlow(int size, int half) throws InterruptedException {
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) 1.0;
        }
        long a = System.currentTimeMillis();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, HALF, arr2, 0, half);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args) throws InterruptedException {
        withOutFlow(SIZE);
        withFlow(SIZE, HALF);

    }

    @Override
    public void run() {

    }
}
