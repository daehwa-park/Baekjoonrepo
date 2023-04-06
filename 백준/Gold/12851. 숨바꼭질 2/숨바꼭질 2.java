import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k, cnt;

	public static int bfs(int sp, int ep) {
		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[100001];

		Arrays.fill(visited, Integer.MAX_VALUE);

		q.offer(sp);
		visited[sp] = 0;

		boolean ok = false;

		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int cur = q.poll();

				if (cur == ep) {
					cnt++;
					ok = true;
				}

				if (cur - 1 >= 0 && visited[cur - 1] >= time) {
					q.offer(cur - 1);
					visited[cur - 1] = time;
				}
				if (cur + 1 < visited.length && visited[cur + 1] >= time) {
					q.offer(cur + 1);
					visited[cur + 1] = time;
				}
				if (cur * 2 <= visited.length && visited[cur * 2] >= time) {
					q.offer(cur * 2);
					visited[cur * 2] = time;
				}
			}
			if (ok) {
				return time;
			}
			time++;
		}

		return -1;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int result = bfs(n, k);

		System.out.println(result);
		System.out.println(cnt);

	}
}