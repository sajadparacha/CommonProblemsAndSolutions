//package com.knowledge.sharing.bootstrap;
//
//import com.knowledge.sharing.domain.Application;
//import com.knowledge.sharing.domain.CommonProblem;
//import com.knowledge.sharing.domain.Solution;
//import com.knowledge.sharing.repositories.ApplicationRepository;
//import com.knowledge.sharing.repositories.CommonProblemRepository;
//import com.knowledge.sharing.repositories.ProblemSearchTagsRepository;
//import com.knowledge.sharing.repositories.SolutionRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class Bootstrap implements CommandLineRunner {
//    ApplicationRepository applicationRepository;
//    CommonProblemRepository commonProblemRepository;
//    ProblemSearchTagsRepository problemSearchTagRepository;
//    SolutionRepository solutionRepository;
//
//    public Bootstrap(ApplicationRepository applicationRepository, CommonProblemRepository commonProblemRepository, ProblemSearchTagsRepository problemSearchTagRepository, SolutionRepository solutionRepository) {
//        this.applicationRepository = applicationRepository;
//        this.commonProblemRepository = commonProblemRepository;
//        this.problemSearchTagRepository = problemSearchTagRepository;
//        this.solutionRepository = solutionRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Inserting Records in Database");
//        Application application1= Application.builder().applicationId(1l).applName("CSAS").applDescription("Cement Slurry Application").build();
//        applicationRepository.save(application1);
//        CommonProblem commonProblem1 = CommonProblem
//                .builder()
//                .commonProblemId(1l)
//                .problemDesc("Problems 1")
//                .application(application1)
//                .build();
//        commonProblemRepository.save(commonProblem1);
//        Solution solution1=Solution.builder()
//                .solutionId(1l)
//                .commonProblem(commonProblem1)
//                .seqNumber(1)
//                .solDescription("Solution 1")
//                .build();
//        solutionRepository.save(solution1);
//
//
//
//        Application application2= Application.builder().applicationId(2l).applName("BRAVO").applDescription("Drilling Best Practices").build();
//        applicationRepository.save(application2);
//
//        CommonProblem commonProblem2 = CommonProblem
//                .builder()
//                .commonProblemId(2l)
//                .problemDesc("Problems 2")
//                .application(application2)
//                .build();
//        commonProblemRepository.save(commonProblem2);
//
//        Solution solution2=Solution.builder()
//                .solutionId(2l)
//                .commonProblem(commonProblem2)
//                .seqNumber(2)
//                .solDescription("Solution 2")
//                .build();
//        solutionRepository.save(solution1);
//
//        System.out.println("Inserting Records in Database");
//
//    }
//}
