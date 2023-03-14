package calculadora.gui;

import java.awt.FontMetrics;

import javax.swing.JTextField;

public class CalculadoraFontDimensionsManager {

	int maxChars;
	int maxLines;

	public CalculadoraFontDimensionsManager(JTextField jTextField) {
		FontMetrics fontMetrics = jTextField.getFontMetrics(
				(jTextField.getFont()));
		final int charWidth = fontMetrics.charWidth('M');
		final int charHeight = fontMetrics.getHeight();
		final int prefWidth = jTextField.getSize().width;
		final int prefHeight = jTextField.getSize().height;
		maxChars = prefWidth / charWidth;
		maxLines = prefHeight / charHeight;
	}

	public int getMaxChars() {
		return maxChars;
	}

	public int getMaxLines() {
		return maxLines;
	}


	
	
}
