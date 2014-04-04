package ru.aerospacesystems.dirdoc.handlers;

import java.util.ArrayList;
import java.util.List;

public enum DirDocCreatModelProvider {
  INSTANCE;

  public List<AttachedDocObject> persons;

  DirDocCreatModelProvider() {
    persons = new ArrayList<AttachedDocObject>();
    // Image here some fancy database access to read the persons and to
    // put them into the model

  }

  public int ModelProviderSize() {
	return persons.size();
			 
	  }
  public List<AttachedDocObject> getPersons() {
    return persons;
  }

}