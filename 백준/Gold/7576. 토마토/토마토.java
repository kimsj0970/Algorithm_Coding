import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] xd = {-1, 1, 0, 0};
    static int[] yd = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        arr = new int[N][M];

        int unripe = 0; // 익지 않은 토마토 개수
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            //st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j}); // 익은 토마토의 위치를 큐에 추가
                } else if (arr[i][j] == 0) {
                    unripe++; // 익지 않은 토마토 개수 증가
                }
            }
        }

        if (unripe == 0) { // 모든 토마토가 처음부터 익어 있는 경우
            System.out.println(0);
            return;
        }

        bfs();

        // BFS 이후 익지 않은 토마토가 남아있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day - 1); // BFS 레벨(날짜) 출력
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + xd[k];
                    int ny = y + yd[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1; // 토마토가 익음
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            day++;

        }
    }
}
