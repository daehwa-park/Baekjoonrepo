import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for (int t : tangerine) {
            hmap.put(t, hmap.getOrDefault(t, 0) + 1);
        }
        
        
        Collection<Integer> map = hmap.values();
        List<Integer> arr = new ArrayList<>(map);
        Collections.sort(arr,Collections.reverseOrder());
        
        for (int i : arr) {
            if(k <= 0) {
                break;
            }
            k -= i;
            answer++;
        }
        
        return answer;
    }
}