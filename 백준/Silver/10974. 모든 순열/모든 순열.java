import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean [] visited;
    static int arr[];
    static int N;
    static void sun(int num, int dep, int n){
        if(dep==n){
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[dep] = i;
                sun(num, dep+1, n);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        arr = new int[N];
        sun(0,0,N);


    }
}
