import java.util.*;
public class Main{
    public static int n,m;
    public static int arr[] = new int[100001];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        if(n == m) {
            System.out.println(0);
        }else {
            bfs(n);
        }
    }
    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 1;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < 3; i++) {
                int next;
                if(i == 0)
                    next = now + 1;
                else if(i == 1)
                    next = now - 1;
                else
                    next = now * 2;
                if(next == m) {
                    System.out.println(arr[now]);
                    return;
                }
                if(next >= 0 && next < arr.length && arr[next] == 0) {
                    queue.add(next);
                    arr[next] = arr[now] + 1;
                }
            }
        }
    }
}