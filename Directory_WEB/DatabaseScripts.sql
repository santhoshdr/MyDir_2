DROP TABLE IF EXISTS directory.member;

create table directory.member (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   sex VARCHAR(20) default NULL,
   date_of_birth  DATE,
   Occupation VARCHAR(20) default NULL,
   married BOOLEAN default FALSE,
   location VARCHAR(20) default NULL,
   creationDate DATE,
   updatedDate DATE,
   updatedBy VARCHAR(20) default NULL,
   createdBy VARCHAR(20) default NULL,
   PRIMARY KEY (id)
);