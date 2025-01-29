import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static int arr[][];
    static boolean visit[];
    static int min = Integer.MAX_VALUE;

    static void back(int start, int depth) {
        if (depth == N/2) {
            diff();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                back(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) { // N이 4면 i값이 4, j값이 4 이렇게 만나지 않고 3 ,4로 끝날 수 있게 -1
            for (int j = i+1; j < N; j++) { // arr[1][0]과 arr[0][1] 같은 중복 계산 방지
                if (visit[i] == true && visit[j] == true) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int val = Math.abs(start - link);
        // -2가 들어오면 2로 바꿔서 저장 후 저장된 min 값보다 작으면 min에 저장
        min = Math.min(val, min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit= new boolean[N];

        for (int i = 0; i < N; i++) {
            String line[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        back(0, 0);
        System.out.println(min);

    }
}
