package ru.aerospacesystems.dirdoc.handlers;

import org.eclipse.jface.viewers.TableViewer;

import ru.aerospacesystems.dirdoc.dirDocCreation.MainWindowSwt;
import ru.aerospacesystems.dirdoc.handlers.tableHandlers.PrimaryOutput.EditTableForEffectivity;



public class TableManager {

	 public static void PasteColumn (String identifier ,String revision, String status, TableViewer viewer) throws Exception {
		 AttachedDocObject obj = new AttachedDocObject();
		 DirDocCreatAttachedDocModelProvider persons = DirDocCreatAttachedDocModelProvider.INSTANCE;
			obj.setIdentifier(identifier);
			obj.setRevision(revision);
			obj.setStatus(status);
			persons.getPersons().add(obj);
			viewer.refresh();
		 }

	 public static void PasteColumn2 (String item ,String instance, TableViewer viewer) throws Exception {
		EffectivityObject obj = new EffectivityObject();
		 DirDocCreatEffectivityModelProvider persons2 = DirDocCreatEffectivityModelProvider.INSTANCE;
			obj.setItem(item);
			obj.setInstantces(instance);

			persons2.getPersons().add(obj);
			viewer.refresh();
		 }

	 public static void ClearEnum1(TableViewer viewer) throws Exception {
		 AttachedDocObject obj = new AttachedDocObject();
		 DirDocCreatAttachedDocModelProvider persons =   DirDocCreatAttachedDocModelProvider.INSTANCE;

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
		 DirDocCreatEffectivityModelProvider persons =  DirDocCreatEffectivityModelProvider.INSTANCE;

			persons.getPersons().clear();
			viewer.refresh();
		 }
	 public static void PasteColumn3 (String identifier ,String revision, String status, TableViewer viewer) throws Exception {
		 AttachedDocObject obj = new AttachedDocObject();
		 DirDocEditAttachedDocModelProvider persons =  DirDocEditAttachedDocModelProvider.INSTANCE;
			obj.setIdentifier(identifier);
			obj.setRevision(revision);
			obj.setStatus(status);
			persons.getPersons().add(obj);
			viewer.refresh();
		 }

	 public static void PasteColumn4 (String item ,String instance, TableViewer viewer) throws Exception {
			EffectivityObject obj = new EffectivityObject();
			 DirDocEditEffectivityModelProvider persons = DirDocEditEffectivityModelProvider.INSTANCE;
				obj.setItem(item);
				obj.setInstantces(instance);

				persons.getPersons().add(obj);
				viewer.refresh();
			 }

	 public static boolean checkClone(String identifier, String revision) {
		 DirDocCreatAttachedDocModelProvider persons = DirDocCreatAttachedDocModelProvider.INSTANCE;

		 boolean result = true;
		 for (int i=0; i < persons.ModelProviderSize(); i++)
		 {

				try {
					String id = TableManager.getColumn(i).getIdentifier();
					String rev = TableManager.getColumn(i).getRevision();

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

		 DirDocCreatAttachedDocModelProvider persons = DirDocCreatAttachedDocModelProvider.INSTANCE;

		 int sizeOfTableArray = DirDocCreatAttachedDocModelProvider.INSTANCE.ModelProviderSize();
		 if (number > sizeOfTableArray){
			 System.out.println("!!!!!getColumn!!!!!!" + "Размер массива данных таьлицы = " + sizeOfTableArray + " Обращение к номеру = " +number);

		 }

		return	persons.getPersons().get(number);

		 }

	 public static EffectivityObject getColumn2 (int number) throws Exception {

		 DirDocCreatEffectivityModelProvider persons = DirDocCreatEffectivityModelProvider.INSTANCE;
		 int sizeOfTableArray = DirDocCreatEffectivityModelProvider.INSTANCE.ModelProviderSize();
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
