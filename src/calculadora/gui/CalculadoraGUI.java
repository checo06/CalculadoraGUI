package calculadora.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.SwingConstants;

import calculadora.dominio.CalculadoraDominioIE;

public class CalculadoraGUI {

    CalculadoraDominioIE calculadoraDominioIE = new CalculadoraDominioIE();
    ElementoOperandoActionListener elementoOperandoActionListener = new ElementoOperandoActionListener();
    OperadorActionListener operadorActionListener = new OperadorActionListener();	
    
	private JFrame frmCalculadoraSimple;
	private JTextField textField;
	private JPanel panel_operadores;
	private JPanel panel_borrar;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_1;
	private JButton button_2;
	private JButton button_0;
	private JButton btnBorrar;
	private JButton button;
	private JButton button_10;
	private JButton btnNewButton;
	private JButton button_11;
	private JButton button_12;
	private JButton button_3;
	private JButton button_dot;
	private JButton button_13;
	
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGUI window = new CalculadoraGUI();
					window.frmCalculadoraSimple.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadoraGUI() {
		
		initialize();
		
		/*
		 * Agregar los ActionListener a los digitos y operadores 
		 */
		
        elementoOperandoActionListener.setCalculadoraDominioIE(calculadoraDominioIE);
        elementoOperandoActionListener.setCalculadoraGUI(this);	

        operadorActionListener.setCalculadoraDominioIE(calculadoraDominioIE);
        operadorActionListener.setCalculadoraGUI(this);

        textField.setText(calculadoraDominioIE.getVisualizador());		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraSimple = new JFrame();
		frmCalculadoraSimple.setTitle("Calculadora Simple");
		frmCalculadoraSimple.setMinimumSize(new Dimension(300, 340));
		frmCalculadoraSimple.setBounds(100, 100, 300, 340);
		frmCalculadoraSimple.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		frmCalculadoraSimple.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel_botones = new JPanel();
		frmCalculadoraSimple.getContentPane().add(panel_botones, BorderLayout.CENTER);
		panel_botones.setLayout(new GridLayout(5, 3, 3, 3));
		
		button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_7);
		
		button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_8);
		
		button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_9);
		
		button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_4);
		
		button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_5);
		
		button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_6);
		
		button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_1);
		
		button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_2);
		
		button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_3);
		
		button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		
		button_13 = new JButton("+/-");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);
			}
		});
		panel_botones.add(button_13);
		panel_botones.add(button_0);
		
		button_dot = new JButton(".");
		button_dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elementoOperandoActionListener.actionPerformed(e);				
			}
		});
		panel_botones.add(button_dot);
		
		panel_operadores = new JPanel();
		frmCalculadoraSimple.getContentPane().add(panel_operadores, BorderLayout.EAST);
		panel_operadores.setLayout(new GridLayout(5, 1, 3, 3));
		
		button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operadorActionListener.actionPerformed(e);
			}
		});
		panel_operadores.add(button);
		
		button_10 = new JButton("-");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operadorActionListener.actionPerformed(e);
			}
		});
		panel_operadores.add(button_10);
		
		btnNewButton = new JButton("*");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operadorActionListener.actionPerformed(e);
			}
		});
		panel_operadores.add(btnNewButton);
		
		button_11 = new JButton("/");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operadorActionListener.actionPerformed(e);
			}
		});
		panel_operadores.add(button_11);
		
		button_12 = new JButton("=");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operadorActionListener.actionPerformed(e);
			}
		});
		panel_operadores.add(button_12);
		
		panel_borrar = new JPanel();
		frmCalculadoraSimple.getContentPane().add(panel_borrar, BorderLayout.SOUTH);
		panel_borrar.setLayout(new BorderLayout(0, 0));
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                calculadoraDominioIE.borrarCalculadora();
                textField.setText(calculadoraDominioIE.getVisualizador());
            }
		});
		
		panel_borrar.add(btnBorrar, BorderLayout.CENTER);
	}

}
