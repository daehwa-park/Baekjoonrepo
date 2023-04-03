import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int sharki, sharkj;
	static int[][] map;
	static boolean[][] visited;
	static int sharksize, atefish;
	static int[] di = { -1, 0, 0, 1 };
	static int[] dj = { 0, -1, 1, 0 };

	public static class Pos implements Comparable<Pos> {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Pos o) {
			return this.r == o.r ? this.c - o.c : this.r - o.r;
		}
	}

	public static int bfs() {
		int time = 0;
		if (check()) {
			return -1;
		}
		Queue<Pos> q = new ArrayDeque<>();
		visited = new boolean[n][n];

		q.offer(new Pos(sharki, sharkj));
		visited[sharki][sharkj] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			PriorityQueue<Pos> pq = new PriorityQueue<>();
			for (int c = 0; c < size; c++) {
				Pos cur = q.poll();

				if (map[cur.r][cur.c] >= 1 && map[cur.r][cur.c] <= 6 && map[cur.r][cur.c] < sharksize) {
					pq.offer(new Pos(cur.r, cur.c));
				}

				for (int d = 0; d < 4; d++) {
					int nexti = cur.r + di[d];
					int nextj = cur.c + dj[d];
					if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < n && map[nexti][nextj] <= sharksize
							&& !visited[nexti][nextj]) {
						q.offer(new Pos(nexti, nextj));
						visited[nexti][nextj] = true;
					}
				}
			}
			if (!pq.isEmpty()) {
				Pos min = pq.poll();
				map[min.r][min.c] = 0;
				atefish++;
				if (atefish == sharksize) {
					atefish = 0;
					sharksize++;
				}
				sharki = min.r;
				sharkj = min.c;
				return time;
			}
			time++;
		}
		return -1;
	}

	public static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] >= 1 && map[i][j] <= 6) {
					return false;
				}
			}
		}
		return true;
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		sharksize = 2;
		atefish = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharki = i;
					sharkj = j;
					map[i][j] = 0;
				}
			}
		}
		// end input

		int result = 0;
		while (!check()) {
			int num = bfs();
			if (num == -1) {
				break;
			} else {
				result += num;
			}
			// print();
		}

		System.out.println(result);
	}
}