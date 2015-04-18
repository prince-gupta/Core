package forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by Pgupta on 2/25/2015.
 */
public class ForkJoinTest {

    static ForkJoinPool forkJoinPool = new ForkJoinPool(1);
    public static final int LENGTH = 21;
    public static void main(String[] args) {
        int [] numbers = new int[LENGTH];
        //Create  an array with some values.
        for(int i=0; i<LENGTH; i++){
            numbers[i] = i * 2;
        }
        /*
         * Invoke the NumberDividerTask with the array
         * which in turn creates multiple sub tasks.
         */
        long sum = forkJoinPool.invoke(new NumberDividerTask(numbers));

        System.out.println("Sum: "+sum);
    }
}