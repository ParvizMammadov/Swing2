import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;



public class Testing {

	public static void main(String[] args) throws IOException {
		JFrame f = new JFrame();
		
		JButton b1 = new JButton("Button 1");
		b1.setSize(100, 50);
		JButton b2 = new JButton("Button 2");
		b2.setSize(100, 50);
		JTextField[] field = new JTextField[15];
		
		for(int i=0; i<15; i++) {
			field[i] = new JTextField(20);
			f.add(field[i]);
		}
		
		f.add(b1);  f.add(b2);
		f.setLayout(new FlowLayout());
		f.setSize(300, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		File folder = new File("d:\\PrevOnDesktop");
		File file = new File("d:\\output1.txt");
		File dest = new File("d:\\output1new.txt");
		String abspath = file.getAbsolutePath(); // d:\output1.txt
		String cnnpath = file.getCanonicalPath();// D:\output1.txt
		long freeSpace = file.getFreeSpace();    // returns free space in bytes
		String name = file.getName();            // output1.txt
		String parent = file.getParent();        // d:\
		String path = file.getPath();            // d:\output1.txt
		long totalSpace = file.getTotalSpace();  // returns total space in bytes
		long usableSpace = file.getUsableSpace();// returns usable space in bytes
		long length = file.length();             // returns file size in bytes
		String[] list = folder.list();           // returns the list of all folders and files
		System.out.println(file.renameTo(dest)); // returns true upon success
		
		String pathSep = File.pathSeparator;     // ;
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				field[0].setText(abspath);
				field[1].setText(cnnpath);
				field[2].setText(String.valueOf(freeSpace));
				field[3].setText(name);
				field[4].setText(parent);
				field[5].setText(path);
				field[6].setText(String.valueOf(totalSpace));
				field[7].setText(String.valueOf(usableSpace));
				field[8].setText(String.valueOf(length));
				
				String s="";
				for(int i=0; i<list.length; i++) {
					s += list[i]+", ";
				}
				
				field[9].setText(s);
				field[10].setText(pathSep);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
