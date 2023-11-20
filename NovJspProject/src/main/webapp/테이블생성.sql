CREATE TABLE mvcboard(
                         idx int AUTO_INCREMENT PRIMARY KEY ,
                         name varchar(50) NOT NULL,
                         title varchar(200) NOT NULL,
                         content varchar(2000) NOT NULL,
                         postdate date DEFAULT current_date NOT NULL,
                         ofile varchar(200),
                         sfile varchar(30),
                         downcount int DEFAULT 0 NOT NULL,
                         pass varchar(50) NOT NULL,
                         visitcount int DEFAULT 0 NOT NULL
);