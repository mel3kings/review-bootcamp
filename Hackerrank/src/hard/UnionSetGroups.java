package hard;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class UnionSetGroups {

    /**
     * https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/
     * https://www.hackerrank.com/challenges/friend-circle-queries/forum
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<String> queryType = new ArrayList<>();
        queryType.add("Friend");
        queryType.add("Friend");
        queryType.add("Total");
        ArrayList<Integer> student1 = new ArrayList<>();
        student1.add(4);
        student1.add(2);
        student1.add(2);


        ArrayList<Integer> student2 = new ArrayList<>();
        student2.add(1);
        student2.add(4);
        student2.add(3);

        //0,1,2,3,4
        //0,4,2,3,4
        //0,2,2,3,2
        //0,2,2,3,2
        List results = getTheGroups(5, queryType, student1, student2);
        System.out.println(results);
    }

    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        int[] friends = new int[n];
        List<Integer> results = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> friends[i] = i);


        for (int i = 0; i < queryType.size(); i++) {
            String query = queryType.get(i);
            int student1 = students1.get(i);
            int student2 = students2.get(i);
            if (query.equals("Friend")) {
                IntStream.range(0, n).forEach(j -> {
                    if (friends[j] == student2) {
                        friends[j] = student1;
                    }
                });
            } else if (query.equals("Total")) {
                long student1Friends = Arrays.stream(friends).filter(x -> x == student1).count();
                long student2Friends = Arrays.stream(friends).filter(x -> x == student2).count();
                results.add((int) student1Friends);
                results.add((int) student2Friends);
            }
        }

        return results;
    }


}
