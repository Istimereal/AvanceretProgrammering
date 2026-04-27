package afTræning;

public class SortingArray {

    private static void bubbleSortArray(int[] input)
    {
int n = input.length;
        for(int i = 0; i< n -1; i++ )
        {
            for(int j = 0; j< n - i - 1; j++)
            {
                if(input[j] > input[j + 1])
                {
                    swap(input, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
