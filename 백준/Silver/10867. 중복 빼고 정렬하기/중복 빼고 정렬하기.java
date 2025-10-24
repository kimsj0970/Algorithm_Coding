import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(a[i]);
        }

        List<Integer> integerList = new ArrayList<>(list.stream().distinct().sorted().collect(Collectors.toList()));
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i)+" ");
        }


    }
}
