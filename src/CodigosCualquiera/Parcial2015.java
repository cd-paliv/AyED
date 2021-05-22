package CodigosCualquiera;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial2015 {

	/*
	 El famoso esp�a Eddie Chapman est� tratando de descifrar el mensaje que le llega desde
	  Londres. Antes de dejar Londres, Chapman le explicaron c�mo deb�a descifrar los mensajes
	  que le enviaban. Para poder desccifrar el mensaje, a Chapman le entregaron una estructura:
	 
	 				   -
	 				/      \
	 		       -        -
	 	          /      /    \
	 		     -      -      -
	 		    / \    / \    / \
	 	       C  S   -   E  D   -
	 	       		 / \          \
	 	       		-   R          O
	 	       	   / \
	 	       	  A   G
	 
	 En esta estructura, los 0 siempre gu�an a la izquierda del nodo superior, y los 1 a la derecha.
	  A modo de ejemplo, si Chapman recibe el mensaje: 101	001	 10001  1111  1001  110  1111 con la
	  estructura tra�da de Londres, el mensaje se descifra como ESGORDO
	 
	 Asuma que todas las secuencias cifradas se corresponden con una letra.
	 
	 Su misi�n es escribir en una clase llamada C�digoZigZag (que NO contiene variables de instancia)
	  un m�todo con la siguiente firma:
	   "public ListaGenerica<Character> descifrarCodigo(????, ListaGenerica<String> listaDeSecuencias)"
	  que sea capaz de descifrar un mensaje que ha sido cifrado como secuencias de ceros y unos.
	  	 */
	
	
	public static void main(String[] args) {
		
		ArbolBinario<Character> der2 = new ArbolBinario<Character>(' ');
		der2.agregarHijoDerecho(new ArbolBinario<Character>('O'));
		ArbolBinario<Character> der1 = new ArbolBinario<Character>(' ');
		der1.agregarHijoIzquierdo(new ArbolBinario<Character>('D')); der1.agregarHijoDerecho(der2);
		
		ArbolBinario<Character> derIzq3 = new ArbolBinario<Character>(' ');
		derIzq3.agregarHijoDerecho(new ArbolBinario<Character>('G')); derIzq3.agregarHijoIzquierdo(new ArbolBinario<Character>('A'));
		ArbolBinario<Character> derIzq2 = new ArbolBinario<Character>(' ');
		derIzq2.agregarHijoDerecho(new ArbolBinario<Character>('R')); derIzq2.agregarHijoIzquierdo(derIzq3);
		ArbolBinario<Character> derIzq = new ArbolBinario<Character>(' ');
		derIzq.agregarHijoDerecho(new ArbolBinario<Character>('E')); derIzq.agregarHijoIzquierdo(derIzq2);

		ArbolBinario<Character> der = new ArbolBinario<Character>(' ');
		der.agregarHijoDerecho(der1); der.agregarHijoIzquierdo(derIzq);
		
		ArbolBinario<Character> izq1 = new ArbolBinario<Character>(' ');
		izq1.agregarHijoDerecho(new ArbolBinario<Character>('S')); izq1.agregarHijoIzquierdo(new ArbolBinario<Character>('C'));
		ArbolBinario<Character> izq = new ArbolBinario<Character>(' ');
		izq.agregarHijoIzquierdo(izq1);
		
		ArbolBinario<Character> ab = new ArbolBinario<Character>(' ');
		ab.agregarHijoDerecho(der); ab.agregarHijoIzquierdo(izq);
		
		ListaGenerica<String> codigo = new ListaEnlazadaGenerica<String>();
		codigo.agregarFinal("101");  //E
		codigo.agregarFinal("001");  //S
		codigo.agregarFinal("10001");//G
		codigo.agregarFinal("1111"); //O
		codigo.agregarFinal("1001"); //R
		codigo.agregarFinal("110");  //D
		codigo.agregarFinal("1111"); //O
		
		ListaGenerica<Character> codigoDescifrado = descifrarCodigo(ab, codigo);
		System.out.println(codigoDescifrado);
	}
	
	public static ListaGenerica<Character> descifrarCodigo(ArbolBinario<Character> a, ListaGenerica<String> listaDeSecuencias){
		ListaGenerica<Character> codigoDescifrado = new ListaEnlazadaGenerica<Character>();
		ArbolBinario<Character> arbolAux;
		for(int i = 1; i < listaDeSecuencias.tamanio()+1; i++) {
			arbolAux = a; //vuelvo al principio
			char[] dig = listaDeSecuencias.elemento(i).toCharArray(); //101 => dig: |1|0|1|
			for(int j = 0; j < dig.length; j++) {
				if(Character.getNumericValue(dig[j]) == 0) {
					if(arbolAux.tieneHijoIzquierdo())
						arbolAux = arbolAux.getHijoIzquierdo();
				}else {
					if(arbolAux.tieneHijoDerecho())
						arbolAux = arbolAux.getHijoDerecho();
				}
			}
			//if(arbolAux.getDato() != ' ')
			codigoDescifrado.agregarFinal(arbolAux.getDato());
		}
		return codigoDescifrado;
		
	}
	
	/*
	Ejercicio 2:
	En una ocasi�n Chapman no estaba seguro de que la estructura tra�da de Londres en realidad
	 serv�a para descifrar a todas las letras. Por esto quiso imprimir de manera ordenada las
	 letras contenidas en la estructura, s�lo para poder verificar que no hab�a letras faltantes
	 Su nueva misi�n es agregar un m�todo con la siguiente firma:
	   "public voi imprimirLetrasOrdenadas(ArbolBinario<Character> a)"
	 que imprime en orden alfab�tico las letras que est�n en la estructura. Para realizar este
	 ejercicio DEBER� USAR alguna de las estructuras vistas en la pr�ctica y que le ayude con
	 el objetivo del ejercicio. NO PODR� escribir el m�todo de ordenaci�n (como ordenaci�n de
	 listas o insertar ordenado en un arreglo), ni usar c�digo de la API de java
	 (como Arrays.sort())
	 */
	
	public void imprimirLetrasOrdenadas(ArbolBinario<Character> a) {
		
	}

}
