package ru.aerospacesystems.dirdoc.handlers;

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

import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.aif.kernel.InterfaceAIFComponent;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentQuery;
import com.teamcenter.rac.kernel.TCComponentQueryType;
import com.teamcenter.rac.kernel.TCSession;

public class MainWindowSwt extends Shell {
	private FormattedText dirDocIdTextField;
	 private TableViewer viewer;
	  // static fields to hold the images
	 public final static String EDIT_MASK1 = "UU.UU-UUUU/UU-UU";
	 public final static String EDIT_MASK2 = "UU.UUUU.-UU-UUUU-UU.UU";



	private InterfaceAIFComponent pasteTargets[];

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
		okButton.setText("\u041E\u041A");

		Button cancelButton = new Button(ButtonComposite, SWT.NONE);
		cancelButton.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false, false));


		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		cancelButton.setBounds(10, 116, 186, 45);
		cancelButton.setText("\u041E\u0442\u043C\u0435\u043D\u0430");

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
		fd_composite_1.bottom = new FormAttachment(composite_2, -6);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite_2 = new FormData();
		fd_composite_2.top = new FormAttachment(0, 50);
		fd_composite_2.left = new FormAttachment(0, 10);
		fd_composite_2.right = new FormAttachment(100, -10);

		final SwitchButton button2 = new SwitchButton(composite_1, SWT.NONE);
		button2.setBounds(399, 0, 151, 37);
		button2.setText("");
		button2.setTextForSelect("12");
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



		Button addButton = new Button(composite1, SWT.NONE);
		fd_composite_2.bottom = new FormAttachment(addButton, -17);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

		String[][] selectedForTable = FileManager.getSelectedObject();
		boolean isCloneExist = false;
		try {


			for (int i=0; i < selectedForTable.length; i++){
				 ModelProvider persons = ModelProvider.INSTANCE;
				 System.out.println("Dlina "+ persons.ModelProviderSize());



				 for (int i2=0; i2 < persons.ModelProviderSize(); i2++){
					 String id = TableManager.getColumn(i2).getFirstName();
					 String rev = TableManager.getColumn(i2).getLastName();
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
			TableManager.PasteColumn(selectedForTable[i][1],selectedForTable[i][2],"Отсутствует",viewer);
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
				 ISelection selection = viewer.getSelection();

					    if (selection != null && selection instanceof IStructuredSelection) {
					      List<ItemRevisonObject> persons = ModelProvider.INSTANCE.getPersons();
					      IStructuredSelection sel = (IStructuredSelection) selection;

					      for (Iterator<ItemRevisonObject> iterator = sel.iterator(); iterator.hasNext();) {
					        ItemRevisonObject person = iterator.next();
					        persons.remove(person);
					      }
					      viewer.refresh();
					    }
			}
		});
		FormData fd_removeButton = new FormData();
		fd_removeButton.top = new FormAttachment(addButton, 0, SWT.TOP);
		fd_removeButton.right = new FormAttachment(100, -10);
		fd_removeButton.left = new FormAttachment(0, 316);
		removeButton.setLayoutData(fd_removeButton);
		removeButton.setText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");

    createPartControl(composite_2);
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
				 ModelProvider persons = ModelProvider.INSTANCE;
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
					/////////////////////////////////
											} catch (Exception e1) {


												try {
													GuiManager.errorMessage("Ошибка создания директивного документа", e1.toString(), getShell());
												} catch (Exception e3) {

												}






	}
											try {
											for (int i=0; i < persons.ModelProviderSize(); i++){
												dirDocRevision = FileManager.getDirDocRevision(tcSession, dirDocIdTextField.getControl().getText());
													TCComponent otherFileRev =FileManager.getDirDocRevision2(tcSession, TableManager.getColumn(i).getFirstName(), TableManager.getColumn(i).getLastName());
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

	 private void createViewer(Composite parent) {
		    viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
		        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

		    createColumns(parent, viewer);
		    final Table table = viewer.getTable();
		    table.setHeaderVisible(true);
		    table.setLinesVisible(true);

		    viewer.setContentProvider(new ArrayContentProvider());
		    // get the content for the viewer, setInput will call getElements in the
		    // contentProvider
		    viewer.setInput(ModelProvider.INSTANCE.getPersons());
		    // make the selection available to other views
		    //getSite().setSelectionProvider(viewer);
		    // set the sorter for the table

		    // define layout for the viewer
		    GridData gridData = new GridData();
		    gridData.verticalAlignment = GridData.FILL;
		    gridData.horizontalSpan = 2;
		    gridData.grabExcessHorizontalSpace = true;
		    gridData.grabExcessVerticalSpace = true;
		    gridData.horizontalAlignment = GridData.FILL;
		    viewer.getControl().setLayoutData(gridData);
		  }

	 private void createColumns(final Composite parent, final TableViewer viewer) {
		    String[] titles = { "Идентификатор", "Ревизия", "Статус"};
		    int[] bounds = { 150, 150, 150 };

		    // first column is for the first name
		    TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
		    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        ItemRevisonObject p = (ItemRevisonObject) element;
		        return p.getFirstName();
		      }
		    });

		    // second column is for the last name
		    col = createTableViewerColumn(titles[1], bounds[1], 1);
		    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        ItemRevisonObject p = (ItemRevisonObject) element;
		        return p.getLastName();
		      }
		    });

		    // now the gender
		    col = createTableViewerColumn(titles[2], bounds[2], 2);
		    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        ItemRevisonObject p = (ItemRevisonObject) element;
		        return p.getGender();
		      }
		    });

		    // now the status married



		  }

		  private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
		        SWT.NONE);
		    final TableColumn column = viewerColumn.getColumn();
		    column.setText(title);
		    column.setWidth(bound);
		    column.setResizable(true);
		    column.setMoveable(true);
		    return viewerColumn;
		  }

		  public TableViewer getViewer() {
		    return viewer;
		  }

	  public void createPartControl(Composite parent) {
		    GridLayout layout = new GridLayout(2, false);
		    parent.setLayout(layout);

		    createViewer(parent);
		  }
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