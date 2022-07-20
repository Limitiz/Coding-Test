package bruteForce_backTracking;

import java.util.Scanner;

public class B1018 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char chess[][] = new char[m][n];
        sc.nextLine();
        for(int i=0;i<m;i++)
            chess[i] = sc.nextLine().toCharArray();
        int min=64;

        for(int i=0; i<=m-8; i++){
            for(int j=0; j<=n-8; j++){
                int num1=0; int num2=0;
                for(int p=i; p<i+8; p++){
                    for(int q=j; q<j+8; q++) {
                        if (chess[p][q] == 'B') {
                            if ((p + q) % 2 == 1)
                                num1++;
                            else
                                num2++;
                        }
                        else{
                            if((p + q)%2 == 0)
                                num1++;
                            else
                                num2++;
                        }
                    } }
                min = Math.min(min, Math.min(num1, num2));
            }
        }
        System.out.println(min);
        sc.close();
    }
}
