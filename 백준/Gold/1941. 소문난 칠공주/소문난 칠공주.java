import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static int ans;
	static boolean[][] visited, bfsvisit;
	static int bnum;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void comb(int totcount, int scount, int start) {
		if (totcount == 7) {
			if (scount >= 4) {
				bfsvisit = new boolean[5][5];
				bnum = 0;
				out: for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (visited[i][j]) {
							dfs(i, j);
							break out;
						}
					}
				}
				if (bnum == 7) {
					ans++;
				}
			}
			return;
		}

		for (int i = start; i < 25; i++) {
			int x = i / 5;
			int y = i % 5;

			if (map[x][y] == 'S') {
				visited[x][y] = true;
				comb(totcount + 1, scount + 1, i + 1);
				visited[x][y] = false;
			} else {
				visited[x][y] = true;
				comb(totcount + 1, scount, i + 1);
				visited[x][y] = false;
			}
		}
	}

	public static void dfs(int i, int j) {
		bnum++;
		bfsvisit[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];

			if (nexti >= 0 && nexti < 5 && nextj >= 0 && nextj < 5 && visited[nexti][nextj]
					&& !bfsvisit[nexti][nextj]) {
				dfs(nexti, nextj);
			}
		}
	}

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[5][5];

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// end input

		visited = new boolean[5][5];
		
		comb(0, 0, 0);

		System.out.println(ans);

    }
}