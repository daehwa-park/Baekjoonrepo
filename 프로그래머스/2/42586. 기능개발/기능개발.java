import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int len = progresses.length;
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < len; i++) {
//            int day = (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : ((100 - progresses[i]) / speeds[i]) + 1;
            int day = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.offer(day);
        }
        // 작업일 계산
        int count = 0;
        int pub = q.peek();
        while(!q.isEmpty()) {
            if(pub >= q.peek()) {
                q.poll();
                count++;
            }
            else {
                answer.add(count);
                count = 1;
                pub = q.poll();
            }
        }
        answer.add(count);
        
        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}