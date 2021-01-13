package other;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class File_Font_Color {

	private JFrame frame;
	static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File_Font_Color window = new File_Font_Color();
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
	public File_Font_Color() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 55, 331, 271);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				int i = fc.showOpenDialog(frame);
				
				if(i == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					String filepath = file.getPath();
					
					try {
						BufferedReader reader = new BufferedReader(new FileReader(filepath));
						String s1 = "", s2 = "";
						
						while((s1=reader.readLine()) != null) {
							s2 += s1 + "\n";
						}
						
						textArea.setText(s2);
						reader.close();
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnOpenFile.setBounds(21, 21, 89, 23);
		frame.getContentPane().add(btnOpenFile);
		
		JButton btnChangeFont = new JButton("Change Font");
		btnChangeFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FontDialog fontDialog = new FontDialog();
				fontDialog.frame.setVisible(true);
				textArea.setFont(fontDialog.getFont());
			}
		});
		btnChangeFont.setBounds(374, 55, 107, 23);
		frame.getContentPane().add(btnChangeFont);
		
		JButton btnChangeColor = new JButton("Change Font Color");
		btnChangeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(frame, "Select font color", Color.BLACK);
				textArea.setForeground(color);
			}
		});
		btnChangeColor.setBounds(374, 269, 149, 23);
		frame.getContentPane().add(btnChangeColor);
		
		JButton btnChangeBackgroundColor = new JButton("Change Background Color");
		btnChangeBackgroundColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(frame, "Select background color", Color.WHITE);
				textArea.setBackground(color);
			}
		});
		btnChangeBackgroundColor.setBounds(374, 303, 200, 23);
		frame.getContentPane().add(btnChangeBackgroundColor);
		
	}
}
