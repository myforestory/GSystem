-- [系統管理者]
-- AdministratorMst
CREATE TABLE `mst_administrator`
     ( `administrator_id`          VARCHAR(200)             UNIQUE NOT NULL COMMENT '系統管理者帳號'
     , `password`                  VARCHAR(200)                    NOT NULL COMMENT '系統管理者密碼'
     , `authorization`             VARCHAR(200)                    NOT NULL COMMENT '權限(待查證)'
     ) COMMENT '系統管理者查增改刪TABLE' ;