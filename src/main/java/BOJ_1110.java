import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int left, right, temp, origin;
        int cycle = 0;

        origin = n;
        do{
            if (n < 10)  left = 0;
            else  left = n / 10;

            right = n % 10;
            temp = left + right;
            n = right*10+temp%10;

            cycle++;
        }while(origin != n);

        System.out.print(cycle);
    }
}