import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[n];
		for (int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		// end input

		int max = -1;
		int cnt = 0;
		int[] visited = new int[d + 1];
		boolean free = false;

		for (int i = 0; i < k; i++) {
			if (visited[sushi[i]] == 0) {
				cnt++;
			}
			visited[sushi[i]]++;
		}
		if (visited[c] == 0) {
			max = Math.max(max, cnt + 1);
		}
		else {
			max = Math.max(max, cnt);
		}


		int sp = 0;
		int ep = k - 1;
		while (sp != n) {
			sp++;
			ep = (ep + 1) % n;
			visited[sushi[sp - 1]]--;
			if (visited[sushi[sp - 1]] == 0) {
				cnt--;
			}
			if (visited[sushi[ep]] == 0) {
				cnt++;
			}
			visited[sushi[ep]]++;

			if (visited[c] == 0) {
				max = Math.max(max, cnt + 1);
			}
			else {
				max = Math.max(max, cnt);
			}
		}

		System.out.println(max);

	}
}