package olimp.CODE_FORCE.sol_07_10_2022;

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
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class B {
    public void solve(BigDecimal l, BigDecimal r, PrintWriter out) {

        var l1 = new BigDecimal(l.toString());
        var r1 = new BigDecimal(r.toString());
        l = l.sqrt(MathContext.DECIMAL128);

        r = r.sqrt(MathContext.DECIMAL128);
        l = l.setScale(0, RoundingMode.HALF_UP);
        r = r.setScale(0, RoundingMode.HALF_UP);
        var res = l.multiply(new BigDecimal(3));
        var res2 = r.multiply(new BigDecimal(3));
        System.out.println(res2);
        System.out.println(res);

        res = res.multiply(new BigDecimal(3));




        out.println(res);
    }

    public void read(FastScanner fastScanner, PrintWriter out) {
        String l, r;
        l = fastScanner.next();
        r = fastScanner.next();

        new BigDecimal(l);
        new BigDecimal(r);

        solve(new BigDecimal(l), new BigDecimal(r), out);
    }
    //  int n = fastScanner.nextInt();
    //  while (n--> 0) {
    // }

    /*
        ⣿⣿⣷⡁⢆⠈⠕⢕⢂⢕⢂⢕⢂⢔⢂⢕⢄⠂⣂⠂⠆⢂⢕⢂⢕⢂⢕⢂⢕⢂
        ⣿⣿⣿⡷⠊⡢⡹⣦⡑⢂⢕⢂⢕⢂⢕⢂⠕⠔⠌⠝⠛⠶⠶⢶⣦⣄⢂⢕⢂⢕
        ⣿⣿⠏⣠⣾⣦⡐⢌⢿⣷⣦⣅⡑⠕⠡⠐⢿⠿⣛⠟⠛⠛⠛⠛⠡⢷⡈⢂⢕⢂
        ⠟⣡⣾⣿⣿⣿⣿⣦⣑⠝⢿⣿⣿⣿⣿⣿⡵⢁⣤⣶⣶⣿⢿⢿⢿⡟⢻⣤⢑⢂
        ⣾⣿⣿⡿⢟⣛⣻⣿⣿⣿⣦⣬⣙⣻⣿⣿⣷⣿⣿⢟⢝⢕⢕⢕⢕⢽⣿⣿⣷⣔
        ⣿⣿⠵⠚⠉⢀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣗⢕⢕⢕⢕⢕⢕⣽⣿⣿⣿⣿
        ⢷⣂⣠⣴⣾⡿⡿⡻⡻⣿⣿⣴⣿⣿⣿⣿⣿⣿⣷⣵⣵⣵⣷⣿⣿⣿⣿⣿⣿⡿
        ⢌⠻⣿⡿⡫⡪⡪⡪⡪⣺⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃
        ⠣⡁⠹⡪⡪⡪⡪⣪⣾⣿⣿⣿⣿⠋⠐⢉⢍⢄⢌⠻⣿⣿⣿⣿⣿⣿⣿⣿⠏⠈
        ⡣⡘⢄⠙⣾⣾⣾⣿⣿⣿⣿⣿⣿⡀⢐⢕⢕⢕⢕⢕⡘⣿⣿⣿⣿⣿⣿⠏⠠⠈
        ⠌⢊⢂⢣⠹⣿⣿⣿⣿⣿⣿⣿⣿⣧⢐⢕⢕⢕⢕⢕⢅⣿⣿⣿⣿⡿⢋⢜⠠⠈
        ⠄⠁⠕⢝⡢⠈⠻⣿⣿⣿⣿⣿⣿⣿⣷⣕⣑⣑⣑⣵⣿⣿⣿⡿⢋⢔⢕⣿⠠⠈
        ⠨⡂⡀⢑⢕⡅⠂⠄⠉⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⢔⢕⢕⣿⣿⠠⠈
        ⠄⠪⣂⠁⢕⠆⠄⠂⠄⠁⡀⠂⡀⠄⢈⠉⢍⢛⢛⢛⢋⢔⢕⢕⢕⣽⣿⣿⠠⠈
   *////////////////////////////////////////////
    public static boolean isLocal = true;

    public static void main(String[] args) {

        FastScanner fastScanner = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int N = fastScanner.nextInt();
        var example = new B();
        while (N-- > 0) {
            example.read(fastScanner, out);
        }
        out.println();
        out.close();


        if (isLocal) {
            try {
                new B().buildFile();
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
                    File f = new File("src/CODE_FORCE.sol_07_10_2022/input.txt");
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

        File thisFile = new File("src/CODE_FORCE.sol_07_10_2022/LeetCoodeExample.B.java");
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
        s = s.replace("package CODE_FORCE.sol_07_10_2022;", "// ronin");
        s = s.replace("public static boolean isLocal = true;",
                "public static boolean isLocal = false;");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        File file = new File("src/CODE_FORCE.sol_07_10_2022/LastBuild.txt");
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