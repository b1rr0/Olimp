package structures.tree;

import java.util.ArrayList;
import java.util.List;


public class Heap<T> {

    List<Pair<Integer, T>> heap = new ArrayList<>();

    public Heap() {
        heap.add(null);
    }

    public void add(Pair<Integer, T> p) {
        heap.add(p);
        shiftUp(heap.size() - 1);
    }

    public boolean getTop() {
        if (heap.size() == 1) return false;
        System.out.println(heap.get(1));
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (heap.size() == 1) return true;
        shiftDown();
        return true;
    }

    private void shiftDown() {
        int i = 1;
        while (true) {
            int left = left(i);
            int right = right(i);
            var p = heap.get(i);
            var pL = heap.size() > left ? heap.get(left) : null;
            var pR = heap.size() > right ? heap.get(right) : null;

            int ind = i;
            var max = p;
            if (pL != null && pL.a < max.a) {
                ind = left;
                max = pL;
            }
            if (pR != null && pR.a < max.a) {
                ind = right;
                max = pR;
            }

            if (ind == i) return;
            heap.set(i, max);
            heap.set(ind, p);
            i = ind;
        }
    }

    public void print() {
        int j = 1;
        int index = 0;

        for (int i1 = 1; i1 < heap.size(); i1++) {
            System.out.print(heap.get(i1) + " ");
            index++;
            if (j == index) {
                j <<= 1;
                System.out.println();
                index = 0;
            }

        }
    }

    private void shiftUp(int i) {
        while (i > 1) {
            var current = heap.get(i);
            var parent = heap.get(parent(i));
            if (parent.a > current.a) {
                heap.set(i, parent);
                heap.set(parent(i), current);
                i = parent(i);
            } else return;
        }
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return left(i) + 1;
    }

    public static void main(String[] args) {
        
        Heap<Integer> heap = new Heap<>();
        heap.add(new Pair<>(1, 2));
        heap.add(new Pair<>(3, 2));
        heap.add(new Pair<>(5, 2));
        heap.add(new Pair<>(2, 2));
        heap.add(new Pair<>(4, 2));
        heap.add(new Pair<>(6, 2));
        heap.add(new Pair<>(2, 2));
        heap.add(new Pair<>(3, 2));
        heap.add(new Pair<>(2, 2));
        heap.add(new Pair<>(5, 2));
        heap.add(new Pair<>(4, 2));
        assert 2==2;
        heap.getTop();
        heap.add(new Pair<>(5, 2));
        heap.add(new Pair<>(2, 2));
        heap.print();
  //while (heap.getTop()) {
  //   System.out.println();
  //   heap.print();
  //
    }

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
            return a + "=" + b;
        }
    }
}