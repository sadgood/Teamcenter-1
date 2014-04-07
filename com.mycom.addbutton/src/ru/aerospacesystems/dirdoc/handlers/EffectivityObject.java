package ru.aerospacesystems.dirdoc.handlers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EffectivityObject {
  private String item;
  private String instantces;

  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  public EffectivityObject() {
  }

  public EffectivityObject(String item, String instantces) {
    super();
    this.item = item;
    this.instantces = instantces;


  }

  public void addPropertyChangeListener(String propertyName,
      PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }

  public String getFirstName() {
    return item;
  }


  public String getLastName() {
    return instantces;
  }



  public void setFirstName(String item) {
    propertyChangeSupport.firePropertyChange("Идентифкатор", this.item,
        this.item = item);
  }



  public void setLastName(String instantces) {
    propertyChangeSupport.firePropertyChange("Модификация", this.instantces,
        this.instantces = instantces);
  }



 @Override
  public String toString() {
    return item + " " + instantces;
  }

}