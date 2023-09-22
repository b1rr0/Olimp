package structures.tree;

public class BinaryTree {
    Node n;

    public BinaryTree(int n) {
        this.n = new Node(n);
    }

    public boolean isPresent(int s) {
        var locan = n;
        while (locan != null) {
            if (locan.val == s) {
                return true;
            }
            locan = locan.val < s ? locan.r : locan.l;
        }
        return false;
    }


    public void add(int s) {
        var locan = n;
        while (true) {

            if (locan.val < s) {
                if (locan.r == null) {
                    locan.r = new Node(s);
                    return;
                }
                locan = locan.r;
            } else {
                if (locan.l == null) {
                    locan.l = new Node(s);
                    return;
                }
                locan = locan.l;
            }
        }
    }

    public void print() {
        print(n, "","=");
    }

    private void print(Node n, String s,String prep) {
        if (n.l != null) {
            print(n.l,"  "+s,"/-");
        }
        System.out.println(s+prep+ n.val);
        if (n.r != null) {
            print(n.r,"  "+s,"\\-");
        }

    }

    class Node {
        int val;
        Node l;
        Node r;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        var v = new BinaryTree(11);
        v.add(0);
        v.add(45);
        v.add(30);
        v.add(22);
        v.add(55);
        v.add(42);
        v.add(12);
        v.add(52);
        v.print();
        System.out.println(v.isPresent(2));
    }
}
