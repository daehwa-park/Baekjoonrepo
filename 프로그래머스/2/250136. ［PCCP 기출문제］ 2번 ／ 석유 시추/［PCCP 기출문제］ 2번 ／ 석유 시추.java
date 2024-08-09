import java.util.*;

class Solution {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    
    static public int bfs(int[][] land, boolean[][] visited, ArrayList<Integer> line, int i, int j, int count) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        line.add(j);
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(ni >= 0 && ni < visited.length && nj >= 0 && nj < visited[0].length && !visited[ni][nj] && land[ni][nj] == 1) {
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    cnt++;
                    if(!line.contains(nj)) {
                        line.add(nj);
                    }
                }
            }
            
        }
        
        return cnt;
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        int m = land[0].length;
        
        ArrayList<ArrayList<Integer>> line = new ArrayList<>();
        int count = 0;
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    line.add(new ArrayList<>());
                    int max = bfs(land, visited, line.get(count), i, j, count);
                    hmap.put(count, max);
                    count++;
                }
            }
        }
        
        int[] oil = new int[m];
        for(int i = 0; i < line.size(); i++) {
            for(int j : line.get(i)) {
                oil[j] += hmap.get(i);
            }
        }
        
        for(int i = 0; i < m; i++) {
            answer = Math.max(answer, oil[i]);
        }
        
        
        return answer;
    }
}