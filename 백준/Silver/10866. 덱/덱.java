import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 명령의 수
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" "); // 명령 입력

            switch (s[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(s[1])); // 정수 X를 덱에 넣기
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(s[1])); // 정수 X를 덱에 넣기
                    break;
                case "pop_front":
                    System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    // 덱이 비어 있으면 1, 아니면 0 출력
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    // 덱의 가장 앞에 있는 정수 출력
                    System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case "back":
                    System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
                    break;
            }
        }
    }
}
