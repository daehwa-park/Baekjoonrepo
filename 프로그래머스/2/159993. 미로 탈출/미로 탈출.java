import java.util.*;

class Solution {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    
    static public int bfs(int[] s, int[] e, char[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[map.length][map[0].length][2];
        
        q.offer(new int[]{s[0], s[1], 0});
        visited[s[0]][s[1]][0] = true;
        
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int si = 0; si < size; si++) {
                int[] cur = q.poll();
                
                if(cur[0] == e[0] && cur[1] == e[1] && cur[2] == 1) {
                    return time;
                }
                if(map[cur[0]][cur[1]] == 'L') {
                    cur[2] = 1;
                }
                
                for(int d = 0; d < 4; d++) {
                    int ni = cur[0] + di[d];
                    int nj = cur[1] + dj[d];
                    
                    if(ni >= 0 && ni < map.length && nj >= 0 && nj < map[0].length && !visited[ni][nj][cur[2]] && map[ni][nj] != 'X') {
                        q.offer(new int[]{ni, nj, cur[2]});
                        visited[ni][nj][cur[2]] = true;
                    }
                }
            }
            time++;
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        char[][] map = new char[maps.length][];
        for(int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        int[] s = new int[2];
        int[] e = new int[2];
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'S') {
                    s[0] = i;
                    s[1] = j;
                }
                else if(map[i][j] == 'E') {
                    e[0] = i;
                    e[1] = j;
                }
            }
        }
        
        answer = bfs(s, e, map);
        
        
        return answer;
    }
}