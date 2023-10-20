import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static boolean isEnd;

    public static void dfs(int v) {
        visit[v] = true;
        System.out.print(v+" ");

        for(int i : adj[v]) {
            if(!visit[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            System.out.print(cur+" ");

            for(int i : adj[cur]){
                if(!visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];

        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }

        dfs(v);
        visit = new boolean[n + 1];
        System.out.println();
        bfs(v);

    }
}
