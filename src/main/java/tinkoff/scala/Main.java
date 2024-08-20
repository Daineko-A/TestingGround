package tinkoff.scala;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
        int a = scanner.nextInt();
        scanner.hasNext();
        scanner.hasNext();
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        LinkedList<Integer> res = new LinkedList<>();
        res.add(0);
        System.out.println(str);

        int index = 0;
        int count = 1;
        for (char ch : chars) {
            if (ch == 'l' || ch == 'L') {
                res.add(index, count);
            } else {
                index++;
                res.add(index, count);
            }
            count++;
        }

        System.out.println(
                res.stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining(" ")));
    }
}
