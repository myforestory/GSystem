-- [テーブル作成]
-- 中間システム項目マスタ
CREATE TABLE `mst_is_item` 
     ( `is_item_serial_id`     BIGINT      AUTO_INCREMENT UNIQUE NOT NULL COMMENT 'シリアルID' 
     , `mapping_no`            VARCHAR(32)                       NOT NULL COMMENT 'マッピング番号	 PK項目1。マッピング画面を一意に特定する文字列。CSV種類マスタのCSV番号と同じ' 
     , `is_item_no`            VARCHAR(32)                       NOT NULL COMMENT '中間システム項目番号	 PK項目2。1つのマッピング画面内で中間システム項目を特定する文字列。各テーブルカラムの物理名が格納される' 
     , `seq_no`                INT                               NOT NULL COMMENT '順序番号	 マッピング画面ごとの中間システム項目の並び（1始まり）' 
     , `table_no`              VARCHAR(32)                       NOT NULL COMMENT 'テーブル番号	 テーブルを一意に特定する文字列。各テーブルの物理名が格納される' 
     , `is_item_required_flag` TINYINT                           NOT NULL COMMENT '中間システム項目必須フラグ	 この中間項目がWMS項目へマッピング必須なのか任意なのかを表すフラグ（0：任意、1：必須）' 
     ) COMMENT '中間システム項目マスタ	 マッピング画面ごとに複数の中間システム項目を管理するマスタテーブル。
マッピングWMS項目マスタの該当マッピングIDに紐づくレコードが存在しない場合、
初回はこのマスタから中間システム項目の並びを取得する' ; 
