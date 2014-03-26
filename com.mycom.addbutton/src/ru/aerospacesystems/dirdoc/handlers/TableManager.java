package ru.aerospacesystems.dirdoc.handlers;

import org.eclipse.jface.viewers.TableViewer;



public class TableManager {

	 public static void PasteColumn (String identifier ,String revision, String status, TableViewer viewer) throws Exception {
		 ItemRevisonObject obj = new ItemRevisonObject();
		 ModelProvider persons = ModelProvider.INSTANCE;
			obj.setFirstName(identifier);
			obj.setLastName(revision);
			obj.setGender(status);
			persons.getPersons().add(obj);
			viewer.refresh();
		 }

	 public static boolean checkClone(String identifier, String revision) {
		 ModelProvider persons = ModelProvider.INSTANCE;
		
		 boolean result = true;
		 for (int i=0; i < persons.ModelProviderSize(); i++)
		 {
			 
				try {
					String id = TableManager.getColumn(i).getFirstName();
					String rev = TableManager.getColumn(i).getLastName();

					if ( id.equals(identifier) & rev.equals(revision) )
					{
					result = true;
						
					}
					else 
					{
						result = false;	
					}
				} catch (Exception e) {
				
					
					
					e.printStackTrace();
				}
				
		

		 }
		return result;

	 }
	 public static ItemRevisonObject getColumn (int number) throws Exception {

		 ModelProvider persons = ModelProvider.INSTANCE;

		return	persons.getPersons().get(number);

		 }

}
