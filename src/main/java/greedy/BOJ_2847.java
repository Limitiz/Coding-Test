package greedy;

import java.util.Scanner;

public class BOJ_2847 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] score = new int[num];
        for(int i=0;i<num;i++)
            score[i] = sc.nextInt();

        int count=0, sub=0;
        for(int i = num-1; i>0; i--){
            if(score[i]<=score[i-1]) {
                sub = score[i - 1] - score[i] + 1;
                count += sub;
                score[i-1] -= sub;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
