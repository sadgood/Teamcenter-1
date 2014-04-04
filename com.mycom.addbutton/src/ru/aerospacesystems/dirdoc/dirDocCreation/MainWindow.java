package ru.aerospacesystems.dirdoc.dirDocCreation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import ru.aerospacesystems.dirdoc.handlers.FileManager;

import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;


public class MainWindow extends JFrame {

	private JPanel mainPanel;
	static MainWindow frame;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		final TCSession tcSession = (TCSession )AIFDesktop.getActiveDesktop().getCurrentApplication().getSession();
		setResizable(false);
		mainPanel = new JPanel();
		final JPanel contentPanel = new JPanel();
		contentPanel.setBounds(177, 0, 515, 380);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(5, 383, 687, 32);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);
        panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));



        final CardLayout cardLayout = new CardLayout();

        JButton exitlButton = new JButton("\u0412\u044B\u0445\u043E\u0434");
        exitlButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		 dispose();
        	}
        });
        ButtonGroup radioButtonGroup = new ButtonGroup();




		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 458);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		//

		//Изменяющаяся панель 2




		//Панель содержания
        contentPanel.setLayout(cardLayout);

        JPanel panel1 = new JPanel();
        panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel1.setBackground(UIManager.getColor("Button.background"));
        contentPanel.add(panel1, "panel1");

        final JLabel lblNewLabel = new JLabel("\u0421\u043B\u0443\u0436\u0435\u0431\u043D\u0430\u044F \u0437\u0430\u043F\u0438\u0441\u043A\u0430 \u2116");

        final JFormattedTextField idTextField = new JFormattedTextField();
        idTextField.setText("xxxxxxxxx");

 String mask = "#.###-####/##-##";

        MaskFormatter mf = null;
		try {
			mf = new MaskFormatter(mask);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        mf.install(idTextField);



        GroupLayout gl_panel1 = new GroupLayout(panel1);
        gl_panel1.setHorizontalGroup(
        	gl_panel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)

        			.addGap(114))
        );
        gl_panel1.setVerticalGroup(
        	gl_panel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
        					.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lblNewLabel)))
        );
        gl_panel1.setAutoCreateGaps(true);
        gl_panel1.setAutoCreateContainerGaps(true);
        panel1.setLayout(gl_panel1);
        contentPanel.add( panel2,"panel2" );
         mainPanel.setLayout(null);
         mainPanel.add(contentPanel);
         mainPanel.add(buttonPanel);

                 JButton okButton = new JButton("\u041E\u041A");

                 		 GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
                 		 gl_buttonPanel.setHorizontalGroup(
                 		 	gl_buttonPanel.createParallelGroup(Alignment.LEADING)
                 		 		.addGroup(gl_buttonPanel.createSequentialGroup()
                 		 			.addComponent(exitlButton, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                 		 			.addGap(315)
                 		 			.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                 		 			.addContainerGap())
                 		 );
                 		 gl_buttonPanel.setVerticalGroup(
                 		 	gl_buttonPanel.createParallelGroup(Alignment.LEADING)
                 		 		.addGroup(gl_buttonPanel.createSequentialGroup()
                 		 			.addGap(4)
                 		 			.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
                 		 				.addComponent(exitlButton)
                 		 				.addComponent(okButton)))
                 		 );
                 		 buttonPanel.setLayout(gl_buttonPanel);
         JPanel radioButtonPanel = new JPanel();
         radioButtonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
         radioButtonPanel.setBounds(0, 0, 178, 380);
         mainPanel.add(radioButtonPanel);
         JPanel panel11 = new JPanel();
         panel11.setBounds(2, 2, 174, 121);
         panel11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
         JPanel panel12 = new JPanel();
         panel12.setBounds(2, 134, 174, 76);
         panel12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
         JPanel panel13 = new JPanel();
         panel13.setBounds(2, 221, 174, 76);
         panel13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));



                 JLabel l1 = new JLabel("Выпуск и изменение КД");
                 JLabel l2 = new JLabel("Изменение применяемости");
                 JLabel l3 = new JLabel("СТОП");
                 final JRadioButton r1 = new JRadioButton("Первичный выпуск", true);
                 final JRadioButton r2 = new JRadioButton("Внесение изменений");
                 r2.setEnabled(false);
                 final JRadioButton r3 = new JRadioButton("Аннулирование");
                 r3.setEnabled(false);
                 final JRadioButton r4 = new JRadioButton("Выпуск ПИ");
                 r4.setEnabled(false);
                 final JRadioButton r5 = new JRadioButton("Расширение применяемости");
                 r5.setEnabled(false);
                 final JRadioButton r6 = new JRadioButton("Ограничение применяемости");
                 r6.setEnabled(false);
                 final  JRadioButton r7 = new JRadioButton("Выпуск СТОП");
                 final  JRadioButton r8 = new JRadioButton("Отмена действия СТОП");
                 r8.setEnabled(false);
                 radioButtonGroup.add(r1);
                 radioButtonGroup.add(r2);
                 radioButtonGroup.add(r3);
                 radioButtonGroup.add(r4);
                 radioButtonGroup.add(r5);
                 radioButtonGroup.add(r6);
                 radioButtonGroup.add(r7);
                 radioButtonGroup.add(r8);
                 panel11.setLayout(new BoxLayout(panel11, BoxLayout.PAGE_AXIS));
                 panel12.setLayout(new BoxLayout(panel12, BoxLayout.PAGE_AXIS));
                 panel13.setLayout(new BoxLayout(panel13, BoxLayout.PAGE_AXIS));
                 		radioButtonPanel.setLayout(null);

                 		radioButtonPanel.add( panel11 );
                 		//
                 		panel11.add(l1);
                 		panel11.add(r1);
                 		panel11.add(r2);
                 		panel11.add(r3);
                 		panel11.add(r4);
                 		//
                 		radioButtonPanel.add( panel12 );
                 		//
                 		panel12.add(l2);
                 		panel12.add(r5);
                 		panel12.add(r6);
                 		//
                 		radioButtonPanel.add( panel13 );
                 		//
                 		panel13.add(l3);
                 		panel13.add(r7);
                 		panel13.add(r8);
       //Основная панель
                 		  ActionListener a3 = new ActionListener(){
                              public void actionPerformed(ActionEvent ae) {


                              }
                          };


                 		  ActionListener al = new ActionListener(){
                              public void actionPerformed(ActionEvent ae) {
                                if (r1.isSelected()) {
                                      cardLayout.show(contentPanel, "panel1");
                                      lblNewLabel.setText("Служебная записка №");
                                  }
                                if (r7.isSelected()) {
                                    cardLayout.show(contentPanel, "panel1");
                                    lblNewLabel.setText("Служебная записка СТОП №");
                                }
                                if (r3.isSelected()) {
                                    cardLayout.show(contentPanel, "panel2");
                                }

                              }
                          };


                          ActionListener a2 = new ActionListener(){
                              public void actionPerformed(ActionEvent ae) {
                                if (r1.isSelected()) {
                                     try {


										FileManager.createDirDoc(tcSession ,idTextField.getText(), "Служебная записка");
										JOptionPane.showMessageDialog(null, "Служебная записка " +  idTextField.getText() + " создана");
										dispose();
									} catch (TCException e) {
										JOptionPane.showMessageDialog(null, e.toString() );
									}
                                  }
                                if (r7.isSelected()) {
                                    try {
										FileManager.createDirDoc(tcSession ,idTextField.getText(), "Служебная записка СТОП");
										JOptionPane.showMessageDialog(null, "Служебная записка СТОП " + " создана" );
										dispose();

									} catch (TCException e1) {
										JOptionPane.showMessageDialog(null, e1.toString() );
									}
                                 }


                              }
                          };
r1.addActionListener(al);
r2.addActionListener(al);
r7.addActionListener(al);
okButton.addActionListener(a2);




	}
}
