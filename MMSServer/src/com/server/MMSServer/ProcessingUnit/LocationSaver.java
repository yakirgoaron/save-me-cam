/**
 * JDO to save location data to DB
 */

package com.server.MMSServer.ProcessingUnit;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

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
    private String Country;
    
    @Persistent
    private String Region;
    
    @Persistent
    private String City;
        
    @Persistent
    private Date LocDate;
    
    @Persistent
    private int LocX;

    @Persistent
    private int LocY;
    
    @Persistent
    private Long ImageID;
    //...

    public Long getId() {
        return key.getId();
    }


    public String getCountry() {
        return Country;
    }
    
    public String getRegion() {
        return Region;
    }
    
    public String getCity() {
        return City;
    }
    
    public int getLocX() {
        return LocX;
    }
    
    public Date getDate() {
        return LocDate;
    }
    
    public int getLocY() {
        return LocY;
    }
    
    public Long getImageID() {
        return  ImageID;
    }


    public void setCountry(String Country) {
        this.Country = Country;
    }
    
    public void setRegion(String Region) {
        this.Region = Region;
    }
    
    public void setCity(String City) {
        this.City = City;
    }
    
    public void setLocX(int LocX) {
        this.LocX = LocX;
    }
    
    public void setLocY(int LocY) {
        this.LocY = LocY;
    }
    
    public void setLocDate(Date LocDate) {
        this.LocDate = LocDate;
    }
    
    public void setImageID(Long ImageID) {
        this.ImageID = ImageID;
    }

    //...
}