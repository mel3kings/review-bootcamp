package crackingcode.review;


import java.util.*;

public class FindResto {

    public static void main(String[] args) {
        FindResto d = new FindResto();
        ArrayList<Integer> restos = new ArrayList<Integer>();
        restos.add(1);
        restos.add(2);

        ArrayList<Integer> restos2 = new ArrayList<Integer>();
        restos2.add(1);
        restos2.add(2);

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(restos);
        listOfLists.add(restos2);

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


}
