package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        Arrays.sort(unsorted, (left, right) -> {
            if (left.length() != right.length())
                return left.length() - right.length();
            return left.compareTo(right);
        });

        for(int index = 0 ; index < unsorted.length; index ++){
            System.out.println(unsorted[index]);
        }
    }
}