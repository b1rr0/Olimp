package diploma_researches;

import diploma_researches.HashTable.TestRunner;
import diploma_researches.SkipList.SkipList;

import java.util.*;

public class TestSkipLists {

    public static void main(String[] args) {
        List<TestRunner> testRunners = new ArrayList<>();

        Random r = new Random();


        List<Integer> dataSet = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataSet.add(r.nextInt());
        }


        Scanner scanner = new Scanner(System.in);
        SkipList<String, String> skipList = new SkipList<>();

        for (; ; ) {
            String a = scanner.nextLine();
            String[] test = a.split(" ");

            if (test[0].equals("help")) {
                System.out.println("Available commands:");
                System.out.println("add <key> <value> - Add a key-value pair to the SkipList");
                System.out.println("rm <key> - Remove a key-value pair from the SkipList");
                System.out.println("show - Display the contents of the SkipList");
                System.out.println("fill - Fill the SkipList with 100 key-value pairs from the dataSet");
                System.out.println("get <key> - Get the value associated with a key in the SkipList");
                continue;
            }

            if (test[0].equals("add")) {
                String res = String.join("", Arrays.copyOfRange(test, 2, test.length));
                skipList.put(test[1], res);
                System.out.println("added");
            }

            if (test[0].equals("rm")) {
                skipList.remove(test[1]);
                System.out.println("deleted");
            }
            if (test[0].equals("show")) {
                skipList.show();
                System.out.println("---");
            }
            if (test[0].equals("fill")) {
                for (int i = 0; i < 100; i++) {
                    skipList.put("" + dataSet.get(i), "data" + dataSet.get(i));
                }
                System.out.println("filled");
            }
            if (test[0].equals("get")) {
                System.out.println(skipList.get(test[1]));
            }
            if(test[0].equals("exit")) break;

        }
    }


}
