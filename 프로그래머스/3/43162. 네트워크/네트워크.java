import java.util.*;
class Solution {
    static int rn;
    static boolean[] visited;
    
    static public void dfs(int start, int[][] computers) {
        for(int i = 0; i < rn; i++) {
            if(computers[start][i] == 1 && start != i && !visited[i]) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        rn = n;
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
}