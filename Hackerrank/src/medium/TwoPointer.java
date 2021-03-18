package medium;

import java.util.*;

public class TwoPointer {
        public int[] prisonAfterNDays(int[] cells, int n) {
            int[] response = Arrays.copyOfRange(cells, 0, cells.length);
            for(int i = 0; i < n; i++){

                for(int j = 0; j < cells.length; j++){

                    if(j == 0 || j == cells.length-1){
                        response[j] = 0;
                        continue;
                    }
                    int left = j-1, right = j+1;
                    if(cells[left] == cells[right]){
                        response[j] = 1;
                    }else{
                        response[j] = 0;
                    }
                    left++;
                    right++;
                }
                cells = Arrays.copyOfRange(response, 0, response.length);
            }
            return response;
    }
}
