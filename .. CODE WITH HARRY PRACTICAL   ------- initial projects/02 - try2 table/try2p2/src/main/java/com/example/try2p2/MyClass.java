package com.example.try2p2;

public class MyClass {
    public static void main(String[] args) {

        for (int i = 10; i < 1; i--) {

            for (int j = 10; j < i; i--){

                System.out.print("*");
            }
            System.out.println();

        }

    }
}