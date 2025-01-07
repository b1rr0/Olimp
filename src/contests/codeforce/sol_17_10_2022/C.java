package contests.codeforce.sol_17_10_2022;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class C {

    static long[][] dp;
    static int SSS = 0;


    long req(int index, boolean[] isKr, long max, List<Long> list) {

        if (index == list.size()) return max;
        int in2 = isKr[index] ? 1 : 0;
        if (dp[index][in2] > max) {
            return dp[index][in2];
        } else {
            dp[index][in2] = max;
        }
        SSS++;
        long res = max;
        for (int i = index; i < list.size(); i++) {
            if (isKr[i] && !isKr[i - 1]) {
                isKr[i] = false;
                res = Math.max(res, req(index + 1, isKr, max - list.get(i) + list.get(i - 1), list));
                isKr[i] = true;
            }
        }
        return res;
    }


    public void solve() {
        int n = fastScanner.nextInt();
        String s = fastScanner.next();
        List<Long> l = new ArrayList<>();
        while (n-- > 0) {
            l.add(fastScanner.nextLong());
        }
        boolean[] booleans = new boolean[s.length()];
        for (int i = 0; i < s.toCharArray().length; i++) {
            booleans[i] = s.charAt(i) == '1';
        }
        dp = new long[s.length()][2];

        if (booleans[0]) {
            dp[0][1] = l.get(0);
            dp[0][0] = -9999;
        } else {
            dp[0][0] = 0;
        }

        for (int i = 1; i < l.size(); i++) {
            if (booleans[i]) {
                if (dp[i - 1][0] == -9999) {
                    dp[i][0] = -9999;
                    dp[i][1] = l.get(i);
                } else {
                    dp[i][1] = dp[i - 1][1] + l.get(i);
                    dp[i][0] = dp[i - 1][0];
                }
            } else {
                dp[i][1] = (dp[i - 1][1]);
                dp[i][0] = dp[i - 1][0]+ l.get(i);
            }
            System.out.println(booleans[i]);
            System.out.println(dp[i][0] + "->" + dp[i][1]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i][0] + " = " + dp[i][1]);
        }
        out.println(booleans[s.length() - 1] ? 1 : 0);
    }

    //  int n = fastScanner.nextInt();
    //  while (n--> 0) {
    // }

    /*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ⣿⣿⣷⡁⢆⠈⠕⢕⢂⢕⢂⢕⢂⢔⢂⢕⢄⠂⣂⠂⠆⢂⢕⢂⢕⢂⢕⢂⢕⢂  ⣿⣿⣷⡁⢆⠈⠕⢕⢂⢕⢂⢕⢂⢔⢂⢕⢄⠂⣂⠂⠆⢂⢕⢂⢕⢂⢕⢂⢕⢂  ⣿⣿⣷⡁⢆⠈⠕⢕⢂⢕⢂⢕⢂⢔⢂⢕⢄⠂⣂⠂⠆⢂⢕⢂⢕⢂⢕⢂⢕⢂
    ⣿⣿⣿⡷⠊⡢⡹⣦⡑⢂⢕⢂⢕⢂⢕⢂⠕⠔⠌⠝⠛⠶⠶⢶⣦⣄⢂⢕⢂⢕  ⣿⣿⣿⡷⠊⡢⡹⣦⡑⢂⢕⢂⢕⢂⢕⢂⠕⠔⠌⠝⠛⠶⠶⢶⣦⣄⢂⢕⢂⢕  ⣿⣿⣿⡷⠊⡢⡹⣦⡑⢂⢕⢂⢕⢂⢕⢂⠕⠔⠌⠝⠛⠶⠶⢶⣦⣄⢂⢕⢂⢕
    ⣿⣿⠏⣠⣾⣦⡐⢌⢿⣷⣦⣅⡑⠕⠡⠐⢿⠿⣛⠟⠛⠛⠛⠛⠡⢷⡈⢂⢕⢂  ⣿⣿⠏⣠⣾⣦⡐⢌⢿⣷⣦⣅⡑⠕⠡⠐⢿⠿⣛⠟⠛⠛⠛⠛⠡⢷⡈⢂⢕⢂  ⣿⣿⠏⣠⣾⣦⡐⢌⢿⣷⣦⣅⡑⠕⠡⠐⢿⠿⣛⠟⠛⠛⠛⠛⠡⢷⡈⢂⢕⢂
    ⠟⣡⣾⣿⣿⣿⣿⣦⣑⠝⢿⣿⣿⣿⣿⣿⡵⢁⣤⣶⣶⣿⢿⢿⢿⡟⢻⣤⢑⢂  ⠟⣡⣾⣿⣿⣿⣿⣦⣑⠝⢿⣿⣿⣿⣿⣿⡵⢁⣤⣶⣶⣿⢿⢿⢿⡟⢻⣤⢑⢂  ⠟⣡⣾⣿⣿⣿⣿⣦⣑⠝⢿⣿⣿⣿⣿⣿⡵⢁⣤⣶⣶⣿⢿⢿⢿⡟⢻⣤⢑⢂
    ⣾⣿⣿⡿⢟⣛⣻⣿⣿⣿⣦⣬⣙⣻⣿⣿⣷⣿⣿⢟⢝⢕⢕⢕⢕⢽⣿⣿⣷⣔  ⣾⣿⣿⡿⢟⣛⣻⣿⣿⣿⣦⣬⣙⣻⣿⣿⣷⣿⣿⢟⢝⢕⢕⢕⢕⢽⣿⣿⣷⣔  ⣾⣿⣿⡿⢟⣛⣻⣿⣿⣿⣦⣬⣙⣻⣿⣿⣷⣿⣿⢟⢝⢕⢕⢕⢕⢽⣿⣿⣷⣔
    ⣿⣿⠵⠚⠉⢀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣗⢕⢕⢕⢕⢕⢕⣽⣿⣿⣿⣿  ⣿⣿⠵⠚⠉⢀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣗⢕⢕⢕⢕⢕⢕⣽⣿⣿⣿⣿  ⣿⣿⠵⠚⠉⢀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣗⢕⢕⢕⢕⢕⢕⣽⣿⣿⣿⣿
    ⢷⣂⣠⣴⣾⡿⡿⡻⡻⣿⣿⣴⣿⣿⣿⣿⣿⣿⣷⣵⣵⣵⣷⣿⣿⣿⣿⣿⣿⡿  ⢷⣂⣠⣴⣾⡿⡿⡻⡻⣿⣿⣴⣿⣿⣿⣿⣿⣿⣷⣵⣵⣵⣷⣿⣿⣿⣿⣿⣿⡿  ⢷⣂⣠⣴⣾⡿⡿⡻⡻⣿⣿⣴⣿⣿⣿⣿⣿⣿⣷⣵⣵⣵⣷⣿⣿⣿⣿⣿⣿⡿
    ⢌⠻⣿⡿⡫⡪⡪⡪⡪⣺⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃  ⢌⠻⣿⡿⡫⡪⡪⡪⡪⣺⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃  ⢌⠻⣿⡿⡫⡪⡪⡪⡪⣺⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃
    ⠣⡁⠹⡪⡪⡪⡪⣪⣾⣿⣿⣿⣿⠋⠐⢉⢍⢄⢌⠻⣿⣿⣿⣿⣿⣿⣿⣿⠏⠈  ⠣⡁⠹⡪⡪⡪⡪⣪⣾⣿⣿⣿⣿⠋⠐⢉⢍⢄⢌⠻⣿⣿⣿⣿⣿⣿⣿⣿⠏⠈  ⠣⡁⠹⡪⡪⡪⡪⣪⣾⣿⣿⣿⣿⠋⠐⢉⢍⢄⢌⠻⣿⣿⣿⣿⣿⣿⣿⣿⠏⠈
    ⡣⡘⢄⠙⣾⣾⣾⣿⣿⣿⣿⣿⣿⡀⢐⢕⢕⢕⢕⢕⡘⣿⣿⣿⣿⣿⣿⠏⠠⠈  ⡣⡘⢄⠙⣾⣾⣾⣿⣿⣿⣿⣿⣿⡀⢐⢕⢕⢕⢕⢕⡘⣿⣿⣿⣿⣿⣿⠏⠠⠈  ⡣⡘⢄⠙⣾⣾⣾⣿⣿⣿⣿⣿⣿⡀⢐⢕⢕⢕⢕⢕⡘⣿⣿⣿⣿⣿⣿⠏⠠⠈
    ⠌⢊⢂⢣⠹⣿⣿⣿⣿⣿⣿⣿⣿⣧⢐⢕⢕⢕⢕⢕⢅⣿⣿⣿⣿⡿⢋⢜⠠⠈  ⠌⢊⢂⢣⠹⣿⣿⣿⣿⣿⣿⣿⣿⣧⢐⢕⢕⢕⢕⢕⢅⣿⣿⣿⣿⡿⢋⢜⠠⠈  ⠌⢊⢂⢣⠹⣿⣿⣿⣿⣿⣿⣿⣿⣧⢐⢕⢕⢕⢕⢕⢅⣿⣿⣿⣿⡿⢋⢜⠠⠈
    ⠄⠁⠕⢝⡢⠈⠻⣿⣿⣿⣿⣿⣿⣿⣷⣕⣑⣑⣑⣵⣿⣿⣿⡿⢋⢔⢕⣿⠠⠈  ⠄⠁⠕⢝⡢⠈⠻⣿⣿⣿⣿⣿⣿⣿⣷⣕⣑⣑⣑⣵⣿⣿⣿⡿⢋⢔⢕⣿⠠⠈  ⠄⠁⠕⢝⡢⠈⠻⣿⣿⣿⣿⣿⣿⣿⣷⣕⣑⣑⣑⣵⣿⣿⣿⡿⢋⢔⢕⣿⠠⠈
    ⠨⡂⡀⢑⢕⡅⠂⠄⠉⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⢔⢕⢕⣿⣿⠠⠈  ⠨⡂⡀⢑⢕⡅⠂⠄⠉⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⢔⢕⢕⣿⣿⠠⠈  ⠨⡂⡀⢑⢕⡅⠂⠄⠉⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⢔⢕⢕⣿⣿⠠⠈
    ⠄⠪⣂⠁⢕⠆⠄⠂⠄⠁⡀⠂⡀⠄⢈⠉⢍⢛⢛⢛⢋⢔⢕⢕⢕⣽⣿⣿⠠⠈  ⠄⠪⣂⠁⢕⠆⠄⠂⠄⠁⡀⠂⡀⠄⢈⠉⢍⢛⢛⢛⢋⢔⢕⢕⢕⣽⣿⣿⠠⠈  ⠄⠪⣂⠁⢕⠆⠄⠂⠄⠁⡀⠂⡀⠄⢈⠉⢍⢛⢛⢛⢋⢔⢕⢕⢕⣽⣿⣿⠠⠈
      */////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean isLocal = true;
    static FastScanner fastScanner = new FastScanner();
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {


        int N = fastScanner.nextInt();
        var example = new C();
        while (N-- > 0) {
            example.solve();
        }
        out.println();
        out.println(SSS);
        out.close();


        if (isLocal) {
            try {
                new C().buildFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public FastScanner() {
            if (isLocal) {
                try {
                    File f = new File("src/CODE_FORCE.sol_17_10_2022/input.txt");
                    this.br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }

    public void buildFile() throws IOException {

        File thisFile = new File("src/CODE_FORCE.sol_17_10_2022/LeetCoodeExample.C.java");
        String s = "";
        try (FileReader reader = new FileReader(thisFile)) {
            int c;
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            s = stringBuilder.toString();
        }
        /////////////////////////////////////////////////////////////////////////////
        s = s.replace("  cout", "// cout");
        s = s.replace("  System.out.print", "// System.out.print");
        s = s.replace("  cout", "// cout");
        s = s.replace("package CODE_FORCE.sol_17_10_2022;", "// ronin");
        s = s.replace("public static boolean isLocal = true;",
                "public static boolean isLocal = false;");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        File file = new File("src/CODE_FORCE.sol_17_10_2022/LastBuild.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(s);
            writer.flush();
        }

    }

    ///////

    public <T> void sout(List<T> s) {
        for (T o : s) {
            System.out.print(o + " ");
        }
    }

    public <T, V> void sout(Map<T, V> s) {
        for (T t : s.keySet()) {
            System.out.println(t + "=" + s.get(t));
        }
    }

    /////////
    /////////
    /////////
    /////////
    static class Pair<V, T> {
        private V a;
        private T b;

        public Pair(V a, T b) {
            this.a = a;
            this.b = b;
        }

        public V getA() {
            return a;
        }

        public T getB() {
            return b;
        }

        public Pair<V, T> setA(V a) {
            this.a = a;
            return this;
        }

        public Pair<V, T> setB(T b) {
            this.b = b;
            return this;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
                    .add("a=" + a)
                    .add("b=" + b)
                    .toString();
        }
    }

    //algs
    private boolean isEven(int a) {
        return (a & 1) == 0;
    }

    public static int binFindPosToPut(List<Integer> list, int val, boolean isSorted) {
        if (!isSorted) {
            Collections.sort(list);
        }
        int l = 0;
        int r = list.size();
        int m = 0;
        while (l < r) {
            m = (l + r) / 2;
            var cur = list.get(m);
            if (cur < val) {
                l = ++m;
                continue;
            }
            if (cur == val) return m;
            r = --m;
        }
        return m;
    }
}