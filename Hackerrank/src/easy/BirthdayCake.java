package easy;

public class BirthdayCake {
    static int solve(int[] s, int d, int m) {
        int totalCorrect  = 0;
        for(int start = 0; start < s.length; start++){
            int partsTotal =0, numberOfSteps = 0;
            for(int chunk = start; chunk < (start + m) && chunk < s.length; chunk++){
              partsTotal+=s[chunk];
              numberOfSteps++;
                if(numberOfSteps == m && partsTotal == d){
                  totalCorrect++;
              }
          }
        }
    return totalCorrect;
    }

    public static void main(String[] args){
        int[] s ={1, 2, 1, 3, 2};
        int d = 3;
        int m = 2;
        System.out.print(solve(s,d,m));

    }
}
