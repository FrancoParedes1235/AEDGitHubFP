import java.util.ArrayList; 
import java.util.List; 

class Limits { 
    int[] a; 
    int prim; 
    int ult; 
} 

class SetVectors { 
    static List<Limits> heterogeneo = new ArrayList<>(); 
    static List<Limits> homogeneo = new ArrayList<>(); 

    static void Insertar(List<Limits> list, Limits p) { 
        list.add(p); 
    } 

    static int Long_Mayor(List<Limits> list) { 
        return list.size(); 
    } 

    static Limits Mayor(List<Limits> list) { 
        Limits mayor = list.get(0); 
        for (Limits p : list) { 
            if (p.a.length > mayor.a.length) { 
                mayor = p; 
            } 
        } 
        return mayor; 
    } 

    static boolean Esvacio(List<Limits> list) { 
        return list.isEmpty(); 
    } 

    static void Destruir(List<Limits> list) { 
        list.clear(); 
    } 
} 

public class Moda3 { 
    static class Result { 
        int moda; 
        int count; 
    } 

    static void Pivote2(int[] a, int mediana, int prim, int ult, int[] izq, int[] der) { 
        // Implementación del algoritmo para dividir el vector en dos subvectores 
        // en base a una mediana. 
    } 

    static int Moda3(int[] a, int prim, int ult) { 
        Limits p = new Limits(); 
        p.a = a; 
        p.prim = prim; 
        p.ult = ult; 
        SetVectors.Insertar(SetVectors.heterogeneo, p); 

        while (SetVectors.Long_Mayor(SetVectors.heterogeneo) > SetVectors.Long_Mayor(SetVectors.homogeneo)) { 
            p = SetVectors.Mayor(SetVectors.heterogeneo); 
            int mediana = p.a[(p.prim + p.ult) / 2]; 
            int izq = 0, der = 0; 
            Pivote2(p.a, mediana, p.prim, p.ult, izq, der); 

            Limits p1 = new Limits(); 
            Limits p2 = new Limits(); 
            Limits p3 = new Limits(); 

            p1.a = p.a; 
            p1.prim = p.prim; 
            p1.ult = izq - 1; 

            p2.a = p.a; 
            p2.prim = izq; 
            p2.ult = der - 1; 

            p3.a = p.a; 
            p3.prim = der; 
            p3.ult = p.ult; 

            if (p1.prim < p1.ult) { 
                SetVectors.Insertar(SetVectors.heterogeneo, p1); 
            } 
            if (p3.prim < p3.ult) { 
                SetVectors.Insertar(SetVectors.heterogeneo, p3); 
            } 
            if (p2.prim < p2.ult) { 
                SetVectors.Insertar(SetVectors.homogeneo, p2); 
            } 
        } 

        if (SetVectors.Esvacio(SetVectors.homogeneo)) { 
            return a[prim]; 
        } 

        p = SetVectors.Mayor(SetVectors.homogeneo); 
        SetVectors.Destruir(SetVectors.homogeneo); 
        SetVectors.Destruir(SetVectors.heterogeneo); 
        return p.a[p.prim]; 
    } 

    public static void main(String[] args) { 
        int[] vector = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4}; 
        int moda = Moda3(vector, 0, vector.length - 1); 
        System.out.println("La moda es: " + moda); 
    } 
}
