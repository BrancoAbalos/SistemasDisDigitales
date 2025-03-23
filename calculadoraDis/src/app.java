import java.util.Scanner;

public class app {
	public static void main(String[] args) {
		Sistema sistema = SistemaImpl.getInstancia();
		
		while(true) {
			System.out.println("Bienvenido, a la calculadora, indique el digito a calcular: ");	
			Scanner s = new Scanner(System.in);
			String numInicial = s.nextLine();
			System.out.println("Seleccione la base correspondiente");
			System.out.println("1- Base 2");
			System.out.println("2- Base 8");
			System.out.println("3- Base 10");
			System.out.println("4- Base 16");
			
			switch (s.nextLine()) {
			case "1":
				System.out.println(sistema.calcularBase2(numInicial, 2));
				System.out.println(sistema.calcularBase8(numInicial, 2));
				System.out.println(sistema.calcularBase10(numInicial, 2));
				System.out.println(sistema.calcularBase16(numInicial, 2));
				break;
			case "2":
				System.out.println(sistema.calcularBase2(numInicial, 8));
				System.out.println(sistema.calcularBase8(numInicial, 8));
				System.out.println(sistema.calcularBase10(numInicial, 8));
				System.out.println(sistema.calcularBase16(numInicial, 8));
				break;
			case "3":
				System.out.println(sistema.calcularBase2(numInicial, 10));
				System.out.println(sistema.calcularBase8(numInicial, 10));
				System.out.println(sistema.calcularBase10(numInicial, 10));
				System.out.println(sistema.calcularBase16(numInicial, 10));
				break;
			case "4":
				System.out.println(sistema.calcularBase2(numInicial, 16));
				System.out.println(sistema.calcularBase8(numInicial, 16));
				System.out.println(sistema.calcularBase10(numInicial, 16));
				System.out.println(sistema.calcularBase16(numInicial, 16));
				break;
			default:
				break;
			}
		}
	}

}
