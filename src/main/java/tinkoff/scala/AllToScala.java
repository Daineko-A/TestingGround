package tinkoff.scala;

import java.util.Arrays;
import java.util.Scanner;

public class AllToScala {
    //        Assert.assertEquals(0,0);

//    @Test
//    public void name() {
//        Assert.assertEquals(method(15, 1), 8);
//        Assert.assertEquals(method(16, 2), 9);
//
////        28
//        Assert.assertEquals(method(1, 15), 22);
////        29
//        Assert.assertEquals(method(1, 16), 23);
////        30
//        Assert.assertEquals(method(1, 17), 24);
////        31
//        Assert.assertEquals(method(1, 18), 25);
//
////        31
//        Assert.assertEquals(method(7, 24), 31);
////        30
//        Assert.assertEquals(method(8, 24), 1);
////        29
//        Assert.assertEquals(method(9, 24), 2);
////        28
//        Assert.assertEquals(method(10, 24), 3);
//
//        Assert.assertEquals(method(13, 30), 6);
//
//        //    * * * * * * 16
////    * * * * * * 23
////    * * * * * * 1
//
////    * * * * * * 15
////    * * * * * * 22
////    * * * * * * 1
//
////    * * * * * * 24
////    * * * 28 29 30 31
////    * * * * * * 9
////
////    * * * * * * 30
////    31 * * * * * 6
////    * * * * * * 13
//
////    * * * * * * 1
////    * * * * * * 8
////    * * * * * * 15
//
////    * * * * * * 2
////    * * * * * * 9
////    * * * * * * 16
//    }
//
//    public int method(int a, int b) {
//        return a - 7 > 0 ? a - 7 : b + 7;
//    }
//
//
//    public static void mainNext(String[] args) {
//        int a = Integer.parseInt(args[0]);
//        int b = Integer.parseInt(args[1]);
//        System.out.println(a - 7 > 0 ? a - 7 : b + 7);
//    }
//
//
//    @Test
//    public void trinity() {
//        String[] args = {"abcabcabc"};
//        Assert.assertEquals(methodTr(args), 1);
////        Assert.assertEquals(methodTr("abcabcabc"), 3);
////        Assert.assertEquals(methodTr("abcde"), 3);
////        Assert.assertEquals(methodTr("abcaaaabc"), 2);
////        Assert.assertEquals(methodTr("ab"), 0);
////        Assert.assertEquals(methodTr("zyxedcba"), 0);
//    }
//
//    public int methodTr(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.hasNext();
//        String str = scanner.nextLine();
//        if (str.length() <= 2) return 0;
//        char[] chars = str.toCharArray();
//        int result = 0;
//        for (int i = 0; i + 2 < chars.length; i++) {
//            if (chars[i] < chars[i + 1] && chars[i + 1] < chars[i + 2]) {
//                result++;
//            }
//        }
//        return result;
//    }
//
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        scanner.hasNext();
////        String str = scanner.toString();
////        if (str.length() <= 2) System.out.println(0);
////        char[] chars = str.toCharArray();
////        int result = 0;
////        for (int i = 0; i + 2 < chars.length; i++) {
////            if (chars[i] < chars[i + 1] && chars[i + 1] < chars[i + 2]) {
////                result++;
////            }
////        }
////        System.out.println(result);
////    }
//
//    @Test
//    public void crazyArray() {
////        String[] args = {"5", "LRRRL"};
//        String[] args2 = {"6\n" +
//                "RRLLRR"};
////        methodCrazyArray(args);
//        methodCrazyArray(args2);
////        Assert.assertEquals(, "1 2 3 5 4 0");
////        Assert.assertEquals(methodCrazyArray(6, "RRLLRR"), "0 1 4 5 6 3 2");
//    }
//
//    public void methodCrazyArray(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.hasNext();
//        int a = scanner.nextInt();
//        scanner.hasNext();
//        String str = scanner.nextLine();
//        char[] chars = str.toCharArray();
//        LinkedList<Integer> res = new LinkedList<>();
//        res.add(0);
//
//        int index = 0;
//        int count = 1;
//        for (char ch : chars) {
//            if (ch == 'L') {
//                res.add(index, count);
//            } else {
//                index++;
//                res.add(index, count);
//            }
//            count++;
//        }
//
//        System.out.println(res.stream().map(Objects::toString).collect(Collectors.joining(" ")));
//    }

//    public void methodCrazyArray(String[] args) {
//        char[] chars = args[1].toCharArray();
//        LinkedList<Integer> res = new LinkedList<>();
//        res.add(0);
//
//        int index = 0;
//        int count = 1;
//        for (char ch : chars) {
//            if (ch == 'l' || ch == 'L') {
//                res.add(index, count);
//            } else {
//                index++;
//                res.add(index, count);
//            }
//            count++;
//        }
//
//        System.out.println(res.stream().map(Objects::toString).collect(Collectors.joining(" ")));
//    }

//    @Test
//    public void boy() {
//        int[] a = {1, 2, 3, 4};
//        Assert.assertEquals(methodCrazyBoy(4, 0, a), 10);
//    }

//    public int methodCrazyBoy(int n, int k, int[] a) {
//
//    }

    //    public static void main(String[] args) {
//        char[] chars = args[1].toCharArray();
//        LinkedList<Integer> res = new LinkedList<>();
//        res.add(0);
//
//        int index = 0;
//        int count = 1;
//        for (char ch : chars){
//            if (ch == 'l' || ch == 'L') {
//                res.add(index, count);
//            } else {
//                index++;
//                res.add(index, count);
//            }
//            count++;
//        }
//
//        System.out.println(res.stream().map(Objects::toString).collect(Collectors.joining(" ")));
//    }

//4, 0, {1, 2, 3, 4}
//4, 1,  {-1, -2, -3, -4}
//4, 1,  {-1, -2, 3, 4}
//5, 1,  {-2, 3, -1, 3, -2}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        int a = Integer.parseInt(strArr[0]);
        int b = Integer.parseInt(strArr[1]);

        scanner.hasNext();
        String strNext = scanner.nextLine();
        String[] strSec = strNext.split(" ");
        int[] arrPoints = Arrays.stream(strSec)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] seqArray = new int[arrPoints.length];

        int indexArray = 0;
        int summArray = 0;
        boolean flag = true;

        int summ = 0;
        for (int i = 0; i < arrPoints.length; i++) {
            if (arrPoints[i] > 0) {
                summ += arrPoints[i];
                flag = false;
                continue;
            }
            if (arrPoints[i] < 0) {
                if (i == arrPoints.length - 1) {
                    summ += arrPoints[i];
                    continue;
                }

                if (i + 1 == arrPoints.length - 1 || arrPoints[i + 1] < 0) {
                    if (flag) {
                        summArray = summArray + arrPoints[i];
                    } else {
                        if (summArray < 0) {
                            seqArray[indexArray] = summArray;
                        }
                        summArray = arrPoints[i];
                        indexArray++;
                        flag = true;
                    }
                }
            }
        }
        Arrays.sort(seqArray);
        for (int i = 0; i < seqArray.length - b; i++) {
            summ -= seqArray[i];
        }

        System.out.println(summ);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.hasNext();
//        String str1 = scanner.nextLine();
//        String[] split1 = str1.split(" ");
//        int n = Integer.parseInt(split1[0]);
//        int k = Integer.parseInt(split1[1]);
//
//        scanner.hasNext();
//        String str2 = scanner.nextLine();
//        String[] split2 = str2.split(" ");
//        int[] sentimentChanges = Arrays.stream(split2).mapToInt(Integer::parseInt).toArray();
//
//
//
//        System.out.println(getSumm(n, k, sentimentChanges));
//    }


//    public static int getSumm(int n, int k, int[] sentimentChanges) {
//
//        int[] sequencArray = new int[sentimentChanges.length];
//
//        int indexSequencArray = 0;
//        int summSequencArray = 0;
//        boolean currentSequence = true;
//
//        int summ = 0;
//        for (int i = 0; i < sentimentChanges.length; i++) {
//            if (sentimentChanges[i] > 0) {
//                summ += sentimentChanges[i];
//                currentSequence = false; //+
//                continue;
//            }
//            if (sentimentChanges[i] < 0) {
//                if (i == sentimentChanges.length - 1) {
//                    summ += sentimentChanges[i];
//                    continue;
//                } else if (i + 1 == sentimentChanges.length - 1 || sentimentChanges[i + 1] > 0) {
//                    continue;
//                } else {
//                    if (currentSequence) {
//                        summSequencArray = summSequencArray + sentimentChanges[i];
//                    } else {
//                        if (summSequencArray < 0) {
//                            sequencArray[indexSequencArray] = summSequencArray;
//                        }
//                        summSequencArray = sentimentChanges[i];
//                        indexSequencArray++;
//                        currentSequence = true;
//                    }
//                }
//            }
//        }
//        if (sequencArray.length > k) {
//            Arrays.sort(sequencArray);
//            for (int i = 0; i < sequencArray.length - k; i++) {
//                summ -= sequencArray[i];
//            }
//        }
//        return summ;
//    }

//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        scanner.hasNext();
////        String str = scanner.nextLine();
//        String str = "4 0";
////        String str = scanner.nextLine();
////        String str = scanner.nextLine();
////        String str = scanner.nextLine();
//        String[] strArr = str.split(" ");
//        int a = Integer.parseInt(strArr[0]);
//        int b = Integer.parseInt(strArr[1]);
//
////        scanner.hasNext();
////        String strNext = scanner.nextLine();
//        String strNext = "1 2 3 4";
////        String strNext = scanner.nextLine();
////        String strNext = scanner.nextLine();
////        String strNext = scanner.nextLine();
//        String[] strSec = strNext.split(" ");
//        int[] arrPoints = Arrays.stream(strSec)
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        int[] seqArray = new int[arrPoints.length];
//
//        int indexArray = 0;
//        int summArray = 0;
//        boolean currentSequence = true;
//
//        int summ = 0;
//        for (int i = 0; i < arrPoints.length; i++) {
//            if (arrPoints[i] > 0) {
//                summ += arrPoints[i];
//                currentSequence = false; //+
//                continue;
//            }
//            if (arrPoints[i] < 0) {
//                if (i == arrPoints.length - 1) {
//                    summ += arrPoints[i];
//                } else if (i + 1 == arrPoints.length - 1 || arrPoints[i + 1] > 0) {
//                } else {
//                    if (currentSequence) {
//                        summArray = summArray + arrPoints[i];
//                    } else {
//                        if (summArray < 0) {
//                            seqArray[indexArray] = summArray;
//                        }
//                        summArray = arrPoints[i];
//                        indexArray++;
//                        currentSequence = true;
//                    }
//                }
//            }
//        }
//        if (seqArray.length > b) {
//            Arrays.sort(seqArray);
//            for (int i = 0; i < seqArray.length - b; i++) {
//                summ -= seqArray[i];
//            }
//        }
//
//
////        System.out.println(summ);
//        System.out.println(summ == 10);
//        System.out.println(summ == -4);
//        System.out.println(summ == 7);
//        System.out.println(summ == 4);
//    }
}
