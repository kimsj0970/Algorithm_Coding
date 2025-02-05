class Solution {
    static int[] array = {-1,-1};
    static int min=Integer.MAX_VALUE;
    
      public int[] solution(int[] sequence, int k) {
        int left =0;  int sum = 0;
        int size = sequence.length;
        for (int right=0; right < sequence.length; right++) {
            sum+=sequence[right];
            while ( sum>k){
                sum-=sequence[left];
                left++;
            }
            if (sum==k){
                if (size > right-left){
                    size= right-left;
                    array[0]=left;
                    array[1]=right;
                }
            }
        }
        return array;
    }
}