package Bingo;

public class Metodos {
    
    // Este método genera un array de 6 números sin repetir ninguno
    public static int[] generar_carton(int n){
       
        // Crear array de números aleatorios
        int[] numeros = new int[n];       
        int i = 0;
        // Bucle para generar los siguientes números aleatorios
        while(i < n){
            int numAleatorio = (int) (Math.random()* (10-1)+1);
            
            // Comprobar que el número aleatorio no se ha generado antes
            boolean numRepetido = false;
            for(int j = 0; j < i; j++){
                if(numeros[j] == numAleatorio){
                    numRepetido = true;
                    break;
                }
            }
            
            // Si el número generado no se ha guardado antes, lo guardamos en el array
            if(!numRepetido){
                numeros[i] = numAleatorio;
                i++;
            }
        }
        return numeros;
    }
    
    public static boolean comprobarSiHaSalido(int azar, int[] numerosYaSalidos) {
    	//Se comprueba en el array de numeros ya obtenidos, si el nuevo numero existe en él
    	boolean haSalido = false;
    	for(int i = 0; i < numerosYaSalidos.length; i++) {
    		if(azar == numerosYaSalidos[i]) {
    			haSalido = true;
    			break;
    		}
    		haSalido = false;
    	}
    	//Si llega aqui, es que no ha salido
    	//Este for lo que hace es recorrer el array, encontrar el primer indice que no es 0, y ahi mete el valor de "azar"
    	for(int i = 0; i < numerosYaSalidos.length; i++) {
    		if(numerosYaSalidos[i] == 0) {
    			numerosYaSalidos[i] = azar;
    			break;
    		}
    }
    	return haSalido;
    }
    
    public static boolean comprobarSiEsLinea(int numero1, int numero2, int[] almacenados) {
    	boolean hayLinea = false;
    	//Este for recorre el array buscando el primero numero de una dupla
    	//Si encuentra el numero, entra en el siguiente for y busca desde el principio del array esta vez el numero 2
    	for(int i = 0; i < almacenados.length; i++) {
    		if(almacenados[i] == numero1) {
    			for(int j = 0; j < almacenados.length; j++) {
    				if(almacenados[j] == numero2) {
    					//Si llega aqui es que existe en el array numero1 y numero 2, es linea, se sale del bucle
    					hayLinea = true;
    					break;
    				}
    			}
    		}
    	}
    	return hayLinea;
    }
}
