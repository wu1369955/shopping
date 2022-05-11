use shopping;
CREATE TABLE IF NOT EXISTS `user`
(
    `user_id`       INT UNSIGNED AUTO_INCREMENT,
    `user_name`     VARCHAR(100) NOT NULL,
    `user_password` VARCHAR(40)  NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO user (user_id, user_name, user_password)
VALUES ('1', 'user_1', '123456'),
       ('2', 'user_2', '123456'),
       ('3', 'user_3', '123456');
insert into user(user_name, user_password)
VALUES ('admin@qq.com', '123');
select *
from user;

CREATE TABLE IF NOT EXISTS `goods`
(
    `goods_id`     INT UNSIGNED AUTO_INCREMENT,
    `goods_name`   varchar(100) NOT NULL,
    `goods_price`  integer(10)  NOT NULL,
    `goods_number` integer(10)  NOT NULL,
    PRIMARY KEY (`goods_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# insert into goods(goods_id, goods_name, goods_price, goods_number) VALUES
# ('1', '商品1', '89', '500'),
# ('2', '商品2', '89', '700'),
# ('3', '商品3', '89', '800'),
# ('4', '商品4', '89', '200'),
# ('5', '商品5', '89', '5300'),
# ('6', '商品6', '89', '5500'),
# ('7', '商品7', '89', '5050'),
# ('8', '商品8', '89', '2020');

# CREATE TABLE IF NOT EXISTS `shopcart`(
#                                       `shop_id` INT UNSIGNED AUTO_INCREMENT,
#                                       `sh` varchar(100) NOT NULL,
#                                       `goods_price` integer(10) NOT NULL,
#                                       `goods_number` integer(10) NOT NULL,
#                                       PRIMARY KEY ( `goods_id` )
# )ENGINE=InnoDB DEFAULT CHARSET=utf8;
drop table if exists `mall_food`;
drop table if exists `mall_cloth`;
drop table if exists `mall_mobile`;
drop table if exists `mall_fruit`;
create table if not exists `mall_cloth`
(
    `id`       int       not null,
    `name`     char(20)  not null,
    `price`    int       not null,
    `number`   int       not null,
    `describe` char(100) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  default charset = utf8;

create table if not exists `mall_fruit`
(
    `id`       int       not null,
    `name`     char(20)  not null,
    `price`    int       not null,
    `number`   int       not null,
    `describe` char(100) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  default charset = utf8;

create table if not exists `mall_mobile`
(
    `id`       int       not null,
    `name`     char(20)  not null,
    `price`    int       not null,
    `number`   int       not null,
    `describe` char(100) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  default charset = utf8;


create table if not exists `mall_food`
(
    `id`       int       not null,
    `name`     char(20)  not null,
    `price`    int       not null,
    `number`   int       not null,
    `describe` char(100) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  default charset = utf8;


insert into mall_cloth (id, name, price, number, `describe`)
VALUES ('0', '短袖', '300', '4000', '黑色'),
       ('1', '长袖', '700', '2000', '黑色'),
       ('2', '短裤', '800', '12000', '黑色'),
       ('3', '长裤', '1000', '8000', '黑色');

insert into mall_fruit (id, name, price, number, `describe`)
values ('4', '苹果', '23', '2000', '江西'),
       ('5', '香蕉', '7', '2050', '九江'),
       ('6', '荔枝', '20', '15400', '江西'),
       ('7', '橙子', '5', '8080', '赣南');


insert into mall_mobile (id, name, price, number, `describe`)
VALUES ('8', '手机', '1780', '5000', '华为'),
       ('9', '手表', '700', '3000', '三星'),
       ('10', '平板', '800', '12400', '苹果'),
       ('11', '电脑', '5000', '6000', '苹果');

insert into mall_food (id, name, price, number, `describe`)
VALUES ('12', '三只松鼠', '40', '785', '内地'),
       ('13', '老干妈', '20', '4545', '内地'),
       ('14', '泡椒鸡爪', '10', '545', '内地'),
       ('15', '肥宅快乐水', '5', '854', '内地');



