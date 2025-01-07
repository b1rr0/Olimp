package contests.leet.solutions;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class LastNumber {
    public String largestNumber(int[] nums) {
        Queue<String> q = new PriorityQueue<>((Comparator<String>) (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int num : nums) {
            q.add(String.valueOf(num));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!q.isEmpty()) {
            stringBuilder.append(q.poll());
        }
        var a = stringBuilder.toString();

        return a.startsWith("0")?"0":a;
    }
}