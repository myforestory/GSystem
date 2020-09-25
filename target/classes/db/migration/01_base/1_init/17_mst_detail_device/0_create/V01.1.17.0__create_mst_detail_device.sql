-- [テーブル作成]
-- デバイス明細マスタ
CREATE TABLE `mst_detail_device` 
     ( `detail_device_serial_id`       BIGINT      AUTO_INCREMENT UNIQUE NOT NULL COMMENT 'シリアルID' 
     , `device_id`                     VARCHAR(32)                                COMMENT 'デバイスID	 元になるHTのデバイスID' 
     , `child_device_id`               VARCHAR(32)                                COMMENT '子デバイスID	HTに紐づくプリンタのデバイスID' 
     , `priority`                      INT                                        COMMENT '優先順位	数値が低いほど優先度が高い' 
     , `insert_time`                   DATETIME                                   COMMENT '登録日時' 
     , `update_time`                   DATETIME                                   COMMENT '更新日時' 
     ) COMMENT 'デバイス明細マスタ	 親デバイスと子デバイスの紐づけを管理するマスタテーブル' ; 