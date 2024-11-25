import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 명령의 수
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" "); // 명령 입력

            switch (s[0]) {
                case "push":
                    queue.add(Integer.parseInt(s[1])); // 정수 X를 스택에 넣기
                    break;
                case "pop":
                    // 큐에서 가장 위에 있는 정수를 제거하고 출력, 비어있으면 -1
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;
                case "size":
                    // 큐에 들어있는 정수의 개수 출력
                    System.out.println(queue.size());
                    break;
                case "empty":
                    // 큐가 비어 있으면 1, 아니면 0 출력
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    // 큐의 가장 앞에 있는 정수 출력
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).getLast());
                    break;
            }
        }
    }
}
