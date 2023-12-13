CREATE TABLE mvcboard(
                         idx int  PRIMARY KEY AUTO_INCREMENT,
                         name varchar(50) NOT NULL,
                         title varchar(200) NOT NULL,
                         content varchar(2000) NOT NULL,
                         postdate timestamp DEFAULT now() NOT NULL,
                         ofile varchar(200),
                         sfile varchar(30),
                         downcount int DEFAULT 0 NOT NULL,
                         pass varchar(300) NOT NULL,
                         visitcount int DEFAULT 0 NOT NULL
);