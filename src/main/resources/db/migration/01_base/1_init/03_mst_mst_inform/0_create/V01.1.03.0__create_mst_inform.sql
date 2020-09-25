-- [訊息類別]
-- BannerMst
CREATE TABLE `mst_inform`
     ( `inform_id`                BIGINT      AUTO_INCREMENT UNIQUE NOT NULL COMMENT '訊息ID'
     , `inform_management_id`     VARCHAR(200)                      NOT NULL COMMENT '訊息類別ID'
     , `inform_type`              TINYINT                           NOT NULL COMMENT '訊息類別種類(1.最新消息 2.訊息通知)'
     , `name`                     VARCHAR(200)                      NOT NULL COMMENT '訊息類別名稱'
     , `status`                   TINYINT                                    COMMENT '訊息狀態(1.簡訊推播兩者 2.簡訊 3.推播)'
     , `popup`                    TINYINT                                    COMMENT '訊息狀態(1.不顯示 2.顯示)'
     , `text`                     VARCHAR(10000)                             COMMENT '推播內容'
     , `podcast_time`             DATETIME                                   COMMENT '發送時間'
     ) COMMENT '最新消息/訊息通知之TABLE' ;
