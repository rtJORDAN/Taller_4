import java.util.Scanner;

public class TablaMultiplicar { 

    public static void main(String[] args) { // método principal donde inicia el programa

        Scanner sc = new Scanner(System.in); // crea objeto Scanner para leer datos del teclado

        System.out.print("Ingrese un número: "); 
        int numero = sc.nextInt(); // guarda el número ingresado

        System.out.println("\nTabla de multiplicar del " + numero + ":\n"); // muestra título de la tabla

        for (int i = 1; i <= 10; i++) { // ciclo que va del 1 al 10
            int resultado = numero * i; // calcula la multiplicación
            System.out.println(numero + " x " + i + " = " + resultado); // muestra cada resultado
        }

        sc.close(); // cierra el Scanner
    }
}
