-- ユニークインデックス設定
CREATE UNIQUE INDEX `mst_table_management_PKI` 
    ON `mst_table_management`(`table_no`, `is_item_no`) ; 
