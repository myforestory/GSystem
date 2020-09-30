-- [テーブル作成]
-- テーブル管理マスタ
CREATE TABLE `mst_table_management` 
     ( `table_no`     VARCHAR(32)       NOT NULL COMMENT 'テーブル番号	 テーブルを一意に特定する文字列。各テーブルの物理名が格納される' 
     , `is_item_no`   VARCHAR(32)       NOT NULL COMMENT '中間システム項目番号	 各テーブルカラムの物理名が格納される' 
     , `item_order`   INT                        COMMENT '項目順序	 各テーブルの列の順序。1始まり' 
     , `table_name`   VARCHAR(100)      NOT NULL COMMENT 'テーブル名	 各テーブルの論理名が格納される' 
     , `item_name`    VARCHAR(64)       NOT NULL COMMENT '項目名	 各テーブルの列（カラム）名。画面に表示するラベル' 
     , `data_type`    TINYINT DEFAULT 0 NOT NULL COMMENT 'データタイプ	 0：テキスト、1：数値、2：リスト、3：日時' 
     , `display_flag` TINYINT DEFAULT 1 NOT NULL COMMENT '表示フラグ	 0：非表示、1：表示' 
     ) COMMENT 'テーブル管理マスタ	 中間システムにあるDBの列をレコードとして管理するマスタテーブル。
テーブル管理画面のヘッダ、データタイプを持っている' ; 
