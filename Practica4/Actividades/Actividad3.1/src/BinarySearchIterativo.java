public class BinarySearchIterativo {
    // Método para búsqueda binaria iterativa
    int binarySearch(int arr[], int x) {
        int lo = 0, hi = arr.length - 1; // Inicialización de los límites inferior y superior
        // Itera mientras el límite inferior no supere al límite superior
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // Calcula el índice medio del rango actual
            // Compara el elemento medio con el valor buscado
            if (arr[mid] == x)
                return mid; // Si son iguales, devuelve el índice medio
            // Si el valor medio es menor que el valor buscado,
            // actualiza el límite inferior para buscar en la mitad superior
            if (arr[mid] < x)
                lo = mid + 1;
            else // Si el valor medio es mayor que el valor buscado,
                hi = mid - 1; // actualiza el límite superior para buscar en la mitad inferior
        }
        // Si el elemento no se encuentra en el arreglo, devuelve -1
        return -1;
    }

    public static void main(String[] args) {
        // Crea una instancia de BinarySearchIterativo
        BinarySearchIterativo ob = new BinarySearchIterativo();
        int arr[] = { 1, 2, 3, 4, 5 }; // Arreglo ordenado
        int x = 3; // Elemento a buscar
        // Llama a binarySearch para buscar x en arr
        int position = ob.binarySearch(arr, x);
        // Verifica si se encontró el elemento
        if (position == -1)
            System.out.println("Element not present"); // Si no se encontró, imprime un mensaje
        else
            System.out.println("Element found at index: " + position); // Si se encontró, imprime el índice
    }
}