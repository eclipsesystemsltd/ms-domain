package uk.co.meridenspares.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name="topiccommentattachment")
public class TopicCommentAttachment extends TopicAttachment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topiccomment_id")	
	private TopicComment topicComment;

	public TopicComment getTopicComment() {
		return topicComment;
	}

	public void setTopicComment(TopicComment comment) {
		this.topicComment = comment;
	}	
	
}
