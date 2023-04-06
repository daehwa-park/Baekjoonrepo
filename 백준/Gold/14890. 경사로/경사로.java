import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// end input

		int ans = 2 * n;

		for (int i = 0; i < n; i++) {
			boolean down = false;
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					cnt++;
					if (down && cnt == l) {
						cnt = 0;
						down = false;
					}
				} else if (map[i][j] == map[i][j + 1] + 1) {
					if (down) {
						ans--;
						down = false;
						break;
					}
					cnt = 1;
					down = true;
					if (down && cnt == l) {
						cnt = 0;
						down = false;
					}
				} else if (map[i][j] == map[i][j + 1] - 1) {
					if (cnt >= l) {
						cnt = 1;
					} else {
						ans--;
						down = false;
						break;
					}
				} else {
					ans--;
					down = false;
					break;
				}
			}
			if (down) {
				ans--;
			}


			down = false;
			cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (map[j][i] == map[j + 1][i]) {
					cnt++;
					if (down && cnt == l) {
						cnt = 0;
						down = false;
					}
				} else if (map[j][i] == map[j + 1][i] + 1) {
					if (down) {
						ans--;
						down = false;
						break;
					}
					cnt = 1;
					down = true;
					if (down && cnt == l) {
						cnt = 0;
						down = false;
					}
				} else if (map[j][i] == map[j + 1][i] - 1) {
					if (cnt >= l) {
						cnt = 1;
					} else {
						ans--;
						down = false;
						break;
					}
				} else {
					ans--;
					down = false;
					break;
				}
			}
			if (down) {
				ans--;
			}
		}

		System.out.println(ans);
	}
}