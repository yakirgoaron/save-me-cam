/**
 * JDO object for Users
 */
package com.MainServer.DB;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * JDO-annotated model class for storing Users properties;
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Users {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String Name;
    
    
    @Persistent
    private String Mail;
    
    @Persistent
    private String Number;
    
    @Persistent
    private Long CameraID;
    
     //...

    public Long getId() {
        return key.getId();
    }


    public String getMail() {
        return Mail;
    }
    


    public void setMail(String Mail) {
        this.Mail = Mail;
    }


    public String getNumber() {
		return Number;
	}


    public void setNumber(String Number) {
		this.Number = Number;
	}


	public String getName() {
		return Name;
	}


	public void setName(String Name) {
		this.Name = Name;
	}


	public Long getCameraID() {
		return CameraID;
	}


	public void setCameraID(Long CameraID) {
		this.CameraID = CameraID;
	}
    

    //...
}