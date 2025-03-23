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
        int numParse = Integer.parseInt(numero); // Convierte el número de cadena a entero
        if(base == 2) {
            return numParse; // Si la base es 2, retorna el número tal cual
        } else if(base == 8) {
            return Integer.parseInt(numero); // INCOMPLETO PQ TENGO QUE AGARRAR EL STRING CONCATENADO Y CALCULARLO DE AHI*****************
        } else if(base == 10) {
            StringBuilder concatenados = new StringBuilder();
            if (numParse == 0) {
                return 0; // Si el número es 0, retorna 0
            }
            while(numParse != 0) {
                concatenados.append(numParse % 2); // Agrega el residuo de la división por 2
                numParse = numParse / 2; // Realiza la división por 2
            }
            concatenados.reverse(); // Invierte el resultado para obtener el número binario correcto
            int binarioResultado = Integer.parseInt(concatenados.toString()); // Convierte a número binario
            return binarioResultado;
        } else if(base == 16) {
            return Integer.parseInt(numero); // INCOMPLETO PQ TENGO QUE AGARRAR EL STRING CONCATENADO Y CALCULARLO DE AHI*******************
        } else {
            return 0; // Si la base no es válida, retorna 0
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
        int numParse = Integer.parseInt(numero); // Convierte el número de cadena a entero
        if(base == 2) {
            return numParse; // Creo q no vimos de base 8 a base 2 XDDD tengo q buscar cmo hacerlo************
        }
        if(base == 8) {
            return numParse; // Si la base es 8, retorna el número tal cual
        } else if(base == 10) {
            StringBuilder concatenados = new StringBuilder();
            if (numParse == 0) {
                return 0; // Si el número es 0, retorna 0
            }
            while(numParse != 0) {
                concatenados.append(numParse % 8); // Agrega el residuo de la división por 8
                numParse = numParse / 8; // Realiza la división por 8
            }
            concatenados.reverse(); // Invierte el resultado para obtener el número octal correcto
            int octoResultado = Integer.parseInt(concatenados.toString()); // Convierte a número
            return octoResultado;
        } else if(base == 16) {
            return Integer.parseInt(numero); // Creo q no vimos de base 8 a base 16 XDDD tengo q buscar cmo hacerlo, aunque debiera ser la mitad del digito pero tan los caracteres raros************
        } else {
            return 0; // Si la base no es válida, retorna 0
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
        if(base == 2) {
            int binarioADecimal = 0;
            char[] binarios = numero.toCharArray(); // Convierte el número binario en un arreglo de caracteres
            for (int i = binarios.length-1; i >= 0; i--) {
                if(Character.getNumericValue(binarios[i]) == 1) {
                    binarioADecimal += (Character.getNumericValue(binarios[i]) * Math.pow(2, binarios.length-i-1)); // Convierte binario a decimal
                }
            }
            return binarioADecimal; // Retorna el resultado en base 10
        } else if(base == 8) {
            int octaADecimal = 0;
            char[] octa = numero.toCharArray(); // Convierte el número octal en un arreglo de caracteres
            for (int i = octa.length-1; i >= 0; i--) {
                octaADecimal += (Character.getNumericValue(octa[i]) * Math.pow(8, octa.length-i-1)); // Convierte octal a decimal
            }
            return octaADecimal; // Retorna el resultado en base 10
        } else if(base == 10) {
            return Double.parseDouble(numero); // Si la base es 10, retorna el número tal cual
        } else if(base == 16) {
            return Double.parseDouble(numero); // El problema de los digitos raros por aca zzzzzzz*********************
        }
        return base; // Si la base no es válida, retorna la base como valor por defecto
    }

	@Override
	public double calcularBase16(String numero, int base) {
	    int numParse = Integer.parseInt(numero); // Convierte el número de cadena a entero
	    if(base == 2) {
	        return numParse; 
	    } else if(base == 8) {
	        return Integer.parseInt(numero); 
	    } else if(base == 10) {
	        StringBuilder concatenados = new StringBuilder();
	        if (numParse == 0) {
	            return 0; // Si el número es 0, retorna 0
	        }
	        while(numParse != 0) {
	            concatenados.append(numParse % 16); // Agrega el residuo de la división por 16
	            numParse = numParse / 16; // Realiza la división por 16
	        }
	        concatenados.reverse(); // Invierte el resultado para obtener el número hexadecimal correcto
	        int hexaADecimal = Integer.parseInt(concatenados.toString()); // Convierte a número
	        return hexaADecimal; // Retorna el resultado en base 16   / Todo esto de aca ta malo kjjjjj es que aun no hago las conversiones de A = 10, B = 11 y asi, tendria q hacerlo cmo funcion creo yo
	    } else if(base == 16) {
	        return Double.parseDouble(numero); // Si la base es 16, retorna el número tal cual
	    }
	    return 0; // Si la base no es válida, retorna 0
	}
}
