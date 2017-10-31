package com.company.problems;

/**
 * Created by Pgupta on 4/5/2015.
 */
public class FibonnaciSeries {
    public static void main(String[] args) {

        for(int i = 1 ; i <= 10 ; i++){
            System.out.print(fibonnaciRecursion(i) + " ");
        }
        System.out.print("\n");
        for(int i = 1 ; i <= 10 ; i++){
            System.out.print(fibonnaciLoop(i) + " ");
        }
    }

    private static int fibonnaciRecursion(int number){
        if(number == 1 || number == 2){
            return 1;
        }

        return fibonnaciRecursion(number - 1) + fibonnaciRecursion( number -2);
    }

    private static int fibonnaciLoop(int number){
        if(number == 1 || number == 2)
            return 1;
        int fibo1 = 1 , fibo2 = 1, fibonnaci=1;
        for(int i = 3 ; i <= number ; i++ ){
            fibonnaci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonnaci;
        }
        return fibonnaci;
    }
}
