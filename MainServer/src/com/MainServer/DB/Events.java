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
public class Events {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private Date date;
    
    @Persistent
    private Long TypeId;
    
    @Persistent
    private String Message;
    
    @Persistent
    private Long UserID;
    
    @Persistent
    private Long ImageID;
    
     //...

    public Long getId() {
        return key.getId();
    }

    public Long getImageID() {
        return this.ImageID;
    }

    public Date getDate() {
        return date;
    }
    


    public void setDate(Date date) {
        this.date = date;
    }


    public Long getTypeId() {
		return TypeId;
	}


    public void setTypeId(Long typeId) {
		this.TypeId = typeId;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		this.Message = message;
	}


	public Long getUserID() {
		return UserID;
	}


	public void setUserID(Long userID) {
		this.UserID = userID;
	}
	
	public void setImageID(Long ImageID) {
		this.ImageID = ImageID;
	}
    

    //...
}