
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        var arr = new int[]{5, 2, 4, 6, 1, 3, 2, 6};
//        var arr = genRandArr(100);

        System.out.println("Array before sort");
        System.out.println(Arrays.toString(arr));
        Long t = System.currentTimeMillis();
        sort(arr, 0, arr.length-1);
        Long dt = System.currentTimeMillis();
        System.out.println("Array after sort");
        System.out.println(Arrays.toString(arr));
        System.out.printf("Sort time %dms", dt-t);

    }

    private static void sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = roundHalfDown((double) (p+r)/2 ); //do not want to use BigDecimal and RoundingMode for such simple task
            sort(arr, p, q);
            sort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }

    //should use more transparent variable name
    //p - array first value
    //q - compare value
    //r - array last value

    private static void merge(int[] arr, int p, int q, int r) {
//        System.out.printf("p (high) = %d; q (mid) = %d; r (low) = %d%n", p, q, r);
        int size1 = q - p + 1, size2 = r - q;
        int arr1[] = new int[size1];
        int arr2[] = new int[size2];
        for (int i = 0; i < size1; ++i) {
            arr1[i] = arr[p + i];
        }
        for (int j = 0; j < size2; ++j) {
            arr2[j] = arr[q + 1 + j];
        }
        int i = 0, j = 0;
        int k = p;
        while (i < size1 && j < size2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            }
            else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < size1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
//        System.out.println("From merge function " + Arrays.toString(arr));

    }
    //only unnecessary functions from here
    public static int roundHalfDown(double d) {
        double i = Math.floor(d);
        double f = d - i;
        double result = f <= 0.5 ? i : i + 1D;
        return (int) result;
    }

    public static int[] genRandArr(int capacity) {
        int[] arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        return arr;
    }

}
