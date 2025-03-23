import java.util.Iterator;

public class SistemaImpl implements Sistema {
	private static SistemaImpl instancia;
	
	private SistemaImpl() {}
	
	public static SistemaImpl getInstancia() {
		if(instancia == null) {
			instancia = new SistemaImpl();
		}
		return instancia;
	}

	@Override
	public int calcularBase2(String numero, int base) {
		// TODO Auto-generated method stub
		if(base == 2) {
			return Integer.parseInt(numero);
			
		} else if(base == 8) {
			return Integer.parseInt(numero);
			
		} else if(base == 10) {
			int numParse = Integer.parseInt(numero);
			StringBuilder concatenados = new StringBuilder();
			if (numParse == 0) {
	            return 0;
	        }
			while(numParse != 0) {
				concatenados.append(numParse%2);
				numParse = numParse/2;
		} concatenados.reverse();
		int binarioResultado = Integer.parseInt(concatenados.toString());
		  return binarioResultado;
		} else if(base == 16) {
			return Integer.parseInt(numero);
			
		} else {
			return 0;
		}
	}

	@Override
	public double calcularBase8(String numero, int base) {
		// TODO Auto-generated method stub
		if(base == 8) {
			return Double.parseDouble(numero);
		} else {
			return 0;
		}
	}

	@Override
	public double calcularBase10(String numero, int base) {
		// TODO Auto-generated method stub
		if(base == 2) {
			int binarioADecimal = 0;
			char[] binarios = numero.toCharArray();
			for (int i = binarios.length-1; i >= 0; i--) {
				if(Character.getNumericValue(binarios[i]) == 1) {
					binarioADecimal+=(Character.getNumericValue(binarios[i]) * Math.pow(2, binarios.length-i-1));
				}
			}	return binarioADecimal;
		} else if(base == 8) {
			int octaADecimal = 0;
			char[] octa = numero.toCharArray();
			for (int i = octa.length-1; i >= 0; i--) {
					octaADecimal += (Character.getNumericValue(octa[i]) * Math.pow(8, octa.length-i-1));
			}	return octaADecimal;
		} else if(base == 10) {
			return Double.parseDouble(numero);
			
		} else if(base == 16) {
			return Double.parseDouble(numero);
		}
		return base; 
	}

	@Override
	public double calcularBase16(String numero, int base) {
		// TODO Auto-generated method stub
		if(base == 16) {
			return Double.parseDouble(numero);
		} else {
			return 0;
		}
	}
}
