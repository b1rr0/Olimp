package contests.leet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));

        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length - 1; i++) {
            var a = words[i];
            for (int i1 = i + 1; i1 < words.length; i1++) {
                if (words[i1].contains(a)) {
                    res.add(a);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i=0;i<=100;i++){
            System.out.println(i);
        }

    }
}


