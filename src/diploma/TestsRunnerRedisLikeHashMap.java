package diploma;

import diploma.HashTable.RedisLikeHashMap;
import diploma.HashTable.TestRunner;

import java.util.*;

public class TestsRunnerRedisLikeHashMap {
    public static void main(String[] args) {
        List<TestRunner> testRunners = new ArrayList<>();

        Random r = new Random();


        List<Integer> dataSet = new ArrayList<>();
       // for (int i = 0; i < 1_000_000; i++) {
      //      dataSet.add(r.nextInt());
    //    }


        Scanner scanner = new Scanner(System.in);
        RedisLikeHashMap redisLikeHashMap = new RedisLikeHashMap<String, String>();

        for (; ; ) {
            String a = scanner.nextLine();
            String[] test = a.split(" ");

            if (test[0].equals("add")) {
                String res = String.join("", Arrays.copyOfRange(test, 2, test.length));
                redisLikeHashMap.put(test[1], res);
            }

            if (test[0].equals("rm")) {
                redisLikeHashMap.remove(test[1]);
            }
            if (test[0].equals("get")) {
                redisLikeHashMap.get(test[1]);
            }
        }
    }


}
