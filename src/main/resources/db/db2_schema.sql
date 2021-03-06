-- [テーブル作成]
-- タスク履歴
DROP TABLE `tr_task_hst`;

CREATE TABLE IF NOT EXISTS `tr_task_hst` 
     ( `task_hst_serial_id`                BIGINT      AUTO_INCREMENT UNIQUE NOT NULL COMMENT 'シリアルID' 
     , `wes_no`                            BIGINT                                     COMMENT 'WES No' 
     , `foreign_link_no1`                  VARCHAR(128)                               COMMENT '旧タスク番号	 入庫番号/出荷番号/ピッキングNo/タスクNo' 
     , `foreign_link_no2`                  VARCHAR(128)                               COMMENT '旧タスク番号	 入庫明細番号/出荷明細番号' 
     , `batch_no`                          VARCHAR(20)                                COMMENT 'バッチ番号' 
     , `batch_detail_no`                   INT                                        COMMENT 'バッチ明細番号	 取り込み時に採番' 
     , `task_type`                         TINYINT                           NOT NULL COMMENT 'タスクタイプ	 1：通常仕分け、5：返品仕分け、10：TC仕分け、15：手仕分け、20：搬送仕分け、31：ピッキング、61：補充' 
     , `product_no`                        VARCHAR(32)                                COMMENT '商品番号	 商品を一意に特定する文字列' 
     , `scan_code`                         VARCHAR(128)                               COMMENT 'スキャンコード（旧JANコード）	CSV取り込み時に商品マスタから検索して登録。' 
     , `scan_message`                      VARCHAR(32)                                COMMENT 'スキャンメッセージ	HTのスキャン時に送信する警告メッセージ' 
     , `rfid`                              VARCHAR(500)                               COMMENT 'RFID' 
     , `manufacturing_lot`                 VARCHAR(128)                               COMMENT '製造ロット	 製造ロット番号が設定される' 
     , `manufacturing_expiration_date`     VARCHAR(6)                                 COMMENT '製造年月日/賞味期限	 賞味期限もしくは製造日が設定される。YYMMDD形式' 
     , `plan_quantity`                     INT                               NOT NULL COMMENT '予定数量	 製造ロット番号が設定される' 
     , `chute_no`                          VARCHAR(10)                                COMMENT 'シュートNo	 スキャンした商品の運び先' 
     , `chute_branch_no`                   VARCHAR(3)                                 COMMENT 'シュート枝番	 スキャンした商品の運び先' 
     , `task_order`                        INT                                        COMMENT '（旧シュート順序）	低い数値から順にLibiaoはシュートへ運ぶ。シュート割付時に振られる' 
     , `shop_no`                           VARCHAR(32)                                COMMENT '店舗番号' 
     , `shop_name`                         VARCHAR(50)                                COMMENT '店舗名称' 
     , `status`                            TINYINT     DEFAULT 0             NOT NULL COMMENT 'ステータス	 0：未処理、1：割当済、2：開始済、3：処理中、4：完了済、5：終了' 
     , `temporary_holding`                 TINYINT                                    COMMENT '一時保留	 0：保留なし、1：保留中'
     , `csv_out_flag`                      TINYINT     DEFAULT 0             NOT NULL COMMENT '自動CSV出力フラグ	 0：未出力、1：出力済' 
     , `robot_id`                          VARCHAR(10)                                COMMENT 'robotID	（旧機器ID）Libiaoを一意に特定する文字列' 
     , `induction_id`                      VARCHAR(10)                                COMMENT 'インダクションID	（旧スキャンID）。RCSから送られてくるステーションID' 
     , `device_id`                         VARCHAR(32)                                COMMENT 'インダクションID	（旧スキャンID）。スキャンシステム等から送られてくるデバイスID' 
     , `result_quantity`                   INT                                        COMMENT '実績数量	 スキャンシステムがスキャンした数量' 
     , `box_no`                            BIGINT                                     COMMENT '箱番号	 自動採番' 
     , `change_num`                        INT                                        COMMENT '箱切替番号	箱切り替え時にそのシュートの何番目の箱かを表示する'
     , `remarks`                           VARCHAR(32)                                COMMENT '備考欄	ラベルに印刷する備考'
     , `scan_time`                         DATETIME                                   COMMENT 'スキャン日時	 商品をスキャンした日時' 
     , `chute_time`                        DATETIME                                   COMMENT 'シュート日時	 Libiaoがシュートへ投入完了した日時' 
     , `insert_time`                       DATETIME                                   COMMENT '登録日時' 
     , `update_time`                       DATETIME                                   COMMENT '更新日時' 
     , `hist_insert_time`                  DATETIME                                   COMMENT '履歴登録日時	 履歴テーブルに登録した日時' 
     ) COMMENT 'タスク履歴	 タスクの履歴を管理するトランザクションテーブル' ; 
     