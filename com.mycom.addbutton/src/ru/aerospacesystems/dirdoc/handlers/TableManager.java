package ru.aerospacesystems.dirdoc.handlers;

import org.eclipse.jface.viewers.TableViewer;



public class TableManager {

	 public static void PasteColumn (String identifier ,String revision, String status, TableViewer viewer) throws Exception {
		 AttachedDocObject obj = new AttachedDocObject();
		 DirDocCreatModelProvider persons = DirDocCreatModelProvider.INSTANCE;
			obj.setFirstName(identifier);
			obj.setLastName(revision);
			obj.setGender(status);
			persons.getPersons().add(obj);
			viewer.refresh();
		 }
	 
	 public static void PasteColumn2 (String item ,String instance, TableViewer viewer) throws Exception {
		EffectivityObject obj = new EffectivityObject();
		 DirDocCreatModelProvider2 persons2 = DirDocCreatModelProvider2.INSTANCE;
			obj.setFirstName(item);
			obj.setLastName(instance);
			
			persons2.getPersons().add(obj);
			viewer.refresh();
		 }

	 public static boolean checkClone(String identifier, String revision) {
		 DirDocCreatModelProvider persons = DirDocCreatModelProvider.INSTANCE;
		
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
	 public static AttachedDocObject getColumn (int number) throws Exception {

		 DirDocCreatModelProvider persons = DirDocCreatModelProvider.INSTANCE;

		return	persons.getPersons().get(number);

		 }
	 
	 public static EffectivityObject getColumn2 (int number) throws Exception {

		 DirDocCreatModelProvider2 persons = DirDocCreatModelProvider2.INSTANCE;

		return	persons.getPersons().get(number);

		 }



}
