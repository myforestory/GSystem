-- [首頁Banner]
-- BannerMst
CREATE TABLE `mst_banner`
     ( `banner_id`      BIGINT      AUTO_INCREMENT UNIQUE NOT NULL COMMENT 'bannerID,auto產生'
     , `name`           VARCHAR(200)                      NOT NULL COMMENT 'banner標題'
     , `image`          MEDIUMBLOB                        NOT NULL COMMENT 'banner上傳圖片'
     , `upload_time`    DATETIME                          NOT NULL COMMENT 'banner上架時間'
     , `remove_time`    DATETIME                                   COMMENT 'banner下架時間'
     ) COMMENT '首頁Banner管理新增刪除修改TABLE' ; 
