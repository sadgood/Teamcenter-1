package ru.aerospacesystems.dirdoc.handlers;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class GuiManager {

	 public static void infoMessage (String text,String message, Shell shell) throws Exception {
		 MessageBox messageBox = new MessageBox(shell,SWT.ICON_INFORMATION |
					SWT.OK);
			messageBox.setText(text);
			messageBox.setMessage(message);
			messageBox.open();
		 }
	 public static void errorMessage (String text,String message, Shell shell) throws Exception {
		 MessageBox messageBox = new MessageBox(shell,SWT.ICON_ERROR|
					SWT.OK);
			messageBox.setText(text);
			messageBox.setMessage(message);
			messageBox.open();
		 }

}
