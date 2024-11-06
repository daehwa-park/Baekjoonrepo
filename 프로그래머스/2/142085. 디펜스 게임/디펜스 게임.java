import java.util.*;

class Solution {    
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < enemy.length; i++) {
            if(k > 0) {
                k--;
                pq.offer(enemy[i]);
                answer = i + 1;
            }
            else {
                if(pq.peek() >= enemy[i]) {
                    if(n >= enemy[i]) {
                        n -= enemy[i];
                        answer = i + 1;
                    }
                    else {
                        break;
                    }
                }
                else {
                    int min = pq.poll();
                    if(n >= min) {
                        n -= min;
                        pq.offer(enemy[i]);
                        answer = i + 1;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        
        
        return answer;
    }
}