package com.knowledge.sharing.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name ="common_problem_and_solution")
public class CommonProblemAndSolution {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "problemId")
	private long problemId;
	@Column(name = "problemDesc")
	private long problemDesc;
	@Column(name = "solution")
	private long solution;
	@ManyToOne
    private Application application;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commonProblemAndSolution")
    private Set<ProblemAttachments> problemAttachments=new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commonProblemAndSolution")
    private Set<ProblemSearchTags> problemSearchTags=new HashSet<>();
	
	
	

}
