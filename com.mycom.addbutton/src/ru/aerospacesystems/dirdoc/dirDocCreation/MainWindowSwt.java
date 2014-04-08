package ru.aerospacesystems.dirdoc.dirDocCreation;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.nebula.widgets.formattedtext.NumberFormatter;
import org.eclipse.nebula.widgets.formattedtext.StringFormatter;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.nebula.widgets.formattedtext.MaskFormatter;

import ru.aerospacesystems.dirdoc.handlers.EffectivityObject;
import ru.aerospacesystems.dirdoc.handlers.FileManager;
import ru.aerospacesystems.dirdoc.handlers.GuiManager;
import ru.aerospacesystems.dirdoc.handlers.AttachedDocObject;
import ru.aerospacesystems.dirdoc.handlers.DirDocCreatAttachedDocModelProvider;
import ru.aerospacesystems.dirdoc.handlers.DirDocCreatEffectivityModelProvider;
import ru.aerospacesystems.dirdoc.handlers.SwitchButton;
import ru.aerospacesystems.dirdoc.handlers.TableManager;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput.TableForAttachedDocuments;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput.TableForEffectivity;

import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.aif.kernel.InterfaceAIFComponent;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCSession;

import org.eclipse.swt.widgets.Combo;

public class MainWindowSwt extends Shell {
	private FormattedText dirDocIdTextField;
	// private TableViewer viewer;
	// private TableViewer viewer2;
	  // static fields to hold the images
	 public final static String EDIT_MASK1 = "UU.UU-UUUU/UU-UU";
	 public final static String EDIT_MASK2 = "UU.UUUU.-UU-UUUU-UU.UU";



	private InterfaceAIFComponent pasteTargets[];
	private Text instanceField;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MainWindowSwt shell = new MainWindowSwt(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public MainWindowSwt(Display display) {
		super(display, SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX | SWT.ON_TOP);

		setImage(ResourceManager.getPluginImage("ru.aerospacesystems.dirdoc", "icons/dirDoc.gif"));
		setText("\u0421\u043E\u0437\u0434\u0430\u043D\u0438\u0435 \u0434\u0438\u0440\u0435\u043A\u0442\u0438\u0432\u043D\u043E\u0433\u043E \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u0430");
		final TCSession tcSession = (TCSession )AIFDesktop.getActiveDesktop().getCurrentApplication().getSession();



		setSize(828, 499);
		setLayout(new FormLayout());

		Composite composite = new Composite(this, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.right = new FormAttachment(0, 794);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new FormLayout());

		Composite ButtonComposite = new Composite(composite, SWT.BORDER);
		FormData fd_ButtonComposite = new FormData();
		fd_ButtonComposite.bottom = new FormAttachment(0, 444);
		fd_ButtonComposite.right = new FormAttachment(0, 210);
		fd_ButtonComposite.top = new FormAttachment(0, 269);
		fd_ButtonComposite.left = new FormAttachment(0);
		ButtonComposite.setLayoutData(fd_ButtonComposite);

		Button okButton = new Button(ButtonComposite, SWT.NONE);

		okButton.setBounds(10, 10, 186, 100);
		okButton.setText("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0414\u0414");

		Button cancelButton = new Button(ButtonComposite, SWT.NONE);
		cancelButton.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false, false));


		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		cancelButton.setBounds(10, 116, 186, 45);
		cancelButton.setText("\u0412\u044B\u0445\u043E\u0434");

		Composite radioButtonComposite = new Composite(composite, SWT.BORDER);
		FormData fd_radioButtonComposite = new FormData();
		fd_radioButtonComposite.bottom = new FormAttachment(0, 271);
		fd_radioButtonComposite.right = new FormAttachment(0, 210);
		fd_radioButtonComposite.top = new FormAttachment(0);
		fd_radioButtonComposite.left = new FormAttachment(0);
		radioButtonComposite.setLayoutData(fd_radioButtonComposite);


		Label label_2 = new Label(radioButtonComposite, SWT.NONE);
		label_2.setText("\u0412\u044B\u043F\u0443\u0441\u043A \u0438 \u0438\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u0435 \u041A\u0414");
		label_2.setBounds(10, 10, 139, 15);

		final Button rb1 = new Button(radioButtonComposite, SWT.RADIO);
		rb1.setSelection(true);
		rb1.setText("\u041F\u0435\u0440\u0432\u0438\u0447\u043D\u044B\u0439 \u0432\u044B\u043F\u0443\u0441\u043A");
		rb1.setBounds(10, 31, 129, 16);

		Button button = new Button(radioButtonComposite, SWT.RADIO);
		button.setText("\u041E\u0442\u043C\u0435\u043D\u0430 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044F \u0421\u0422\u041E\u041F");
		button.setEnabled(false);
		button.setBounds(10, 243, 151, 16);

		final Button rb7 = new Button(radioButtonComposite, SWT.RADIO);
		rb7.setText("\u0412\u044B\u043F\u0443\u0441\u043A \u0421\u0422\u041E\u041F");
		rb7.setBounds(10, 221, 98, 16);

		Label label = new Label(radioButtonComposite, SWT.NONE);
		label.setText("\u0421\u0422\u041E\u041F");
		label.setBounds(10, 200, 55, 15);

		Button button_2 = new Button(radioButtonComposite, SWT.RADIO);
		button_2.setText("\u041E\u0433\u0440\u0430\u043D\u0438\u0447\u0435\u043D\u0438\u0435 \u043F\u0440\u0438\u043C\u0435\u043D\u044F\u0435\u043C\u043E\u0441\u0442\u0438");
		button_2.setEnabled(false);
		button_2.setBounds(10, 170, 183, 16);

		Button button_3 = new Button(radioButtonComposite, SWT.RADIO);
		button_3.setText("\u0420\u0430\u0441\u0448\u0438\u0440\u0435\u043D\u0438\u0435 \u043F\u0440\u0438\u043C\u0435\u043D\u044F\u0435\u043C\u043E\u0441\u0442\u0438");
		button_3.setEnabled(false);
		button_3.setBounds(10, 148, 183, 16);

		Label label_1 = new Label(radioButtonComposite, SWT.NONE);
		label_1.setText("\u0418\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u0435 \u043F\u0440\u0438\u043C\u0435\u043D\u044F\u0435\u043C\u043E\u0441\u0442\u0438");
		label_1.setBounds(10, 127, 154, 15);

		Button button_4 = new Button(radioButtonComposite, SWT.RADIO);
		button_4.setText("\u0412\u044B\u043F\u0443\u0441\u043A \u041F\u0418");
		button_4.setEnabled(false);
		button_4.setBounds(10, 97, 90, 16);

		Button button_5 = new Button(radioButtonComposite, SWT.RADIO);
		button_5.setText("\u0410\u043D\u043D\u0443\u043B\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435");
		button_5.setEnabled(false);
		button_5.setBounds(10, 75, 139, 16);

		Button button_6 = new Button(radioButtonComposite, SWT.RADIO);
		button_6.setEnabled(false);
		button_6.setText("\u0412\u043D\u0435\u0441\u0435\u043D\u0438\u0435 \u0438\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u0439");
		button_6.setBounds(10, 53, 139, 16);

		Label label_3 = new Label(radioButtonComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(0, 192, 205, 2);

		Label label_4 = new Label(radioButtonComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(0, 119, 205, 2);

		final Composite contentComposite = new Composite(composite, SWT.NONE);
		FormData fd_contentComposite = new FormData();
		fd_contentComposite.bottom = new FormAttachment(0, 444);
		fd_contentComposite.right = new FormAttachment(0, 794);
		fd_contentComposite.top = new FormAttachment(0);
		fd_contentComposite.left = new FormAttachment(0, 216);
		contentComposite.setLayoutData(fd_contentComposite);
		final StackLayout stackLayout = new StackLayout();
		contentComposite.setLayout(stackLayout);



		final Composite composite1 = new Composite(contentComposite, SWT.BORDER);
		composite1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		final Composite composite2 = new Composite(contentComposite, SWT.NONE);
		composite2.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));

		Button button_1 = new Button(composite2, SWT.NONE);
		button_1.setBounds(473, 405, 75, 25);
		button_1.setText("New Button");


		stackLayout.topControl=composite1;
		composite1.setLayout(new FormLayout());

		Composite composite_1 = new Composite(composite1, SWT.BORDER | SWT.EMBEDDED);
		composite_1.setLayout(null);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(0);
		fd_composite_1.left = new FormAttachment(0, 10);
		fd_composite_1.right = new FormAttachment(100, -10);
		composite_1.setLayoutData(fd_composite_1);

		final CLabel labelComposite1 = new CLabel(composite_1, SWT.NONE);
		labelComposite1.setBounds(3, 3, 184, 21);
		labelComposite1.setText("\u0421\u043B\u0443\u0436\u0435\u0431\u043D\u0430\u044F \u0437\u0430\u043F\u0438\u0441\u043A\u0430 \u2116");

		dirDocIdTextField = new FormattedText(composite_1, SWT.BORDER);
		final Text text = dirDocIdTextField.getControl();
		text.setBounds(206, 3, 184, 21);

		dirDocIdTextField.setFormatter(new MaskFormatter(EDIT_MASK1));

		Composite composite_2 = new Composite(composite1, SWT.NONE);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite_2 = new FormData();
		fd_composite_2.left = new FormAttachment(0, 10);
		fd_composite_2.right = new FormAttachment(100, -10);

		final SwitchButton button2 = new SwitchButton(composite_1, SWT.NONE);
		button2.setBounds(399, 0, 151, 37);
		button2.setText("");
		button2.setTextForSelect("\"ОКБ \"АКС\"");
		button2.setTextForUnselect("16");
		dirDocIdTextField.setValue("XXXXXXXXXXXX");
		button2.addSelectionListener(new SelectionListener() {
		        @Override
		        public void widgetSelected(final SelectionEvent e) {
		                if (button2.getSelection() == false){
		                	dirDocIdTextField.setFormatter(new MaskFormatter(EDIT_MASK2));
		                	dirDocIdTextField.setValue("XXXXXXXXXXXXXXXX");

		                }
		                else if (button2.getSelection() == true){
		                	dirDocIdTextField.setFormatter(new MaskFormatter(EDIT_MASK1));
		                	dirDocIdTextField.setValue("XXXXXXXXXXXX");

		                }
		        }

		        @Override
		        public void widgetDefaultSelected(final SelectionEvent e) {
		        }
		});
		composite_2.setLayoutData(fd_composite_2);
		Composite composite_3 = new Composite(composite1, SWT.NONE);

		final TableForAttachedDocuments tableForAttachedDocuments	= new  TableForAttachedDocuments();
		tableForAttachedDocuments.createPartControl(composite_2);


		final TableForEffectivity tableForEffectivity =new  TableForEffectivity();
		tableForEffectivity.createPartControl(composite_3);
		try {
			TableManager.ClearEnum1(tableForAttachedDocuments.getViewer());
			TableManager.ClearEnum2(tableForEffectivity.getViewer());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Button addButton = new Button(composite1, SWT.NONE);
		fd_composite_2.bottom = new FormAttachment(addButton, -6);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

		String[][] selectedForTable = FileManager.getSelectedObject();
		boolean  isCloneExist = false;
		try {


			for (int i=0; i < selectedForTable.length; i++){
				 DirDocCreatAttachedDocModelProvider persons = DirDocCreatAttachedDocModelProvider.INSTANCE;
				 System.out.println("Dlina "+ persons.ModelProviderSize());



				 for (int i2=0; i2 < persons.ModelProviderSize(); i2++){

					 String id = tableForAttachedDocuments.getColumn(i2).getIdentifier();
					 String rev = tableForAttachedDocuments.getColumn(i2).getRevision();
					 String Id = selectedForTable[i][1];
					 String Rev = selectedForTable[i][2];




					 if (id.equals(Id) && rev.equals(Rev)){
						 System.out.println("True");
							isCloneExist = true;
						break;
		}
					 else if (!id.equals(Id) || !rev.equals(Rev))
					 {
						 System.out.println("False");
						 isCloneExist = false;
					 }
					 }

          if ( isCloneExist == false){
        	  TCComponent selectedObject =  FileManager.getDirDocRevision2(tcSession, selectedForTable[i][1], selectedForTable[i][2]);
        	  String Id = selectedForTable[i][1];
			  String Rev = selectedForTable[i][2];
			  String Desc = selectedObject.getStringProperty("object_desc");
			tableForAttachedDocuments.pasteRow(Id,Desc,Rev,"Отсутствует");

          }
			}
			}





		 catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}





			        }

			    });
		FormData fd_addButton = new FormData();
		fd_addButton.right = new FormAttachment(100, -305);
		fd_addButton.left = new FormAttachment(0, 10);
		fd_addButton.bottom = new FormAttachment(100, -10);
		addButton.setLayoutData(fd_addButton);
		addButton.setText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");

		Button removeButton = new Button(composite1, SWT.NONE);
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 ISelection selection = tableForAttachedDocuments.getViewer().getSelection();

					    if (selection != null && selection instanceof IStructuredSelection) {
					      List<AttachedDocObject> persons = DirDocCreatAttachedDocModelProvider.INSTANCE.getPersons();
					      IStructuredSelection sel = (IStructuredSelection) selection;

					      for (Iterator<AttachedDocObject> iterator = sel.iterator(); iterator.hasNext();) {
					        AttachedDocObject person = iterator.next();
					        persons.remove(person);
					      }
					      tableForAttachedDocuments.getViewer().refresh();
					    }
			}
		});
		FormData fd_removeButton = new FormData();
		fd_removeButton.top = new FormAttachment(addButton, 0, SWT.TOP);
		fd_removeButton.right = new FormAttachment(100, -10);
		fd_removeButton.left = new FormAttachment(0, 316);
		removeButton.setLayoutData(fd_removeButton);
		removeButton.setText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");


		fd_composite_2.top = new FormAttachment(0, 137);
		FormData fd_composite_3 = new FormData();
		fd_composite_3.bottom = new FormAttachment(composite_2, -6);
		fd_composite_3.top = new FormAttachment(composite_1, 6);
		fd_composite_3.left = new FormAttachment(0, 10);
		composite_3.setLayoutData(fd_composite_3);

		Label lblNewLabel = new Label(composite1, SWT.NONE);
		fd_composite_3.right = new FormAttachment(lblNewLabel, -6);
		fd_composite_1.bottom = new FormAttachment(100, -396);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.left = new FormAttachment(0, 340);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("\u041F\u0440\u0438\u043C\u0435\u043D\u044F\u0435\u043C\u043E\u0441\u0442\u044C");

		final Combo itemField = new Combo(composite1, SWT.NONE);
		itemField.setItems(new String[] {"MC-21", "ST-21"});
		fd_lblNewLabel.bottom = new FormAttachment(100, -377);
		FormData fd_itemField = new FormData();
		fd_itemField.left = new FormAttachment(composite_3, 6);
		fd_itemField.top = new FormAttachment(lblNewLabel, 6);
		itemField.setLayoutData(fd_itemField);

		instanceField = new Text(composite1, SWT.BORDER);
		FormData fd_instanceField = new FormData();
		fd_instanceField.top = new FormAttachment(lblNewLabel, 6);
		fd_instanceField.right = new FormAttachment(composite_1, 0, SWT.RIGHT);
		fd_instanceField.left = new FormAttachment(itemField, 6);
		instanceField.setLayoutData(fd_instanceField);

		Button btnNewButton = new Button(composite1, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					TableManager.PasteColumn2(itemField.getText(),instanceField.getText(), tableForEffectivity.getViewer());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(composite_2, -31, SWT.TOP);
		fd_btnNewButton.bottom = new FormAttachment(composite_2, -6);
		fd_btnNewButton.left = new FormAttachment(composite_3, 6);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");

		Button btnNewButton_1 = new Button(composite1, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tableForEffectivity.getViewer().getSelection();

			    if (selection != null && selection instanceof IStructuredSelection) {
			      List<EffectivityObject> persons = DirDocCreatEffectivityModelProvider.INSTANCE.getPersons();
			      IStructuredSelection sel = (IStructuredSelection) selection;

			      for (Iterator<EffectivityObject> iterator = sel.iterator(); iterator.hasNext();) {
			    	  EffectivityObject person = iterator.next();
			        persons.remove(person);
			      }
			      tableForAttachedDocuments.getViewer().refresh();
			    }
			}
		});
		fd_btnNewButton.right = new FormAttachment(btnNewButton_1, -6);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.bottom = new FormAttachment(composite_2, -6);
		fd_btnNewButton_1.right = new FormAttachment(composite_1, 0, SWT.RIGHT);
		fd_btnNewButton_1.left = new FormAttachment(0, 458);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");


		rb7.addListener (SWT.Selection, new Listener () {
			@Override
			public void handleEvent(Event arg0) {
				if (rb7.getSelection() != true) {
					labelComposite1.setText("Служебная записка № ");
				contentComposite.layout();
				}
				if (rb1.getSelection() != true) {
					labelComposite1.setText("Служебная записка СТОП № ");

					}
			}

			});























		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String dirDocId = dirDocIdTextField.getControl().getText();
				 DirDocCreatAttachedDocModelProvider persons = DirDocCreatAttachedDocModelProvider.INSTANCE;
				 DirDocCreatEffectivityModelProvider persons2 = DirDocCreatEffectivityModelProvider.INSTANCE;
				if (rb7.getSelection() != true) {
					TCComponent dirDocRevision = null;


					 //						 //Создание ДД
											try {
												FileManager.createDirDoc(tcSession ,dirDocId, "Служебная записка");

												 //Создание PDF в ДД
											FileManager.createDataset(tcSession, "PDF", dirDocId);
											FileManager.createDataset(tcSession, "MSWORD", dirDocId);
					//

					//								 //ДД в ньюстафф
					FileManager.pasteItem(tcSession, FileManager.getDirDoc(tcSession, dirDocIdTextField.getControl().getText()));
												//свзяь ДД т ПДФ
					dirDocRevision = FileManager.getDirDocRevision(tcSession, dirDocIdTextField.getControl().getText());
													dirDocRevision .add("IMAN_specification",FileManager.getDirDocDataset(tcSession, dirDocIdTextField.getControl().getText(), "PDF") );
													dirDocRevision .add("IMAN_specification",FileManager.getDirDocDataset(tcSession, dirDocIdTextField.getControl().getText(), "MSWORD") );
													GuiManager.infoMessage("Успешное создания директивного документа", "Служебная записка № " + dirDocIdTextField.getControl().getText() + " успешно создана", getShell());
                                                    String effectivityString = new String();

                                                    if (persons2.ModelProviderSize() != 0 ){

                                                    effectivityString =  TableManager.getColumn2(0).getItem()+ "#" + TableManager.getColumn2(0).getInstantces();
                                                    }
													for (int i=1; i < persons2.ModelProviderSize(); i++){
														effectivityString = effectivityString + "/" + TableManager.getColumn2(i).getItem()+ "#" + TableManager.getColumn2(i).getInstantces();
													}

														dirDocRevision.setStringProperty("gov_classification", effectivityString);

											} catch (Exception e1) {


												try {
													GuiManager.errorMessage("Ошибка создания директивного документа", e1.toString(), getShell());
													e1.printStackTrace();
												} catch (Exception e3) {

												}






	}
											try {
											for (int i=0; i < persons.ModelProviderSize(); i++){
												dirDocRevision = FileManager.getDirDocRevision(tcSession, dirDocIdTextField.getControl().getText());
													TCComponent otherFileRev =FileManager.getDirDocRevision2(tcSession, TableManager.getColumn(i).getIdentifier(), TableManager.getColumn(i).getRevision());
													otherFileRev.add("AS2_guidingdocuments", dirDocRevision);
													dirDocRevision.add("AS2_AttachedDoc", otherFileRev);


											}dispose();} catch (Exception e1) {
													try {
														GuiManager.errorMessage("Ошибка прикрепления прилагаемых документов", e1.toString(), getShell());
													} catch (Exception e3) {

													}


													}

			//////////////////////////


													// TODO Auto-generated catch block



			}
			}
		});






	}
/////////////TABLE1

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Директивные документы");
		setSize(812, 483);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}


















}