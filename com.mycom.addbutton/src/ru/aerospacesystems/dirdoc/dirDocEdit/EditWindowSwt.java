package ru.aerospacesystems.dirdoc.dirDocEdit;

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

import ru.aerospacesystems.dirdoc.handlers.DirDocEditAttachedDocModelProvider;
import ru.aerospacesystems.dirdoc.handlers.DirDocEditEffectivityModelProvider;
import ru.aerospacesystems.dirdoc.handlers.EffectivityObject;
import ru.aerospacesystems.dirdoc.handlers.FileManager;
import ru.aerospacesystems.dirdoc.handlers.GuiManager;
import ru.aerospacesystems.dirdoc.handlers.AttachedDocObject;
import ru.aerospacesystems.dirdoc.handlers.DirDocCreatModelProvider;
import ru.aerospacesystems.dirdoc.handlers.DirDocCreatModelProvider2;
import ru.aerospacesystems.dirdoc.handlers.SwitchButton;
import ru.aerospacesystems.dirdoc.handlers.TableManager;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput.EditTableForAttachedDocuments;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput.EditTableForEffectivity;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput.TableForAttachedDocuments;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput.TableForEffectivity;

import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.aif.kernel.InterfaceAIFComponent;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentQuery;
import com.teamcenter.rac.kernel.TCComponentQueryType;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;

import org.eclipse.swt.widgets.Combo;

public class EditWindowSwt extends Shell {
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
			EditWindowSwt shell = new EditWindowSwt(display);
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
	public EditWindowSwt(Display display) {
		super(display, SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX | SWT.ON_TOP);

		setImage(ResourceManager.getPluginImage("ru.aerospacesystems.dirdoc", "icons/dirDoc.gif"));
		setText("\u0421\u043E\u0437\u0434\u0430\u043D\u0438\u0435 \u0434\u0438\u0440\u0435\u043A\u0442\u0438\u0432\u043D\u043E\u0433\u043E \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u0430");
		final TCSession tcSession = (TCSession )AIFDesktop.getActiveDesktop().getCurrentApplication().getSession();



		setSize(567, 536);
		setLayout(new FormLayout());

		Composite composite = new Composite(this, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100);
		fd_composite.right = new FormAttachment(0, 794);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new FormLayout());

				final Composite contentComposite = new Composite(composite, SWT.NONE);
				contentComposite.setLayoutData(new FormData());
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

																final CLabel editedDirDocLabel = new CLabel(composite_1, SWT.NONE);
																editedDirDocLabel.setBounds(3, 3, 184, 21);

																editedDirDocLabel.setText(FileManager.getSelectedObject()[0][1]);

																Composite composite_2 = new Composite(composite1, SWT.NONE);
																composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
																FormData fd_composite_2 = new FormData();
																fd_composite_2.left = new FormAttachment(0, 10);
																fd_composite_2.right = new FormAttachment(100, -10);
																composite_2.setLayoutData(fd_composite_2);
																Composite composite_3 = new Composite(composite1, SWT.NONE);


																final EditTableForAttachedDocuments editTableForAttachedDocuments = new EditTableForAttachedDocuments();
																final EditTableForEffectivity editTableForEffectivity = new EditTableForEffectivity();
																try {
																	TableManager.ClearEnum3(editTableForAttachedDocuments.getViewer());
																} catch (Exception e2) {
																	// TODO Auto-generated catch block
																	e2.printStackTrace();
																}
																editTableForAttachedDocuments.createPartControl(composite_2);
																editTableForEffectivity.createPartControl(composite_3);
																TCComponent dirDocRel = null;
																try {
																	dirDocRel = FileManager.getDirDocRevision(tcSession, editedDirDocLabel.getText());
																} catch (TCException e2) {
																	// TODO Auto-generated catch block
																	e2.printStackTrace();
																}

																try {

																	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+ dirDocRel.getStringProperty("object_string"));
																	TCComponent[] related = FileManager.getRelated(dirDocRel);


																for (int i=0; i<related.length; i++){

																		String relatedID =related[i].getStringProperty("object_string");
																		 String[] parts = relatedID.split("/");

																	 String[] parts2 = parts[1].split(";");
																 String[] parts3 = parts[1].split(";");


																		 TableManager.PasteColumn3(parts[0], parts2[0], parts2[1], editTableForAttachedDocuments.getViewer());
																		}


																	String effectivityString = dirDocRel.getStringProperty("gov_classification");
																	String[] rowEffectivityArray = effectivityString.split("/");
																	for (int i = 0; i < rowEffectivityArray.length; i++){
																		String[] cellEffectivityMassive = rowEffectivityArray[i].split("#");
																		TableManager.PasteColumn4(cellEffectivityMassive[0], cellEffectivityMassive[1], editTableForEffectivity.getViewer());

																	}



																} catch (Exception e1) {
																	// TODO Auto-generated catch block
																	e1.printStackTrace();
																}




																				fd_composite_2.top = new FormAttachment(composite_3, 6);
																				final Combo itemField = new Combo(composite1, SWT.NONE);
																		Button addButton = new Button(composite1, SWT.NONE);
																		fd_composite_2.bottom = new FormAttachment(addButton, -6);
																		addButton.addSelectionListener(new SelectionAdapter() {
																			@Override
																			public void widgetSelected(SelectionEvent e) {
																				String[][] selectedForTable = FileManager.getSelectedObject();
																				boolean isCloneExist = false;
																				try {


																					for (int i=0; i < selectedForTable.length; i++){
																						 DirDocEditAttachedDocModelProvider persons = DirDocEditAttachedDocModelProvider.INSTANCE;
																						 System.out.println("Dlina "+ persons.ModelProviderSize());



																						 for (int i2=0; i2 < persons.ModelProviderSize(); i2++){
																							 System.out.println("Razmer = " + persons.ModelProviderSize() + "  Index = " + i2);
																							 String id = TableManager.getColumn3(i2).getFirstName();
																							 String rev = TableManager.getColumn3(i2).getLastName();
																							 String ID = selectedForTable[i][1];
																							 String REV = selectedForTable[i][2];




																							 if (id.equals(ID) & rev.equals(REV)){
																								 System.out.println("True");
																									isCloneExist = true;
																								break;
																				}
																							 else if (!id.equals(ID) || !rev.equals(REV))
																							 {
																								 System.out.println("False");
																								 isCloneExist = false;
																							 }
																							 }

																		          if ( isCloneExist == false){
																					TableManager.PasteColumn3(selectedForTable[i][1],selectedForTable[i][2],"Отсутствует",editTableForAttachedDocuments.getViewer());
																					TCComponent addAttachedDoc = FileManager.getDirDocRevision2(tcSession, selectedForTable[i][1], selectedForTable[i][2]);
																					  TCComponent dirDocRel = FileManager.getDirDocRevision(tcSession, editedDirDocLabel.getText());
																				        dirDocRel.add("AS2_AttachedDoc", addAttachedDoc);
																				        addAttachedDoc.add("AS2_guidingdocuments", dirDocRel);
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
																						 ISelection selection = editTableForAttachedDocuments.getViewer().getSelection();

																						    if (selection != null && selection instanceof IStructuredSelection) {
																						      List<AttachedDocObject> persons = DirDocEditAttachedDocModelProvider.INSTANCE.getPersons();
																						      IStructuredSelection sel = (IStructuredSelection) selection;

																						      for (Iterator<AttachedDocObject> iterator = sel.iterator(); iterator.hasNext();) {
																						        AttachedDocObject person = iterator.next();
																						        String idString = person.getFirstName();
																						        String revString = person.getLastName();
																						        TCComponent removedAttachedDoc;
																								try {
																									removedAttachedDoc = FileManager.getDirDocRevision2(tcSession, idString, revString);
																									  TCComponent dirDocRel = FileManager.getDirDocRevision(tcSession, editedDirDocLabel.getText());
																								        dirDocRel.remove("AS2_AttachedDoc", removedAttachedDoc);
																								        removedAttachedDoc.remove("AS2_guidingdocuments", dirDocRel);
																								} catch (TCException e1) {
																									// TODO Auto-generated catch block
																									e1.printStackTrace();
																								}

																						        persons.remove(person);
																						      }
																						      editTableForAttachedDocuments.getViewer().refresh();
																						    }
																				}
																			});
																				FormData fd_removeButton = new FormData();
																				fd_removeButton.top = new FormAttachment(addButton, 0, SWT.TOP);
																				fd_removeButton.right = new FormAttachment(100, -10);
																				fd_removeButton.left = new FormAttachment(0, 316);
																				removeButton.setLayoutData(fd_removeButton);
																				removeButton.setText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
																						FormData fd_composite_3 = new FormData();
																						fd_composite_3.top = new FormAttachment(composite_1, 6);
																						fd_composite_3.left = new FormAttachment(0, 10);
																						composite_3.setLayoutData(fd_composite_3);

																								Label lblNewLabel = new Label(composite1, SWT.NONE);
																								fd_composite_3.right = new FormAttachment(lblNewLabel, -6);
																								fd_composite_1.bottom = new FormAttachment(100, -436);
																								FormData fd_lblNewLabel = new FormData();
																								fd_lblNewLabel.left = new FormAttachment(0, 340);
																								fd_lblNewLabel.top = new FormAttachment(composite_1, 6);
																								lblNewLabel.setLayoutData(fd_lblNewLabel);
																								lblNewLabel.setText("\u041F\u0440\u0438\u043C\u0435\u043D\u044F\u0435\u043C\u043E\u0441\u0442\u044C");


																										itemField.setItems(new String[] {"MC-21", "ST-21"});
																										FormData fd_itemField = new FormData();
																										fd_itemField.left = new FormAttachment(composite_3, 6);
																										fd_itemField.top = new FormAttachment(lblNewLabel, 6);
																										itemField.setLayoutData(fd_itemField);

																												instanceField = new Text(composite1, SWT.BORDER);
																												FormData fd_instanceField = new FormData();
																												fd_instanceField.top = new FormAttachment(lblNewLabel, 6);
																												fd_instanceField.left = new FormAttachment(itemField, 6);
																												fd_instanceField.right = new FormAttachment(100, -10);
																												instanceField.setLayoutData(fd_instanceField);

																														Button btnNewButton = new Button(composite1, SWT.NONE);
																														fd_composite_3.bottom = new FormAttachment(btnNewButton, 0, SWT.BOTTOM);
																														btnNewButton.addSelectionListener(new SelectionAdapter() {
																															@Override
																															public void widgetSelected(SelectionEvent e) {
																																try {
																																	 DirDocEditEffectivityModelProvider effPersons = DirDocEditEffectivityModelProvider.INSTANCE;
																																	
																																	TableManager.PasteColumn4(itemField.getText(), instanceField.getText(), editTableForEffectivity.getViewer());
																																	TCComponent dirDocRevision = FileManager.getDirDocRevision(tcSession, editedDirDocLabel.getText());
///////////////////////////
																																	
																														             String effectivityString = new String();
																				                                                      
																					                                                    if (effPersons.ModelProviderSize() != 0 ){
																					                                                    
																					                                                    effectivityString =  TableManager.getColumn4(0).getFirstName()+ "#" + TableManager.getColumn4(0).getLastName();
																					                                                    }
																																		for (int i=1; i < effPersons.ModelProviderSize(); i++){
																																			effectivityString = effectivityString + "/" + TableManager.getColumn4(i).getFirstName()+ "#" + TableManager.getColumn4(i).getLastName();
																																		}

																																			dirDocRevision.setStringProperty("gov_classification", effectivityString);

																																} catch (Exception e1) {
																																	e1.printStackTrace();
																																	
																																	
																																}
																															}
																														});
																														FormData fd_btnNewButton = new FormData();
																														fd_btnNewButton.left = new FormAttachment(composite_3, 6);
																														fd_btnNewButton.top = new FormAttachment(itemField, 6);
																														btnNewButton.setLayoutData(fd_btnNewButton);
																														btnNewButton.setText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");

																																Button btnNewButton_1 = new Button(composite1, SWT.NONE);
																																btnNewButton_1.addSelectionListener(new SelectionAdapter() {
																																	@Override
																																	public void widgetSelected(SelectionEvent e) {
																																		ISelection selection = editTableForEffectivity.getViewer().getSelection();

																																	    if (selection != null && selection instanceof IStructuredSelection) {
																																	      List<EffectivityObject> persons = DirDocEditEffectivityModelProvider.INSTANCE.getPersons();
																																	      IStructuredSelection sel = (IStructuredSelection) selection;

																																	      for (Iterator<EffectivityObject> iterator = sel.iterator(); iterator.hasNext();) {
																																	    	  EffectivityObject person = iterator.next();
																																	    	  TCComponent dirDocRel;
																																			try {
																																				dirDocRel = FileManager.getDirDocRevision(tcSession, editedDirDocLabel.getText());
																																				String effectivityStringFromPoperty = dirDocRel.getStringProperty("gov_classification");
																																		    	 dirDocRel.setStringProperty("gov_classification", effectivityStringFromPoperty.replace(person.getFirstName()+"#"+person.getLastName()+"/","") );
																																		    	 dirDocRel.setStringProperty("gov_classification", effectivityStringFromPoperty.replace(person.getFirstName()+"#"+person.getLastName(),"") );
																																		    	 effectivityStringFromPoperty = dirDocRel.getStringProperty("gov_classification");
																																		    	 if (effectivityStringFromPoperty.length() < 4){
																																		    		 dirDocRel.setStringProperty("gov_classification", effectivityStringFromPoperty.replace("/","") );
																																		    	 }


																																			} catch (TCException e1) {
																																				// TODO Auto-generated catch block
																																				e1.printStackTrace();
																																			}

																																	        persons.remove(person);
																																	      }


																																	      editTableForEffectivity.getViewer().refresh();
																																	    }

																																	}
																																});
																																fd_btnNewButton.right = new FormAttachment(btnNewButton_1, -6);
																																fd_btnNewButton.bottom = new FormAttachment(btnNewButton_1, 0, SWT.BOTTOM);
																																FormData fd_btnNewButton_1 = new FormData();
																																fd_btnNewButton_1.top = new FormAttachment(instanceField, 6);
																																fd_btnNewButton_1.right = new FormAttachment(100, -10);
																																fd_btnNewButton_1.left = new FormAttachment(0, 458);
																																btnNewButton_1.setLayoutData(fd_btnNewButton_1);
																																btnNewButton_1.setText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");

																																Composite composite_4 = new Composite(composite, SWT.BORDER);
																																FormData fd_composite_4 = new FormData();
																																fd_composite_4.right = new FormAttachment(contentComposite, 0, SWT.RIGHT);
																																fd_composite_4.top = new FormAttachment(contentComposite, 2);
																																fd_composite_4.bottom = new FormAttachment(100);
																																fd_composite_4.left = new FormAttachment(0);
																																composite_4.setLayoutData(fd_composite_4);

																																Button btnNewButton_2 = new Button(composite_4, SWT.NONE);
																																btnNewButton_2.setBounds(8, 3, 229, 25);
																																btnNewButton_2.setText("\u041F\u0440\u0438\u043C\u0435\u043D\u0438\u0442\u044C \u0438\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u044F");

																																Button btnNewButton_3 = new Button(composite_4, SWT.NONE);
																																btnNewButton_3.setBounds(315, 3, 219, 25);
																																btnNewButton_3.setText("\u0412\u044B\u0445\u043E\u0434");

		final TableForAttachedDocuments tableForAttachedDocuments	= new  TableForAttachedDocuments();
		final TableForEffectivity tableForEffectivity =new  TableForEffectivity();






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