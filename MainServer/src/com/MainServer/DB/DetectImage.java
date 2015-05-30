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

    //...
}