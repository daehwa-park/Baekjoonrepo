import java.util.*;

class Solution {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0 , 1, 0, -1};
    static boolean[][] visited;
    static int n, m, sum;
    static char[][] map;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        map = new char[maps.length][];
        
        for(int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        n = map.length;
        m = map[0].length;
        
        // for(int i = 0; i < map.length; i++) {
        //     for(int j = 0; j < map[0].length; j++) {
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        visited = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m;j++) {
                if(map[i][j] != 'X' && !visited[i][j]) {
                    sum = 0;
                    dfs(i, j);
                    list.add(sum);
                }
            }
        }
        
        Collections.sort(list);
        
        if(list.isEmpty()) {
            answer = new int[] {-1};
        }else {
            answer = new int[list.size()];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
    
    public static void dfs(int i, int j) {
        visited[i][j] = true;
        sum += map[i][j] - '0';
        
        for(int d = 0; d < 4; d++) {
            int nexti = i + di[d];
            int nextj = j + dj[d];
            
            if(nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && !visited[nexti][nextj] 
               && map[nexti][nextj] != 'X') {
                dfs(nexti, nextj);
            }
        }
    }
}