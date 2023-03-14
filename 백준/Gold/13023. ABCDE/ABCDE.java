import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] al;
	static boolean[] visited;
	static boolean isok = false;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		al = new ArrayList[n];
		// visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			al[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			al[a].add(b);
			al[b].add(a);
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			dfs(i, 0);
			if (isok) {
				break;
			}
		}

		System.out.println(isok ? 1 : 0);
	}

	public static void dfs(int start, int num) {
		if (num == 4) {
			isok = true;
			return;
		}

		for (int i = 0; i < al[start].size(); i++) {
			if (!visited[al[start].get(i)]) {
				visited[al[start].get(i)] = true;
				dfs(al[start].get(i), num + 1);
				visited[al[start].get(i)] = false;
			}

			if (isok) {
				return;
			}
		}

	}
}