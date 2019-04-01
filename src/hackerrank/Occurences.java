package hackerrank;

import java.util.Scanner;

/**
 * Created by princegupta on 12/03/18.
 */
public class Occurences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainString = scanner.next();
        String substring = scanner.next();

        int counter = 0;
        for (int i =0 ; i < ((mainString.length() - substring.length()) + 1); i ++){
            if(mainString.substring(i, i + substring.length()).equals(substring))
                counter ++ ;
        }

        System.out.print(counter);
    }
}
