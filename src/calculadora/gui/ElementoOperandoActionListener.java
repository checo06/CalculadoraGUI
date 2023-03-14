package calculadora.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculadora.dominio.CalculadoraDominioIE;

public class ElementoOperandoActionListener implements ActionListener {

	CalculadoraGUI calculadoraGUI = null;

	CalculadoraDominioIE calculadoraDominioIE = null;

	public CalculadoraDominioIE getCalculadoraDominioIE() {
		return calculadoraDominioIE;
	}

	public void setCalculadoraDominioIE(
			CalculadoraDominioIE calculadoraDominioIE) {
		this.calculadoraDominioIE = calculadoraDominioIE;
	}

	public CalculadoraGUI getCalculadoraGUI() {
		return calculadoraGUI;
	}

	public void setCalculadoraGUI(CalculadoraGUI calculadoraGUI) {
		this.calculadoraGUI = calculadoraGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String elementoOperando = e.getActionCommand(); // Get text from button

		CalculadoraFontDimensionsManager calculadoraFontDimensionsManager = new CalculadoraFontDimensionsManager(
				calculadoraGUI.getTextField());
		//El caso de "0." (2 digitos) solo puede ocurrir al inicio del operando y nunca como caso de que sobrepase el tamanio limite
		//El caso del signo, si ya esta al limite el operando no se podra hacer cambio de signo
		if (calculadoraGUI.getTextField().getText().length()+1 >= calculadoraFontDimensionsManager
				.getMaxChars()) {
			System.out
					.println(this.getClass().getSimpleName()
							+ " actionPerformed - entro calculadoraGUI.getTextField().getText().length()+1>maxChars");
			return;
		}

		this.calculadoraDominioIE.ingresarElementoOperando(elementoOperando);

		calculadoraGUI.getTextField().setText(
				calculadoraDominioIE.getVisualizador());

	}

}