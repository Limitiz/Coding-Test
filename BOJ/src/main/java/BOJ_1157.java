import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int word[] = new int[26];
        int max = 0, second = 0;
        int ans = 0;
        String s = br.readLine().toUpperCase();

        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'A';
            word[index]++;
        }

        for(int i=0; i<26; i++){
            if(word[i] > max) {
                max = word[i];
                ans = i;
            }
            else if(word[i] == max)
                second = word[i];
        }

        if(max == second)
            System.out.print("?");
        else
            System.out.print((char)(ans+'A'));
    }
}
