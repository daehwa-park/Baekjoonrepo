import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        HashMap<Long, Long> map = new HashMap<>();
        
        for(int w : weights) {
            long key = (long)w;
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }
        
        for(Long k : map.keySet()) {
            
            answer += (map.get(k) * (map.get(k) - 1)) / 2;
            
            answer += map.get(k) * map.getOrDefault(k * 2, 0L);
            
            if((k * 3) % 2 == 0) {
                answer += map.get(k) * map.getOrDefault((k / 2) * 3, 0L);
            }
            
            if((k * 4) % 3 == 0) {
                answer += map.get(k) * map.getOrDefault((k / 3) * 4, 0L);
            }
            
        }
        
        return answer;
    }
}