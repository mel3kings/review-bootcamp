package crackingcode.stringsandarrays;

public class NumberOfOccurences {

    public static void main(String[] args) {
        String holder= "ABCABCABDABEasdadasdsadasAB";
        String remove = "AB";
        int num = 0;

        while(holder.contains(remove)){
            int index = holder.indexOf(remove);
            int end = index + remove.length();
            holder = holder.substring(0, index) + holder.substring(end, holder.length());
            num++;
        }
        System.out.println("Number of occurrences of " + num );
    }
}
