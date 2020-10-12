-- -- [ForeignKey設定]
-- -- 點數管理Master（母表：會員Master）
ALTER TABLE `mst_point_management` ADD constraint `mst_point_management_FK1` foreign key(`member_id`) references `mst_member`(`member_id`);
