public class SubsetSum {

    // Función principal para verificar la posibilidad de alcanzar la suma objetivo
    public static boolean subsetSum(int[] nums, int target) {
        // Filtramos los números según las restricciones dadas
        int[] validNumbers = filterNumbers(nums);

        // Verificamos si se puede formar el objetivo con los números válidos
        return isSubsetSum(validNumbers, validNumbers.length, target);
    }

    // Verifica si existe un subconjunto cuya suma sea igual al objetivo
    private static boolean isSubsetSum(int[] arr, int n, int target) {
        // Caso base: si la suma es 0, siempre es posible (no elegir ningún número)
        if (target == 0)
            return true;

        // Caso base: si no hay elementos o la suma objetivo es negativa, no se puede
        // formar
        if (n == 0 || target < 0)
            return false;

        // Llamadas recursivas: Excluyendo o incluyendo el último número
        return isSubsetSum(arr, n - 1, target) || isSubsetSum(arr, n - 1, target - arr[n - 1]);
    }

    // Filtra los números según las restricciones
    private static int[] filterNumbers(int[] nums) {
        // Primero, calculamos cuántos números válidos hay
        int count = 0;

        // Contamos cuántos números son potencias de 2 o no tienen restricciones
        for (int i = 0; i < nums.length; i++) {
            if (isPowerOfTwo(nums[i])
                    || (i == nums.length - 1 || (nums[i] % 5 != 0 || (nums[i] % 5 == 0 && nums[i + 1] % 2 == 0)))) {
                count++;
            }
        }

        // Creamos un arreglo con los números válidos
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

    // Verifica si un número es potencia de 2
    private static boolean isPowerOfTwo(int num) {
        return (num > 0) && (num & (num - 1)) == 0;
    }

    // Función principal para probar los casos de entrada
    public static void main(String[] args) {
        // Ejemplos de entrada y salida esperada
        int[] nums1 = { 5, 4, 8, 10, 3, 5 };
        int target1 = 27;
        System.out.println("Input: " + java.util.Arrays.toString(nums1) + " Target: " + target1 + " Result: "
                + subsetSum(nums1, target1)); // true

        int[] nums2 = { 5, 4, 8, 10, 3, 6 };
        int target2 = 27;
        System.out.println("Input: " + java.util.Arrays.toString(nums2) + " Target: " + target2 + " Result: "
                + subsetSum(nums2, target2)); // false

        int[] nums3 = { 6, 2, 16, 5, 7, 10 };
        int target3 = 33;
        System.out.println("Input: " + java.util.Arrays.toString(nums3) + " Target: " + target3 + " Result: "
                + subsetSum(nums3, target3)); // true

        int[] nums4 = { 6, 2, 16, 5, 3, 10 };
        int target4 = 33;
        System.out.println("Input: " + java.util.Arrays.toString(nums4) + " Target: " + target4 + " Result: "
                + subsetSum(nums4, target4)); // false

        int[] nums5 = { 4, 2, 5, 1, 6 };
        int target5 = 13;
        System.out.println("Input: " + java.util.Arrays.toString(nums5) + " Target: " + target5 + " Result: "
                + subsetSum(nums5, target5)); // true
    }
}
