import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int count = 0;
    static int target;
    static int size;
    static int[] numList;

    public static void dfs (int depth, int sum){
        if(depth == size){
            if (sum == target){
                count++;
            }
            return;
        }

        dfs(depth+1, sum + numList[depth]);
        dfs(depth+1, sum);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = a[0];
        target = a[1];
        numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, 0);

        if(target == 0){
            System.out.println(count-1);
        }
        else{
            System.out.println(count);
        }

    }
}