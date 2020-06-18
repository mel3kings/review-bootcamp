package hard;

import java.util.*;

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
        location4.add(-3);
        location4.add(4);

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
        TreeMap<Double, List<Integer>> shortest = new TreeMap<>();
        for (int i = 0; i < total; i++) {
            List<Integer> coordinates = allLocations.get(i);
            int x = coordinates.get(0);
            int y = coordinates.get(1);

            double distance = Math.sqrt(Math.pow(-x, 2) + Math.pow(-y, 2));
            List<Integer>  list = new ArrayList<>();
            list.add(x);
            list.add(y);
            shortest.put(distance, list);
            System.out.println(distance);
        }
        int counter = 0;
        for (List l : shortest.values()) {
            results.add(l);
            if (counter == numOfReturn - 1) {
                break;
            }
            counter++;
        }
        return results;
    }
}

