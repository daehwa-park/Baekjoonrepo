import java.util.*;

class Solution {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    
    static public int bfs(int[] start, int[] end, char[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        q.offer(start);
        visited[start[0]][start[1]] = true;
        
        int size = 0;
        int time = 0;
        while(!q.isEmpty()) {
            size = q.size();
            for(int s = 0; s < size; s++) {
                int[] cur = q.poll();

                if (cur[0] == end[0] && cur[1] == end[1]) {
                    return time;
                }
                
                for(int d = 0; d < 4; d++) {
                    int ni = cur[0] + di[d];
                    int nj = cur[1] + dj[d];
                    while(ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && board[ni][nj] != 'D') {
                        int ti = ni;
                        int tj = nj;
                        ni = ni + di[d];
                        nj = nj + dj[d];
                        
                        if((ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length || board[ni][nj] == 'D') && !visited[ti][tj]) {
                            visited[ti][tj] = true;
                            q.offer(new int[]{ti, tj});
                        }
                    }
                }
            }
            time++;
        }
        
        return -1;
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        int[] posR = new int[2];
        int[] posG = new int[2];
        
        char[][] map = new char[board.length][];
        for(int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'R') {
                    posR[0] = i;
                    posR[1] = j;
                }
                else if(map[i][j] == 'G') {
                    posG[0] = i;
                    posG[1] = j;
                }
            }
        }
        
        answer = bfs(posR, posG, map);
        
        return answer;
    }
}