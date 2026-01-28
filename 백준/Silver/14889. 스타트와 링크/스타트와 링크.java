import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr ;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;


    static void backtrack(int idx, int depth) {
        if (depth == arr.length/2 || result == 0) {
            diff();
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i+1; j < arr[i].length; j++) {
                if(visited[i] == true &&  visited[j] == true) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else {
                    if (visited[i] == false && visited[j] == false) {
                        link += arr[i][j];
                        link += arr[j][i];
                    }
                }
            }
        }
        int teamValue = Math.abs(start - link);
        result = Math.min(result, teamValue);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        backtrack(0, 0);

        sb.append(result);
        System.out.println(sb.toString());
    }
}