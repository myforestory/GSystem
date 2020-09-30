-- [點數管理]
-- PointManagementMst
CREATE TABLE `mst_point_management`
     ( `point_management_id`    BIGINT      AUTO_INCREMENT UNIQUE NOT NULL COMMENT '點數管理ID,auto產生'
     , `member_id`              VARCHAR(200)                      NOT NULL COMMENT '會員ID'
     , `expired_day`            INT(3)                                     COMMENT '到期日'
     , `alert`                  TINYINT                                    COMMENT '到期通知(0.不啟用 1.啟用)'
     , `description_text`       VARCHAR(2000)                              COMMENT '說明文字'
     , `inform_text`            VARCHAR(2000)                              COMMENT '通知文字'
     , `alert_day`              INT(3)                                     COMMENT '到期提醒_日'
     , `alert_hour`             INT(3)                                     COMMENT '到期提醒_時'
     , `alert_min`              INT(3)                                     COMMENT '到期提醒_分'
     ) COMMENT '點數管理查增改刪TABLE' ;