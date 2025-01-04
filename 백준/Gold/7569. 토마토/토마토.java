import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] arr;
    static int[] xd = {-1, 1, 0, 0};
    static int[] yd = {0, 0, -1, 1};
    static int[] zd = {-1, 1}; // 위, 아래 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);
        arr = new int[N][M][H];
        Queue<int[]> queue = new LinkedList<>();
        int unripe = 0; // 익지 않은 토마토 개수


        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    arr[i][j][h] = Integer.parseInt(line[j]);
                    if (arr[i][j][h] == 1) {
                        queue.add(new int[]{i, j, h}); // 익은 토마토의 위치를 큐에 추가
                    } else if (arr[i][j][h] == 0) {
                        unripe++; // 익지 않은 토마토 개수 증가
                    }
                }
            }
        }

        // 모든 토마토가 처음부터 익어 있는 경우
        if (unripe == 0) {
            System.out.println(0);
            return;
        }

        // BFS 실행
        int days = bfs(queue);

        // BFS 이후 익지 않은 토마토가 남아있는지 확인
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j][h] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        // 답 출력
        System.out.println(days);
    }

    static int bfs(Queue<int[]> q) {
        int day = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int z = curr[2];

                // 4방향 탐색
                for (int k = 0; k < 4; k++) {
                    int nx = x + xd[k];
                    int ny = y + yd[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny][z] == 0) {
                        arr[nx][ny][z] = 1; // 토마토가 익음
                        q.add(new int[]{nx, ny, z});
                    }
                }

                // 위, 아래 방향 탐색
                for (int k = 0; k < 2; k++) {
                    int nz = z + zd[k];
                    if (nz >= 0 && nz < H && arr[x][y][nz] == 0) {
                        arr[x][y][nz] = 1; // 토마토가 익음
                        q.add(new int[]{x, y, nz});
                    }
                }
            }
            day++; // 한 레벨 탐색이 끝날 때 날짜 증가
        }
        return day - 1; // 마지막 추가된 날짜 제외
    }
}
