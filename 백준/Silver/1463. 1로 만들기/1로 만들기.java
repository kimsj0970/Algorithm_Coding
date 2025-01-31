import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        // 1은 이미 1이므로 0번 계산
        dp[1] = 0;

        // 2부터 N까지 반복하면서 최소 연산 횟수 갱신
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 최소 연산을 위해 -1 적용

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
