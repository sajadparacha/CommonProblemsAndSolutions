package com.knowledge.sharing.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="problem_attachments")
public class ProblemAttachments {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "attachmentDesc")
	private String attachmentDesc;
	//problem= This Attachment is related to problem , solution= this attachment is related to solution
	@Column(name = "attachmentType")
	private String attachmentType;
	
	@ManyToOne
    private CommonProblemAndSolution commonProblemAndSolution;
}
