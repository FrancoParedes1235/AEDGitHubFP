public class BinarySearchRecursivo {
    // Método para búsqueda binaria recursiva
    int binarySearch(int arr[], int lo, int hi, int x) {
        // Verifica si el rango es válido
        if (hi >= lo && lo <= arr.length - 1) {
            // Calcula el índice medio del rango
            int mid = lo + (hi - lo) / 2;
            // Compara el elemento medio con el valor buscado
            if (arr[mid] == x)
                return mid; // Si son iguales, devuelve el índice medio
            // Si el valor medio es mayor que el valor buscado,
            // busca en la mitad inferior del rango
            if (arr[mid] > x)
                return binarySearch(arr, lo, mid - 1, x);
            // Si el valor medio es menor que el valor buscado,
            // busca en la mitad superior del rango
            return binarySearch(arr, mid + 1, hi, x);
        }
        // Si el rango es inválido o el límite inferior supera al superior,
        // devuelve -1 para indicar que el elemento no se encontró
        return -1;
    }

    public static void main(String[] args) {
        // Crea una instancia de BinarySearch
        BinarySearchRecursivo ob = new BinarySearchRecursivo();
        // Arreglo ordenado
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        int x = 4; // Elemento a buscar
        // Llama a binarySearch para buscar x en arr
        int position = ob.binarySearch(arr, 0, n - 1, x);
        // Verifica si se encontró el elemento
        if (position == -1)
            System.out.println("Element not found !!!"); // Si no se encontró, imprime un mensaje
        else
            System.out.println("Element found at index: " + position); // Si se encontró, imprime el índice
    }
}