package com.MainServer.DB;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * JDO-annotated model class for storing movie properties; movie's promotional
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
    
     //...

    public Long getId() {
        return key.getId();
    }


    public String getPassword() {
        return Password;
    }
    


    public void setMail(String Password) {
        this.Password = Password;
    }


    public String getNumber() {
		return Number;
	}


    public void setNumber(String Number) {
		this.Number = Number;
	}

    //...
}