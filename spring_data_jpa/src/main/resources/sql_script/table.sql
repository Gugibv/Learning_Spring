CREATE TABLE tb_customer (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  cust_name VARCHAR(255) DEFAULT NULL,
  cust_address VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO tb_customer (cust_name, cust_address) VALUES ('张三', '北京市海淀区'),
                                                         ('李四', '上海市浦东新区'),
                                                         ('王五', '广州市天河区'),
                                                         ('赵六', '深圳市南山区'),
                                                         ('钱七', '重庆市渝北区');



