import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean[][] water;

    static int[] di = { -1, 0, 1, 0 };
    static int[] dj = { 0, 1, 0, -1 };

    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pos [x=" + x + ", y=" + y + "]";
        }
    }

    public static int bfs(int i, int j) {
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];

        q.offer(new Pos(i, j));
        visited[i][j] = true;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Pos cur = q.poll();

                if (map[cur.x][cur.y] == 'D') {
                    return time;
                }

                for (int d = 0; d < 4; d++) {
                    int nextx = cur.x + di[d];
                    int nexty = cur.y + dj[d];
                    
                    if (nextx >= 0 && nextx < r && nexty >= 0 && nexty < c && !visited[nextx][nexty]
                            && map[nextx][nexty] != 'X' && map[nextx][nexty] != '*' && !water[nextx][nexty]) {
                        q.offer(new Pos(nextx, nexty));
                        visited[nextx][nexty] = true;
                    }
                }
            }
            time++;

            // 물 차기
            flood();
        }

        return -1;
    }

    public static void flood() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (water[i][j]) {
                    map[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    for (int d = 0; d < 4; d++) {
                        int nextx = i + di[d];
                        int nexty = j + dj[d];

                        if (nextx >= 0 && nextx < r && nexty >= 0 && nexty < c && !water[nextx][nexty]
                                && map[nextx][nexty] == '.') {
                            water[nextx][nexty] = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int si = 0;
        int sj = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    si = i;
                    sj = j;
                    map[i][j] = '.';
                }
            }
        }
        // end input

        water = new boolean[r][c];

        flood();
        int result = bfs(si, sj);

        System.out.println(result == -1 ? "KAKTUS" : result);
    }
}