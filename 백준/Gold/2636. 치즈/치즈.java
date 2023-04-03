import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int N, M;
	static int[][] map;
	static int cheese = 0;
	static int time = 0;
	static boolean[][] visited;

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

	public static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		visited = new boolean[N][M];

		q.offer(new Pos(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();

				if (map[cur.x][cur.y] == 1) {
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = cur.x + di[d];
					int nextj = cur.y + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]) {
						q.offer(new Pos(nexti, nextj));
						visited[nexti][nextj] = true;
					}
				}
			}
		}

	}

	public static boolean check() {
		int cnt = 0;
		boolean isf = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visited[i][j]) {
					cnt++;
					map[i][j] = 0;
				} else if (map[i][j] == 1 && !visited[i][j]) {
					isf = true;
				}
			}
		}
		if (isf) {
			return false;
		}
		cheese = cnt;

		return true;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		int cheesecnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheesecnt++;
				}
			}
		}
		// end input

		if (cheesecnt != 0) {
			while (true) {
				bfs();
				if (!check()) {
					time++;
				} else {
					break;
				}
			}

			System.out.println(time + 1);
			System.out.println(cheese);
		} else {
			System.out.println(0);
			System.out.println(0);
		}

	}
}