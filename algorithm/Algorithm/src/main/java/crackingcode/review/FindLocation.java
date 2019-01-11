package crackingcode.review;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindLocation {

    public static void main(String[] args) {
        FindLocation d = new FindLocation();
        ArrayList<Integer> location1 = new ArrayList<Integer>();
        location1.add(1);
        location1.add(2);

        ArrayList<Integer> location2 = new ArrayList<Integer>();
        location2.add(5);
        location2.add(4);

        ArrayList<Integer> location3 = new ArrayList<Integer>();
        location3.add(10);
        location3.add(9);

        ArrayList<Integer> location4 = new ArrayList<Integer>();
        location4.add(1);
        location4.add(2);

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(location1);
        listOfLists.add(location2);
        listOfLists.add(location3);
        listOfLists.add(location4);

        List<List<Integer>> result = d.findNearestLocation(4, listOfLists, 2);
        System.out.println(result);
    }

    List<List<Integer>> findNearestLocation(int total, List<List<Integer>> allLocations, int numOfReturn) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        TreeMap<Double, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < total && i < allLocations.size(); i++) {
            List<Integer> list = allLocations.get(i);
            double l = 0.0;
            for (Integer x : list) {
                l += x * x;
            }
            map.put(Math.sqrt(l), list);
        }
        if (map.size() > 0) {
            for (int get = 0; get < numOfReturn; get++) {
                results.add(map.get(map.firstKey()));
                map.remove(map.firstKey());
            }

        }
        return results;
    }
}
