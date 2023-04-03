import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;

    static int[] di = { -1, 0, 1, 0 };
    static int[] dj = { 0, 1, 0, -1 };

    public static class Pos {
        int x;
        int y;
        int key;

        public Pos(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }

    public static int bfs(int px, int py) {
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][64];

        q.offer(new Pos(px, py, 0));
        visited[px][py][0] = true;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pos cur = q.poll();

                if (map[cur.x][cur.y] == '1') {
                    return time;
                }

                for (int d = 0; d < 4; d++) {
                    int nextx = cur.x + di[d];
                    int nexty = cur.y + dj[d];
                    if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && map[nextx][nexty] != '#') {
                        if(map[nextx][nexty] >= 'a' && map[nextx][nexty] <= 'f') {
                        	int num = cur.key | 1<<(map[nextx][nexty] - 'a');
                        	if(!visited[nextx][nexty][num]) {
                        		q.offer(new Pos(nextx, nexty, num));
                        		visited[nextx][nexty][num] = true;
                        	}
                        }
                        else if(map[nextx][nexty] >= 'A' && map[nextx][nexty] <= 'F') {
                        	if((cur.key & (1<<(map[nextx][nexty] - 'A'))) != 0 && !visited[nextx][nexty][cur.key] ) {
                        		q.offer(new Pos(nextx, nexty, cur.key));
                        		visited[nextx][nexty][cur.key] = true;
                        	}
                        } 
                        else if((map[nextx][nexty] == '.' || map[nextx][nexty] == '1') && !visited[nextx][nexty][cur.key]) {
                        	q.offer(new Pos(nextx, nexty, cur.key));
                    		visited[nextx][nexty][cur.key] = true;
                        }
                    }
                }
            }
            time++;
        }

        return -1;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int px = 0;
        int py = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    px = i;
                    py = j;
                    map[i][j] = '.';
                }
            }
        }
        // end input
        
        int result = bfs(px, py);
        
        System.out.println(result);

    }
}