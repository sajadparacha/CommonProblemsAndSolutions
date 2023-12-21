package com.knowledge.sharing.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

public class CommonProblem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commonProblemId;

	@Column(name = "problemDesc")
	private String problemDesc;


	@JsonBackReference
	@ManyToOne (cascade=CascadeType.PERSIST)
//	@ManyToOne (cascade=CascadeType.All)
	/*
	*Having cascade=CascadeType.All was deleting parent with child record
	* so we have disabled it
	* */

    private Application application;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commonProblem")
    private Set<ProblemSearchTags> problemSearchTags=new HashSet<>();
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commonProblem")
	private Set<Solution> solutions=new HashSet<>();




}
