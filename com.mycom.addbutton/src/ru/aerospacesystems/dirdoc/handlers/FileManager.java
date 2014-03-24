package ru.aerospacesystems.dirdoc.handlers;

import javax.swing.JOptionPane;

import com.teamcenter.rac.aif.AIFDesktop;
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

public class FileManager {






	 public static void createDirDoc (TCSession tcSession, String dirDocID, String dirDocDesc) throws TCException {

		  TCComponent test = null ;

		  TCComponentItemType dirDoc = new TCComponentItemType();


				dirDoc = (TCComponentItemType)tcSession.getTypeComponent("Item");
				dirDoc.create(dirDocID, "A","AS2_DirDoc", dirDocID, dirDocDesc, test);

				TCSession tCSession = (TCSession )AIFDesktop.getActiveDesktop().getCurrentApplication().getSession();

				//????

	  }

	 public static TCComponent getDirDoc (TCSession tcSession, String dirDocID ) throws TCException {

			TCComponentQuery tceItemQuery = null;

	        TCComponentQueryType qType = (TCComponentQueryType) tcSession.getTypeComponent("ImanQuery");
	        tceItemQuery = (TCComponentQuery) qType.find("Модификация изделия...");

	        String entry[] = { "Идентификатор изделия" };
	        String value[] = { dirDocID};

	        TCComponent[] result =  tceItemQuery.execute(entry, value);

			return result[0];


	  }

	 public static TCComponent getDirDocRevision (TCSession tcSession, String dirDocID ) throws TCException {

			TCComponentQuery tceItemQuery = null;

	        TCComponentQueryType qType = (TCComponentQueryType) tcSession.getTypeComponent("ImanQuery");
	        tceItemQuery = (TCComponentQuery) qType.find("Изделие...");

	        String entry[] = { "Идентификатор изделия" };
	        String value[] = { dirDocID};

	        TCComponent[] result =  tceItemQuery.execute(entry, value);

			return result[0];


	  }

	 public static TCComponent getDirDocDataset (TCSession tcSession, String dirDocID ) throws TCException {

			TCComponentQuery tceItemQuery = null;

	        TCComponentQueryType qType = (TCComponentQueryType) tcSession.getTypeComponent("ImanQuery");
	        tceItemQuery = (TCComponentQuery) qType.find("Набор данных...");

	        String entry[] = { "Имя" };
	        String value[] = { dirDocID};

	        TCComponent[] result =  tceItemQuery.execute(entry, value);

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

