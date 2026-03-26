# 🚀 Taller_4
cuarto taller lógica de programación en equipo 


---

## 📌 Descripción del Proyecto

Este proyecto corresponde a un taller de programación en Java enfocado en el uso de ciclos y estructuras repetitivas. El objetivo es practicar el uso de ciclos como for y while para resolver distintos problemas mediante programas interactivos en consola.

El proyecto incluye tres programas principales:

- Menú de ciclos: Un programa con un menú infinito que permite realizar diferentes operaciones como calcular el término n-ésimo de Fibonacci, encontrar el n-ésimo número primo, resolver una ecuación cuadrática y calcular el promedio de varios números ingresados por el usuario. El programa valida las entradas del usuario y maneja posibles errores para evitar que se cierre inesperadamente.
- Juego de adivinar el número: Un juego donde el usuario debe adivinar un número aleatorio generado dentro de un rango definido por el usuario. El programa indica si el número ingresado es mayor o menor que el número secreto y cuenta la cantidad de intentos.
- Tabla de multiplicar: Un programa que muestra la tabla de multiplicar de un número ingresado por el usuario utilizando un ciclo for.

Estos ejercicios permiten reforzar conceptos fundamentales como:

- Uso de ciclos (for, while)
- Validación de datos ingresados por el usuario
- Uso de variables de control y contadores
- Manejo básico de entrada y salida en consola
- Desarrollo de programas interactivos en Java

---

## 👥 Integrantes del Equipo
- 👤 Felipe Londoño Ospina 
- 👤 Jordan Restrepo Tobón 

---

## Codigo pograma ciclos

```java
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

        return numero; // devuelve primo encontrado
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

```

---

## Codigo pograma juego adivinador 

```java
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
```

---

## Codigo pograma tablas de multiplicar

```java
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
```

---

## Respuestas de preguntas de teoria

1. ¿Cuál es la diferencia entre un ciclo for, un ciclo while y un do-while?​

R/: Ciclo for: Se usa cuando sabemos cuántas veces se repetirá el ciclo. Tiene tres partes: inicialización, condición y actualización. Ejemplo:​

for (int i = 1; i <= 10; i++) {​
    System.out.println(i);​
}​

Ciclo while: Se usa cuando no sabemos exactamente cuántas veces se repetirá, solo sabemos la condición. Ejemplo:​

int i = 1;​
while (i <= 10) {​
    System.out.println(i);​
    i++;​
}​

Ciclo do-while: Es parecido al while, pero siempre se ejecuta al menos una vez, porque la condición se revisa al final. Ejemplo:​

int i = 1;​
do {​
    System.out.println(i);​
    i++;​
} while (i <= 10);​

2. ¿Qué es un ciclo infinito y cómo se puede evitar?​

R/: Un ciclo infinito es un ciclo que nunca termina porque la condición siempre es verdadera. Ejemplo:​

while (true) {​
    System.out.println("Este ciclo nunca termina");​
}​

Se puede evitar: ​
Usando condiciones correctas.​
Actualizando correctamente la variable del ciclo.​
Usando break para salir del ciclo.

3. ¿Cómo se pueden anidar ciclos en Java?​

R/: Anidar ciclos significa poner un ciclo dentro de otro ciclo. Ejemplo:​

for (int i = 1; i <= 3; i++) {​
    for (int j = 1; j <= 3; j++) {​
        System.out.println(i + " " + j);​
    }​
}​
Esto se usa mucho para:​

Tablas​
Matrices​
Patrones de impresión​

4. ¿Qué es el alcance de una variable dentro de un ciclo?​

R/: El alcance (scope) es el lugar donde una variable puede ser usada.Si una variable se declara dentro de un ciclo, solo existe dentro de ese ciclo. Ejemplo: ​

for (int i = 0; i < 5; i++) {​
    int numero = i;​
    System.out.println(numero);​
}

5. Explique 3 palabras reservadas que se pueden usar en un ciclo​

R/: break: Se usa para terminar un ciclo antes de que la condición se cumpla. Ejemplo:​
for(int i = 1; i <= 10; i++){​
    if(i == 5){​
        break;​
    }​
    System.out.println(i);​
}​

Continue: Se usa para saltar una iteración del ciclo y continuar con la siguiente. Ejemplo:​
for(int i = 1; i <= 5; i++){​
    if(i == 3){​
        continue;​
    }​
    System.out.println(i);​
}​
return: Se usa para salir de un método, incluso si está dentro de un ciclo. Ejemplo:​
while(true){​
    return;​
}

6. ¿Cómo se pueden usar los ciclos para procesar datos de entrada del usuario?​

R/: Los ciclos permiten pedir datos repetidamente al usuario hasta que se cumpla una condición. Ejemplo: pedir números hasta que el usuario ingrese 0.​
Scanner sc = new Scanner(System.in);​
​
int numero = -1;​
​
while(numero != 0){​
    System.out.print("Ingrese un número (0 para salir): ");​
    numero = sc.nextInt();​
}​
Esto se usa mucho para:​
menús​
validación de datos​
juegos​
repetición de cálculos​

7. ¿Qué es un contador?, ¿qué tipos de variables de control conoce? Un contador es una variable que lleva el número de veces que se ejecuta un ciclo. Ejemplo:​
int contador = 0;​
​
for(int i = 1; i <= 5; i++){​
    contador++;​
}

Tipos de variables de control:​
ContadorCuenta: cuántas veces ocurre algo.​
Acumulador: Guarda la suma de valores.​
Ejemplo:​
int suma = 0;​
suma = suma + numero;​
​
Bandera (flag):Variable booleana que controla si algo ocurrió o no. Ejemplo:​
boolean encontrado = false;

8. ¿Qué es una secuencia de escape, cómo se usa para resolver este taller?​
R/: Una secuencia de escape es un carácter especial que se usa dentro de textos en Java para representar acciones especiales. Ejemplo:​
​
Secuencias y significado:

- \n​: Salto de líneas​
- \t​: Tabulación​
- \”​: Comillas​
- \\​: Barra invertida​
​
En este taller se usan para:​
organizar el menú​
mostrar texto ordenado​
crear diseños ASCII​
hacer que la salida sea más clara para el usuario​

9. Explique tres atajos de teclado útiles para programar en VSC​

R/: Ctrl + C / Ctrl + V: Sirve para copiar y pegar código, lo cual ayuda a reutilizar estructuras o partes del programa.​
Ctrl + S: Sirve para guardar el archivo actual. Es importante usarlo frecuentemente para no perder cambios.​
Ctrl + /: Permite comentar o descomentar líneas de código rápidamente.​

10. ¿Qué es overflow?, ¿en qué parte del taller se puede presentar?​

R/: El overflow ocurre cuando un número supera el valor máximo que puede almacenar un tipo de dato. Por ejemplo, un int tiene un límite aproximado de 2,147,483,647. Si se supera ese valor, el número se reinicia y produce resultados incorrectos.​
En este taller puede ocurrir en:​
Fibonacci, cuando los números crecen muy rápido.​
Contadores o acumuladores si se usan valores muy grandes.​

11. ¿Cómo se puede personalizar los colores de la consola en Java?​

R/: Se pueden usar códigos ANSI para cambiar colores del texto en la consola. Ejemplo:​
System.out.println("\u001B[31mTexto en rojo\u001B[0m");​
System.out.println("\u001B[32mTexto en verde\u001B[0m");​
System.out.println("\u001B[34mTexto en azul\u001B[0m");

---

## ✅ Conclusion
En este taller se aplicaron conceptos fundamentales de programación en Java, especialmente el uso de ciclos (for, while) para resolver distintos problemas. A través de los programas desarrollados se practicó la interacción con el usuario mediante la consola, el uso de variables de control, contadores y validación de datos.

Los ejercicios realizados, como el menú de operaciones con ciclos, el juego de adivinar el número y la tabla de multiplicar, permitieron comprender cómo los ciclos pueden utilizarse para repetir procesos, procesar datos ingresados por el usuario y controlar el flujo de un programa.

Además, el desarrollo del proyecto permitió reforzar habilidades importantes como la organización del código, la resolución de problemas mediante lógica de programación y el uso de GitHub para gestionar y documentar el trabajo.

---

## Enlaces a recursos utilizados

- Documentación oficial de Java – Oracle
https://docs.oracle.com/javase/tutorial/
- W3Schools – Java Loops (ciclos en Java)
https://www.w3schools.com/java/java_while_loop.asp
- W3Schools – Java For Loop
https://www.w3schools.com/java/java_for_loop.asp
- W3Schools – Java Break y Continue
https://www.w3schools.com/java/java_break.asp
- GeeksforGeeks – Loops in Java
https://www.geeksforgeeks.org/loops-in-java/
- GeeksforGeeks – Overflow en Java
https://www.geeksforgeeks.org/overflow-and-underflow-in-java/
-StackOverflow – ANSI colors en consola Java
https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println 
