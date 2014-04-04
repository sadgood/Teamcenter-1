package ru.aerospacesystems.dirdoc.handlers;

import javax.swing.JOptionPane;

import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.aif.AbstractAIFUIApplication;
import com.teamcenter.rac.aif.kernel.InterfaceAIFComponent;
import com.teamcenter.rac.aifrcp.AIFUtility;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentBOMLine;
import com.teamcenter.rac.kernel.TCComponentBOMWindow;
import com.teamcenter.rac.kernel.TCComponentBOMWindowType;
import com.teamcenter.rac.kernel.TCComponentDataset;
import com.teamcenter.rac.kernel.TCComponentDatasetType;
import com.teamcenter.rac.kernel.TCComponentFolder;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCComponentItemType;
import com.teamcenter.rac.kernel.TCComponentQuery;
import com.teamcenter.rac.kernel.TCComponentQueryType;
import com.teamcenter.rac.kernel.TCComponentUser;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.kernel.VariantCondition;

public class FileManager {



	 public static String[][]  getSelectedObject ()  {
		 AbstractAIFUIApplication app = AIFUtility.getCurrentApplication();
		InterfaceAIFComponent pasteTargets[];
		 pasteTargets = app.getTargetComponents();
	     int numberOfOjects = pasteTargets.length;
		 String[][] objects = new String[numberOfOjects][3];

		 for (int i = 0; i < numberOfOjects; i++)
		 {

			 objects[i][1] = pasteTargets[i].toString();
			 String[] parts = objects[i][1].split("/");
			 System.out.println("DLNA MASSIVA " + parts.length);
			 objects[i][1] = parts[0];
			 for (int i2 = 1; i2 < parts.length - 1 ; i2++){
				 objects[i][1] +="/" + parts[i2];
			 }


			 parts = parts[parts.length - 1].split(";");
			 objects[i][2]  = parts[0];

		 }

        return objects;
	  }

	 public static String getDirDocIdFromObjectString(String objectString){
		 String[] id = objectString.split("/");
		return id[0];

	 }

	 public static TCComponent[] getRelated (TCComponent dirDocRev) throws TCException {

			TCComponent[] related = dirDocRev.getRelatedComponents("AS2_AttachedDoc");

			return related;


	  }





	 public static void createDirDoc (TCSession tcSession, String dirDocID, String dirDocDesc) throws TCException {

		  TCComponent test = null ;

		  TCComponentItemType dirDoc = new TCComponentItemType();


				dirDoc = (TCComponentItemType)tcSession.getTypeComponent("Item");
				dirDoc.create(dirDocID, "A","AS2_DirDoc", dirDocID, dirDocDesc, test);

				TCSession tCSession = (TCSession )AIFDesktop.getActiveDesktop().getCurrentApplication().getSession();

				//????

	  }

	 public static TCComponent  getDirDocRevision (TCSession tcSession, String dirDocID ) throws TCException {

			TCComponentQuery tceItemQuery = null;

	        TCComponentQueryType qType = (TCComponentQueryType) tcSession.getTypeComponent("ImanQuery");
	        tceItemQuery = (TCComponentQuery) qType.find("Модификация изделия...");

	        String entry1[] = { "Идентификатор изделия" };
	        String value1[] = { dirDocID };



	        TCComponent [] result =  tceItemQuery.execute(entry1, value1);

			return result[0];


	  }

	 public static TCComponent getDirDocRevision2 (TCSession tcSession, String dirDocID, String dirDocIDRev  ) throws TCException {

			TCComponentQuery tceItemQuery = null;

	        TCComponentQueryType qType = (TCComponentQueryType) tcSession.getTypeComponent("ImanQuery");

	        tceItemQuery = (TCComponentQuery) qType.find("Модификация изделия...");

	        String entry1[] = { "Идентификатор изделия", "Модификация" };
	        String value1[] = { dirDocID, dirDocIDRev };



	        TCComponent[] result =  tceItemQuery.execute(entry1, value1);

			return result[0];


	  }

	    public static void paste(TCComponent clipboardComponents, TCComponent[] selectedComponents, final String propertyKey) throws TCException {
	        if (clipboardComponents == null) {
	            return;
	        }

	        if (propertyKey.equals("bl_variant_condition") || propertyKey.equals("bl_condition_tag") || propertyKey.equals("bl_formula")) {
	            if (!(clipboardComponents instanceof TCComponentBOMLine))
	                return;
	            try {
	                TCComponentBOMLine line = (TCComponentBOMLine) clipboardComponents;
	                TCComponent condition = line.getReferenceProperty("bl_condition_tag");
	                if (condition == null) {
	                    String varCondMvl = line.getProperty("bl_variant_condition");
	                    TCComponentBOMLine toLine = (TCComponentBOMLine) selectedComponents[0];
	                    toLine.getSession().getVariantService().setLineMvlCondition(toLine, varCondMvl);
	                } else {
	                    VariantCondition clauses = VariantCondition.create(condition, line.window());
	                    selectedComponents[0].setReferenceProperty("bl_condition_tag", clauses.toCondition());
	                }
	            } catch (TCException e) {

	            }
	            return;
	        }

	        for (TCComponent selectedComponent : selectedComponents) {
	            try {
	                selectedComponent.setProperty(propertyKey, clipboardComponents.getProperty(propertyKey));
	            } catch (TCException e) {

	            }
	        }
	    }

	 public static TCComponent getDirDoc (TCSession tcSession, String dirDocID ) throws TCException {

			TCComponentQuery tceItemQuery = null;

	        TCComponentQueryType qType = (TCComponentQueryType) tcSession.getTypeComponent("ImanQuery");
	        tceItemQuery = (TCComponentQuery) qType.find("Изделие...");

	        String entry[] = { "Идентификатор изделия" };
	        String value[] = { dirDocID};

	        TCComponent[] result =  tceItemQuery.execute(entry, value);

			return result[0];


	  }

	 public static TCComponent getDirDocDataset (TCSession tcSession, String dirDocID, String type ) throws TCException {

			TCComponentQuery tceItemQuery = null;

	        TCComponentQueryType qType = (TCComponentQueryType) tcSession.getTypeComponent("ImanQuery");
	        tceItemQuery = (TCComponentQuery) qType.find("Набор данных...");

	        String entry[] = { "Имя" , "Тип набора данных" };
	        String value[] = { dirDocID , type};

	        TCComponent[] result =  tceItemQuery.execute(entry, value);

			return result[0];


	  }

	 public static TCComponent getDirDocDatasetStatus(TCSession tcSession, String dirDocID, String dirDocIDRev, String dirDocStatus) throws TCException {




			TCComponentQuery tceItemQuery = null;

	        TCComponentQueryType qType = (TCComponentQueryType) tcSession.getTypeComponent("ImanQuery");

	        tceItemQuery = (TCComponentQuery) qType.find("Модификация изделия...");

	        String entry1[] = { "Идентификатор изделия", "Модификация", "Статус выпуска" };
	        String value1[] = { dirDocID, dirDocIDRev, dirDocStatus};

	        TCComponent[] result =  tceItemQuery.execute(entry1, value1);

		return result[0];


		 }


	 public static void pasteItem (TCSession session, TCComponent item) throws Exception {
		 TCComponentUser user = session.getUser();
		 System.out.println(" User = "+user);

		 TCComponentFolder newstuffFolder = user.getNewStuffFolder();
		 System.out.println(" NewStuff Folder  = "+newstuffFolder);

		 String relation = newstuffFolder.getDefaultPasteRelation();

		 // Add Business Object (TCComponet) in Newstuff folder
		 newstuffFolder.add(relation, item);

		 }

	    public static TCComponentDataset createDataset(TCSession tcSession, String strDatasetType, String datasetName)
	    	    throws TCException
	    	{
	    	    TCComponentDataset tcDataSet = null;
	    	    TCComponentDatasetType datasetType = (TCComponentDatasetType)tcSession.getTypeService().getTypeComponent("Dataset");
	    	    tcDataSet = datasetType.create(datasetName, "", strDatasetType);
	    	    return tcDataSet;
	    	}





}

