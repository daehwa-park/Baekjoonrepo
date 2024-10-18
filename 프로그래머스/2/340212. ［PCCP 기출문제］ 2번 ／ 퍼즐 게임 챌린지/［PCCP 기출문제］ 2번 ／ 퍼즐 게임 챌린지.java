import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int max = 0;
        int min = 1;
        for(int d : diffs) {
            max = Math.max(max, d);
        }
        
        int lv = (min + max) / 2;
        int mlv = max;
        while(true) {
            long time = times[0];
            for(int i = 1; i < diffs.length; i++) {
                if(diffs[i] <= lv) {
                    time += times[i];
                }
                else {
                    time += ((times[i] + times[i - 1]) * (diffs[i] - lv)) + times[i];
                }
            }
            if(time > limit) {
                min = lv;
                lv = (min + max) / 2;
                if(lv == min) {
                    break;
                }
            }
            else {
                mlv = lv;
                max = lv;
                lv = (min + max) / 2;
                if(min == max) {
                    break;
                }
            }
            
        }
        
        return mlv;
    }
}