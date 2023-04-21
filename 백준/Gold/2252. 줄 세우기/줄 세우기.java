import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<Integer>[] adj;
	static int[] in_degree;
	static StringBuilder sb;

	public static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			if (in_degree[i] == 0) {
				q.offer(i);
				visited[i] = true;
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			sb.append(cur + " ");

			for (int i = 0; i < adj[cur].size(); i++) {
				if (in_degree[adj[cur].get(i)] > 0) {
					in_degree[adj[cur].get(i)]--;
				}
			}

			for (int i = 1; i <= n; i++) {
				if (in_degree[i] == 0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		in_degree = new int[n + 1];
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adj[from].add(to);
			in_degree[to]++;
		}
		// end input

		sb = new StringBuilder();

		bfs();

		System.out.println(sb.toString());
	}
}
