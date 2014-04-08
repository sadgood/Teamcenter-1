package ru.aerospacesystems.dirdoc.handlers;

import java.util.ArrayList;
import java.util.List;

public enum DirDocCreatAttachedDocModelProvider {
  INSTANCE;

  public List<AttachedDocObject> persons;

  DirDocCreatAttachedDocModelProvider() {
    persons = new ArrayList<AttachedDocObject>();
    

  }

  public int ModelProviderSize() {
	return persons.size();
			 
	  }
  public List<AttachedDocObject> getPersons() {
    return persons;
  }

}