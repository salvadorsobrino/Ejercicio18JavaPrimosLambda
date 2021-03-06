package ejercicio18JavaPrimosLambda;

import java.util.Scanner;


interface InterfazLambdaPrimo{
	
	public Runnable esPrimo(Integer n);
}

public class PrimoMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca un numero para comprobar si es primo:");
		int n1 = sc.nextInt();

		System.out.println("Introduzca otro numero para comprobar si es primo:");
		int n3 = sc.nextInt();

		System.out.println("Introduzca el ultimo numero para comprobar si es primo:");
		int n2 = sc.nextInt();

		
		InterfazLambdaPrimo interfazLambdaPrimo  = numero -> {
			boolean primo = true;

			if (numero != 2 && numero % 2 == 0) {
				primo = false;
			} else {
				for (int i = 3; i < numero; i+=2) {
					if (numero % i == 0) {
						primo = false;
					}

				}
			} 
			if (primo) {
				System.out.println("El numero " + numero + " es Primo");
			} else {
				System.out.println("El numero " + numero + " NO es Primo");
			}
			return null; //If null, this classes run method does nothing.
		};
		
		/*A un objeto de tipo Thread se le puede pasar por parametros de 
		constructor una funci?n lambda (runnable es una interfaz funcional)
		Quiero que todo este en la clase main y no haya otras clases.*/
		
		Thread hilo1 = new Thread(interfazLambdaPrimo.esPrimo(n1));
		Thread hilo2 = new Thread(interfazLambdaPrimo.esPrimo(n2));
		Thread hilo3 = new Thread(interfazLambdaPrimo.esPrimo(n3));
		
		hilo1.start();		
		hilo2.start();
		hilo3.start();
	}

}
