import java.util.Scanner;

public class Main {
	static int N, M;
	static int ans;
	static int[][] map;
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				dfs(i, j, 0, 0);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				check(i,j);
			}
		}
		System.out.println(ans);
	}
	
	static void check(int i, int j) {
//		int sum=map[i][j];
//		for(int d=0; d<4; d++) {
//			int ni = i+di[d];
//			int nj = j+dj[d];
//			if(ni>=0 && ni<N && nj>=0 && nj<M)
//				sum += map[ni][nj];
//		}
//		
//		for(int d=0; d<4; d++) {
//			int ni = i+di[d];
//			int nj = j+dj[d];
//			if(ni>=0 && ni<N && nj>=0 && nj<M)
//				ans = Math.max(ans, sum - map[ni][nj]);
//		}
		// ㅗ모양
	    if(i>=1 && j>=1 && j<M-1)
	        ans = Math.max(ans, map[i][j]+map[i-1][j]+map[i][j-1]+map[i][j+1]);
	    // ㅜ모양
	    if(i<N-1 && j>=1 && j<M-1)
	        ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i][j-1]+map[i][j+1]);
	    // ㅏ모양
	    if(i<N-1 && i>=1 && j<M-1)
	        ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i-1][j]+map[i][j+1]);
	    // ㅓ모양
	    if(i<N-1 && i>=1 && j>=1)
	        ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i-1][j]+map[i][j-1]);
	}
	
	static void dfs(int i, int j, int sum, int cnt) {
		if(cnt==4) {
			ans = Math.max(ans, sum);
			return;
		}
		visit[i][j] = true;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && ni<N && nj>=0 && nj<M && !visit[ni][nj]) {
				dfs(ni, nj, sum+map[i][j], cnt+1);
			}
		}
		visit[i][j] = false;
		
		
	}
}