import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Pos[] np;

	public static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean bfs(Pos sp, Pos rp) {
		Queue<Pos> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n];

		q.offer(new Pos(sp.x, sp.y));

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			if (dist(cur, rp) <= 1000) {
				return true;
			}

			for (int i = 0; i < n; i++) {
				if (dist(cur, np[i]) <= 1000 && !visited[i]) {
					q.offer(new Pos(np[i].x, np[i].y));
					visited[i] = true;
				}
			}
		}

		return false;
	}

	public static int dist(Pos o1, Pos o2) {
		return Math.abs(o1.x - o2.x) + Math.abs(o1.y - o2.y);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Pos sp = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			np = new Pos[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				np[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			Pos rp = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			boolean result = bfs(sp, rp);

			System.out.println(result ? "happy" : "sad");
		}
	}
}