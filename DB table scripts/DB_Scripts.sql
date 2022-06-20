create table Teachers (tid int primary key, tname  varchar(30));

--  insert into Teachers values(1, "ABC"); //this is to test in MYSQL 
-- insert into Teachers values(?, ?);  //this is to plug in java class

create table Subjects (subid int primary key, subname  varchar(30));

--  insert into Subjects values(1, "ABC"); //this is to test in MYSQL 
-- insert into Subjects values(?, ?);  //this is to plug in java class
/*
create table classroomteacher (sno int primary key, classroomid  int, subid int, 
index par_ind(subid),  FOREIGN KEY (subid) references Subjects(subid),
tid int, index tea_ind(tid),FOREIGN KEY (tid) references Teachers(tid)  );
*/

create table classroomteacher (sno INT UNSIGNED NOT NULL AUTO_INCREMENT,
     PRIMARY KEY (sno), classroomid  int, subid int, 
index par_ind(subid),  FOREIGN KEY (subid) references Subjects(subid),
tid int, index tea_ind(tid),FOREIGN KEY (tid) references Teachers(tid)  );



--insert into classroomteacher values (1, 1, 1, 1);
-- insert into classroomteacher values(?,?,?,?);  //this is to plug in java class

/* sample test for auto increment
CREATE TABLE insect
     (
     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
     PRIMARY KEY (id),
    name VARCHAR(30) ,  
     date DATE NOT NULL,  
     origin VARCHAR(30)  
);

INSERT INTO insect (id,name,date,origin) VALUES
    (NULL,'housefly','2001-09-10','kitchen'),
    (NULL,'millipede','2001-09-10','driveway'),
      (NULL,'grasshopper','2001-09-10','front yard');
*/	  

create table acamdemicclass(clid int primary key, classnum int);  
-- insert into acamdemicclass values (1,10);
-- insert into acamdemicclass values (?,?); //this is to plug in java class
 
--create table StudentClass (stdid int primary key, stdname  varchar(30),  );

create table studentdets(stdid int primary key, stdname varchar(30), clid int);
--  insert into studentdets values (1,'veer',10);
-- insert into studentdets values (?,?,?);