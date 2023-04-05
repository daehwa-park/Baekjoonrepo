import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dp[a][b] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (i == k || dp[i][k] == 0)
					continue;
				for (int j = 1; j <= n; j++) {
					if (dp[i][j] == 1)
						continue;
					dp[i][j] = dp[k][j];
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (dp[i][j] == 1) {
					cnt++;
				}
				if (dp[j][i] == 1) {
					cnt++;
				}
			}
			if (cnt == n - 1) {
				ans++;
			}
		}

		System.out.println(ans);
	}
}