package structures.chouse_normal_name.hafman;

import java.io.*;
import java.util.*;

public class Hafman {
    public void solve(String s, PrintWriter out) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Pair<Character, Integer>> list = new ArrayList<>();
        for (Character character : map.keySet()) {
            list.add(new Pair<>(character, map.get(character)));
        }
        List<Node> nodes = new ArrayList<>();
        for (Pair<Character, Integer> characterIntegerPair : list) {
            var node = new Node();
            node.val = characterIntegerPair.a;
            node.prior = characterIntegerPair.b;
            nodes.add(node);
        }
        if (nodes.size() == 1) {
            var node = new Node();
            node.val = '4';
            node.prior = -1;
            nodes.add(node);
        }
        while (nodes.size() != 1) {
            Collections.sort(nodes, Comparator.comparingInt(node -> node.prior));
            Node n = merge2nodes(nodes.get(0), nodes.get(1));
            nodes.remove(1);
            nodes.set(0, n);
        }
        print(nodes.get(0), "", "");
        Map<Character, String> res = new HashMap<>();
        dfs(nodes.get(0), "", res);

        sout(res);
        String ans = "";
        for (char c : s.toCharArray()) {
            ans += res.get(c);
        }
        res.remove('4');
        out.println(res.keySet()
                .size() + " " + ans.length());
        for (int i = 0; i < 26; i++) {
            char current = (char) (i + 'a');
            if (!res.containsKey(current)) {
                continue;
            }
            String ansLocal = current + ": " + res.get(current);
            out.println(ansLocal);
        }

        out.println(ans);
        out.println("");
    }

    public Node merge2nodes(Node a, Node b) {
        System.out.println(a.prior + " a==" + a.val);
        Node res = new Node();
        res.val = '-';
        res.prior = a.prior + b.prior;
        if (a.prior > b.prior) {
            res.l = b;
            res.r = a;
        } else {
            res.l = a;
            res.r = b;
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

    public static void dfs(Node node, String pref, Map<Character, String> map) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        if (node.val != '-') map.put(node.val, pref);
        dfs(node.l, pref + "1", map);
        dfs(node.r, pref + "0", map);
    }

    static class Node {
        int prior;
        char val;
        Node l, r;

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("prior=" + prior)
                    .add("val=" + val)
                    .add("l=" + l)
                    .add("r=" + r)
                    .toString();
        }
    }


    public void read(FastScanner fastScanner, PrintWriter out) {
        int a, b;
        String s = fastScanner.next();
        solve(s, out);
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
        var example = new Hafman();
        while (N-- > 0) {
            example.read(fastScanner, out);
        }
        out.println();
        out.close();


        if (isLocal) {
            try {
                new Hafman().buildFile();
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

        File thisFile = new File("src/Stepik/Hafman.java");
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