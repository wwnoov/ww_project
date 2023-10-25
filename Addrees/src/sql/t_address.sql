create table t_address (
    id            int             primary key auto_increment,
    name          varchar(20)    not null,
    address       varchar(10)     not null,
    phone         varchar(13)     not null
);

/* 주석의 방법에는 두가지 여러줄: /*...*/  -- 한줄  */

-- insert into t_address (name, address, phone) values ('홍길동', '수원', '010-1234-5678'); 

insert into t_address set `name` = '홍길동', address='수원', phone='010-1234-5678';

select * from t_address;

