package com.knowledge.sharing.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name ="problem_search_tags")
public class ProblemSearchTags {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "tag")
	private String tag;
	@JsonBackReference
	@ManyToOne (cascade=CascadeType.ALL)

    private CommonProblem commonProblem;
}
