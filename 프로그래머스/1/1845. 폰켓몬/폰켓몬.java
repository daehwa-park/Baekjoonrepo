import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        
        answer = Math.min(nums.length / 2, set.size());
        
        return answer;
    }
}