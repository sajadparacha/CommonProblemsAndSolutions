package com.knowledge.sharing.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="solution")

public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long solutionId;
    @Column(name = "solDescription")
    private String solDescription;
    @Column(name = "seqNumber")
    private int seqNumber;
    @JsonBackReference
    @ManyToOne (cascade=CascadeType.ALL)

    private CommonProblem commonProblem;


}
