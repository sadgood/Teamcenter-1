package ru.aerospacesystems.dirdoc.handlers;

import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.CLabel;

import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;

public class MainWindowSwt extends Shell {
	private Text textFieldComposite1;
	private Table table;

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
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
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
		composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
		FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(0, 10);
		composite_1.setLayoutData(fd_composite_1);

		final CLabel labelComposite1 = new CLabel(composite_1, SWT.NONE);
		labelComposite1.setLayoutData(new RowData(184, SWT.DEFAULT));
		labelComposite1.setText("\u0421\u043B\u0443\u0436\u0435\u0431\u043D\u0430\u044F \u0437\u0430\u043F\u0438\u0441\u043A\u0430 \u2116");

		textFieldComposite1 = new Text(composite_1, SWT.BORDER);
		textFieldComposite1.setLayoutData(new RowData(199, SWT.DEFAULT));

		table = new Table(composite1, SWT.BORDER | SWT.FULL_SELECTION);
		fd_composite_1.right = new FormAttachment(table, 0, SWT.RIGHT);
		fd_composite_1.bottom = new FormAttachment(table, -6);
		fd_composite_1.left = new FormAttachment(table, 0, SWT.LEFT);
		FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(100, -10);
		fd_table.top = new FormAttachment(0, 48);
		fd_table.right = new FormAttachment(0, 564);
		fd_table.left = new FormAttachment(0, 10);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
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
				if (rb7.getSelection() != true) {

					 try {
							FileManager.createDirDoc(tcSession ,textFieldComposite1.getText(), "Служебная записка");
							FileManager.createDataset(tcSession, "PDF", textFieldComposite1.getText());

							try {
								FileManager.pasteItem(tcSession, FileManager.getDirDoc(tcSession, textFieldComposite1.getText()));
								FileManager.getDirDoc(tcSession, textFieldComposite1.getText()).add("IMAN_specification",FileManager.getDirDocDataset(tcSession, textFieldComposite1.getText()) );

								System.out.println(FileManager.getDirDoc(tcSession, textFieldComposite1.getText()).toString());
								System.out.println(FileManager.getDirDocRevision(tcSession, textFieldComposite1.getText()).toString());
								System.out.println(FileManager.getDirDocDataset(tcSession, textFieldComposite1.getText()).toString());

							} catch (Exception e1) {
								// TODO Auto-generated catch block
								MessageBox messageBox = new MessageBox(getShell(),SWT.ERROR |
										SWT.OK);
								messageBox.setText("Ошибка создания директивного документа");
								messageBox.setMessage(e1.toString());
								messageBox.open();
							}

							MessageBox messageBox = new MessageBox(getShell(),SWT.ICON_INFORMATION |
									SWT.OK);
							messageBox.setText("Успешное создания директивного документа");
							messageBox.setMessage("Служебная записка № " + textFieldComposite1.getText() + " успешно создана");
							messageBox.open();
							dispose();

							dispose();
						} catch (TCException e2) {
							MessageBox messageBox = new MessageBox(getShell(),SWT.ERROR |
									SWT.OK);
							messageBox.setText("Ошибка создания директивного документа");
							messageBox.setMessage(e2.toString());
							messageBox.open();

						}

				}
				if (rb1.getSelection() != true) {

					 try {
							FileManager.createDirDoc(tcSession ,textFieldComposite1.getText(), "Служебная записка СТОП");

							MessageBox messageBox = new MessageBox(getShell(),SWT.ICON_INFORMATION |
									SWT.OK);
							messageBox.setText("Успешное создания директивного документа");
							messageBox.setMessage("Служебная записка СТОП № " + textFieldComposite1.getText() + " успешно создана");
							messageBox.open();
							dispose();

				} catch (TCException e3) {

					MessageBox messageBox = new MessageBox(getShell(),SWT.ICON_ERROR |
							SWT.OK);
					messageBox.setText("Ошибка создания директивного документа");
					messageBox.setMessage(e3.toString());
					messageBox.open();


				}

					}

			}
		});






	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(812, 483);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
