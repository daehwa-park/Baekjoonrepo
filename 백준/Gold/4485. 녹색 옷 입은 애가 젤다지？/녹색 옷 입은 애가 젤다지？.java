import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int w;

		public Pos(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Pos o) {
			return this.w - o.w;
		}

	}

	public static int dijkstra() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		int[][] dist = new int[n][n];
		boolean[][] visited = new boolean[n][n];

		pq.offer(new Pos(0, 0, map[0][0]));

		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		dist[0][0] = map[0][0];

		while (!pq.isEmpty()) {
			Pos cur = pq.poll();

			if (visited[cur.x][cur.y])
				continue;

			visited[cur.x][cur.y] = true;

			if (cur.x == n - 1 && cur.y == n - 1) {
				return cur.w;
			}

			for (int d = 0; d < 4; d++) {
				int nextx = cur.x + di[d];
				int nexty = cur.y + dj[d];
				if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < n && !visited[nextx][nexty]
						&& dist[nextx][nexty] > dist[cur.x][cur.y] + map[nextx][nexty]) {
					dist[nextx][nexty] = dist[cur.x][cur.y] + map[nextx][nexty];
					pq.offer(new Pos(nextx, nexty, dist[nextx][nexty]));
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// end input

			int result = dijkstra();

			System.out.println("Problem " + tc + ": " + result);

			tc++;
		}
	}
}
