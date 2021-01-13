import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

	private JFrame frame;
	private JTextField op1;
	private JTextField op2;
	private JTextField ans;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 414, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		op1 = new JTextField();
		op1.setBounds(30, 48, 86, 20);
		frame.getContentPane().add(op1);
		op1.setColumns(10);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double a = Double.parseDouble(op1.getText());
				double b = Double.parseDouble(op2.getText());
				double c = a + b;
				ans.setText(String.valueOf(c));
			}
		});
		btnPlus.setBounds(145, 47, 89, 23);
		frame.getContentPane().add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double a = Double.parseDouble(op1.getText());
				double b = Double.parseDouble(op2.getText());
				double c = a - b;
				ans.setText(String.valueOf(c));
			}
		});
		btnMinus.setBounds(145, 81, 89, 23);
		frame.getContentPane().add(btnMinus);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double a = Double.parseDouble(op1.getText());
				double b = Double.parseDouble(op2.getText());
				double c = a * b;
				ans.setText(String.valueOf(c));
			}
		});
		btnMultiply.setBounds(145, 115, 89, 23);
		frame.getContentPane().add(btnMultiply);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double a = Double.parseDouble(op1.getText());
				double b = Double.parseDouble(op2.getText());
				double c = a / b;
				ans.setText(String.valueOf(c));
			}
		});
		btnDivide.setBounds(145, 149, 89, 23);
		frame.getContentPane().add(btnDivide);
		
		op2 = new JTextField();
		op2.setBounds(258, 48, 86, 20);
		frame.getContentPane().add(op2);
		op2.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(30, 209, 46, 14);
		frame.getContentPane().add(lblAnswer);
		
		ans = new JTextField();
		ans.setBounds(86, 206, 148, 20);
		frame.getContentPane().add(ans);
		ans.setColumns(10);
	}
}
