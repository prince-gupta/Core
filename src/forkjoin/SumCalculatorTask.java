package forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Pgupta on 2/25/2015.
 */
class SumCalculatorTask extends RecursiveTask<Integer> {
    int [] numbers;
    SumCalculatorTask(int[] numbers){
        this.numbers = numbers;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        for (int i : numbers){
            sum += i;
        }
        return sum;
    }
}