import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int num;

	public static class Pos {
		int x;
		int time;

		public Pos(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bfs(n, k);

		System.out.println(num);
	}

	public static void bfs(int n, int k) {
		if (n == k) {
			return;
		}
		Queue<Pos> q = new ArrayDeque<Pos>();
		boolean[] visited = new boolean[100001];

		q.offer(new Pos(n, 0));
		visited[n] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			if (cur.x == k) {
				num = cur.time;
				return;
			}

			if (cur.x - 1 >= 0 && !visited[cur.x - 1]) {
				q.offer(new Pos(cur.x - 1, cur.time + 1));
				visited[cur.x - 1] = true;
			}
			if (cur.x + 1 < visited.length && !visited[cur.x + 1]) {
				q.offer(new Pos(cur.x + 1, cur.time + 1));
				visited[cur.x + 1] = true;
			}
			if (cur.x * 2 <= k + 1 && !visited[cur.x * 2]) {
				q.offer(new Pos(cur.x * 2, cur.time + 1));
				visited[cur.x * 2] = true;
			}
		}

	}
}