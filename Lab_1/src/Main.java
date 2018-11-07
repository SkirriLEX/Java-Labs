import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("enter an mass size");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int arr[][] = new int[num][num];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("enter an number start position");
        num = in.nextInt();

        for (int i = 0; i < arr.length; i++) {

            arr[i] = bubbleSort(num,arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

    }

    public static int[] bubbleSort(int k, int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = k-1; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

}
