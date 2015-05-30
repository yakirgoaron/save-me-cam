package com.MainServer.DB;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
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
public class EventsType {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String Name;
    
     //...

    public Long getId() {
        return key.getId();
    }


    public String getName() {
        return Name;
    }
    


    public void setName(String Name) {
        this.Name = Name;
    }
    

    //...
}