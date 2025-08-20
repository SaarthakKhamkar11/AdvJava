
import java.util.*;

interface SortStrategy {
    void sort(int[] arr);
}

class BubbleSort implements SortStrategy {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        System.out.println("Sorted using BubbleSort: " + Arrays.toString(arr));
    }
}

class QuickSort implements SortStrategy {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted using QuickSort: " + Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}

class MergeSort implements SortStrategy {
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted using MergeSort: " + Arrays.toString(arr));
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length)
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}

class Sorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] arr) {
        if (strategy != null) {
            strategy.sort(arr);
        } else {
            System.out.println("No sorting strategy selected.");
        }
    }
}

public class exp1b3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sorter sorter = new Sorter();

        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        int[] data = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        System.out.println("\nChoose Sorting Algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Merge Sort");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sorter.setStrategy(new BubbleSort());
                break;
            case 2:
                sorter.setStrategy(new QuickSort());
                break;
            case 3:
                sorter.setStrategy(new MergeSort());
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
        }

        int[] dataToSort = data.clone();
        System.out.println("Original array: " + Arrays.toString(data));
        sorter.sort(dataToSort);

        scanner.close();
    }
}
