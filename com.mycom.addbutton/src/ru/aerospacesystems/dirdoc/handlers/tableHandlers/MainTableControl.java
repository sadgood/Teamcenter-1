package ru.aerospacesystems.dirdoc.handlers.tableHandlers;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;



public abstract class MainTableControl implements ITableControl {
protected static TableViewer viewer;


	@Override
  public  void createPartControl(Composite parent){
		 GridLayout layout = new GridLayout(2, false);
		    parent.setLayout(layout);
		    createViewer(parent);
	};
	
	protected abstract void createViewer(Composite parent);
	 
	protected abstract void createColumns(final Composite parent, final TableViewer viewer);
	 
	 protected TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber){
		   final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,   SWT.NONE);
			    final TableColumn column = viewerColumn.getColumn();
			    column.setText(title);
			    column.setWidth(bound);
			    column.setResizable(true);
			    column.setMoveable(true);
			    return viewerColumn;
		 
	 }
	 
	public TableViewer getViewer(){
		return viewer;
	 }

}
