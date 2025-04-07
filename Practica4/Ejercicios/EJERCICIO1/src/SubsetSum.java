public class SubsetSum {

    public static boolean subsetSum(int[] nums, int target) {
        int[] validNumbers = filterNumbers(nums);
        return isSubsetSum(validNumbers, validNumbers.length, target);
    }
    private static boolean isSubsetSum(int[] arr, int n, int target) {
        if (target == 0)
            return true;
        if (n == 0 || target < 0)
            return false;

        return isSubsetSum(arr, n - 1, target) || isSubsetSum(arr, n - 1, target - arr[n - 1]);
    }

    private static int[] filterNumbers(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isPowerOfTwo(nums[i])
                    || (i == nums.length - 1 || (nums[i] % 5 != 0 || (nums[i] % 5 == 0 && nums[i + 1] % 2 == 0)))) {
                count++;
            }
        }

        int[] filtered = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPowerOfTwo(nums[i])
                    || (i == nums.length - 1 || (nums[i] % 5 != 0 || (nums[i] % 5 == 0 && nums[i + 1] % 2 == 0)))) {
                filtered[index++] = nums[i];
            }
        }
        return filtered;
    }

    private static boolean isPowerOfTwo(int num) {
        return (num > 0) && (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        int[] nums1 = { 5, 4, 8, 10, 3, 5 };
        int target1 = 27;
        System.out.println("Input: " + java.util.Arrays.toString(nums1) + " Target: " + target1 + " Result: "
                + subsetSum(nums1, target1));

        int[] nums2 = { 5, 4, 8, 10, 3, 6 };
        int target2 = 27;
        System.out.println("Input: " + java.util.Arrays.toString(nums2) + " Target: " + target2 + " Result: "
                + subsetSum(nums2, target2)); 

        int[] nums3 = { 6, 2, 16, 5, 7, 10 };
        int target3 = 33;
        System.out.println("Input: " + java.util.Arrays.toString(nums3) + " Target: " + target3 + " Result: "
                + subsetSum(nums3, target3)); 

        int[] nums4 = { 6, 2, 16, 5, 3, 10 };
        int target4 = 33;
        System.out.println("Input: " + java.util.Arrays.toString(nums4) + " Target: " + target4 + " Result: "
                + subsetSum(nums4, target4)); 

        int[] nums5 = { 4, 2, 5, 1, 6 };
        int target5 = 13;
        System.out.println("Input: " + java.util.Arrays.toString(nums5) + " Target: " + target5 + " Result: "
                + subsetSum(nums5, target5)); // true
    }
}
