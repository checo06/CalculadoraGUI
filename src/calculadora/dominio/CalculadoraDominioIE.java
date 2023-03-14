package calculadora.dominio;

import java.math.BigDecimal;

/**
 * Clase de dominio para una calculadora implementada por estados(IE). 
 * @author usuario1
 *
 */
public class CalculadoraDominioIE {

	private String visualizador = "0";
	private String operando1 = "";
	private String operador = "";
	private String operando2 = "";
	
	public static final String DIGITOS="0123456789";
	public static final String DOT=".";
	public static final String EQUALS="=";
	public static final String SIGN="+/-";
	
	private EstadosCalculdora estadoCalculdora = EstadosCalculdora.INICIAL;

	public enum EstadosCalculdora {
		INICIAL, DEFINIENDO_OPERANDO1, DEFINIENDO_OPERADOR, DEFININDO_OPERANDO2
	}

	public void ingresarElementoOperando(String elementoOperando) {

		switch (estadoCalculdora) {

		case INICIAL:
			if(this.DIGITOS.contains(elementoOperando)){
				this.visualizador = elementoOperando;
				this.estadoCalculdora = EstadosCalculdora.DEFINIENDO_OPERANDO1;				
			}
			else if(this.DOT.contains(elementoOperando)){
				this.visualizador = "0"+elementoOperando;
				this.estadoCalculdora = EstadosCalculdora.DEFINIENDO_OPERANDO1;				
			}
			else if(this.SIGN.contains(elementoOperando)&&this.visualizador.equalsIgnoreCase("0")){
			}			
			else if(this.SIGN.contains(elementoOperando)&&!this.visualizador.equalsIgnoreCase("0")){
				BigDecimal bigDecimal1 = new BigDecimal(this.visualizador);
				BigDecimal bigDecimal2 = new BigDecimal("-1");
				this.visualizador=bigDecimal1.multiply(bigDecimal2).toString();				
			}			

			break;

		case DEFINIENDO_OPERANDO1:
			if(this.DIGITOS.contains(elementoOperando)){
				this.visualizador += elementoOperando;
			}
			else if(this.DOT.contains(elementoOperando)&&!this.visualizador.contains(this.DOT)){
				this.visualizador += elementoOperando;
			}			
			else if(this.DOT.contains(elementoOperando)&&this.visualizador.contains(this.DOT)){
			}			
			else if(this.SIGN.contains(elementoOperando)){
				BigDecimal bigDecimal1 = new BigDecimal(this.visualizador);
				BigDecimal bigDecimal2 = new BigDecimal("-1");
				this.visualizador=bigDecimal1.multiply(bigDecimal2).toString();
			}						
			break;

		case DEFINIENDO_OPERADOR:
			if(this.DIGITOS.contains(elementoOperando)){
				this.visualizador = elementoOperando;
				this.estadoCalculdora = EstadosCalculdora.DEFININDO_OPERANDO2;
			}
			else if(this.DOT.contains(elementoOperando)){
				this.visualizador = "0"+elementoOperando;
				this.estadoCalculdora = EstadosCalculdora.DEFININDO_OPERANDO2;
			}
			else if(this.SIGN.contains(elementoOperando)){
			}			
			break;

		case DEFININDO_OPERANDO2:
			if(this.DIGITOS.contains(elementoOperando)){
				this.visualizador += elementoOperando;
			}
			else if(this.DOT.contains(elementoOperando)&&!this.visualizador.contains(this.DOT)){
				this.visualizador += elementoOperando;
			}			
			else if(this.DOT.contains(elementoOperando)&&this.visualizador.contains(this.DOT)){
			}
			else if(this.SIGN.contains(elementoOperando)){
				BigDecimal bigDecimal1 = new BigDecimal(this.visualizador);
				BigDecimal bigDecimal2 = new BigDecimal("-1");
				this.visualizador=bigDecimal1.multiply(bigDecimal2).toString();
			}			
			break;

		}

	}

	public void ingresarOperador(String operador) throws Exception {
		switch (estadoCalculdora) {

		case INICIAL:
			if (operador.equalsIgnoreCase(this.EQUALS)) {
			}else if (!operador.equalsIgnoreCase(this.EQUALS)) {
				this.operando1 = this.visualizador;
				this.operador = operador;
				this.estadoCalculdora = EstadosCalculdora.DEFINIENDO_OPERADOR;				
			}
			break;

		case DEFINIENDO_OPERANDO1:
			if (operador.equalsIgnoreCase(this.EQUALS)) {
			}else if (!operador.equalsIgnoreCase(this.EQUALS)) {
				this.operando1 = this.visualizador;
				this.operador = operador;
				this.estadoCalculdora = EstadosCalculdora.DEFINIENDO_OPERADOR;				
			}
			break;

		case DEFINIENDO_OPERADOR:
			if (operador.equalsIgnoreCase(this.EQUALS)) {
			}else if (!operador.equalsIgnoreCase(this.EQUALS)) {
				this.operador = operador;
			}
			break;

		case DEFININDO_OPERANDO2:
			// esta lo interesante			
			if (operador.equalsIgnoreCase(this.EQUALS)) {
				this.operando2 = this.visualizador;
				this.visualizador = this.realizarOperacion();
				this.estadoCalculdora = EstadosCalculdora.INICIAL;
			} else if (!operador.equalsIgnoreCase(this.EQUALS)) {
				this.operando2 = this.visualizador;
				this.operando1 = this.realizarOperacion();
				this.visualizador = this.operando1;
				this.operador = operador;
				this.estadoCalculdora = EstadosCalculdora.DEFINIENDO_OPERADOR;
			}			
			
			break;

		}
	}

	public void borrarCalculadora(){
		this.visualizador = "0";
		this.operando1 = "";
		this.operador = "";
		this.operando2 = "";
		this.estadoCalculdora = EstadosCalculdora.INICIAL;
	}
	
	
	public String getVisualizador() {
		return visualizador;
	}


	/**
	 * Se realiza la operacion indicada y se entrega el resultado.
	 * Si la operacion es realizada y regresada a Double, se pierde precision en la notacion cientifica, 
	 * por lo que es mejor manejar String con DecimalFormat.
	 * @return El resultado de la operacion (sin notacion cientifica y con representacion en String)
	 * @throws Exception
	 */
	private String realizarOperacion() throws Exception {

		String resultado;
		if (this.operador.equalsIgnoreCase("+")) {
			BigDecimal bigDecimal1 = new BigDecimal(this.operando1);
			BigDecimal bigDecimal2 = new BigDecimal(this.operando2);
			resultado = bigDecimal1.add(bigDecimal2).toString();
		} 
		else if (this.operador.equalsIgnoreCase("-")) {
			BigDecimal bigDecimal1 = new BigDecimal(this.operando1);
			BigDecimal bigDecimal2 = new BigDecimal(this.operando2);
			resultado = bigDecimal1.subtract(bigDecimal2).toString();
		} 
		else if (this.operador.equalsIgnoreCase("*")) {
			BigDecimal bigDecimal1 = new BigDecimal(this.operando1);
			BigDecimal bigDecimal2 = new BigDecimal(this.operando2);
			resultado = bigDecimal1.multiply(bigDecimal2).toString();
		} 
		else if (this.operador.equalsIgnoreCase("/")) {
			BigDecimal bigDecimal1 = new BigDecimal(this.operando1);
			BigDecimal bigDecimal2 = new BigDecimal(this.operando2);
			resultado = bigDecimal1.divide(bigDecimal2).toString();	
		} 		
		else {
			throw new Exception("operacion invalida");
		}
		return resultado + "";
	}

}
