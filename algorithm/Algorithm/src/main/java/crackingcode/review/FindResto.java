package crackingcode.review;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

public class FindResto {

    public static void main(String[] args) {
        FindResto d = new FindResto();
        ArrayList<Integer> restos = new ArrayList<Integer>();
        restos.add(1);
        restos.add(2);

        ArrayList<Integer> restos2 = new ArrayList<Integer>();
        restos2.add(3);
        restos2.add(4);

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(restos);
        listOfLists.add(restos2);

        mapLocations(listOfLists);
        d.findNearestResto(2, listOfLists, 2);
    }

    List<List<Integer>> findNearestResto(int totalResto, List<List<Integer>> allResto, int size) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        TreeMap<Double, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < totalResto && i < allResto.size(); i++) {
            List<Integer> list = allResto.get(i);
            double l = 0.0;
            for (Integer x : list) {
                l += x * x;
            }
            map.put(Math.sqrt(l), list);
        }
        if (map.size() > 0) {
            for (int get = 0; get < size; get++) {
                results.add(map.get(map.firstKey()));
                map.remove(map.firstKey());
            }

        }
        return results;
    }

    private static CompletableFuture<TreeMap> mapLocations(List<List<Integer>> allResto) {
        TreeMap<Double, List<Integer>> map = new TreeMap<>();
        allResto.stream().forEach(s -> {
            List<Integer> list = s;
            Double key = s.stream().mapToDouble(Math::sqrt).sum();
            map.put(key, list);
        });

        CompletableFuture<TreeMap> future = new CompletableFuture<>();
        future.complete(map);
        return future;
    }


}
