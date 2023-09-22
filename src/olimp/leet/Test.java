package olimp.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test {

    public String reverseVowels(String string) {
        Set<Character> s = new HashSet<>();
        s.add('a');
        s.add('A');
        s.add('E');
        s.add('e');
        s.add('i');
        s.add('I');
        s.add('o');
        s.add('O');
        s.add('u');
        s.add('U');

        List<Character> q = new ArrayList<>();
        var va = string.toCharArray();
        for (int i = va.length - 1; i >= 0; i--) {

            var v = string.charAt(i);
            if (s.contains(v)) {
                q.add(v);
            }
        }
        int index = q.size() - 1;
        for (int length = va.length - 1; length >= 0; length--) {

            var v = string.charAt(length);
            if (s.contains(v)) {
                va[length] = q.get(index--);
            }
        }

        return new String(va);
        //a', 'e', 'i', 'o', and 'u'
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(4);
        set.add(5);
        for (Integer integer : set) {
            System.out.println(integer);
        }
        System.out.println(set.higher(10));
    }
// /* // /* ****** */ */
    /* *** */


}
