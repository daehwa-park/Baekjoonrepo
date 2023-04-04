import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String target = br.readLine();
		String pattern = br.readLine();

		// end input

		int[] pi = new int[pattern.length()];

		char[] p = pattern.toCharArray();
		char[] t = target.toCharArray();

		int j = 0;
		for (int i = 1; i < pi.length; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}

			if (p[i] == p[j]) {
				j++;
				pi[i] = j;
			} else {
				pi[i] = 0;
			}
		}

		int cnt = 0;
		LinkedList<Integer> list = new LinkedList<>();
		j = 0;
		for (int i = 0; i < t.length; i++) {
			while (j > 0 && t[i] != p[j]) {
				j = pi[j - 1];
			}

			if (t[i] == p[j]) {
				if (j == p.length - 1) {
					cnt++;
					list.add(i - j + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		for (int i : list) {
			sb.append(i + " ");
		}

		System.out.println(sb.toString());

		// System.out.println(Arrays.toString(pi));
	}
}