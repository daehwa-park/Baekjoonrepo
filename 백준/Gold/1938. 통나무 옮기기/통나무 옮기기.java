import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int n;
	static char[][] map;
	static int ei, ej, et;
	static boolean[][][] visited;
	
	public static int bfs(int si, int sj, int st) {
		Queue<Pos> q = new ArrayDeque<>();
		visited = new boolean[n][n][2]; // x, y, 회전 여부 방문 배열
		
		q.offer(new Pos(si, sj, st)); // 기둥 좌표 입력
		visited[si][sj][st] = true;  //방문 처리
		
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Pos cur = q.poll();
				
				if(cur.x == ei && cur.y == ej && cur.t == et) { // e로 도착했다면 끝
					return time;
				}
				
				if(isupok(cur.x, cur.y, cur.t)) { //위로 갈수 있는지 확인
					q.offer(new Pos(cur.x - 1, cur.y, cur.t));
					visited[cur.x - 1][cur.y][cur.t] = true;
				}
				if(isdownok(cur.x, cur.y, cur.t)) { //아래로 갈수 있는지 확인
					q.offer(new Pos(cur.x + 1, cur.y, cur.t));
					visited[cur.x + 1][cur.y][cur.t] = true;
				}
				if(isleftok(cur.x, cur.y, cur.t)) { // 왼쪽으로 갈 수 있는지 확인
					q.offer(new Pos(cur.x, cur.y - 1, cur.t));
					visited[cur.x][cur.y - 1][cur.t] = true;
				}
				if(isrightok(cur.x, cur.y, cur.t)) { // 오른쪽으로 갈 수 있는지 확인
					q.offer(new Pos(cur.x, cur.y + 1, cur.t));
					visited[cur.x][cur.y + 1][cur.t] = true;
				}
				if(isturnok(cur.x, cur.y, cur.t)) { //회전 할 수 있는지 확인
					q.offer(new Pos(cur.x, cur.y, (cur.t + 1) % 2));
					visited[cur.x][cur.y][(cur.t + 1) % 2] = true;
				}		
			}
			time++;
		}
		
		return 0;
	}
	
	public static boolean isupok(int x, int y, int t) {
		if(t == 0) { //가로
			if(x - 1 >= 0 && y - 1 >= 0 && y + 1 < n && !visited[x - 1][y][t] && map[x - 1][y - 1] == '0' && map[x - 1][y] == '0' && map[x - 1][y + 1] == '0' ) {
				return true;
			}
		}else { //세로
			if(x - 2 >= 0 && !visited[x - 1][y][t] && map[x - 2][y] == '0') {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isdownok(int x, int y, int t) {
		if(t == 0) { //가로
			if(x + 1 < n && y - 1 >= 0 && y + 1 < n && !visited[x + 1][y][t] && map[x + 1][y - 1] == '0' && map[x + 1][y] == '0' && map[x + 1][y + 1] == '0' ) {
				return true;
			}
		}else { //세로
			if(x + 2 < n && !visited[x + 1][y][t] && map[x + 2][y] == '0') {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isleftok(int x, int y, int t) {
		if(t == 1) { //세로
			if(y - 1 >= 0 && x - 1 >= 0 && x + 1 < n && !visited[x][y - 1][t] && map[x + 1][y - 1] == '0' && map[x][y - 1] == '0' && map[x - 1][y - 1] == '0' ) {
				return true;
			}
		}else { //가로
			if(y - 2 >= 0 && !visited[x][y - 1][t] && map[x][y - 2] == '0') {
				return true;
			}
		}
		return false;
	}
	public static boolean isrightok(int x, int y, int t) {
		if(t == 1) { //세로
			if(y + 1 < n && x - 1 >= 0 && x + 1 < n && !visited[x][y + 1][t] && map[x + 1][y + 1] == '0' && map[x][y + 1] == '0' && map[x - 1][y + 1] == '0' ) {
				return true;
			}
		}else { //가로
			if(y + 2 < n && !visited[x][y + 1][t] && map[x][y + 2] == '0') {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isturnok(int x, int y, int t) {
		if(x - 1 >= 0 && x + 1 < n && y + 1 < n && y - 1 >= 0 && !visited[x][y][(t + 1) % 2]) {
			for(int i = -1 ; i <= 1; i++) {
				for(int j =-1; j <= 1; j++ ) {
					if(map[x + i][y + j] != '0') {
						return false;
					}
				}
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	public static class Pos {
		int x;
		int y;
		int t;
		
		public Pos(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", t=" + t + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ei = 0;
		ej = 0;
		et = 0;
		int bi = 0;
		int bj = 0;
		int bt = 0;
		int cnte = 0;
		int cntb = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 'E') { // e의 위치 찾기
					map[i][j] = '0';
					cnte++;
					if(cnte == 2) { // 가운데 E일 때
						ei = i;
						ej = j;
						if(j + 1 < n && map[i][j + 1] == 'E') {
							et = 0; // 가로
						}
						else if(i + 1 < n && map[i + 1][j] == 'E') {
							et = 1; // 세로
						}
					}
				}
				if(map[i][j] == 'B') { // b의 위치 찾기
					map[i][j] = '0';
					cntb++;
					if(cntb == 2) { // 가운데 B일 때
						bi = i;
						bj = j;
						if(j + 1 < n && map[i][j + 1] == 'B') {
							bt = 0; // 가로
						}
						else if(i + 1 < n && map[i + 1][j] == 'B') {
							bt = 1; // 세로
						}
					}
				}
			}
		}
		//end input
		
//		for(int i =0 ; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println(ei+" "+ej);
		
		int result = bfs(bi, bj, bt);
		
		System.out.println(result);
		
	}
}
