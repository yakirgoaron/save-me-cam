package com.server.MMSServer.ProcessingUnit;
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
public class LocationSaver {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private Date detectedDate;
    
    @Persistent
    private String ipOfLocation;

    //...

    public Long getId() {
        return key.getId();
    }


    public Date getDate() {
        return detectedDate;
    }
    
    public String getIpLocation() {
        return ipOfLocation;
    }


    public void setIpLocation(String ipOfLocation) {
        this.ipOfLocation = ipOfLocation;
    }
    
    public void setDetectedDate(Date detectedDate) {
        this.detectedDate = detectedDate;
    }

    //...
}