import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static class Pos {
		int r, c;
		boolean wall;

		public Pos(int r, int c, boolean wall) {
			this.r = r;
			this.c = c;
			this.wall = wall;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", wall=" + wall + "]";
		}
	}

	public static int bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][2];

		q.offer(new Pos(0, 0, false));
		visited[0][0][0] = true;

		int dist = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();

				if (cur.r == N - 1 && cur.c == M - 1) {
					return dist;
				}

				for (int d = 0; d < 4; d++) {
					int nextr = cur.r + di[d];
					int nextc = cur.c + dj[d];

					if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && !cur.wall && !visited[nextr][nextc][1]
							&& map[nextr][nextc] == 1) { // 벽이지만 벽을 부순적이 없다면
						q.offer(new Pos(nextr, nextc, true)); // 벽 부수고
						visited[nextr][nextc][1] = true; // 방문처리
					}

					if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && cur.wall && !visited[nextr][nextc][1]
							&& map[nextr][nextc] == 0) { // 벽이 아니지만 벽을 부순적이 있다면
						q.offer(new Pos(nextr, nextc, cur.wall));
						visited[nextr][nextc][1] = true; // 부순 상태에서 방문처리
					}

					if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && !cur.wall && !visited[nextr][nextc][0]
							&& map[nextr][nextc] == 0) {
						q.offer(new Pos(nextr, nextc, cur.wall));
						visited[nextr][nextc][0] = true;
					}
				}
			}
			dist++;
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j] - '0';
			}
		}

		int result = bfs();

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}