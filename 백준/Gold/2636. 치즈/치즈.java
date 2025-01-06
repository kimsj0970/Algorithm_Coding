import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int totalTime = 0; // 치즈가 녹는 데 걸리는 총 시간
    static int lastCheeseCount = 0; // 치즈가 모두 녹기 한 시간 전에 남아있는 치즈 조각 수

    // BFS로 외곽 공기부터 탐색하며 치즈 녹이기
    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];

        // 외곽 공기부터 시작
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int cheeseCount = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (map[nx][ny] == 1) {
                        // 외부 공기와 접촉한 치즈
                        map[nx][ny] = 0; // 치즈 녹이기
                        cheeseCount++;
                    } else if (map[nx][ny] == 0) {
                        // 공기면 탐색 계속
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return cheeseCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        map = new int[n][m];

        // 입력받기
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        while (true) {
            int meltedCheese = bfs();

            if (meltedCheese == 0) {
                // 더 이상 녹을 치즈가 없으면 종료
                break;
            }

            lastCheeseCount = meltedCheese; // 마지막으로 녹은 치즈 개수 저장
            totalTime++; // 시간 증가
        }

        System.out.println(totalTime);
        System.out.println(lastCheeseCount);
    }
}
