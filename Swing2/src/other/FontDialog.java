package other;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FontDialog {

	JFrame frame;
	private Font font;
	
	public FontDialog() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFont = new JLabel("Font");
		lblFont.setBounds(52, 36, 46, 14);
		frame.getContentPane().add(lblFont);
		
		JLabel lblFontStyle = new JLabel("Font style");
		lblFontStyle.setBounds(183, 36, 75, 14);
		frame.getContentPane().add(lblFontStyle);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(311, 36, 46, 14);
		frame.getContentPane().add(lblSize);
		
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JComboBox cbFont = new JComboBox(fonts);
		cbFont.setBounds(52, 61, 107, 22);
		frame.getContentPane().add(cbFont);
		
		String styles[] = {"Plain", "Bold", "Italic"};
		JComboBox cbFontStyle = new JComboBox(styles);
		cbFontStyle.setBounds(183, 61, 83, 22);
		frame.getContentPane().add(cbFontStyle);
		
		Integer sizes[] = {8,9,10,11,12,14,16,18,20,22,24,26,28,36,48,72};
		JComboBox cbSize = new JComboBox(sizes);
		cbSize.setBounds(311, 61, 46, 22);
		frame.getContentPane().add(cbSize);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = (String) cbFont.getSelectedItem();
				String fs = (String) cbFontStyle.getSelectedItem();
				int style = 0;
				
				switch(fs) {
				case "Plain":
					style = 0;
					break;
				case "Bold":
					style = 1;
					break;
				case "Italic":
					style = 2;
					break;
				}
				
				int size = (int) cbSize.getSelectedItem();
				
				font = new Font(name, style, size);
				File_Font_Color.textArea.setFont(font);
				
				frame.setVisible(false);
			}
		});
		btnOk.setBounds(231, 228, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
			}
		});
		btnCancel.setBounds(335, 228, 89, 23);
		frame.getContentPane().add(btnCancel);
	}
	
	public Font getFont() {
		return font;
	}
}
