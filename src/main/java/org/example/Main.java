package org.example;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final SecureRandom random = new SecureRandom();
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;

        while (true) {
            if (array == null) {
                System.out.println("Please choose how you want to create array");
                System.out.println("1 - Manual");
                System.out.println("2 - Random");
                System.out.println("Your choice:");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.println("Please enter number separated by comma");
                    String input = scanner.nextLine();
                    array = createManualArray(input);
                } else {
                    System.out.println("Created ramdom array:");
                    array = createRandomArray();
                    printArray(array);
                }
            }
            // Main menu
            System.out.println("\nMenu:");
            System.out.println("1 - Print array");
            System.out.println("2 - Add number");
            System.out.println("3 - Find max");
            System.out.println("4 - Find min");
            System.out.println("5 - Remove number");
            System.out.println("6 - Delete array");
            System.out.println("7 - Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printArray(array);
                    break;
                case 2:
                    System.out.println("Number you want to add:");
                    int numberToAdd = scanner.nextInt();
                    array = addNumber(array, numberToAdd);
                    break;
                case 3:
                    System.out.println("The max number in array is: " + findMax(array));
                    break;
                case 4:
                    System.out.println("The min number in array is: " + findMin(array));
                    break;
                case 5:
                    System.out.println("Number you want to remove:");
                    int numberToRemove = scanner.nextInt();
                    array = removeNumber(array, numberToRemove);
                    break;
                case 6:
                    array = deleteArray();
                    System.out.println("Array deleted");
                    break;
                case 7:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * this function create random array
     * @return random array
     */
    public static int[] createRandomArray() {
        int length = random.nextInt(10) + 1;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(200) - 100;
        }
        return arr;
    }

    /**
     * this function create array of user input
     * @param input input numbers
     * @return
     */
    public static int[] createManualArray(String input) {
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    /**
     * this method print values in an array
     * @param arr specific array
     */
    public static void printArray(int[] arr){
        if (arr != null || arr.length != 0) {
            for (int num : arr) {
                System.out.print(" | " + num);
            }
        } else {
            System.out.println("Array is empty");
        }
    }

    /**
     * this function add number to array
     * @param arr specific array
     * @param number number to add
     * @return return new array
     */
    public static int[] addNumber(int[] arr, int number) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = number;
        return newArr;
    }

    /**
     * find max number
     * @param arr array
     * @return return max number
     */
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    /**
     * find min
     * @param arr specific array
     * @return return min number
     */
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    /**
     * remove number from array
     * @param arr array
     * @param number number to remove
     * @return return new array
     */
    public static int[] removeNumber(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int count = 0;
        for (int num : arr) {
            if (num == number) {
                count++;
            }
        }
        int[] newArray = new int[arr.length - count];
        int index = 0;
        for (int value : arr) {
            if (value != number) {
                newArray[index] = value;
                index++;
            }
        }
        return newArray;
    }

    /**
     * delete array
     * @return null
     */
    public static int[] deleteArray() {
        return null;
    }
}
