import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static int count = 0;

    public static void dfs (int sum, int target){
        if (sum == target){
            count++;
        }
        if (sum > target){
            return;
        }


        dfs(sum + 1, target);
        dfs(sum + 2, target);
        dfs(sum + 3, target);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < loop; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < list.size(); i++) {
            dfs(0, list.get(i));
            System.out.println(count);
            count = 0;
        }
    }
}
