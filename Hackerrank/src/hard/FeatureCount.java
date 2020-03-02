package hard;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FeatureCount {
    public static ArrayList<String> popularNFeatures(int numFeatures,
                                                     int topFeatures, List<String> possibleFeatures,
                                                     int numFeatureRequests,
                                                     List<String> featureRequests) {
        Set<String> requests = featureRequests.stream().flatMap(r ->
                Arrays.stream(r.split(" "))).collect(Collectors.toSet());
        Map<String, Long> featuresMap =
                possibleFeatures.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        requests.stream().filter(featuresMap::containsKey).forEach(request -> featuresMap.computeIfPresent(request,
                (k, v) -> v + 1));
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Testing");
        ArrayList<String> list = new ArrayList<>();
        list.add("Asdasd");
        list.add("BLAH BLAH");
        popularNFeatures(1, 1, list, 0, list);
    }
}