package com.company.dynamicProgramming;

import java.util.Scanner;

/**
 * Created by princegupta on 31/10/17.
 */
public class Fibonacci {
    long[] lookup;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.intializeLookup(number);
        long startTime = System.currentTimeMillis();
        //System.out.println(fibonacci.fib(number));
        //long endTime = System.currentTimeMillis();
        //System.out.println("Time Taken without Dynamic Problem :  " + ((endTime - startTime)) );

        long startTime2 = System.currentTimeMillis();
        System.out.println(fibonacci.fibDynamic(number));
        long endTime2 = System.currentTimeMillis();
        System.out.println("Time Taken with Dynamic Problem :  " + ((endTime2 - startTime2)));

    }

    public void intializeLookup(int length){
        lookup = new long[length+1];
    }

    public long fibDynamic(int n){
        if(lookup[n] == 0){
            if( n <= 1){
                lookup[n] = n;
            }
            else{
                lookup[n] = fibDynamic(n-1) + fibDynamic(n-2);
            }
        }
        return lookup[n];

    }

    public long fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);

    }
}
