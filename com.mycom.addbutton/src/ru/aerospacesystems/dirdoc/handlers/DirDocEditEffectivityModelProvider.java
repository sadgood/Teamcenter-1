package ru.aerospacesystems.dirdoc.handlers;

import java.util.ArrayList;
import java.util.List;

public enum DirDocEditEffectivityModelProvider {
  INSTANCE;

  public List<EffectivityObject> persons2;

  DirDocEditEffectivityModelProvider() {
    persons2 = new ArrayList<EffectivityObject>();
    // Image here some fancy database access to read the persons and to
    // put them into the model

  }

  public int ModelProviderSize() {
	return persons2.size();

	  }
  public List<EffectivityObject> getPersons() {
    return persons2;
  }

}