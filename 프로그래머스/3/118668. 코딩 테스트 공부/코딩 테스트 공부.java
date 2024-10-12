import java.util.*;

class Solution {
    public int bfs(int alp, int cop, int alp_goal, int cop_goal, int[][] problems) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int[][] visited = new int[500][500];
        
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        
        q.offer(new int[]{alp, cop, 0});
        visited[alp][cop] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] >= alp_goal && cur[1] >= cop_goal) {
                return cur[2];
            }
            
            if(visited[cur[0] + 1][cur[1]] > cur[2] + 1) { // 알고 공부
                q.offer(new int[]{cur[0] + 1, cur[1], cur[2] + 1});
                visited[cur[0] + 1][cur[1]] = cur[2] + 1;
            }
            if(visited[cur[0]][cur[1] + 1] > cur[2] + 1) { // 코딩 공부
                q.offer(new int[]{cur[0], cur[1] + 1, cur[2] + 1});
                visited[cur[0]][cur[1] + 1] = cur[2] + 1;
            }
            for(int[] problem : problems) { // 문제 풀기
                if(cur[0] >= problem[0] && cur[1] >= problem[1] && visited[cur[0] + problem[2]][cur[1] + problem[3]] > cur[2] + problem[4]) {
                    q.offer(new int[]{cur[0] + problem[2], cur[1] + problem[3], cur[2] + problem[4]});
                    visited[cur[0] + problem[2]][cur[1] + problem[3]] = cur[2] + problem[4];
                }
            }
            
        }
        return -1;
    }
    
    
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int len = problems.length;
        int alp_goal = 0;
        int cop_goal = 0;
        
        for(int[] problem : problems) {
            if(problem[0] > alp_goal) {
                alp_goal = problem[0];
            }
            if(problem[1] > cop_goal) {
                cop_goal = problem[1];
            }
        }
        
        answer = bfs(alp, cop, alp_goal, cop_goal, problems);
        
        return answer;
    }
}