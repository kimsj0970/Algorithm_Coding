import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void check(int nums){
        if (nums < 2){
            return;
        }

        if (nums == 2){
            sb.append(nums).append('\n');
        }

        if (nums % 2 == 0){
            return;
        }

        for (int i = 3; i * i <= nums; i+=2){
            if (nums % i == 0){
                return;
            }
        }
        sb.append(nums).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        List<Integer> temp = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = temp.get(0); i <= temp.get(1); i++) {
            check(i);
        }
        System.out.println(sb.toString());
    }
}