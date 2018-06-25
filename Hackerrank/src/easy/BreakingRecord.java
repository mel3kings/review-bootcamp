package easy;

import java.util.Arrays;

public class BreakingRecord {

    public static void main(String[] args){

    }
    static int[] breakingRecords(int[] scores) {
        int[] compare = {scores[0], scores[0]};
        int[] result = new int[2];
        Arrays.stream(scores).forEach(score ->{
            if(score > compare[0]){
                result[0]++;
                compare[0] = score;
            }else if(score < compare[1]){
                result[1]++;
                compare[1] = score;
            }
        });
        return result;

    }
}
