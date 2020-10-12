-- -- [ForeignKey設定]
-- -- 通知消息Master（母表：訊息類別管理Master）
ALTER TABLE `mst_inform` ADD constraint `mst_inform_FK1` foreign key(`inform_management_id`, `inform_type`) references `mst_inform_management`(`inform_management_id`, `inform_type`);
