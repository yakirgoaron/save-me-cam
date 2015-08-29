/**
 * JDO object for camera
 */
package com.MainServer.DB;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * JDO-annotated model class for storing Camera properties; 
 * image is stored as a Blob (large byte array) in the image field.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Camera {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String Password;
  
    @Persistent
    private String Number;
    
    
    public Long getId() {
        return key.getId();
    }


    public String getPassword() {
        return Password;
    }
    

    public void setPassword(String Password) {
        this.Password = Password;
    }


    public String getNumber() {
		return Number;
	}


    public void setNumber(String Number) {
		this.Number = Number;
	}

}