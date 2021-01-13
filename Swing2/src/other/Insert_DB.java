package other;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Insert_DB {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAge;
	private String url = "jdbc:sqlserver://FUJITSU\\localhost:1433;databaseName=dbtest;user=sa;password=12061";
	private JTable table;
	private JButton btnShow;
	private JScrollPane scrollPane;
	private JButton btnUpdate;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_DB window = new Insert_DB();
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
	public Insert_DB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(222, 184, 135));
		frame.setBounds(100, 100, 700, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Monaco", Font.PLAIN, 14));
		lblId.setBounds(39, 64, 46, 17);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Monaco", Font.PLAIN, 14));
		lblName.setBounds(39, 102, 46, 17);
		frame.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Monaco", Font.PLAIN, 14));
		lblAge.setBounds(39, 145, 46, 17);
		frame.getContentPane().add(lblAge);
		
		txtId = new JTextField();
		txtId.setBounds(110, 61, 144, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(110, 99, 144, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(110, 142, 144, 20);
		frame.getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DriverManager.getConnection(url);
					
					String sql = "insert into students values(?, ?, ?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, Integer.parseInt(txtId.getText()));
					stmt.setString(2, txtName.getText());
					stmt.setInt(3, Integer.parseInt(txtAge.getText()));
					
					int rows = stmt.executeUpdate();
					if(rows > 0) {
						JOptionPane.showMessageDialog(btnInsert, "Row has been inserted");
					}
					
					con.close();
					
				} catch (Exception e1) {
					
					if(e1 instanceof SQLServerException) {
						JOptionPane.showMessageDialog(btnInsert, "Student with the specified ID already exists.");
					}
					else if(e1 instanceof NumberFormatException) {
						JOptionPane.showMessageDialog(btnInsert, "ID is incorrect or empty.");
					}
				} 
			}
		});
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBackground(new Color(0, 0, 139));
		btnInsert.setFont(new Font("PF Square Sans Pro", Font.PLAIN, 12));
		btnInsert.setBounds(39, 200, 89, 23);
		frame.getContentPane().add(btnInsert);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(357, 61, 275, 161);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnShow = new JButton("Show");
		btnShow.setFont(new Font("PF Square Sans Pro", Font.PLAIN, 12));
		btnShow.setBackground(new Color(30, 144, 255));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = DriverManager.getConnection(url);
					
					String sql = "select * from students";
					Statement stmt = con.createStatement();
					ResultSet result = stmt.executeQuery(sql);
					
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("ID");
					model.addColumn("Name");
					model.addColumn("Age");
					
					while(result.next()) {
						int id = result.getInt("id");
						String name = result.getString("name");
						int age = result.getInt(3);
						
						model.addRow(new Object[] {id, name, age});
						table.setModel(model);
						
					}
					
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnShow.setBounds(357, 24, 89, 23);
		frame.getContentPane().add(btnShow);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection(url);
					
					String sql = "update students set name=?, age=? where id=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, txtName.getText());
					stmt.setInt(2, Integer.parseInt(txtAge.getText()));
					stmt.setInt(3, Integer.parseInt(txtId.getText()));
					
					int rows = stmt.executeUpdate();
					if(rows > 0) {
						JOptionPane.showMessageDialog(btnUpdate, "Row has been updated");
					}
					
					con.close();
					
				} catch (Exception e1) {
					
					if(e1 instanceof NumberFormatException) {
						JOptionPane.showMessageDialog(btnUpdate, "ID is incorrect or empty.");
					}
				} 
			}
		});
		btnUpdate.setBackground(new Color(255, 0, 255));
		btnUpdate.setFont(new Font("PF Square Sans Pro", Font.PLAIN, 12));
		btnUpdate.setBounds(138, 199, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection(url);
					
					String sql = "delete from students where id=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, Integer.parseInt(txtId.getText()));
					
					int rows = stmt.executeUpdate();
					if(rows > 0) {
						JOptionPane.showMessageDialog(btnDelete, "Row has been deleted.");
					}
					
					con.close();
					
				} catch (Exception e1) {
					
					if(e1 instanceof NumberFormatException) {
						JOptionPane.showMessageDialog(btnDelete, "ID is incorrect or empty.");
					}
				} 
			}
		});
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.setFont(new Font("PF Square Sans Pro", Font.PLAIN, 12));
		btnDelete.setBounds(237, 199, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
}
