package structures.chouse_normal_name.hafman;

import java.io.*;
import java.util.*;

import structures.chouse_normal_name.hafman.Hafman.Node;


public class DeHafman {
    public void solve(Map<String, String> map, String res, int size, PrintWriter out) {


        out.println();
    }


    public Node fill(Map<String, String> map) {
        Node res = new Node();
        res.val = '-';

        for (String s : map.keySet()) {
            Node start = res;
            String code = map.get(s);
            for (char c : code.toCharArray()) {
                if (c == '0') {
                    if (start.l == null) {
                        start.l = new Node();
                        start.l.val = '-';
                    }
                    start = start.l;
                } else {
                    if (start.r == null) {
                        start.r = new Node();
                        start.r.val = '-';
                    }
                    start = start.r;
                }
            }
        //    start.val = s;
        }
        return res;
    }

    private void print(Node n, String s, String prep) {
        if (n.l != null) {
            print(n.l, "  " + s, "/-");
        }
        System.out.println(s + prep + " " + n.prior + " " + n.val);
        if (n.r != null) {
            print(n.r, "  " + s, "\\-");
        }

    }


    public void read(FastScanner fastScanner, PrintWriter out) {
        int a, b;


        int n = fastScanner.nextInt();
        b = fastScanner.nextInt();
        Map<String, String> stringStringMap = new TreeMap<>();
        String s, s1;
        while (n-- > 0) {
            s = fastScanner.next();
            s1 = fastScanner.next();
            stringStringMap.put(s1, s.replace(":", ""));
        }
        s = fastScanner.next();
        solve(stringStringMap, s, b, out);
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
        int N = 1;
        var example = new DeHafman();
        while (N-- > 0) {
            example.read(fastScanner, out);
        }
        out.println();
        out.close();


        if (isLocal) {
            try {
                new DeHafman().buildFile();
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
                    File f = new File("src/Stepik/input.txt");
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

        File thisFile = new File("src/Stepik/DeHafman.java");
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
        s = s.replace("package Stepik;", "// ronin");
        s = s.replace("public static boolean isLocal = true;",
                "public static boolean isLocal = false;");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        File file = new File("src/Stepik/LastBuild.txt");
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