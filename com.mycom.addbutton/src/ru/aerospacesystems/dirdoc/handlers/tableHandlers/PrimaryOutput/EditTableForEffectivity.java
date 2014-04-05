package ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput;

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

import ru.aerospacesystems.dirdoc.handlers.DirDocEditEffectivityModelProvider;
import ru.aerospacesystems.dirdoc.handlers.EffectivityObject;
import ru.aerospacesystems.dirdoc.handlers.DirDocCreatModelProvider2;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.MainTableControl;

public class EditTableForEffectivity  {
	protected static TableViewer viewer;
	
	
	

	
	protected
	void createViewer(Composite parent) {
		 viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
			        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

			    createColumns(parent, viewer);
			    final Table table = viewer.getTable();
			    table.setHeaderVisible(true);
			    table.setLinesVisible(true);

			    viewer.setContentProvider(new ArrayContentProvider());
			
			    viewer.setInput(DirDocEditEffectivityModelProvider.INSTANCE.getPersons());
			
			    GridData gridData = new GridData();
			    gridData.verticalAlignment = GridData.FILL;
			    gridData.horizontalSpan = 2;
			    gridData.grabExcessHorizontalSpace = true;
			    gridData.grabExcessVerticalSpace = true;
			    gridData.horizontalAlignment = GridData.FILL;
			    viewer.getControl().setLayoutData(gridData);
		
	}


	protected
	void createColumns(Composite parent, TableViewer viewer) {
		String[] titles = { "Изделие", "Экземпляр"};
	    int[] bounds = { 150, 150};

	    // first column is for the first name
	    TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	        EffectivityObject p = (EffectivityObject) element;
	        return p.getFirstName();
	      }
	    });

	    // second column is for the last name
	    col = createTableViewerColumn(titles[1], bounds[1], 1);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  EffectivityObject p2 = (EffectivityObject) element;
	        return p2.getLastName();
	      }
	    });
	    
	    

	  

		
	}
	public void viewerRefresh() {
	 viewer.refresh();	
    };

    public  void createPartControl(Composite parent){
		 GridLayout layout = new GridLayout(2, false);
		    parent.setLayout(layout);
		    createViewer(parent);
	};
	

	 
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
