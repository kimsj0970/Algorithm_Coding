import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static int map[][]; // 미로 맵
    static boolean[][] visited; // 방문 여부 배열
    static int dist[][]; // 각 칸까지의 거리 배열
    static int xList[] = {-1, +1, 0, 0}; // 상, 하, 좌, 우
    static int yList[] = {0, 0, -1, +1};
    static int n, m;

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true; // 시작점을 방문 처리
        dist[x][y] = 1; // 시작점은 1칸에 포함되므로, 거리를 1로 초기화

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowx = now[0];
            int nowy = now[1];

            for (int i = 0; i < 4; i++) {
                int nextx = nowx + xList[i];
                int nexty = nowy + yList[i];

                // 유효한 범위이고, 벽이 아니며, 방문하지 않은 칸이라면
                if (nextx >= 0 && nexty >= 0 && nextx < n && nexty < m && map[nextx][nexty] == 1 && !visited[nextx][nexty]) {
                    visited[nextx][nexty] = true; // 방문 처리
                    dist[nextx][nexty] = dist[nowx][nowy] + 1; // 현재 칸에서 +1 거리 추가
                    q.add(new int[]{nextx, nexty});
                }
            }
        }

        // 도착점의 거리 출력
        System.out.println(dist[n - 1][m - 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];

        // 미로 입력
        for (int i = 0; i < n; i++) {
            String ss = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = ss.charAt(j) - '0'; 
            }
        }

        bfs(0, 0); // (0, 0)에서 BFS 시작
    }
}
