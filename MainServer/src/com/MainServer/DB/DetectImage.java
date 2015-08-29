/**
 * JDO object for DetectImage
 */
package com.MainServer.DB;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * JDO-annotated model class for storing DetectImage properties;
 * saves an image that was runs from detection
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class DetectImage {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private Long userID;
    
    @Persistent
    @Extension(vendorName="datanucleus", key="gae.unindexed", value="true")
    private int detection;

    @Persistent
    private Long imageSaverId;

    //...

    public Long getId() {
        return key.getId();
    }


    public Long getuserID() {
        return userID;
    }
    
    public int getdetection() {
        return detection;
    }
    
    public Long getimageSaverId() {
        return imageSaverId;
    }

    public void setuserID(Long userID) {
        this.userID = userID;
    }
    
    public void seDetection(int detection) {
        this.detection = detection;
    }

    public void setimageSaverId(Long imageID) {
        this.imageSaverId = imageID;
    }

}