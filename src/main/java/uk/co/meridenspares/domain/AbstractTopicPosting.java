package uk.co.meridenspares.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author User
 */
@MappedSuperclass
@Audited
public abstract class AbstractTopicPosting implements TopicPosting, Auditable<String, Long>, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@NotEmpty(message="{validation.posting.subject.NotEmpty.message}")
	@Size(min=10, max=50, message="{validation.posting.subject.Size.message}")    
	@Column(name="subject")
    protected String subject;
	
	@JsonIgnore
	@NotEmpty(message="{validation.posting.body.NotEmpty.message}")
	@Size(min=10, max=2000, message="{validation.posting.body.Size.message}")
	@Column(name="body")
    protected String body;
	
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="post_date")
    protected DateTime postDate;
	
	@Column(name="created_by")
    protected String createdBy;
	
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="created_date")
    protected DateTime createdDate;
	
	@Column(name="last_modified_by")
    protected String lastModifiedBy;
	
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")	
	@DateTimeFormat(iso=ISO.DATE_TIME)	
	@Column(name="last_modified_date")
    protected DateTime lastModifiedDate;
	
	@Version
	@Column(name="version")
    protected int version;

	public Long getId() {
		return this.id;
	}
	
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public DateTime getPostDate() {
        return postDate;
    }
	
	@Transient
	public String getPostDateString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd").print(postDate);
	}	

    public void setPostDate(DateTime postDate) {
        this.postDate = postDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public DateTime getLastModifiedDate() {
		return this.lastModifiedDate;
	}
	
	@Transient
	public String getLastModifiedDateString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(lastModifiedDate);
	}	

	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}    
    
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	} 
	
	@Transient
	public final boolean isNew() {
		if (id == null) {
			return true;
		} else {
			return false;
		}
	}		
	
}
