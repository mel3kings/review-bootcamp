package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Comparators {
    public static void main(String[] args) {
        System.out.println(getMax(Arrays.asList(0, 50, 100)));
        System.out.println(getAverage(new int[]{0,50,100,150}));
    }

    public static int getMax(List<Integer> x) {
        Optional<Integer> result = x.stream().collect(Collectors.maxBy(Comparator.comparing(Integer::intValue)));
        return result.orElse(0);
    }

    public static double getAverage(int[] x){
        return Arrays.stream(x).boxed().collect(Collectors.averagingInt(Integer::intValue));
    }
}
