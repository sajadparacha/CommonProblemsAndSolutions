package com.knowledge.sharing.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name ="application")
public class Application {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "applDescription")
	private String applDescription;
	@Column(name = "applName")
	private String applName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
    private Set<CommonProblemAndSolution> ingredients=new HashSet<>();
}
