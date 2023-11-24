create table t_user (
   id int auto_increment primary key,
   realname varchar(255),
   cardno varchar(255),
   balance int
);



INSERT INTO t_user (realname, cardno, balance) VALUES
('John Doe', '1234567890', 100),
('Jane Smith', '0987654321', 200),
('Michael Johnson', '5678901234', 150),
('Emily Davis', '4321098765', 300),
('David Brown', '9876543210', 250);
