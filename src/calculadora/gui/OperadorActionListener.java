package calculadora.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculadora.dominio.CalculadoraDominioIE;

public class OperadorActionListener implements ActionListener {

	CalculadoraGUI calculadoraGUI = null;
	CalculadoraDominioIE calculadoraDominioIE = null;

	public CalculadoraGUI getCalculadoraGUI() {
		return calculadoraGUI;
	}

	public void setCalculadoraGUI(CalculadoraGUI calculadoraGUI) {
		this.calculadoraGUI = calculadoraGUI;
	}

	public CalculadoraDominioIE getCalculadoraDominioIE() {
		return calculadoraDominioIE;
	}

	public void setCalculadoraDominioIE(
			CalculadoraDominioIE calculadoraDominioIE) {
		this.calculadoraDominioIE = calculadoraDominioIE;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String operacion = e.getActionCommand(); // Get text from button
		try {
			calculadoraDominioIE.ingresarOperador(operacion);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		CalculadoraFontDimensionsManager calculadoraFontDimensionsManager = new CalculadoraFontDimensionsManager(
				calculadoraGUI.getTextField());
		if (calculadoraDominioIE.getVisualizador().length() > calculadoraFontDimensionsManager
				.getMaxChars()) {

			System.out
					.println(this.getClass().getSimpleName()
							+ " actionPerformed - entro calculadoraDominioIE.getVisualizador().length()>maxChars");

			String format = "%1."
					+ (calculadoraFontDimensionsManager.getMaxChars() / 2)
					+ "e";// caso minimo: "%1.16e"
			calculadoraGUI.getTextField()
					.setText(
							String.format(format, new Double(
									calculadoraDominioIE.getVisualizador())));

			System.out
					.println(this.getClass().getSimpleName()
							+ " actionPerformed - calculadoraDominioIE.getVisualizador():"
							+ calculadoraDominioIE.getVisualizador());
			System.out
					.println(this.getClass().getSimpleName()
							+ " actionPerformed - alterado:"
							+ String.format(format, new Double(
									calculadoraDominioIE.getVisualizador())));
			return;
		}

		calculadoraGUI.getTextField().setText(
				calculadoraDominioIE.getVisualizador());

	}

}