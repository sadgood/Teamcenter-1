package ru.aerospacesystems.dirdoc.handlers;

import org.eclipse.jface.viewers.TableViewer;

import ru.aerospacesystems.dirdoc.dirDocCreation.MainWindowSwt;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput.EditTableForEffectivity;



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

	 public static void ClearEnum1(TableViewer viewer) throws Exception {
		 AttachedDocObject obj = new AttachedDocObject();
		 DirDocCreatModelProvider persons =   DirDocCreatModelProvider.INSTANCE;

			persons.getPersons().clear();
			viewer.refresh();
		 }



	 public static void ClearEnum3(TableViewer viewer) throws Exception {
		 AttachedDocObject obj = new AttachedDocObject();
		 DirDocEditAttachedDocModelProvider persons =  DirDocEditAttachedDocModelProvider.INSTANCE;

			persons.getPersons().clear();
			viewer.refresh();
		 }

	 public static void ClearEnum4(TableViewer viewer) throws Exception {
		 EffectivityObject obj = new EffectivityObject();
		 DirDocEditEffectivityModelProvider persons = DirDocEditEffectivityModelProvider.INSTANCE;

			persons.getPersons().clear();
			viewer.refresh();
		 }

	 public static void ClearEnum2(TableViewer viewer) throws Exception {
		 AttachedDocObject obj = new AttachedDocObject();
		 DirDocCreatModelProvider2 persons =  DirDocCreatModelProvider2.INSTANCE;

			persons.getPersons().clear();
			viewer.refresh();
		 }
	 public static void PasteColumn3 (String identifier ,String revision, String status, TableViewer viewer) throws Exception {
		 AttachedDocObject obj = new AttachedDocObject();
		 DirDocEditAttachedDocModelProvider persons =  DirDocEditAttachedDocModelProvider.INSTANCE;
			obj.setFirstName(identifier);
			obj.setLastName(revision);
			obj.setGender(status);
			persons.getPersons().add(obj);
			viewer.refresh();
		 }

	 public static void PasteColumn4 (String item ,String instance, TableViewer viewer) throws Exception {
			EffectivityObject obj = new EffectivityObject();
			 DirDocEditEffectivityModelProvider persons = DirDocEditEffectivityModelProvider.INSTANCE;
				obj.setFirstName(item);
				obj.setLastName(instance);

				persons.getPersons().add(obj);
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

					if ( id.equals(identifier) && rev.equals(revision) )
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
		 
		 int sizeOfTableArray = DirDocCreatModelProvider.INSTANCE.ModelProviderSize();
		 if (number > sizeOfTableArray){
			 System.out.println("!!!!!getColumn!!!!!!" + "Размер массива данных таьлицы = " + sizeOfTableArray + " Обращение к номеру = " +number);
			 
		 }

		return	persons.getPersons().get(number);

		 }

	 public static EffectivityObject getColumn2 (int number) throws Exception {

		 DirDocCreatModelProvider2 persons = DirDocCreatModelProvider2.INSTANCE;
		 int sizeOfTableArray = DirDocCreatModelProvider2.INSTANCE.ModelProviderSize();
		 if (number > sizeOfTableArray){
			 System.out.println("!!!!!getColumn2!!!!!!" + "Размер массива данных таьлицы = " + sizeOfTableArray + " Обращение к номеру = " +number);
			 
		 } 

		return	persons.getPersons().get(number);

		 }

	 public static AttachedDocObject getColumn3 (int number) throws Exception {

		 DirDocEditAttachedDocModelProvider persons = DirDocEditAttachedDocModelProvider.INSTANCE;
		 
		 int sizeOfTableArray = DirDocEditAttachedDocModelProvider.INSTANCE.ModelProviderSize();
		 if (number > sizeOfTableArray){
			 System.out.println("!!!!!getColumn3!!!!!!" + "Размер массива данных таьлицы = " + sizeOfTableArray + " Обращение к номеру = " +number);
			 
		 } 

		return	persons.getPersons().get(number);

		 }
	 
	 public static EffectivityObject getColumn4 (int number) throws Exception {
		 
		 

		 DirDocEditEffectivityModelProvider persons = DirDocEditEffectivityModelProvider.INSTANCE;
		 
		 int sizeOfTableArray = DirDocEditEffectivityModelProvider.INSTANCE.ModelProviderSize();
		 if (number > sizeOfTableArray){
			 System.out.println("!!!!!getColumn4!!!!!!" + "Размер массива данных таьлицы = " + sizeOfTableArray + " Обращение к номеру = " +number);
			 
		 } 

		return	persons.getPersons().get(number);

		 }


}
