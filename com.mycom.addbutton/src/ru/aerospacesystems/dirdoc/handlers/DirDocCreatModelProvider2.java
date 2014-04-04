package ru.aerospacesystems.dirdoc.handlers;

import java.util.ArrayList;
import java.util.List;

public enum DirDocCreatModelProvider2 {
  INSTANCE;

  public List<EffectivityObject> persons2;

  DirDocCreatModelProvider2() {
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