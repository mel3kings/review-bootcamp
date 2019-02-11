package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MigratoryBirds {

    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
        x.add(2);
        x.add(2);
        x.add(3);
        x.add(3);
        System.out.println(migratoryBirds(x));

    }

    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Long> map = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        return max;
    }
}
