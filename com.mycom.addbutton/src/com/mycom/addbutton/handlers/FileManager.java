package com.mycom.addbutton.handlers;

import javax.swing.JOptionPane;

import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentBOMLine;
import com.teamcenter.rac.kernel.TCComponentBOMWindow;
import com.teamcenter.rac.kernel.TCComponentBOMWindowType;
import com.teamcenter.rac.kernel.TCComponentDataset;
import com.teamcenter.rac.kernel.TCComponentDatasetType;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCComponentItemType;
import com.teamcenter.rac.kernel.TCComponentQuery;
import com.teamcenter.rac.kernel.TCComponentQueryType;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;

public class FileManager {
	
	

	


	 public static void createDirDoc (TCSession tcSession, String dirDocID, String dirDocDesc) throws TCException {

		  TCComponent test = null ;
		  TCComponentItemType dirDoc = new TCComponentItemType();


				dirDoc = (TCComponentItemType)tcSession.getTypeComponent("Item");
				dirDoc.create(dirDocID, "A","AS2_Detail", dirDocID, dirDocDesc, test);





	  }





}

