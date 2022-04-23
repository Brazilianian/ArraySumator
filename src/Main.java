import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        int[] first = {9, 9, 9, 9};
        int[] second = {9, 9, 9, 9};
        int[] sum = findSumOfArray(first, second);
        System.out.println(Arrays.toString(sum));
    }

    public static int[] findSumOfArray(int[] first, int[] second) {
        MyDeque<Integer> queue = new MyDeque<>();
        int index = 0;
        while ((first.length > index) && second.length > index) {
            queue.addLeft(first[first.length - 1 - index] + second[second.length - 1 - index]);
            index++;
        }

        while (first.length > index) {
            queue.addLeft(first[first.length - 1 - index]);
            index++;
        }
        while (second.length > index) {
            queue.addLeft(second[second.length - 1 - index]);
            index++;
        }

        int[] arr = new int[queue.getCount()];

        queue.printFromLeft();

        for (int i = 0; queue.getCount() > 0; i++) {
            int number = queue.pollRight();

            if (number >= 10) {
                if (arr.length - 2 - i < 0) {
                    int[] arr2 = new int[arr.length + 1];
                    System.arraycopy(arr,0, arr2, 1, arr.length);
                    arr = arr2;
                }
                arr[arr.length - 2 - i] += number / 10;
                arr[arr.length - 1 - i] += number % 10;
            } else {
                arr[arr.length - 1 - i] += number;
            }
        }

        return arr;
    }
}
