import java.util.Iterator;


public class SistemaImpl implements Sistema {
    
    // Instancia estática para garantizar que solo haya una instancia de SistemaImpl (Patrón Singleton)
    private static SistemaImpl instancia;
    
    // Constructor privado para evitar instanciación externa
    private SistemaImpl() {}
    
    /**
     * Método que devuelve la instancia única de la clase SistemaImpl.
     * Si no se ha creado previamente, la crea y devuelve.
     *
     * @return Instancia única de SistemaImpl
     */
    public static SistemaImpl getInstancia() {
        if(instancia == null) {
            instancia = new SistemaImpl(); // Se crea la instancia si no existe
        }
        return instancia;
    }

    /**
     * Convierte un número a base 2 desde una base cualquiera
     *
     * @param numero Número en formato de cadena
     * @param base Base en la que se encuentra el número
     * @return El número convertido a base 2
     */
    @Override
    public int calcularBase2(String numero, int base) {
        if(base == 2) {
            return Integer.parseInt(numero); // Si la base es 2, retorna el número tal cual
        } else if(base == 10) {
        	return(base10ABaseX(numero, 2));
        } else {
            String pivote = Integer.toString(baseXABase10(numero, base));
        	return base10ABaseX(pivote, 2);
        }
    }

    /**
     * Convierte un número A base 8 desde una base cualquiera
     *
     * @param numero Número en formato de cadena
     * @param base Base en la que se encuentra el número
     * @return El número convertido en base 8
     */
    @Override
    public double calcularBase8(String numero, int base) {
    	if(base == 8) {
            return Integer.parseInt(numero); // Si la base es 8, retorna el número tal cual
        } else if(base == 10) {
        	return(base10ABaseX(numero, 8));
        } else {
            String pivote = Integer.toString(baseXABase10(numero, base));
            return base10ABaseX(pivote, 8);
        }
    }

    /**
     * Convierte un número a base 10 de cualquier base
     *
     * @param numero Número en formato de cadena
     * @param base Base en la que se encuentra el número
     * @return El número convertido a base 10
     */
    @Override
    public double calcularBase10(String numero, int base) {
        if(base == 10) {
            return Double.parseDouble(numero);
        } else {
            return baseXABase10(numero, base);
        }
    }

	@Override
	public String calcularBase16(String numero, int base) {
	    if(base == 10) {
	        return Integer.toString(base10ABaseX(numero, 16));
	    } else if(base == 16) {
	        return (numero); // Si la base es 16, retorna el número tal cual
	    } else {
	    	String pivote = Integer.toString(baseXABase10(numero, base));
	    	return Integer.toString(base10ABaseX(pivote, 16));
	    }
	}

	public int baseXABase10(String numero, int base) {
		int baseXADecimal = 0;
        char[] cadenaNumeros = numero.toCharArray();
        for (int i = cadenaNumeros.length-1; i >= 0; i--) {
        	baseXADecimal += (charADigito(cadenaNumeros[i]) * Math.pow(base, cadenaNumeros.length-i-1)); // Convierte binario a decimal
        }
        return baseXADecimal;
	}
	
	public int base10ABaseX(String numero, int base) {
		int numParse = Integer.parseInt(numero);
        StringBuilder concatenados = new StringBuilder();
        if (numParse == 0) {
            return 0;
        }
        while(numParse != 0) {
            concatenados.append(numParse % base);
            numParse = numParse / base;
        }
        concatenados.reverse();
        return (Integer.parseInt(concatenados.toString()));
	}
	
	
	
	public int charADigito(char numero) {
	    switch (numero) {
	    	case '0': return 0;
	    	case '1': return 1;
	    	case '2': return 2;
	    	case '3': return 3;
	    	case '4': return 4;
	    	case '5': return 5;
        	case '6': return 6;
        	case '7': return 7;
        	case '8': return 8;
        	case '9': return 9;
	        case 'A': return 10;
	        case 'B': return 11;
	        case 'C': return 12;
	        case 'D': return 13;
	        case 'E': return 14;
	        case 'F': return 15;
	        default: return -1;  // Si el valor no es válido
	    }
	}
}