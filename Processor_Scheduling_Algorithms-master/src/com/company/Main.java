package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Random;

public class Main {

    public static void generate(ArrayList<Proces> arr) {// SJF
        arr.add(new Proces(1, 2, 6, 0, 0));
        arr.add(new Proces(2, 5, 2, 0, 0));
        arr.add(new Proces(3, 1, 8, 0, 0));
        arr.add(new Proces(4, 0, 3, 0, 0));
        arr.add(new Proces(5, 4, 4, 0, 0));

    }

    public static void generate0(ArrayList<Proces> arr) {// FCFS
        arr.add(new Proces(1, 0, 2, 0, 0));
        arr.add(new Proces(2, 1, 6, 0, 0));
        arr.add(new Proces(3, 2, 4, 0, 0));
        arr.add(new Proces(4, 3, 9, 0, 0));
        arr.add(new Proces(5, 6, 12, 0, 0));
    }

    public static void generate1(ArrayList<Proces> arr) {// RR
        arr.add(new Proces(1, 0, 5, 0, 0));
        arr.add(new Proces(2, 1, 6, 0, 0));
        arr.add(new Proces(3, 2, 3, 0, 0));
        arr.add(new Proces(4, 3, 1, 0, 0));
        arr.add(new Proces(5, 4, 5, 0, 0));
        arr.add(new Proces(6, 6, 4, 0, 0));
    }

    public static void generate2(ArrayList<Proces> arr) {// SJF
        arr.add(new Proces(1, 2, 6, 0, 0));
        arr.add(new Proces(2, 5, 25, 0, 0));
        arr.add(new Proces(3, 1, 100, 0, 0));
        arr.add(new Proces(4, 0, 3, 0, 0));
        arr.add(new Proces(5, 4, 4, 0, 0));

    }

    // public static void generate3(ArrayList<Proces> arr) {// big numbers
    //     arr.add(new Proces(1, 2, 6, 0, 0));
    //     arr.add(new Proces(2, 5, 25, 0, 0));
    //     arr.add(new Proces(3, 1, 100, 0, 0));
    //     arr.add(new Proces(4, 0, 3, 0, 0));
    //     arr.add(new Proces(5, 4, 4, 0, 0));

    // }

    public static void rand_generate(ArrayList<Proces> arr) {
        Random rand = new Random();
        for (int i = 0; i <= 200; i++) {
            arr.add(new Proces(i, i, rand.nextInt(1, 10), 0, 0));
        }
    }

    public static void main(String[] args) {
        ArrayList<Proces> arr = new ArrayList<>();
        generate0(arr);
        Procesy pr = new Procesy();
        // System.out.println("RR: " + pr.RR(4, arr));
        // System.out.println("SJF: " + pr.SJF(arr));
        System.out.println("FCFS: " + pr.FCFS(arr));

        // arr.clear();
        // rand_generate(arr);
        // System.out.println("RR: " + pr.RR(3, arr));
        // System.out.println("SJF: " + pr.SJF(arr));
        // System.out.println("FCFS: " + pr.FCFS(arr));

    }
}
