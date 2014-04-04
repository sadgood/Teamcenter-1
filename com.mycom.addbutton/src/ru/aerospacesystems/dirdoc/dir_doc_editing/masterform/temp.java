package ru.aerospacesystems.dirdoc.dir_doc_editing.masterform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

public class temp extends JFrame {

	private JPanel contentPane;
	private JTextField data1_jtextfield;
	private static final Object[][] rowData = {{"Hello", "World"}};
	private static final Object[] columnNames = {"A", "B"};
	private DefaultTableModel model;
	private JButton addButton1;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable t1;
	private JTable t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp frame = new temp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public temp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel workPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(workPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(workPanel, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
		);


		JLabel l2 = new JLabel("Применяемость");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 14));


		data1_jtextfield = new JTextField();
		data1_jtextfield.setColumns(10);

		addButton1 = new JButton("add");
		addButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  model.addRow(rowData[0]);
			}
		});

		scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();



		GroupLayout gl_workPanel = new GroupLayout(workPanel);
		gl_workPanel.setHorizontalGroup(
			gl_workPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_workPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(addButton1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(732, Short.MAX_VALUE))
				.addGroup(gl_workPanel.createSequentialGroup()
					.addGap(394)
					.addGroup(gl_workPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(l2)
						.addComponent(data1_jtextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(467))
				.addGroup(gl_workPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_workPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE))
					.addGap(14))
		);
		gl_workPanel.setVerticalGroup(
			gl_workPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_workPanel.createSequentialGroup()
					.addGap(21)
					.addComponent(data1_jtextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(l2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addButton1)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		t2 = new JTable();
		t2.setEnabled(false);
		scrollPane_1.setViewportView(t2);

		t1 = new JTable();
		t1.setEnabled(false);
		scrollPane.setViewportView(t1);


		workPanel.setLayout(gl_workPanel);
		contentPane.setLayout(gl_contentPane);
		model = new DefaultTableModel(rowData, columnNames);
		t1.setModel(model);
		t2.setModel(model);

	}
}
