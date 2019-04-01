package hackerrank;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        //Converting list to Frequency Map
        Map<Integer, Long> frequencyMap =
                arr
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(), Collectors.counting()
                                )
                        ).entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // Getting first entry for a Map
        Map.Entry<Integer, Long> firstEntry = frequencyMap.entrySet().iterator().next();
        long highestFrequency = firstEntry.getValue();

        //Converting Map to Treemap
        Map<Integer, Long> resultMap = frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == highestFrequency)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue(), (oldV, newV) -> newV, TreeMap::new));


        return resultMap.entrySet().iterator().next().getKey();

    }

    static void test(List<Integer> list) {
        list.stream()
                .collect(
                        Collectors.toMap(Function.identity(), e -> e * 2)
                );
    }


    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        migratoryBirds(list);
    }
}
