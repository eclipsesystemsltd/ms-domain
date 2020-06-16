package uk.co.meridenspares.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.domain.Auditable;

/**
 * @author User
 *
 */
@Entity
@Audited
@Table(name = "topicentry")
public class TopicEntry extends AbstractTopicPosting implements Serializable {
	private static final long serialVersionUID = 1L;
    private static final int MAX_BODY_LENGTH = 80;
    private static final String THREE_DOTS = "...";
    Auditable a;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")	
	private TopicCategory topicCategory;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sub_category_id")	
	private TopicCategory childTopicCategory;
	
	@Column(name="rating")
	private int rating;
	
	@JsonIgnore
	@NotAudited
	@OneToMany(fetch=FetchType.LAZY, mappedBy="topicEntry", cascade=CascadeType.ALL)
	private Set<TopicEntryAttachment> attachments = new HashSet<TopicEntryAttachment>();
	
	@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "topicEntry", cascade = CascadeType.ALL)
	private Set<TopicComment> topicComments = new HashSet<TopicComment>();
	
	@Transient
    public String getShortBody() {
        if (body.length() <= MAX_BODY_LENGTH)
            return body;
        StringBuffer result = new StringBuffer(MAX_BODY_LENGTH + 3);
        result.append(body.substring(0, MAX_BODY_LENGTH));
        result.append(THREE_DOTS);

        return result.toString();
    }

	public TopicCategory getTopicCategory() {
		return this.topicCategory;
	}

	public void setTopicCategory(TopicCategory topicCategory) {
		this.topicCategory = topicCategory;
	}

	public TopicCategory getChildTopicCategory() {
		return this.childTopicCategory;
	}

	public void setChildTopicCategory(TopicCategory childTopicCategory) {
		this.childTopicCategory = childTopicCategory;
	}

	public Set<TopicEntryAttachment> getAttachments() {
		return this.attachments;
	}
	
    public void setAttachments(Set<TopicEntryAttachment> attachments) {
        this.attachments = attachments;
    }		

	public Set<TopicComment> getTopicComments() {
		return this.topicComments;
	}

	public void setTopicComments(Set<TopicComment> comments) {
		this.topicComments = comments;
	}
	
	public void addTopicComment(TopicComment comment) {
		comment.setEntry(this);
		getTopicComments().add(comment);
	}
	
	public void addAttachment(TopicEntryAttachment attachment) {
		getAttachments().add(attachment);
	}	
	
	public String toString() {
		return "Entry id: " + id + " - subject: " + subject + " - category: " + topicCategory
				+ " - post date: " + postDate
				+ " - created by: " + createdBy + " - created date: " + createdDate
				+ " - last modified by: " + lastModifiedBy + " - last modified date: " + lastModifiedDate
				+ " - version: " + version;
	}
}
