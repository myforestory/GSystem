-- ユニークインデックス設定
CREATE UNIQUE INDEX `mst_is_item_PKI` 
    ON `mst_is_item`(`mapping_no`, `is_item_no`) ; 
