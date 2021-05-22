package tp02.ejercicio4;
import tp02.ejercicio3.*;

public class TestBalanceo{
	public static void main(String[] args) {
		/*
		System.out.println("Ingrese string"); //({})[]
		Scanner teclado = new Scanner(System.in);
		String st = teclado.next();
		teclado.close();*/
		System.out.println("Esta balanceado? " + estaBalanceado("({})[]"));
	}
	
	
	public static boolean estaBalanceado(String st1) {
		if (st1 == "") { //si est� vac�o est� balanceado
			return true;
		}else {
			char c = st1.charAt(0); //me guardo un char del string - empieza en 0
			//si el primero es de cierre no est� balanceado
			if((c == ')') || (c == ']') || (c == '}')){
				return false;
			}else {
				PilaGenerica<Character> pila = new PilaGenerica<Character>();
				pila.apilar(c);
				for(int i = 1; i < st1.length(); i++) { //recorro el string
					c = st1.charAt(i); //me guardo un char del string
					//si el char es un simbolo de apertura, apilo
					if((c == '(') || (c == '[') || (c == '{')){
						pila.apilar(st1.charAt(i));
					//si es un simbolo de cerrado, chequeo que su contrario coincida con el �lt apilado. Si no es, esta desbalanceado
					}else if (! pila.esVacia()) {
						if(c == ')') {
							if(pila.desapilar() != '(') {
								return false;
							}
						}else if(c == ']') {
							if(pila.desapilar() != '[') {
								return false;
							}
						}else if(c == '}') {
							if(pila.desapilar() != '{') {
								return false;
							}
						}
					}else return false;
				}
				return pila.esVacia(); //si la pila est� vac�a entonces est� balanceado
			}
			
		}
	}

}
