package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1913 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] time = new int[num][2];
        for(int i=0;i<num;i++){
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1] - o2[1];
            }
        });

        int end = time[0][1];
        int count=1;
        for(int i=1; i<num; i++){
            if(end<=time[i][0]){
                count++;
                end = time[i][1];
            }
        }

        System.out.println(count);
        sc.close();
    }
}
