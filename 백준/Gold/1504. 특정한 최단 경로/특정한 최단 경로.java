import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, e;
	static ArrayList<Pos>[] adj;

	public static class Pos implements Comparable<Pos> {
		int num;
		int weight;

		public Pos(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Pos [num=" + num + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Pos o) {
			return this.weight - o.weight;
		}
	}

	public static int dijstra(int start, int end) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;
		pq.offer(new Pos(start, 0));

		while (!pq.isEmpty()) {
			Pos cur = pq.poll();

			if (visited[cur.num])
				continue;

			visited[cur.num] = true;

			for (Pos list : adj[cur.num]) {
				if (!visited[list.num] && dist[list.num] > dist[cur.num] + list.weight) {
					dist[list.num] = dist[cur.num] + list.weight;
					pq.offer(new Pos(list.num, dist[list.num]));
				}
			}
		}

		return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adj[from].add(new Pos(to, weight));
			adj[to].add(new Pos(from, weight));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int ans = 0;
		int first = dijstra(1, v1);
		int second = dijstra(v1, v2);
		int third = dijstra(v2, n);
		if (first == -1 || second == -1 || third == -1) {
			ans = -1;
		} else {
			ans = first + second + third;
		}

		first = dijstra(1, v2);
		second = dijstra(v2, v1);
		third = dijstra(v1, n);
		if (first != -1 && second != -1 && third != -1 && ans != -1) {
			ans = Math.min(ans, first + second + third);
		} else if (first != -1 && second != -1 && third != -1 && ans == -1) {
			ans = first + second + third;
		}

		System.out.println(ans);

	}
}