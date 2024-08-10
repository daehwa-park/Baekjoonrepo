import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (x1, x2) -> x1[1] - x2[1]);
        
        int end = 0;
        for(int[] target : targets) {
            if(target[0] >= end) {
                answer++;
                end = target[1];
            }
        }
        
        return answer;
    }
}