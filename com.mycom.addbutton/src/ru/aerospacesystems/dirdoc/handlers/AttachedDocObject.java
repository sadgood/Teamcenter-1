package ru.aerospacesystems.dirdoc.handlers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AttachedDocObject {
  private String identifier;
  private String revision;
  private String status;
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  public AttachedDocObject() {
  }

  public AttachedDocObject(String identifier, String revision, String status) {
    super();
    this.identifier = identifier;
    this.revision = revision;
    this.status = status;

  }

  public void addPropertyChangeListener(String propertyName,
      PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }

  public String getFirstName() {
    return identifier;
  }

  public String getGender() {
    return status;
  }

  public String getLastName() {
    return revision;
  }

 

  public void setFirstName(String identifier) {
    propertyChangeSupport.firePropertyChange("Идентифкатор", this.identifier,
        this.identifier = identifier);
  }

  public void setGender(String status) {
    propertyChangeSupport.firePropertyChange("Статус", this.status,
        this.status = status);
  }

  public void setLastName(String revision) {
    propertyChangeSupport.firePropertyChange("Модификация", this.revision,
        this.revision = revision);
  }

 



 

  @Override
  public String toString() {
    return identifier + " " + revision;
  }

}