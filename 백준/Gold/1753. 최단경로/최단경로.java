import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] al;
	static int V, E, K;
	static int[] dist;
	static final int INF = 100000000;

	public static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V];
		dist = new int[V];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.to]) {
				continue;
			}

			visited[cur.to] = true;

			for (Node adj : al[cur.to]) {
				if (!visited[adj.to] && dist[adj.to] > dist[cur.to] + adj.weight) {
					dist[adj.to] = dist[cur.to] + adj.weight;
					pq.offer(new Node(adj.to, dist[adj.to]));
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine()) - 1;

		al = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			al[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			al[from].add(new Node(to, weight));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] != INF) {
				sb.append(dist[i] + "\n");
			} else {
				sb.append("INF\n");
			}
		}

		System.out.println(sb);

	}
}