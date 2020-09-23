package pancakes;

/* Juego Pancakes para IA I
Integrantes:
Negrete Ojeda Ivan Alberto
Ortega Sanchez Jesus David*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main {
	
	public static void main(String args []) {
		int id = 1;
		Queue<pancake> cola = new LinkedList();
		ArrayList<pancake> yaRevisados = new ArrayList<pancake>();

		Scanner leer = new Scanner (System.in);
		System.out.println("Ingrese el número de pancakes");
		int cantidad = leer.nextInt();
		String ordenado = "abcdefghijklmnopqrstuvwxyz";	
		ordenado = ordenado.substring(0, cantidad);
		System.out.println( "" );
		System.out.println("Cadena Original: " + ordenado);
		int caracterRecorrido = 2;
		String cadena = revolver(ordenado);
		pancake raiz = new pancake(cadena, id, 0, 0);
		cola.offer(raiz);
		yaRevisados.add(raiz);
		System.out.println("Cadena Revuelta: " + cadena);
		System.out.println("-----");
		while(!cadena.equals(ordenado)) {
			id++;
			cadena = cola.peek().getTexto();
			cadena = mover(cadena, caracterRecorrido);
			
			pancake estado = new pancake(cadena, id,  cola.peek().getId(), caracterRecorrido);
			cola.offer(estado);
			yaRevisados.add(estado);

			if (caracterRecorrido == (cadena.length())) {
				caracterRecorrido = 2;
				cola.remove();
			} else {
				caracterRecorrido++;
			}
		}
		if(id>1) {
			ArrayList<pancake>camino = new ArrayList<>();
			while (yaRevisados.get(id-1).getIdPadre() > 0) {
				camino.add(yaRevisados.get(id-1));
				id = yaRevisados.get(id-1).getIdPadre();
			}
			for(int i = camino.size()-1; i >= 0; i --) {
				System.out.println("Se movió desde la pos " + camino.get(i).getDesplazados() + ": " + camino.get(i).getTexto());
			}
			System.out.println();
		}else {
			System.out.println("La cadena no requiere ningun cambio: " + cadena);
		}

	}
	
	public static String revolver(String cadena) {
		char texto[] = new char [cadena.length()];
		texto = cadena.toCharArray();
		for(int i = 0; i < texto.length; i ++) {
			char temp = texto[i];
			int rand = (int)(Math.random() * texto.length);
			texto[i] = texto[rand];
			texto[rand] = temp;
		}
		String revuelto = "";
		for(int i = 0; i < texto.length; i ++) {
			revuelto += texto[i];
		}
		return revuelto;
	}
	
	public static String mover (String cadena, int posicion) {
		char texto[] = new char [posicion + 1];
		char cadenaOrig[] = new char [cadena.length()];
		cadenaOrig = cadena.toCharArray();
		String newText = "";
		int e = 0;
		for(int i = posicion-1; i >= 0; i --) {
			texto[e] = cadena.charAt(i);
			e ++;
		}
		for(int i = 0; i < posicion; i ++) {
			cadenaOrig[i] = texto[i];
		}
		for(int i = 0; i < cadena.length(); i ++) {
			newText += cadenaOrig[i];
		}
		return newText;
	}
}
