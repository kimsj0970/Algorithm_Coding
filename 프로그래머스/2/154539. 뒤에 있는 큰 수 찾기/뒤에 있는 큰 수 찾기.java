import java.util.*;
import java.util.Stack;

class Solution {
           public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < answer.length; i++) {
                answer[i] = -1;
            }

            for (int i = 0; i < numbers.length; i++) {
                // 2. 값이 들어가기 시작하면 1 이후 2, 3, 4 이렇게 큐에 넣게 되는데
                // i값이 증가 할 때 numbers[i]값이 큐에 있는 애들 값보다 크면 numbers[i]값을 넣음
                // 즉 본인들보다 큰 값을 찾을 때까지 queue에 쌓이게 됨
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    int index = stack.pop();
                    answer[index] = numbers[i];
                }
                stack.push(i);  // 1. 제일 첨에는 스택에 아무것도 없으니 위에 while문이 실행되지 않고 push가 실행됨
            }
            return answer;
        }
    }
