import java.util.Scanner; // importa Scanner para leer datos del usuario

public class Ciclos { 

    static Scanner sc = new Scanner(System.in); // objeto Scanner para leer datos por consola

    public static void main(String[] args) { 
        int opcion = 0; // variable para guardar la opción del menú

        while (opcion != 5) { // ciclo que se repite hasta que el usuario elija salir
            mostrarMenu(); // muestra el menú en pantalla
            opcion = leerEntero("Seleccione una opción: ");  

            switch (opcion) { // evalúa la opción elegida
                case 1: // si elige opción 1
                    opcionFibonacci(); // ejecuta la función de Fibonacci
                    pausa(); // pausa antes de volver al menú
                    break; // termina este caso
                case 2: // si elige opción 2
                    opcionPrimo(); // ejecuta cálculo de número primo
                    pausa(); // pausa antes de volver al menú
                    break; // termina este caso
                case 3: // si elige opción 3
                    opcionCuadratica(); // calcula raíces de ecuación cuadrática
                    pausa(); // pausa antes de volver al menú
                    break; // termina este caso
                case 4: // si elige opción 4
                    opcionPromedio(); // calcula promedio de números
                    pausa(); // pausa antes de volver al menú
                    break; // termina este caso
                case 5: // si elige salir
                    System.out.println("\n╔══════════════════════════════════════════════╗"); 
                    System.out.println("║          Gracias por usar el programa        ║"); 
                    System.out.println("║                 Hasta luego                  ║"); 
                    System.out.println("╚══════════════════════════════════════════════╝"); 
                    break; // termina el caso
                default: // si escribe una opción inválida
                    System.out.println("\nOpción inválida. Debe elegir entre 1 y 5."); 
                    pausa(); // pausa antes de volver al menú
            }
        }

        sc.close(); // cierra el Scanner
    }

    public static void mostrarMenu() { 
    System.out.println("\n╔═════════════════════════════════════════════════════════════╣"); 
    System.out.println("║   ██████╗██╗ ██████╗██╗      ██████╗ ███████╗               ║"); 
    System.out.println("║  ██╔════╝██║██╔════╝██║     ██╔═══██╗██╔════╝               ║"); 
    System.out.println("║  ██║     ██║██║     ██║     ██║   ██║███████╗               ║"); 
    System.out.println("║  ██║     ██║██║     ██║     ██║   ██║╚════██║               ║"); 
    System.out.println("║  ╚██████╗██║╚██████╗███████╗╚██████╔╝███████║               ║"); 
    System.out.println("║   ╚═════╝╚═╝ ╚═════╝╚══════╝ ╚═════╝ ╚══════╝               ║"); 
    System.out.println("╠═════════════════════════════════════════════════════════════╣"); 
    System.out.println("║  1. Término n-ésimo y suma de Fibonacci                     ║"); 
    System.out.println("║  2. Calcular el n-ésimo número primo                        ║"); 
    System.out.println("║  3. Calcular raíces de una ecuación cuadrática              ║"); 
    System.out.println("║  4. Calcular el promedio de n números                       ║"); 
    System.out.println("║  5. Salir                                                   ║"); 
    System.out.println("╚═════════════════════════════════════════════════════════════╝"); 
}

    public static void opcionFibonacci() { // método para la opción Fibonacci
        System.out.println("\n--- Opción 1: Fibonacci ---"); 
        int n = leerEnteroPositivo("Ingrese un número entero positivo: "); 

        long termino = fibonacci(n); // calcula el término n de Fibonacci
        long suma = sumaFibonacci(n); // calcula la suma de Fibonacci

        System.out.println("El término n-ésimo de Fibonacci es: " + termino); 
        System.out.println("La suma de los primeros " + n + " términos es: " + suma); 
    }

    public static long fibonacci(int n) { // función que calcula Fibonacci
        if (n == 1) return 0; // primer valor
        if (n == 2) return 1; // segundo valor

        long a = 0; // primer número
        long b = 1; // segundo número
        long c = 0; // variable auxiliar

        for (int i = 3; i <= n; i++) { // ciclo para calcular Fibonacci
            c = a + b; // suma de los dos anteriores
            a = b; // mueve valor
            b = c; // nuevo valor
        }

        return b; // devuelve resultado
    }

    public static long sumaFibonacci(int n) { // función para sumar Fibonacci
        long suma = 0; // acumulador

        for (int i = 1; i <= n; i++) { // ciclo hasta n
            suma += fibonacci(i); // suma cada término
        }

        return suma; // devuelve suma total
    }

    public static void opcionPrimo() { // método para números primos
        System.out.println("\n--- Opción 2: Número primo ---"); // título
        int n = leerEnteroPositivo("Ingrese la posición del número primo que desea calcular: "); // pide posición

        int primo = enesimoPrimo(n); // calcula primo
        System.out.println("El primo número " + n + " es: " + primo); // muestra resultado
    }

    public static int enesimoPrimo(int n) { // calcula el n-ésimo primo
        int contador = 0; // cuenta primos encontrados
        int numero = 1; // número que se evalúa

        while (contador < n) { // ciclo hasta encontrar n primos
            numero++; // siguiente número
            if (esPrimo(numero)) { // verifica si es primo
                contador++; // aumenta contador
            }
        }

        return numero; // devuleve primo encontrado
    }

    public static boolean esPrimo(int numero) { // verifica si un número es primo
        if (numero < 2) return false; // números menores que 2 no son primos

        for (int i = 2; i <= Math.sqrt(numero); i++) { // revisa divisores
            if (numero % i == 0) { // si tiene divisor
                return false; // no es primo
            }
        }

        return true; // es primo
    }

    public static void opcionCuadratica() { // método ecuación cuadrática
        System.out.println("\n--- Opción 3: Ecuación cuadrática ---"); // título
        System.out.println("Forma general: ax² + bx + c = 0"); // fórmula

        double a; // coeficiente a
        do {
            a = leerDouble("Ingrese el valor de a (diferente de 0): "); // pide valor
            if (a == 0) {
                System.out.println("Error: a no puede ser 0."); // valida a
            }
        } while (a == 0); // repite si a es 0

        double b = leerDouble("Ingrese el valor de b: "); // pide b
        double c = leerDouble("Ingrese el valor de c: "); // pide c

        double discriminante = (b * b) - (4 * a * c); // calcula discriminante

        if (discriminante > 0) { // dos raíces reales
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a); // raíz 1
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a); // raíz 2

            System.out.println("Las raíces son reales y diferentes:"); 
            System.out.println("x1 = " + x1); // muestra raíz
            System.out.println("x2 = " + x2); // muestra raíz

        } else if (discriminante == 0) { // raíz doble
            double x = -b / (2 * a); // cálculo

            System.out.println("La ecuación tiene una raíz real doble:"); 
            System.out.println("x = " + x); // muestra resultado

        } else { // raíces complejas
            double parteReal = -b / (2 * a); // parte real
            double parteImaginaria = Math.sqrt(-discriminante) / (2 * a); // parte imaginaria

            System.out.println("Las raíces son complejas:"); 
            System.out.println("x1 = " + parteReal + " + " + parteImaginaria + "i"); // raíz 1
            System.out.println("x2 = " + parteReal + " - " + parteImaginaria + "i"); // raíz 2
        }
    }

    public static void opcionPromedio() { // método para promedio
        System.out.println("\n--- Opción 4: Promedio ---"); // título
        int n = leerEnteroPositivo("¿Cuántos números desea ingresar?: "); // cantidad de números

        double suma = 0; // acumulador

        for (int i = 1; i <= n; i++) { // ciclo para pedir números
            double numero = leerDouble("Ingrese el número " + i + ": "); // lee número
            suma += numero; // suma valores
        }

        double promedio = suma / n; // calcula promedio
        System.out.println("El promedio es: " + promedio); // muestra resultado
    }

    public static int leerEntero(String mensaje) { // método para leer enteros
        while (true) { // ciclo hasta que ingrese un número válido
            try {
                System.out.print(mensaje); // muestra mensaje
                int numero = Integer.parseInt(sc.nextLine()); // convierte texto a número
                return numero; // devuelve número
            } catch (Exception e) { // si hay error
                System.out.println("Entrada inválida. Debe ingresar un número entero."); // mensaje
            }
        }
    }

    public static int leerEnteroPositivo(String mensaje) { // método para leer enteros positivos
        int numero;
        do {
            numero = leerEntero(mensaje); // lee número
            if (numero <= 0) {
                System.out.println("Debe ingresar un número mayor que 0."); 
            }
        } while (numero <= 0); // repite si no es positivo

        return numero; // devuelve número válido
    }

    public static double leerDouble(String mensaje) { // método para leer números decimales
        while (true) { // ciclo hasta que el valor sea válido
            try {
                System.out.print(mensaje); // mensaje
                double numero = Double.parseDouble(sc.nextLine()); // convierte a double
                return numero; // devuelve valor
            } catch (Exception e) {
                System.out.println("Entrada inválida. Debe ingresar un número válido."); 
            }
        }
    }

    public static void pausa() { // método para pausar el programa
        System.out.println("\nPresione Enter para volver al menú..."); // mensaje
        sc.nextLine(); // espera que el usuario presione Enter
    }
}
