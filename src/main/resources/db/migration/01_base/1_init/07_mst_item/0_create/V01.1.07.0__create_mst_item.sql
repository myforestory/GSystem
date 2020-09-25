-- [テーブル作成]
-- 商品マスタ
CREATE TABLE `mst_item` 
     ( `item_serial_id` BIGINT       AUTO_INCREMENT UNIQUE NOT NULL COMMENT 'シリアルID' 
     , `product_no`     VARCHAR(32)                                 COMMENT '商品番号	 商品を一意に特定する文字列' 
     , `scan_code`      VARCHAR(128)                       NOT NULL COMMENT 'スキャンコード	（旧JANコード）' 
     , `scan_message`   VARCHAR(32)                                 COMMENT 'スキャンメッセージ	HTのスキャン時に送信する警告メッセージ' 
     , `product_name`   VARCHAR(100)                       NOT NULL COMMENT '商品名' 
     , `length`         MEDIUMINT                                   COMMENT '縦	 単位：mm' 
     , `widht`          MEDIUMINT                                   COMMENT '横	 単位：mm' 
     , `height`         MEDIUMINT                                   COMMENT '高さ	 単位：mm' 
     , `weight`         INT                                         COMMENT '重量	 単位：g' 
     , `tile_angle`     SMALLINT                           NOT NULL COMMENT '傾き	 単位：度（60～90度）' 
     , `touch_credit`   INT                                NOT NULL COMMENT 'タッチ単位	 タスクを取り込んだときに、タスクを分割する数量' 
     , `insert_time`    DATETIME                                    COMMENT '登録日時' 
     , `update_time`    DATETIME                                    COMMENT '更新日時' 
     ) COMMENT '商品マスタ	 商品を管理するマスタテーブル' ; 
