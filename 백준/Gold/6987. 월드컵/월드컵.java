import java.util.Scanner;

public class Main {
	static int[][] result = new int[15][2];
	static int[] score = new int[18];
	static int[][] arr = new int[4][18];
	static int[] ans = new int[4];

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 18; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int idx = 0;
		for (int i = 0; i < 6; i++) { // 6개 중 2개 조합
			for (int j = i + 1; j < 6; j++) {
				result[idx][0] = i;
				result[idx++][1] = j;
			}
		}

		comb(0);

		for (int i = 0; i < 4; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public static void comb(int idx) {
		if (idx == 15) {
			checkscore(score);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				score[3 * result[idx][0]]++;
				score[3 * result[idx][1] + 2]++;
			} else if (i == 1) {
				score[3 * result[idx][0] + 1]++;
				score[3 * result[idx][1] + 1]++;
			} else {
				score[3 * result[idx][0] + 2]++;
				score[3 * result[idx][1]]++;
			}

			if (check(0, score) || check(1, score) || check(2, score) || check(3, score)) {
				comb(idx + 1);
			}
			if (i == 0) {
				score[3 * result[idx][0]]--;
				score[3 * result[idx][1] + 2]--;
			} else if (i == 1) {
				score[3 * result[idx][0] + 1]--;
				score[3 * result[idx][1] + 1]--;
			} else {
				score[3 * result[idx][0] + 2]--;
				score[3 * result[idx][1]]--;
			}
		}
	}

	public static boolean check(int i, int[] score) {
		for (int j = 0; j < 18; j++) {
			if (arr[i][j] < score[j]) {
				return false;
			}
		}

		return true;
	}

	public static void checkscore(int[] score) {
		out: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 18; j++) {
				if (arr[i][j] != score[j]) {
					continue out;
				}
			}
			ans[i] = 1;
		}
	}
}