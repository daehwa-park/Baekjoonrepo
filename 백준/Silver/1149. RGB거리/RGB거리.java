import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] color = new int[n][3];
		int[][] dp = new int[n + 1][3];
		
		for(int i = 0; i< n; i++) {
			for(int j = 0; j< 3; j++) {
				color[i][j] = sc.nextInt();
			}
		}
		
		dp[1][0] = color[0][0];
		dp[1][1] = color[0][1];
		dp[1][2] = color[0][2];
		
		for(int i = 2; i<= n; i++) {
			for(int j = 0; j < 3; j++) {
				dp[i][j] = dp[i - 1][(j + 1) % 3] + color[i - 1][j];
				if(dp[i][j] > dp[i - 1][(j + 2) % 3] + color[i - 1][j]) {
					dp[i][j] = dp[i - 1][(j + 2) % 3] + color[i - 1][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			if(min > dp[n][i]) {
				min = dp[n][i];
			}
		}
		
		System.out.println(min);
		
	}
}
