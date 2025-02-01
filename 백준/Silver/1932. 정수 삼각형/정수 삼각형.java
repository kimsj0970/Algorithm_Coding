import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        dp = new int[N][N];  // dp 배열을 2D 배열로 선언

        // 삼각형 입력
        for (int i = 0; i < N; i++) {
            arr[i] = new int[i + 1];  // 피라미드 형태
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 첫 번째 행 dp 값 초기화
        dp[0][0] = arr[0][0];

        // 아래에서 위로 DP 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int left = 0, right = 0;

                // 왼쪽 부모 값 (i-1, j-1) 인덱스 유효한지 확인
                if (j - 1 >= 0) {
                    left = dp[i - 1][j - 1]; //이전 행 값을 가져와서 하므로 dp
                }

                // 오른쪽 부모 값 (i-1, j) 인덱스 유효한지 확인
                if (j < arr[i - 1].length) {
                    right = dp[i - 1][j];
                }

                // 현재 위치의 dp 값은 부모 중 더 큰 값 + 현재 값
                dp[i][j] = Math.max(left, right) + arr[i][j];

            }
        }

        // 마지막 행에서 최댓값 구하기
        int maxSum = 0;
        for (int i = 0; i < arr[N - 1].length; i++) {
            maxSum = Math.max(maxSum, dp[N - 1][i]);
        }

        System.out.println(maxSum);

    }
}


