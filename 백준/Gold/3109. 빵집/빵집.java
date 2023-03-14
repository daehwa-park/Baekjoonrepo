import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static char[][] map;
	static boolean isEnd;
	static int cnt = 0;
	static boolean[][] visited;

	public static void dfs(int curr, int curc) {
		if (curc == c - 1) {
			isEnd = true;
			cnt++;
			return;
		}

		if (curr - 1 >= 0 && curc + 1 < c && map[curr - 1][curc + 1] == '.' && !visited[curr - 1][curc + 1] && !isEnd) {
			visited[curr - 1][curc + 1] = true;
			dfs(curr - 1, curc + 1);
		}
		if (curc + 1 < c && map[curr][curc + 1] == '.' && !visited[curr][curc + 1] && !isEnd) {
			visited[curr][curc + 1] = true;
			dfs(curr, curc + 1);
		}
		if (curr + 1 < r && curc + 1 < c && map[curr + 1][curc + 1] == '.' && !visited[curr + 1][curc + 1] && !isEnd) {
			visited[curr + 1][curc + 1] = true;
			dfs(curr + 1, curc + 1);
		}
	}

	public static void print() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			isEnd = false;
			visited[i][0] = true;
			dfs(i, 0);
			if (!isEnd) {
				visited[i][0] = false;
			}
		}

		System.out.println(cnt);

	}
}
