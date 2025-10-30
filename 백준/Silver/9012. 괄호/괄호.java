import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<String[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine().split(""));
        }

        for (int i = 0; i < n; i++) {
            String[] listStrings = list.get(i);
            int count =0;
            for (int j = 0; j < listStrings.length; j++) {
                if (listStrings[j].equals("(")) {
                    count++;
                }
                else if (listStrings[j].equals(")")) {
                    count--;
                }

                if (count < 0) {
                    break;
                }

            }
            if (count==0) {
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
    }
}