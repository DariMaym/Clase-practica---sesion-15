import java.util.InputMismatchException;
import java.util.Scanner;

public class App{

    public static int contador = 0;

    // demuestra el lanzamiento de una excepción cuando ocurre una división entre
    // cero
    public static int cociente(int numerador, int denominador) throws Exception {
        
        return numerador / denominador; // posible división entre cero
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Clase practica sobre el manejo de excepciones");

        Scanner leer = new Scanner(System.in);

        boolean continuar = true;
        int contador = 0;

        do {

            try {
                // Bloque de codigo donde puede ocurrir la excepcion
                System.out.println("Ingrese numerador entero");
                int numerador = leer.nextInt();
                System.out.println("Ingrese denominador entero");
                int denominador = leer.nextInt();

                //la division de dos numeros puede resultar en un decimal, por lo que lo mejor seria que el resultado fuera un double
                //pero las indicaciones dicen que debe ser un entero
                if (numerador%denominador == 0) {
                     System.out.println("Resultado del llamado al metodo " + cociente(numerador, denominador));
                } else {
                    System.out.println("El resultado es un decimal, no es un numero entero (decimales omitidos en el resultado) " + cociente(numerador, denominador));
                }
               

                continuar = false;

            } catch (InputMismatchException inputMismatchException) {
                // Bloque de codigo donde se maneja la excepcion
                System.out.println(inputMismatchException);
                leer.nextLine();
                System.out.println("debe introducir un valor entero, intente otra vez ");
               
            } catch (ArithmeticException arithmeticException) {
                System.out.println(arithmeticException);
                System.out.println("Cero es un denominador invalido");
                
            } finally {
                System.out.println("El finally siempre ocurre siempre ocurre ");
                //Añadiendo un contador podemos hacer que el programa ase detenga cuando querramos
                contador++;
                if (contador==3) {
                    continuar=false;
                
                }
            }

        } while (continuar);

        leer.close();

        // Casos de prueba

        // ejecucion correcta con numerador y denominador
        // ejecucion con denominador 0
        // ejecucion con denominador String

    }

}
