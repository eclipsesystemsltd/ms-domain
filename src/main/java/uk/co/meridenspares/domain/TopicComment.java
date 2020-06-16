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

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

/**
 * @author User
 *
 */
@Entity
@Audited
@Table(name = "comment")
//@NamedQueries({
//	@NamedQuery(name="Comment.findReplyToByEntryId", 
//                query="select distinct c.postBy from Comment c where c.entry.id = :entryId")
//})
public class TopicComment extends AbstractTopicPosting implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topicentry_id")
	private TopicEntry topicEntry;
	
	@Column(name = "reply_to")
	private String replyTo;
	
	@Column(name = "post_by")
	private String postBy;
	
	@NotAudited
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "topicComment", cascade = CascadeType.ALL)
	private Set<TopicCommentAttachment> attachments = new HashSet<TopicCommentAttachment>();

	public TopicEntry getEntry() {
		return this.topicEntry;
	}

	public void setEntry(TopicEntry entry) {
		this.topicEntry = entry;
	}

	public String getReplyTo() {
		return this.replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getPostBy() {
		return this.postBy;
	}

	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}

	public Set<TopicCommentAttachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set<TopicCommentAttachment> attachments) {
		this.attachments = attachments;
	}	
	
	public void addAttachment(TopicCommentAttachment attachment) {
		getAttachments().add(attachment);
	}		
}
