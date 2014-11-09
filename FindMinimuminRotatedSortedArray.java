/**
 * Created by bruce on 14-11-9.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] num) {
        int low = 0;
        int high = num.length-1;
        return findMinByLowAndHigh(low, high, num);
    }

    private int findMinByLowAndHigh(int low, int high, int[] num) {
        if (high == low) {
            return num[0];
        }
        if (high - low == 1) {
            if (num[low] <= num[high]) {
                return num[0];
            }
            else return num[high];
        } else {
            int mid = (low+high)/2;
            if(num[mid]<num[mid-1]) {
                return num[mid];
            }
            if(num[mid]>num[mid+1]) {
                return num[mid+1];
            }

            int left = findMinByLowAndHigh(low, mid - 1, num);
            if(left !=num[0]) {
                return left;
            }
            int right = findMinByLowAndHigh(mid + 1, high, num);
            if(right !=num[0]) {
                return right;
            }
            return num[0];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7,8,9,10,11,12,34,67,89,2332, 0, 1, 2,3,4,5,6};
        FindMinimuminRotatedSortedArray fi = new FindMinimuminRotatedSortedArray();
        int result = fi.findMin(arr1);
        System.out.println(result);
    }
}
