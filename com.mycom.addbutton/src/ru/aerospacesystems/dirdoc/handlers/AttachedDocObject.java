package ru.aerospacesystems.dirdoc.handlers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AttachedDocObject {
  private String identifier;
  private String description;
  private String revision;
  private String status;
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  public AttachedDocObject() {
  }

  public AttachedDocObject(String identifier,String description , String revision, String status) {
    super();
    this.identifier = identifier;
    this.revision = revision;
    this.status = status;
    this.description = description;
  }

  public void addPropertyChangeListener(String propertyName,
      PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }

  public String getIdentifier() {
    return identifier;
  }

  public String getDescription() {
	    return description;
	  }

  public String getStatus() {
    return status;
  }

  public String getRevision() {
    return revision;
  }



  public void setIdentifier(String identifier) {
    propertyChangeSupport.firePropertyChange("Идентифкатор", this.identifier,
        this.identifier = identifier);
  }

  public void setStatus(String status) {
    propertyChangeSupport.firePropertyChange("Статус", this.status,
        this.status = status);
  }

  public void setDescription(String description) {
	    propertyChangeSupport.firePropertyChange("Описание", this.description,
	        this.description = description);
	  }

  public void setRevision(String revision) {
    propertyChangeSupport.firePropertyChange("Модификация", this.revision,
        this.revision = revision);
  }







  @Override
  public String toString() {
    return identifier + " " + revision;
  }

}