import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];
        int dp[] = new int[N+1];

        for(int i=1; i<=N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        dp[1] = arr[1];
        if(N >= 2)
            dp[2] = arr[1] + arr[2]; // 계단이 총 2개면 첫번재 두번째 계단을 더함


        for(int i=3; i<=N; i++) // 3번째 계단부터 DP                  // 3칸을 한번에 이동 후 그전 -2번째 값인곳에 가서 총 2칸을 뛴 경우와
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i]; //N이 5면 dp[2]에서 한 칸씩 두 번 점프한 후, 2칸 점프하는 방식
        System.out.println(dp[N]); // 마지막 계단의 최대의 합
    }
}