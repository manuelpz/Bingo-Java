package Bingo;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----CARTON GENERADO----");
        System.out.println("__________________________________________________");

        int[] numeros = Metodos.generar_carton(6);
        int[] almacenados = new int[6];
        int[] numerosSacados = new int[10];

        System.out.println("Primera linea: " + numeros[0] + "  " + numeros[1]);
        System.out.println("Segunda linea: " + numeros[2] + "  " + numeros[3]);
        System.out.println("Tercera linea: " + numeros[4] + "  " + numeros[5]);
        System.out.println("__________________________________________________");

        boolean esBingo = false;
        boolean esLinea = false;
        boolean encontrado = false;
        int proximoIntento = 0;
        int intentos = 0;

        while (!esBingo) {
            int azar = (int) (Math.random() * (10 - 1) + 1);
            if (!Metodos.comprobarSiHaSalido(azar, numerosSacados)) {
                System.out.println("Pulsa una tecla para jugar...");
                sc.nextLine();

                //Se recorre el array de numeros, y si uno de ellos es igual a "azar", se guarda en el array de almacenados
                //Se pone "proximoIntento" porque asi, rellenará el array con el indice que le toque, pues solo suma 1 cuando ha conseguido almacenar un numero
                for (int i = 0; i < numeros.length; i++) {
                    encontrado = false;
                    if (azar == numeros[i]) {
                        almacenados[proximoIntento] = azar;
                        proximoIntento++;
                        encontrado = true;
                        break;
                    }
                }

                //Si encuentra el numero imprime el array de numeros que tienes
                //Se pone if(encontrado) porque si no, si el primero no lo encuentra, imprimiría "[]"
                if (encontrado) {
                    System.out.print("Ya tienes: [");
                    for (int j = 0; j < almacenados.length; j++) {
                        if (almacenados[j] != 0) {
                            System.out.print(almacenados[j]);
                            if (j < almacenados.length - 1 && almacenados[j + 1] != 0) {
                                System.out.print(", ");
                            }
                        }
                    }
                    System.out.println("]");
                }
                
              //Si el numero no se ha encontrado en el array de numeros aleatorios, se informa del numero obtenido
                if (!encontrado) {
                    System.out.println("Ha salido: " + azar);
                }

                //Se comprueba que aun no ha salido linea y se procede a ver si
                //alguna dupla ya es linea -- Con dupla me refiero a la combinacion de las posiciones [0, 1], ó [2, 3], ó [4, 5]
                //Si es, se pone esLinea a true para no volver a entrar a este if
                if(!esLinea && (Metodos.comprobarSiEsLinea(numeros[0], numeros[1], almacenados)
                		|| Metodos.comprobarSiEsLinea(numeros[2], numeros[3], almacenados)
                		|| Metodos.comprobarSiEsLinea(numeros[4], numeros[5], almacenados))) {
                	esLinea = true;
                	System.out.println("LINEA!");
                }
                
                //Recorre el array de numeros almacenados. Mientras el numero que esté evaluando no sea 0 significa que se ha rellenado ese indice
                //del array , por lo cual  es candidato a BINGO.
                //Si el numero (indice del array) es 0, no puede ser BINGO, por lo que se pone a false para volver a empezar el juego y se rompe el bucle
                for (int i = 1; i < almacenados.length; i++) {
                    if (almacenados[i] != 0) {
                        esBingo = true;
                    } else {
                        esBingo = false;
                        break;
                    }
                }

                
                
                //Se suma un intento
                intentos++;
            }
        } 
        //Acaba la partida, es BINGO
        System.out.println("BINGO!");
        System.out.println("Ha salido BINGO en " + intentos + " intentos");

    }
}
