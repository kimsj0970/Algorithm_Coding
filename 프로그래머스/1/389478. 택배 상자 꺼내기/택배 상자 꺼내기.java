class Solution {
    public int solution(int n, int w, int num) {
     int answer = 0;
        int cha = 0;

        // if (n<=w){
        //     cha = n/w;
        // }
        // else
        //     cha = (n/w)+1;

        cha = (n+w - 1) / w;

        int[][] arr = new int[cha][w];

        boolean leftToRight = true;
        int count = 1;
        A:
        for (int i = arr.length-1; i >= 0; i--) {
            if (leftToRight){
                for (int j = 0; j < w; j++) {

                    if(count > n) {
                        break A;
                    }
                    arr[i][j] = count;
                    count++;
                }
            }

            else {
                for (int j =w-1; j >= 0; j--) {
                    if(count > n) {
                        break A;
                    }

                    arr[i][j] = count;
                    count++;
                }
            }
            leftToRight = !leftToRight; // 방향 전환
        }

        // num 위치 찾기
        int x=0, y=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == num){
                    x=j;
                    y=i;
                }
            }
        }

        //찾은 numm 위치에 박스가 몇개인지
        for(int i=y; i >= 0; i--){
            if(arr[i][x] != 0 ){
                answer++;
            }
        }

        return answer;
    }
}
