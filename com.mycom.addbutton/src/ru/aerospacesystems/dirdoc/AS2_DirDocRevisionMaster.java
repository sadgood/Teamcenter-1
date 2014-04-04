package ru.aerospacesystems.dirdoc;

import com.teamcenter.rac.stylesheet.AbstractRendering;
import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCProperty;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.PropertyLayout;
import com.teamcenter.rac.util.VerticalLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ru.aerospacesystems.dirdoc.handlers.FileManager;
import ru.aerospacesystems.dirdoc.handlers.FileManager.*;

import java.awt.event.ActionListener;

public class AS2_DirDocRevisionMaster extends AbstractRendering
{
	private static final long serialVersionUID = 1L;
	private JTextField data1_jtextfield;
    public String stringData2;


	private JTable t1;
	private JTable t2;
	private static final Object[][] rowData = {{"Hello", "World"}};
	private static final Object[] columnNames = {"A", "B"};
	private DefaultTableModel model;
	private JButton addButton1;


	private TCProperty data1_tcproperty;

	private TCProperty as2_disignation_tcproperty;

	private TCComponentForm form;

public AS2_DirDocRevisionMaster( TCComponentForm c) throws Exception {
	super ( c );
	form = c;
	loadRendering();
}

@Override
public void loadRendering() throws TCException {

	System.out.println("inside custom loadRendering........");

	initializeUI();

	data1_tcproperty = form.getFormTCProperty("object_string");
	as2_disignation_tcproperty = form.getFormTCProperty("as2_disignation");
	stringData2  = as2_disignation_tcproperty.getStringValue();
	//stringData2 = /*"hhh"+form.getFormTCProperty("as2_disignation").getStringValue() +"____"+*/form.getFormTCProperty("object_string").getStringValue();
	data1_jtextfield.setText(data1_tcproperty.getStringValue());



}

@Override
public void saveRendering() {

	System.out.println("inside custom saveRendering........");

	try
	{
		data1_tcproperty.setStringValueData(data1_jtextfield.getText() );

		TCProperty[] ps = new TCProperty[2];
		ps[0] = data1_tcproperty;

		form.setTCProperties(ps);
		}
	catch ( TCException ex )
	{
		//MessageBox.post(ex.getMessage(), null, MessageBox.ERROR);
	}
}

@Override
public boolean isRenderingModified() {
	if( data1_tcproperty != null && !data1_jtextfield.getText().equals( data1_tcproperty.getStringValue() ) )
	{
		return true;
		}


	else
	{
		return false;
	}
}

@Override
public Map getRenderingModified () {
	Map modifiedRendering = new HashMap<String, Object> ();

	if( data1_tcproperty != null && !data1_jtextfield.getText().equals( data1_tcproperty.getStringValue() ) )
	{
		data1_tcproperty.setStringValueData(data1_jtextfield.getText() );
		modifiedRendering.put( "user_data_1", data1_tcproperty );
	}



	return modifiedRendering;
	}

private void initializeUI() {


	JPanel mainPanel = new JPanel();
	JPanel workPanel = new JPanel();
	setBounds(100, 100, 999, 522);
	 mainPanel.setBounds(100, 100, 999, 522);

	mainPanel.setOpaque(false);
	mainPanel.setEnabled(false);

	// Create all the text fields
	data1_jtextfield = new JTextField(15);


	//Add components to Panel

	data1_jtextfield.setFont(new Font("Tahoma", Font.BOLD, 13));
//	mainPanel.add("1.1.left.center", workPanel);
	GroupLayout gl_contentPane = new GroupLayout(mainPanel);
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

	t2 = new JTable();
	t2.scrollRectToVisible(t2.getCellRect(5, 5, true));


	data1_jtextfield = new JTextField();
	data1_jtextfield.setColumns(10);


	addButton1 = new JButton("add");
	addButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			  model.addRow(rowData[0]);
		}
	});

	JScrollPane scrollPane = new JScrollPane();

	JScrollPane scrollPane_1 = new JScrollPane();



	GroupLayout gl_workPanel = new GroupLayout(workPanel);
	gl_workPanel.setHorizontalGroup(
		gl_workPanel.createParallelGroup(Alignment.LEADING)
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
			.addGroup(Alignment.TRAILING, gl_workPanel.createSequentialGroup()
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


	final TCSession tcSession = (TCSession )AIFDesktop.getActiveDesktop().getCurrentApplication().getSession();
	TCComponent dirDoc;

	model = new DefaultTableModel(null, columnNames);

	l2.setText(stringData2+"___");

	try {

        String stringData = stringData2;
		dirDoc = FileManager.getDirDocRevision(tcSession, stringData);
		TCComponent[] related = FileManager.getRelated(dirDoc);

		for (int i=0; i<related.length; i++){
		String relatedID =related[i].getStringProperty("object_string");
		System.out.println(i+"====="+relatedID);

		 String[] parts = relatedID.split("/");

		 String[] parts2 = parts[1].split(";");
		 String[] parts3 = parts[1].split(";");


		model.addRow(new Object[]{parts[0], parts2[0], parts2[1]});
		}

	} catch (TCException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}


	t1.setModel(model);
	t2.setModel(model);
	add("unbound.bind", mainPanel);





}

}