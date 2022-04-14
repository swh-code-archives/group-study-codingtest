package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class baekjoon11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String sNum = br.readLine();
        char [] cNum = sNum.toCharArray();
        int sum = 0;
        for(char x : cNum){
            sum += x - '0';
        }

        System.out.println(sum);
    }
}
