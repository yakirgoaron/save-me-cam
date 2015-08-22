package com.MainServer;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.MainServer.DB.Users;

public class SendMail {
	private static final Logger logger = Logger.getLogger("SendMail");
	public static void SendMailToUsers(String Title,String Body, List<Users> UsersMail)
	{
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = Body;
       
        try {
            Message msg = new MimeMessage(session);
            
			msg.setFrom(new InternetAddress("admin@uplifted-plate-89814.appspotmail.com", "Save Me CAM mail"));
			for (Iterator mail = UsersMail.iterator(); mail.hasNext();)
		    {
				Users data = (Users) mail.next();
				msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(data.getMail(), data.getName()));
		    }
            msg.setSubject(Title);
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (AddressException e) {
        	logger.fine(e.toString());
        	
            // ...
        } catch (MessagingException e) {
        	logger.fine(e.toString());
            // ...
        }
        catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
        	logger.fine(e.toString());
			e.printStackTrace();
		}
	}

}
