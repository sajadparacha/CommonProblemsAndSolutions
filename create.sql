create table application (application_id bigint generated by default as identity, appl_description varchar(255), appl_name varchar(255), primary key (application_id));
create table common_problem_and_solution (common_problem_id bigint generated by default as identity, problem_desc varchar(255), application_application_id bigint, primary key (common_problem_id));
create table problem_search_tags (problem_search_tag_id bigint generated by default as identity, tag varchar(255), common_problem_common_problem_id bigint, primary key (problem_search_tag_id));
create table solution (solution_id bigint generated by default as identity, seq_number integer, sol_description varchar(255), common_problem_common_problem_id bigint, primary key (solution_id));
alter table common_problem_and_solution add constraint FKnq3uobh4yte8evbwqlfr7v1q0 foreign key (application_application_id) references application;
alter table problem_search_tags add constraint FKi256aq8spypu9sa05i4lttlb2 foreign key (common_problem_common_problem_id) references common_problem_and_solution;
alter table solution add constraint FK4h05himf7gqpimh0k76prisca foreign key (common_problem_common_problem_id) references common_problem_and_solution;
insert into APPLICATION (application_id,appl_description,appl_name) values (3,'DIOR','Drilling Reports');
Insert into  COMMON_PROBLEM_AND_SOLUTION (common_problem_id,problem_desc,Application_application_id) values (3,'Problem',3);
insert into SOLUTION  (solution_id,seq_number,sol_description,common_problem_common_problem_id) values (3,1,'solution',3);
insert into APPLICATION (application_id,appl_description,appl_name) values (4,'EWellFile','Well File Attachment');
Insert into  COMMON_PROBLEM_AND_SOLUTION (common_problem_id,problem_desc,Application_application_id) values (4,'Problem',4);
insert into SOLUTION  (solution_id,seq_number,sol_description,common_problem_common_problem_id) values (4,1,'solution',4);
insert into APPLICATION (application_id,appl_description,appl_name) values (1,'CSAS','Cement Slurry Application');
Insert into  COMMON_PROBLEM_AND_SOLUTION (common_problem_id,problem_desc,Application_application_id) values (1,'Problem',1);
insert into SOLUTION  (solution_id,seq_number,sol_description,common_problem_common_problem_id) values (1,1,'solution',1);
insert into APPLICATION (application_id,appl_description,appl_name) values (2,'BRAVO','Drilling Best Practices');
Insert into  COMMON_PROBLEM_AND_SOLUTION (common_problem_id,problem_desc,Application_application_id) values (2,'Problem',2);
insert into SOLUTION  (solution_id,seq_number,sol_description,common_problem_common_problem_id) values (2,1,'solution',2);
insert into APPLICATION (application_id,appl_description,appl_name) values (5,'SADK','SADK');
Insert into  COMMON_PROBLEM_AND_SOLUTION (common_problem_id,problem_desc,Application_application_id) values (5,'Problem',5);
insert into SOLUTION  (solution_id,seq_number,sol_description,common_problem_common_problem_id) values (5,1,'solution',5);
