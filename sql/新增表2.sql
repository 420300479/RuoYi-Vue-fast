-- ----------------------------              
-- 0、果表        
-- ----------------------------   
drop table if exists tb_fruits;
create table tb_fruits (
  frid              numeric(15,0)    not null                  comment '表编号',
  dzh               varchar(160)     not null                  comment '果子编号',
  frid1             numeric(15,0)    null                      comment '菠萝编号',
  frid2             numeric(15,0)    null                      comment '西瓜编号',
  frid3             numeric(15,0)    null                      comment '芒果编号',
  frid4             numeric(15,0)    null                      comment '白果编号',
  primary key (frid)
) engine=innodb auto_increment=200 comment = '果表';
-- ----------------------------
-- 初始化果表数据
-- ----------------------------
insert into tb_fruits values(1, 'dzh001', 1,1,1,1);


-- ----------------------------              
-- 1、钢制菠萝表        
-- ----------------------------

-- ----------------------------
DROP TABLE IF EXISTS `tb_fruit1`;
CREATE TABLE `tb_fruit1`
(
    frid     bigint(20) not null AUTO_INCREMENT comment '表编号',
    dzh      varchar(160)   not null comment '果子编号',
    fname    varchar(160)   not null comment '果子名称',
    num      numeric(1, 0)  not null comment '个数',
    forc1    numeric(11, 2) not null comment '力',
    disp1    numeric(11, 2) not null comment '位移',
    disp2    numeric(11, 2) not null comment '变形',
    rounds   numeric(11, 0) not null comment '次数',
    length1  numeric(11, 2) not null comment '长度1',
    dia1     numeric(11, 2) not null comment '直径1',
    dia2     numeric(11, 2) not null comment '直径2',
    dia3     numeric(11, 2) not null comment '直径3',
    coe3     numeric(4, 3)  not null comment '系数',
    length2  numeric(11, 2) null comment '长度2',
    length3  numeric(11, 2) null comment '长度3',
    height1  numeric(11, 2) null comment '高度1',
    length4  numeric(11, 2) null comment '长度4',
    radius1  numeric(11, 2) null comment '半径1',
    mat1     varchar(64) null comment '材料1',
    torsion1 numeric(11, 2) not null comment '扭矩1',
    stress1  numeric(11, 2) null comment '应力1',
    stress2  numeric(11, 2) null comment '应力2',
    stress3  numeric(11, 2) null comment '应力3',
    PRIMARY KEY (`frid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2015 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '钢制菠萝表' ROW_FORMAT = DYNAMIC;



-- ----------------------------
-- 初始化菠萝表数据
-- ----------------------------
insert into tb_fruit1 values(1, 'dzh001', '菠萝',2,2500,7,150,40,300,80,60,50,0.05,180,9,100,60,35,'304L',33500,200,300,200);
insert into tb_fruit1 values(2, 'dzh002', '菠萝2',2,2500,7,150,40,300,80,60,50,0.05,180,9,100,60,35,'304L',33500,200,300,200);
insert into tb_fruit1 values(3, 'dzh001', '菠萝3',2,2500,7,150,40,300,80,60,50,0.05,180,9,100,60,35,'304L',33500,200,300,200);

-- ----------------------------              
-- 2、铸铁西瓜表        
-- ----------------------------   

drop table if exists tb_fruit2;
create table tb_fruit2
(
    frid     bigint(20) not null AUTO_INCREMENT comment '表编号',
    dzh      varchar(160)   not null comment '果子编号',
    fname    varchar(160)   not null comment '果子名称',
    disp1    numeric(11, 2) not null comment '变形',
    rounds   numeric(11, 0) not null comment '次数',
    length1  numeric(11, 2) not null comment '长度1',
    dia1     numeric(11, 2) not null comment '直径1',
    dia2     numeric(11, 2) not null comment '直径2',
    dia3     numeric(11, 2) not null comment '直径3',
    coe3     numeric(4, 3)  not null comment '系数',
    length2  numeric(11, 2) null comment '长度2',
    length3  numeric(11, 2) null comment '长度3',
    height1  numeric(11, 2) null comment '高度1',
    length4  numeric(11, 2) null comment '长度4',
    radius1  numeric(11, 2) null comment '半径1',
    mat1     varchar(64) null comment '材料1',
    torsion1 numeric(11, 2) not null comment '扭矩1',
    stress1  numeric(11, 2) null comment '应力1',
    stress2  numeric(11, 2) null comment '应力2',
    deform   numeric(11, 2) null comment '挠度',
    primary key (frid)
) ENGINE = InnoDB AUTO_INCREMENT = 2015 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '铸铁西瓜表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- 初始化-铸铁西瓜表数据
-- ----------------------------
insert into tb_fruit2 values(1, 'dzh001', '西瓜',130,20,100,40,60,80,0.06,320,12,200,70,45,'Q235',33600,300,400,3);



-- ----------------------------              
-- 3、铝合金芒果表        
-- ----------------------------   
drop table if exists tb_fruit3;
create table tb_fruit3 (
  frid              numeric(15,0)    not null                  comment '表编号',
  dzh               varchar(160)     not null                  comment '果子编号',
  fname             varchar(160)     not null                  comment '果子名称',
  disp1             numeric(11,2)    not null                  comment '位移',
  disp2             numeric(11,2)    not null                  comment '变形',
  length1           numeric(11,2)    not null                  comment '长度1',
  dia1              numeric(11,2)    not null                  comment '直径1',
  dia2              numeric(11,2)    not null                  comment '直径2',
  dia3              numeric(11,2)    not null                  comment '直径3',
  coe3              numeric(4,3)     not null                  comment '系数',
  length2           numeric(11,2)    null                      comment '长度2',
  length3           numeric(11,2)    null                      comment '长度3',
  height1           numeric(11,2)    null                      comment '高度1',
  length4           numeric(11,2)    null                      comment '长度4',
  radius1           numeric(11,2)    null                      comment '半径1',
  mat1              varchar(64)      null                      comment '材料1',
  torsion1          numeric(11,2)    not null                  comment '扭矩1',
  stress1           numeric(11,2)    null                      comment '应力1',
  stress2           numeric(11,2)    null                      comment '应力2',
  stress3           numeric(11,2)    null                      comment '应力3',
  stress4           numeric(11,2)    null                      comment '应力4',
  stress5           numeric(11,2)    null                      comment '应力5',
  primary key (frid)
) engine=innodb auto_increment=200 comment = '铝合金芒果表';
-- ----------------------------
-- 初始化-铝合金芒果表数据
-- ----------------------------
insert into tb_fruit3 values(1, 'dzh001', '芒果',230,43,220,30,80,90,0.26,340,11,220,73,48,'7075',34500,800,800,200,500,400);




-- ----------------------------              
-- 3、混合金白果表        
-- ----------------------------   
drop table if exists tb_fruit4;
create table tb_fruit4 (
  frid              numeric(15,0)    not null                  comment '表编号',
  dzh               varchar(160)     not null                  comment '果子编号',
  fname             varchar(160)     not null                  comment '果子名称',
  disp1             numeric(11,2)    not null                  comment '位移',
  disp2             numeric(11,2)    not null                  comment '变形',
  disp3             numeric(11,2)    null                      comment '位移3',
  disp4             numeric(11,2)    null                      comment '位移4',
  disp5             numeric(11,2)    null                      comment '位移5',
  disp6             numeric(11,2)    null                      comment '位移6',
  disp7             numeric(11,2)    null                      comment '位移7',
  disp8             numeric(11,2)    null                      comment '位移8',
  disp9             numeric(11,2)    null                      comment '位移9',
  disp10            numeric(11,2)    null                      comment '位移10',
  rounds            numeric(11,0)    not null                  comment '次数',
  length1           numeric(11,2)    not null                  comment '长度1',
  dia1              numeric(11,2)    not null                  comment '直径1',
  dia2              numeric(11,2)    not null                  comment '直径2',
  dia3              numeric(11,2)    not null                  comment '直径3',
  coe3              numeric(4,3)     not null                  comment '系数',
  length2           numeric(11,2)    null                      comment '长度2',
  length3           numeric(11,2)    null                      comment '长度3',
  height1           numeric(11,2)    null                      comment '高度1',
  length4           numeric(11,2)    null                      comment '长度4',
  radius1           numeric(11,2)    null                      comment '半径1',
  mat1              varchar(64)      null                      comment '材料1',
  mat2              varchar(64)      null                      comment '材料2',  
  torsion1          numeric(11,2)    not null                  comment '扭矩1',
  stress1           numeric(11,2)    null                      comment '应力1',
  stress2           numeric(11,2)    null                      comment '应力2',
  stress3           numeric(11,2)    null                      comment '应力3',
  stress4           numeric(11,2)    null                      comment '应力4',
  stress5           numeric(11,2)    null                      comment '应力5',
  stress6           numeric(11,2)    null                      comment '应力6',
  primary key (frid)
) engine=innodb auto_increment=200 comment = '混合金白果表';
-- ----------------------------
-- 初始化-混合金白果表数据
-- ----------------------------
insert into tb_fruit4 values(1, 'dzh001', '白果',430,450,530,250,330,150,730,850,434,452,53,320,40,82,92,0.36,341,12,240,43,40,'GH15','40Cr',35500,300,200,100,100,100,10);



