import java.util.Scanner; // importa Scanner para leer datos del usuario
import java.util.Random; // importa Random para generar números aleatorios

public class JuegoAdivinar { 

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); // crea objeto Scanner para leer datos por teclado
        Random random = new Random(); // crea objeto Random para generar números aleatorios

        System.out.println("==================================="); 
        System.out.println("         JUEGO ADIVINA NUMERO      "); 
        System.out.println("==================================="); 

        System.out.print("Ingrese el numero minimo (n): "); 
        int n = sc.nextInt(); // guarda el número mínimo

        System.out.print("Ingrese el numero maximo (m): "); 
        int m = sc.nextInt(); // guarda el número máximo

        while (n >= m) { // ciclo para validar que el mínimo sea menor que el máximo
            System.out.println("El minimo debe ser menor que el maximo."); 
            System.out.print("Ingrese nuevamente n: "); 
            n = sc.nextInt(); // guarda nuevo n

            System.out.print("Ingrese nuevamente m: "); 
            m = sc.nextInt(); // guarda nuevo m
        }

        int numeroSecreto = random.nextInt(m - n + 1) + n; // genera número aleatorio entre n y m

        int intento = 0; // variable para guardar el número que intenta el usuario
        int contador = 0; // contador de intentos

        while (intento != numeroSecreto) { // ciclo que se repite hasta adivinar el número

            System.out.print("Adivine el numero: "); 
            intento = sc.nextInt(); // guarda el intento

            contador++; // aumenta el contador de intentos

            if (intento < numeroSecreto) { // si el intento es menor
                System.out.println("El numero es MAYOR"); 
            }

            if (intento > numeroSecreto) { // si el intento es mayor
                System.out.println("El numero es MENOR"); 
            }
        }

        System.out.println("¡Correcto! Adivinaste el numero."); 
        System.out.println("Numero secreto: " + numeroSecreto); 
        System.out.println("Intentos: " + contador);

        sc.close(); // cierra el Scanner
    }
}
 