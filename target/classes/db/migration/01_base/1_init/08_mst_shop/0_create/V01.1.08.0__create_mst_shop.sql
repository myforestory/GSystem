-- [テーブル作成]
-- 店舗マスタ
CREATE TABLE `mst_shop` 
     ( `shop_serial_id`   BIGINT      AUTO_INCREMENT UNIQUE NOT NULL COMMENT 'シリアルID' 
     , `shop_no`          VARCHAR(32)                                COMMENT '店舗番号' 
     , `shop_name`        VARCHAR(50)                       NOT NULL COMMENT '店舗名称' 
     , `postal_code`      VARCHAR(7)                                 COMMENT '郵便番号	 郵便番号（ハイフンを含まない' 
     , `address`          VARCHAR(100)                               COMMENT '住所' 
     , `tel`              VARCHAR(11)                                COMMENT '電話番号' 
     , `insert_time`      DATETIME                                   COMMENT '登録日時' 
     , `update_time`      DATETIME                                   COMMENT '更新日時' 
     ) COMMENT '店舗マスタ	 店舗を管理するマスタテーブル' ; 
