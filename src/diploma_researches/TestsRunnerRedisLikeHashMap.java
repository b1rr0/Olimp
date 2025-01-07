package diploma_researches;

import diploma_researches.HashTable.RedisLikeHashMap;
import diploma_researches.HashTable.TestRunner;

import java.util.*;

public class TestsRunnerRedisLikeHashMap {
    public static void main(String[] args) {
        List<TestRunner> testRunners = new ArrayList<>();

        Random r = new Random();


        List<Integer> dataSet = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataSet.add(r.nextInt());
        }


        Scanner scanner = new Scanner(System.in);
        RedisLikeHashMap redisLikeHashMap = new RedisLikeHashMap<String, String>();

        for (; ; ) {
            String a = scanner.nextLine();
            String[] test = a.split(" ");

            if (test[0].equals("help")) {
                System.out.println("Available commands:");
                System.out.println("add <key> <value> - Add a key-value pair to the RedisLikeHashMap");
                System.out.println("rm <key> - Remove a key-value pair from the RedisLikeHashMap");
                System.out.println("show - Display the contents of the RedisLikeHashMap");
                System.out.println("fill - Fill the RedisLikeHashMap with 100 key-value pairs from the dataSet");
                System.out.println("get <key> - Get the value associated with a key in the RedisLikeHashMap");
                continue;
            }

            if (test[0].equals("add")) {
                String res = String.join("", Arrays.copyOfRange(test, 2, test.length));
                redisLikeHashMap.put(test[1], res);
                System.out.println("added");
            }

            if (test[0].equals("rm")) {
                redisLikeHashMap.remove(test[1]);
                System.out.println("deleted");
            }
            if (test[0].equals("show")) {
                redisLikeHashMap.show();
                System.out.println("---");
            }
            if (test[0].equals("fill")) {
                for (int i = 0; i < 100; i++) {
                    redisLikeHashMap.put("" + dataSet.get(i), "data" + dataSet.get(i));
                }
                System.out.println("filled");
            }
            if (test[0].equals("get")) {
                System.out.println(redisLikeHashMap.get(test[1]));
            }
            if(test[0].equals("exit")) break;

        }
    }


}
