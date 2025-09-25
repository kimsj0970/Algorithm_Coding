import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Integer, int[]> map = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();
        int[] leftHands = {3,0};
        int[] rightHands = {3,2};
        map.put(1, new int[]{0, 0});
        map.put(2, new int[]{0, 1});
        map.put(3, new int[]{0, 2});
        map.put(4, new int[]{1, 0});
        map.put(5, new int[]{1, 1});
        map.put(6, new int[]{1, 2});
        map.put(7, new int[]{2, 0});
        map.put(8, new int[]{2, 1});
        map.put(9, new int[]{2, 2});
        map.put(0, new int[]{3, 1});


        for (int i = 0; i < numbers.length; i++) {
            int[] position = map.get(numbers[i]);

            if (numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
                result.add("L");
                leftHands[0] = position[0];
                leftHands[1] = position[1];

            }
            else if (numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
                result.add("R");
                rightHands[0] = position[0];
                rightHands[1] = position[1];
            }else{

                int leftResult = Math.abs((position[0]-leftHands[0]))+Math.abs((position[1]-leftHands[1]));
                int rightResult = Math.abs((position[0]-rightHands[0]))+Math.abs((position[1]-rightHands[1]));
                if (leftResult==rightResult){
                    if (hand.equals("left")){
                        result.add("L");
                        leftHands[0] = position[0];
                        leftHands[1] = position[1];
                    }else {
                        result.add("R");
                        rightHands[0] = position[0];
                        rightHands[1] = position[1];
                    }
                }

               else if (leftResult>rightResult){
                    result.add("R");
                    rightHands[0] = position[0];
                    rightHands[1] = position[1];
               }
               else {

                    result.add("L");
                    leftHands[0] = position[0];
                    leftHands[1] = position[1];
                }

            }

        }
        return String.join("", result);

    }
}