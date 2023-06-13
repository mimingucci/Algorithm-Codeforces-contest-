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

    public static void main(String[] args) {
        int t=r.nextInt();
        while((t--)>0){
            int n=r.nextInt();
            int maxx=Integer.MIN_VALUE;
            int minn=Integer.MAX_VALUE;
            int head=-1;
            int b=-1;
            boolean inverse=true;
            for(int i=0; i<n; i++){
                int x=r.nextInt();
                if(i==0){
                    maxx=x;
                    pw.print(1);
                    minn=x;
                    head=x;
                    b=x;
                }else{
                    if(inverse){
                        if(x>=b){
                            pw.print(1);
                            b=x;
                        }else{
                            if(x<=head){
                                b=x;
                                pw.print(1);
                                inverse=false;
                            }else{
                                pw.print(0);
                            }
                        }
                    }else{
                        if(x>=b && x<=head){
                            b=x;
                            pw.print(1);
                        }else{
                            pw.print(0);
                        }
                    }
                }
            }
            pw.println();
        }
        pw.close(); // flushes the output once printing is done
    }
}