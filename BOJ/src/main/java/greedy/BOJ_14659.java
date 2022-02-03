package greedy;

import java.util.Scanner;

public class BOJ_14659 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] mountain = new int[num];
        for(int i=0; i<num; i++)
            mountain[i] = sc.nextInt();

        int count = 0 , max = 0;
        int high = mountain[0];
        for(int i=0; i<num; i++){
            if(high<mountain[i]) {
                high = mountain[i];
                max = max > count ? max : count;
                count=-1;
            }
                count++;
        }
        max = max > count ? max : count;
        System.out.println(max);
        sc.close();
    }
}
