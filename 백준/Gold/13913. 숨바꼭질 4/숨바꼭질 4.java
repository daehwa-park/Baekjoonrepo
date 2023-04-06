import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] visitnum;

	public static int bfs(int sp, int ep) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		visitnum = new int[100001];

		q.offer(sp);
		visited[sp] = true;
		visitnum[sp] = -1;


		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int cur = q.poll();

				if (cur == ep) {
					return time;
				}

				if (cur - 1 >= 0 && !visited[cur - 1]) {
					q.offer(cur - 1);
					visited[cur - 1] = true;
					visitnum[cur - 1] = cur;
				}
				if (cur + 1 < visited.length && !visited[cur + 1]) {
					q.offer(cur + 1);
					visited[cur + 1] = true;
					visitnum[cur + 1] = cur;
				}
				if (cur * 2 <= visited.length && !visited[cur * 2]) {
					q.offer(cur * 2);
					visited[cur * 2] = true;
					visitnum[cur * 2] = cur;
				}
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

		ArrayList<Integer> list = new ArrayList<>();
		int num = k;
		while (true) {
			if (num == -1) {
				break;
			}
			list.add(num);
			num = visitnum[num];
		}

		System.out.println(result);
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}

	}
}