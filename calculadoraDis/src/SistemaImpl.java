public class SistemaImpl implements Sistema {

    private static SistemaImpl instancia;

    private SistemaImpl() {}

    public static SistemaImpl getInstancia() {
        if(instancia == null) {
            instancia = new SistemaImpl(); // Se crea la instancia si no existe
        }
        return instancia;
    }


    @Override
    public String calcularBase2(String numero, int base) {
        String[] partes = numero.split(",");
        String parteEntera = partes[0];
        String parteDecimal = "";
        if (partes.length > 1) {
        	parteDecimal = partes[1];
        } else {
        	parteDecimal = "0";
        }
        String parteEnteraBin = convertirParteEnteraABaseX(parteEntera, base, 2);
        String parteDecimalBin = convertirParteDecimalABaseX(parteDecimal, base, 2);
        String resultado = parteEnteraBin;
        if (!parteDecimalBin.isEmpty()) {
            resultado += "," + parteDecimalBin; // Solo agrega la parte decimal si no está vacía
        }

        return resultado;
    }

    @Override
    public String calcularBase8(String numero, int base) {
        String[] partes = numero.split(",");
        String parteEntera = partes[0];
        String parteDecimal = "";
        if (partes.length > 1) {
        	parteDecimal = partes[1];
        } else {
        	parteDecimal = "0";
        }
        String parteEnteraOct = convertirParteEnteraABaseX(parteEntera, base, 8);
        String parteDecimalOct = convertirParteDecimalABaseX(parteDecimal, base, 8);
        String resultado = parteEnteraOct;
        if (!parteDecimalOct.isEmpty()) {
            resultado += "," + parteDecimalOct; // Solo agrega la parte decimal si no está vacía
        }
        return resultado;
    }

    
    @Override
    public String calcularBase10(String numero, int base) {
        String[] partes = numero.split(",");
        String parteEntera = partes[0];
        String parteDecimal = "";
        if (partes.length > 1) {
        	parteDecimal = partes[1];
        } else {
        	parteDecimal = "0";
        }
        String parteEnteraDecimal = String.valueOf(baseXABase10(parteEntera, base));
        String parteDecimalDecimal = calcularParteDecimalEnBase10(parteDecimal, base);
        String resultado = parteEnteraDecimal;
        if (!parteDecimalDecimal.isEmpty()) {
            resultado += "," + parteDecimalDecimal; // Solo agrega la parte decimal si no está vacía
        }
        return resultado;
    }

    @Override
    public String calcularBase16(String numero, int base) {
        String[] partes = numero.split(",");
        String parteEntera = partes[0];
        String parteDecimal = "";
        if (partes.length > 1) {
        	parteDecimal = partes[1];
        } else {
        	parteDecimal = "0";
        }
        String parteEnteraHex = convertirParteEnteraABaseX(parteEntera, base, 16);
        String parteDecimalHex = convertirParteDecimalABaseX(parteDecimal, base, 16);
        String resultado = parteEnteraHex;
        if (!parteDecimalHex.isEmpty()) {
            resultado += "," + parteDecimalHex; // Solo agrega la parte decimal si no está vacía
        }
        return resultado;
    }


 // Convierte la parte entera de cualquier base a cualquier otra base
    private String convertirParteEnteraABaseX(String parteEntera, int base, int baseDestino) {
        // Primero, convertimos el número de la base original (base) a base 10
        int numero = Integer.parseInt(parteEntera, base);  // Usamos la base especificada aquí para convertir correctamente
        return base10ABaseX(String.valueOf(numero), baseDestino);
    }


    private String convertirParteDecimalABaseX(String parteDecimal, int base, int baseDestino) {
        StringBuilder resultado = new StringBuilder();
        double parteDecimalNumero = 0;

        // Convertir la parte decimal a su valor en base 10
        for (int i = 0; i < parteDecimal.length(); i++) {
            char digito = parteDecimal.charAt(i);
            parteDecimalNumero += charADigito(digito) * Math.pow(base, -(i + 1));  // Parte decimal en base 10
        }

        int precision = 10; // Número de dígitos decimales a mostrar

        // Convertir la parte decimal (en base 10) a la base de destino
        while (parteDecimalNumero > 0 && precision-- > 0) {
            parteDecimalNumero *= baseDestino;
            int entero = (int) parteDecimalNumero;
            resultado.append(digitoAChar(entero));  // Añadir el dígito correspondiente
            parteDecimalNumero -= entero;  // Restar la parte entera obtenida para seguir con la fracción
        }

        return resultado.toString();
    }

    // Convierte un número fraccionario en base X a base 10
    private String calcularParteDecimalEnBase10(String parteDecimal, int base) {
        double resultado = 0;
        for (int i = 0; i < parteDecimal.length(); i++) {
            char digito = parteDecimal.charAt(i);
            resultado += charADigito(digito) * Math.pow(base, -(i + 1));
        }
        return String.format("%.10f", resultado).substring(2); // Devolver solo los decimales
    }

    // Convierte un número de base X a base 10
    public int baseXABase10(String numero, int base) {
        int baseXADecimal = 0;
        char[] cadenaNumeros = numero.toCharArray();
        for (int i = cadenaNumeros.length - 1; i >= 0; i--) {
            baseXADecimal += (charADigito(cadenaNumeros[i]) * Math.pow(base, cadenaNumeros.length - i - 1)); // Convierte a base 10
        }
        return baseXADecimal;
    }


    public String base10ABaseX(String numero, int base) {
        int numParse = Integer.parseInt(numero);
        StringBuilder result = new StringBuilder();
        if (numParse == 0) {
            return "0";
        }
        while(numParse != 0) {
            result.append(digitoAChar(numParse % base));
            numParse = numParse / base;
        }
        result.reverse();
        return result.toString();
    }

    public char digitoAChar(int numero) {
        if (numero < 10) {
            return (char) ('0' + numero); // Para dígitos 0-9
        } else {
            return (char) ('A' + (numero - 10)); // Para dígitos 10-15 (A-F)
        }
    }

    public int charADigito(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0'; // Para caracteres '0'-'9'
        } else if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10; // Para caracteres 'A'-'F'
        }
        throw new IllegalArgumentException("Carácter no válido para conversión: " + c);
    }
}
