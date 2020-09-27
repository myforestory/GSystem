-- [訊息類別管理]
-- InformManagementMst
CREATE TABLE `mst_inform_management`
     ( `inform_management_id`      BIGINT            AUTO_INCREMENT UNIQUE NOT NULL COMMENT '訊息類別ID'
     , `inform_type`               TINYINT                          UNIQUE NOT NULL COMMENT '訊息類別種類(1.最新消息 2.訊息通知)'
     , `name`                      VARCHAR(200)                            NOT NULL COMMENT '訊息類別名稱'
     ) COMMENT '最新消息/訊息通知之類別管理TABLE' ;