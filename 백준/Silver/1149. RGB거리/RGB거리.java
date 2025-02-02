import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(s[j]);
        }

        for (int i = 1; i < N; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]); //R  현재 i값에 green blue 비용을 더함
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]); //G
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]); //B
        }

        System.out.println(Math.min(arr[N - 1][0], Math.min(arr[N - 1][1], arr[N - 1][2])));
        
    }
}