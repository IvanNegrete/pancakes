package pancakes;

<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
>>>>>>> Stashed changes
import java.util.Scanner;

public class main {
	
<<<<<<< Updated upstream
	//Variables globales
	public static String abecedario = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String args []) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese el numero de pancakes:");
		int stack [] = generarPancakes(leer.nextInt());
		System.out.println("");
		for (int i = 0; i < stack.length; i ++) {
			System.out.println(abecedario.charAt(i) + ".- " + stack[i]);
		}
		leer.nextLine();
		while(!arreglado(stack)) {
			mover(leer.nextLine(), stack);
			System.out.print("\033[H\033[2J");  
		    System.out.flush(); 
			for (int i = 0; i < stack.length; i ++) {
				System.out.println(abecedario.charAt(i) + ".- " + stack[i]);
			}
		}
	}
	
	//Se le pasa el numero de pancakes para el juego, los revuelve y regresa el array revuelto
	public static int [] generarPancakes(int numeroPancakes) {
		int stack [] = new int [numeroPancakes];
		for (int i = 0; i < stack.length; i ++) {
			stack[i] = i + 1;
		}
		for (int i = 0; i < stack.length; i ++) {
			int temp = stack[i];
			int rand = (int) (Math.random()*stack.length);
			stack[i] = stack[rand];
			stack[rand] = temp;
=======
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
		int cont = 0;
		String cadena = revolver(ordenado);
		pancake raiz = new pancake(cadena, 1, 0);
		cola.offer(raiz);
		yaRevisados.add(raiz);
		System.out.println("Cadena Reuvelta: " + cadena);
		System.out.println("-----");
		while(!cadena.equals(ordenado)) {
			id++;
			cadena = cola.peek().getTexto();
			cadena = mover(cadena, caracterRecorrido);
			
			pancake estado = new pancake(cadena, id,  cola.peek().getId());
			cola.offer(estado);
			yaRevisados.add(estado);
			// ---------------------------------------------

			if (cont == cadena.length() - 2) {
				cola.remove();
				cont = 0;
			} else {
				cont++;
			}
			if (caracterRecorrido == (cadena.length())) {
				caracterRecorrido = 2;
			} else {
				caracterRecorrido++;
			}
		}
		ArrayList<String>camino = new ArrayList<>();
		while (yaRevisados.get(id-1).getIdPadre() > 0) {
			camino.add(yaRevisados.get(id-1).getTexto());
			id = yaRevisados.get(id-1).getIdPadre();
		}
		for(int i = camino.size()-1; i >= 0; i --) {
			System.out.println(camino.get(i));
		}
		System.out.println();

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
>>>>>>> Stashed changes
		}
		return revuelto;
	}
	
<<<<<<< Updated upstream
	//Método para mover los pancakes
	public static void mover(String pos, int stack[]) {
		int indexMov = abecedario.indexOf(pos);
		int arrayTemp[] = new int [indexMov+1];
		int e = 0;
		for(int i = indexMov; i >= 0; i --) {
			arrayTemp[e] = stack[i];
			e++;
		}
		System.out.println("");
		for(int i = 0; i <= indexMov; i ++) {
			stack[i] = arrayTemp[i];
		}
	}
	
	public static boolean arreglado(int stack[]) {
		for(int i = 0; i < stack.length-1; i ++) {
			if(stack[i] > stack[i+1]) {
				return false;
			}
		}
		return true;
=======
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
>>>>>>> Stashed changes
	}
}
