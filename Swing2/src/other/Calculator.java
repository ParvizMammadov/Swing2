package other;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Calculator {

	private JFrame frmCalculator;
	private JTextField textField;
	String numberDisplayed = "";
	double op1=0, op2=0, ans;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\calculator-icon.png"));
		frmCalculator.setTitle("Calculator");
		frmCalculator.setFont(new Font("Consolas", Font.PLAIN, 16));
		frmCalculator.setBounds(100, 100, 324, 324);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(248, 248, 255));
		textField.setFont(new Font("Consolas", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 290, 40);
		frmCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("+");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Consolas", Font.PLAIN, 14));
		label.setForeground(new Color(255, 0, 0));
		label.setBounds(130, 62, 166, 14);
		label.setVisible(false);
		frmCalculator.getContentPane().add(label);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "7";
				textField.setText(numberDisplayed);
			}
		});
		btn7.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn7.setBounds(10, 89, 50, 30);
		frmCalculator.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "8";
				textField.setText(numberDisplayed);
			}
		});
		btn8.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn8.setBounds(70, 89, 50, 30);
		frmCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "9";
				textField.setText(numberDisplayed);
			}
		});
		btn9.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn9.setBounds(130, 89, 50, 30);
		frmCalculator.getContentPane().add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "4";
				textField.setText(numberDisplayed);
			}
		});
		btn4.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn4.setBounds(10, 130, 50, 30);
		frmCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "5";
				textField.setText(numberDisplayed);
			}
		});
		btn5.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn5.setBounds(70, 130, 50, 30);
		frmCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "6";
				textField.setText(numberDisplayed);
			}
		});
		btn6.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn6.setBounds(130, 130, 50, 30);
		frmCalculator.getContentPane().add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "1";
				textField.setText(numberDisplayed);
			}
		});
		btn1.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn1.setBounds(10, 171, 50, 30);
		frmCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "2";
				textField.setText(numberDisplayed);
			}
		});
		btn2.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn2.setBounds(70, 171, 50, 30);
		frmCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "3";
				textField.setText(numberDisplayed);
			}
		});
		btn3.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn3.setBounds(130, 171, 50, 30);
		frmCalculator.getContentPane().add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += "0";
				textField.setText(numberDisplayed);
			}
		});
		btn0.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn0.setBounds(70, 212, 50, 30);
		frmCalculator.getContentPane().add(btn0);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed = "";
				textField.setText(null);
				op1 = 0;
				
				label.setVisible(false);
				label.setText("+");
			}
		});
		btnC.setBackground(Color.ORANGE);
		btnC.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnC.setBounds(10, 212, 50, 30);
		frmCalculator.getContentPane().add(btnC);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberDisplayed += ".";
				textField.setText(numberDisplayed);
			}
		});
		btnDot.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnDot.setBounds(130, 212, 50, 30);
		frmCalculator.getContentPane().add(btnDot);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(label.getText().charAt(label.getText().length()-1)) {
				case '+':
					op1 += Double.parseDouble(numberDisplayed);
					break;
				case '-':
					op1 -= Double.parseDouble(numberDisplayed);
					break;
				case '*':
					op1 *= Double.parseDouble(numberDisplayed);
					break;
				case '/':
					op1 /= Double.parseDouble(numberDisplayed);
					break;
				}
				
				numberDisplayed = "";
				label.setText(String.valueOf(op1) + "+");
				label.setVisible(true);
				textField.setText(null);
				
			}
		});
		btnPlus.setBackground(new Color(124, 252, 0));
		btnPlus.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnPlus.setBounds(190, 212, 50, 30);
		frmCalculator.getContentPane().add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(label.getText().charAt(label.getText().length()-1)) {
				case '+':
					op1 += Double.parseDouble(numberDisplayed);
					break;
				case '-':
					op1 -= Double.parseDouble(numberDisplayed);
					break;
				case '*':
					op1 *= Double.parseDouble(numberDisplayed);
					break;
				case '/':
					op1 /= Double.parseDouble(numberDisplayed);
					break;
				}
				
				numberDisplayed = "";
				label.setText(String.valueOf(op1) + "-");
				label.setVisible(true);
				textField.setText(null);
			}
		});
		btnMinus.setBackground(new Color(124, 252, 0));
		btnMinus.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnMinus.setBounds(190, 171, 50, 30);
		frmCalculator.getContentPane().add(btnMinus);
		
		JButton btnMultiply = new JButton("x");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(label.getText().charAt(label.getText().length()-1)) {
				case '+':
					op1 += Double.parseDouble(numberDisplayed);
					break;
				case '-':
					op1 -= Double.parseDouble(numberDisplayed);
					break;
				case '*':
					op1 *= Double.parseDouble(numberDisplayed);
					break;
				case '/':
					op1 /= Double.parseDouble(numberDisplayed);
					break;
				}
				
				numberDisplayed = "";
				label.setText(String.valueOf(op1) + "*");
				label.setVisible(true);
				textField.setText(null);
			}
		});
		btnMultiply.setBackground(new Color(124, 252, 0));
		btnMultiply.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnMultiply.setBounds(190, 130, 50, 30);
		frmCalculator.getContentPane().add(btnMultiply);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(label.getText().charAt(label.getText().length()-1)) {
				case '+':
					op1 += Double.parseDouble(numberDisplayed);
					break;
				case '-':
					op1 -= Double.parseDouble(numberDisplayed);
					break;
				case '*':
					op1 *= Double.parseDouble(numberDisplayed);
					break;
				case '/':
					op1 /= Double.parseDouble(numberDisplayed);
					break;
				}
				
				numberDisplayed = "";
				label.setText(String.valueOf(op1) + "/");
				label.setVisible(true);
				textField.setText(null);
			}
		});
		btnDivide.setBackground(new Color(124, 252, 0));
		btnDivide.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnDivide.setBounds(250, 130, 50, 30);
		frmCalculator.getContentPane().add(btnDivide);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(label.getText().charAt(label.getText().length()-1)) {
				case '+':
					op1 += Double.parseDouble(numberDisplayed);
					break;
				case '-':
					op1 -= Double.parseDouble(numberDisplayed);
					break;
				case '*':
					op1 *= Double.parseDouble(numberDisplayed);
					break;
				case '/':
					op1 /= Double.parseDouble(numberDisplayed);
					break;
				}
				
				textField.setText(String.valueOf(op1));
				numberDisplayed = String.valueOf(0.0);
				
				label.setVisible(false);
				label.setText("+");
			}
		});
		btnEqual.setBackground(SystemColor.textHighlight);
		btnEqual.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnEqual.setBounds(250, 171, 50, 71);
		frmCalculator.getContentPane().add(btnEqual);
		
		JButton btnPlusMinus = new JButton("\u00B1");
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textField.setText(String.valueOf(Double.parseDouble(textField.getText())*(-1)));
				numberDisplayed = textField.getText();
			}
		});
		btnPlusMinus.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnPlusMinus.setBounds(190, 89, 50, 30);
		frmCalculator.getContentPane().add(btnPlusMinus);
		
		JButton btnSqrt = new JButton("\u221A");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					textField.setText(String.valueOf(Math.sqrt(Double.parseDouble(textField.getText()))));
					numberDisplayed = textField.getText();
				} catch(Exception ex) {
					
				}
			}
		});
		btnSqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnSqrt.setBounds(250, 89, 50, 30);
		frmCalculator.getContentPane().add(btnSqrt);
		
		
	}

}
