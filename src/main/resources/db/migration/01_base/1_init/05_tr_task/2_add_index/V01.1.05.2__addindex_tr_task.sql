-- インデックス設定
CREATE INDEX `tr_task_IX1` 
    ON `tr_task`(`batch_no`) ; 
CREATE INDEX `tr_task_IX2` 
    ON `tr_task`(`batch_no`, `batch_detail_no`) ; 