package uk.co.meridenspares.domain;

import org.joda.time.DateTime;

/**
 * @author User
 *
 */
public interface TopicPosting {
    
    public String getBody();
    public void setBody(String body);
    
    public DateTime getPostDate();
    public void setPostDate(DateTime postDate);
    
    public String getSubject();
    public void setSubject(String subject);	
	
}
