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
@Table(name="topicentryattachment")
public class TopicEntryAttachment extends TopicAttachment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="topicentry_id")	
	private TopicEntry topicEntry;

	public TopicEntry getTopicEntry() {
		return topicEntry;
	}

	public void setTopicEntry(TopicEntry topicEntry) {
		this.topicEntry = topicEntry;
	}	
	
}
