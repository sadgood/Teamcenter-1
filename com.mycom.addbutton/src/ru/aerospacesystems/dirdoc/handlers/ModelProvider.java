package ru.aerospacesystems.dirdoc.handlers;

import java.util.ArrayList;
import java.util.List;

public enum ModelProvider {
  INSTANCE;

  public List<ItemRevisonObject> persons;

  ModelProvider() {
    persons = new ArrayList<ItemRevisonObject>();
    // Image here some fancy database access to read the persons and to
    // put them into the model

  }

  public int ModelProviderSize() {
	return persons.size();
			 
	  }
  public List<ItemRevisonObject> getPersons() {
    return persons;
  }

}