-- [會員]
-- MemberMst
CREATE TABLE `mst_member`
     ( `member_id`              VARCHAR(200)               UNIQUE NOT NULL COMMENT '會員ID("member_type"+";"+"member_account")(ex: FB;0934300300)'
     , `member_type`            VARCHAR(200)                      NOT NULL COMMENT '會員類別'
     , `member_account`         VARCHAR(200)                      NOT NULL COMMENT '會員帳號'
     , `password`               VARCHAR(200)                      NOT NULL COMMENT '會員密碼(暗碼處理)'
     , `name`                   VARCHAR(200)                               COMMENT '姓名'
     , `mobile`                 INT(12)                                    COMMENT '手機(ex：0934300300)'
     , `sex`                    VARCHAR(10)                                COMMENT '性別'
     , `birth`                  INT(10)                                    COMMENT '生日(ex：19920101)'
     , `address`                VARCHAR(1000)                              COMMENT '地址'
     , `permission`             TINYINT                                    COMMENT '認證狀態(0.未認證 1.已認證)'
     , `banned`                 TINYINT                                    COMMENT '停權狀態(0.未停權 1.已停權)'
     , `re_message`             TINYINT                                    COMMENT '重發簡訊(0.未發送 1.已發送)'
     ) COMMENT '會員查增改刪TABLE' ;