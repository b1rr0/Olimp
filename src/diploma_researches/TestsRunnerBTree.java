package diploma_researches;

import diploma_researches.BTree.BTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestsRunnerBTree {
    public static void main(String[] args) {
        Random r = new Random();

        List<Integer> dataSet = new ArrayList<>();
        for (int i = 0; i < 40_000; i++) {
            dataSet.add(Math.abs(r.nextInt()) % 50_000);
        }

        Scanner scanner = new Scanner(System.in);
        BTree<String> bTree = new BTree<>();

        for (; ; ) {
            String a = scanner.nextLine();
            String[] test = a.split(" ");

            if (test[0].equals("help")) {
                System.out.println("Available commands:");
                System.out.println("add <value> - Add a value to the BTree");
                System.out.println("rm <value> - Remove a value from the BTree");
                System.out.println("show - Display the contents of the BTree");
                System.out.println("fill <count> - Fill the BTree with a specified number of values from the dataSet");
                System.out.println("get <value> - Check if a value exists in the BTree");
                System.out.println("clear - Clear the BTree");
                continue;
            }

            if (test[0].equals("add")) {
                bTree.add(test[1]);
                System.out.println("added");
            }
            if (test[0].equals("rm")) {
                bTree.remove(test[1]);
                System.out.println("deleted");
            }

            if (test[0].equals("show")) {
                System.out.println(bTree);
                System.out.println("---");
            }

            if (test[0].equals("fill")) {
                for (int i = 0; i < Integer.parseInt(test[1]); i++) {
                    bTree.add("" + dataSet.get(i));
                }
                System.out.println("filled");
            }

            if (test[0].equals("get")) {
                System.out.println(bTree.contains(test[1]));
            }

            if (test[0].equals("clear")) {
                bTree = new BTree<String>();
            }
            if (test[0].equals("exit")) break;
        }


    }
}
