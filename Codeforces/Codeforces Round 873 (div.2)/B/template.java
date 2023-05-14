import java.io.*;
import java.util.*;
import java.lang.*;

public class template {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());
        }

        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }

        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
        }
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static int lower_bound(ArrayList<Long> ar, long k) {
        int s = 0;
        int e = ar.size();
        while (s != e) {
            int mid = s + e >> 1;
            if (ar.get(mid) < k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.size()) {
            return s;
        }
        return s;
    }

    public static int upper_bound(ArrayList<Long> ar, long k) {
        int s = 0;
        int e = ar.size();
        while (s != e) {
            int mid = s + e >> 1;
            if (ar.get(mid) <= k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.size()) {
            return s;
        }
        return s;
    }

    static int bit(long n, int i) {
        return (int) ((n >> i) & 1);
    }

    static boolean isPowerOfTwo(long n) {

        return (n >= 1) && (!((n & (n - 1)) >= 1));
    }

    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public static int[][] identity(int n){
        int[][] a=new int[n][n];
        for(int i=0; i<n; i++){
            a[i][i]=1;
        }
        return a;
    }


    public static int[][] multi_matrix(int[][] a, int[][] b){
        int[][] ans=new int[a.length][b[0].length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<b[0].length; j++){
                for(int k=0; k<a[0].length; k++){
                    ans[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return ans;
    }

    public static int[][] pow_matrix(int[][] a, int exp){
        int[][] ans=identity(a.length);
        int[][] base=a;
        for(; exp>0; exp>>=1, base=multi_matrix(base, base)){
            if((exp & 1)>0){
                ans=multi_matrix(ans, base);
            }
        }
        return ans;
    }

    public static class Pair{
        public int black;
        public int white;

        public Pair(int black, int white) {
            this.black = black;
            this.white = white;
        }

        public int getBlack() {
            return black;
        }

        public void setBlack(int black) {
            this.black = black;
        }

        public int getWhite() {
            return white;
        }

        public void setWhite(int white) {
            this.white = white;
        }
    }

    public static boolean isPalindrome(String s){
        if(s.length()==1){
            return true;
        }else{
            int n=s.length();
            for(int i=0; i<n/2; i++){
                if(s.charAt(i)!=s.charAt(n-1-i)){
                    return false;
                }
            }
            return true;
        }
    }

     public static int gcd(int a, int b)
 {
   if (b == 0)
     return a;
   return gcd(b, a % b);
 }



    public static void main(String[] args) {
        int t;
        t=r.nextInt();
        while((t--)>0){
            int n;
            n=r.nextInt();
            int ans=r.nextInt();
            ans-=1;
            for(int i=2; i<=n; i++){
                int x=r.nextInt();
                ans=gcd(ans, Math.abs(x-i));
            }
            pw.println(ans);
        }
        pw.close(); // flushes the output once printing is done
    }
}


