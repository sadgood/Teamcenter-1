// ----------  рабочий вариант
/*---------
package com.mycom.addbutton.jFrame;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class jFrame extends JFrame{//Наследуя от JFrame мы получаем всю функциональность окна

	  private JLabel LabelVipuskKD;
	  private JLabel LabelChangePrim;
	  private JLabel countLabel2;
	  private JButton NextStep;
	  private JButton CloseBtn;
	  private JRadioButton RadiobtnPervichVipusk;
	 
	
	 
	  public jFrame(){
	    super("Директивный документ"); //Заголовок окна
	    setBounds(100, 100, 600, 600); //Если не выставить размер и положение - то окно будет мелкое и незаметное
	  
	    LabelVipuskKD = new JLabel("Crows:");
	    LabelChangePrim = new JLabel("Label");
	    countLabel2 = new JLabel("2 Label");
	    RadiobtnPervichVipusk = new JRadioButton ("Первичная документация");
	   
	    NextStep = new JButton("Далее");
	    CloseBtn = new JButton("Закрыть");
	  //Подготавливаем временные компоненты
	    JPanel buttonsPanel = new JPanel(new FlowLayout()); 
	    //Расставляем компоненты по местам
	    
	    add(LabelVipuskKD,BorderLayout.EAST); 
	    
	    
	    
	    add(LabelChangePrim, BorderLayout.NORTH);
	    add(countLabel2, BorderLayout.EAST);
	    add(RadiobtnPervichVipusk, BorderLayout.CENTER);
	    
	    buttonsPanel.add(NextStep);
	    buttonsPanel.add(CloseBtn);
	 
	    add(buttonsPanel, BorderLayout.SOUTH);
	  
	  
	  }
	 		
	  
	  
	  
	}//jFrame
	
	
-----------*/


package com.mycom.addbutton.jFrame;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class jFrame extends JFrame {// Наследуя от JFrame мы получаем всю
									// функциональность окна

	private final ButtonGroup buttonGroup = new ButtonGroup();

	public jFrame() {

		setTitle("Директивный документ");
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setSize(500, 500);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Выпуск и изменение КД");
		label.setBounds(68, 0, 158, 17);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label);

		JRadioButton RadioButtonPervVipusk = new JRadioButton(
				"Первичный выпуск");
		buttonGroup.add(RadioButtonPervVipusk);
		RadioButtonPervVipusk.setBounds(0, 25, 140, 25);

		RadioButtonPervVipusk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		RadioButtonPervVipusk.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButtonPervVipusk.setSelected(true);
		getContentPane().add(RadioButtonPervVipusk);

		JRadioButton RadioButtonPrimenChange = new JRadioButton(
				"Внесение изменений");
		buttonGroup.add(RadioButtonPrimenChange);
		RadioButtonPrimenChange.setBounds(0, 55, 140, 25);
		RadioButtonPrimenChange.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(RadioButtonPrimenChange);

		JRadioButton RadioButtonAnnulirovanie = new JRadioButton(
				"Аннулирование");
		buttonGroup.add(RadioButtonAnnulirovanie);
		RadioButtonAnnulirovanie.setBounds(0, 85, 150, 25);
		RadioButtonAnnulirovanie
				.setHorizontalAlignment(SwingConstants.TRAILING);
		RadioButtonAnnulirovanie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(RadioButtonAnnulirovanie);

		JRadioButton RadioButtonVipuskPI = new JRadioButton("Выпуск ПИ");
		buttonGroup.add(RadioButtonVipuskPI);
		RadioButtonVipuskPI.setBounds(0, 112, 93, 25);
		RadioButtonVipuskPI.setHorizontalAlignment(SwingConstants.TRAILING);
		RadioButtonVipuskPI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(RadioButtonVipuskPI);

		JLabel label_1 = new JLabel("Изменение применяемости");
		label_1.setBounds(59, 142, 176, 17);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_1);

		JRadioButton RadioButtonRasshirPrim = new JRadioButton(
				"Расширение применяемости");
		buttonGroup.add(RadioButtonRasshirPrim);
		RadioButtonRasshirPrim.setBounds(0, 164, 191, 25);
		RadioButtonRasshirPrim.setHorizontalAlignment(SwingConstants.TRAILING);
		RadioButtonRasshirPrim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(RadioButtonRasshirPrim);

		JRadioButton RadioButtonOgranPrim = new JRadioButton(
				"Ограничение применяемости");
		buttonGroup.add(RadioButtonOgranPrim);
		RadioButtonOgranPrim.setBounds(0, 194, 195, 25);
		RadioButtonOgranPrim.setHorizontalAlignment(SwingConstants.TRAILING);
		RadioButtonOgranPrim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(RadioButtonOgranPrim);

		JLabel label_2 = new JLabel("СТОП");
		label_2.setBounds(59, 224, 176, 17);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_2);

		JRadioButton RadioButtonVipuskStop = new JRadioButton("Выпуск СТОП");
		buttonGroup.add(RadioButtonVipuskStop);
		RadioButtonVipuskStop.setBounds(0, 246, 191, 25);
		RadioButtonVipuskStop.setHorizontalAlignment(SwingConstants.LEFT);
		RadioButtonVipuskStop.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(RadioButtonVipuskStop);

		JRadioButton RadioButtonOtmenaStop = new JRadioButton(
				"Отмена действия СТОП");
		buttonGroup.add(RadioButtonOtmenaStop);
		RadioButtonOtmenaStop.setBounds(0, 276, 195, 25);
		RadioButtonOtmenaStop.setHorizontalAlignment(SwingConstants.LEFT);
		RadioButtonOtmenaStop.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(RadioButtonOtmenaStop);

		JButton btnNewButton = new JButton("Отмена");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(40, 333, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Далее");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1.setBounds(175, 332, 89, 23);
		getContentPane().add(btnNewButton_1);
	}

}// jFrame

