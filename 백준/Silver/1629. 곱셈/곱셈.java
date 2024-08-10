import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger A = new BigInteger(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        BigInteger C = new BigInteger(st.nextToken());

        BigInteger result = modularExponentiation(A, B, C);
        System.out.println(result);
    }

    private static BigInteger modularExponentiation(BigInteger base, int exponent, BigInteger mod) {
        if (exponent == 0) {
            return BigInteger.ONE; 
        }

        BigInteger half = modularExponentiation(base, exponent / 2, mod);
        BigInteger halfSquared = half.multiply(half).mod(mod);

        if (exponent % 2 == 0) {
            return halfSquared; 
        } else {
            return halfSquared.multiply(base).mod(mod); 
        }
    }
}
