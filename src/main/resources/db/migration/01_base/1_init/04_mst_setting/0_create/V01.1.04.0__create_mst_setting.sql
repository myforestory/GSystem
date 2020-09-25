-- [テーブル作成]
-- 設定マスタ
CREATE TABLE `mst_setting` 
     ( `setting_serial_id`      BIGINT      AUTO_INCREMENT UNIQUE  NOT NULL COMMENT 'シリアルID' 
     , `setting_no`             VARCHAR(16) DEFAULT '1'            NOT NULL COMMENT '設定番号	 設定マスタのレコードを一意に特定する文字列' 
     , `wms_name`               VARCHAR(32) DEFAULT 'WMS'          NOT NULL COMMENT 'WMS名' 
     , `is_name`                VARCHAR(32) DEFAULT '中間システム' NOT NULL COMMENT '中間システム名' 
     , `continuous_entry_times` INT         DEFAULT 5              NOT NULL COMMENT '連続投入回数	 同じシュートに連続で投入できる回数' 
     , `ana_scm_upd_seconds`    INT         DEFAULT 5              NOT NULL COMMENT '分析画面更新秒数	 分析画面で自動更新を行う秒数' 
     , `gridx_size`             INT                                         COMMENT 'グリッドXサイズ	シュート進捗画面のレイアウト表示サイズ(X座標)'
     , `gridy_size`             INT                                         COMMENT 'グリッドYサイズ	シュート進捗画面のレイアウト表示サイズ(Y座標)'
     ) COMMENT '設定マスタ	 システム名等を定義する設定管理マスタテーブル。
※現在は一行のみ' ; 
