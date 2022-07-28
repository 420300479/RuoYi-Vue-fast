
-- ----------------------------              
-- 2、计算表        
-- ----------------------------   

drop table if exists tb_qzsjjs;
create table tb_qzsjjs (
  pr_id             numeric(15,0)    not null                  comment '设计计算表',
  dzh               varchar(160)     not null                  comment '定制号',
  name              varchar(160)     not null                  comment '型号',
  jcds              numeric(1,0)     not null                  comment '点数',
  gcl               numeric(11,2)    not null                  comment '力',
  gclxc             numeric(11,2)    not null                  comment '行程',
  hkxc              numeric(11,2)    not null                  comment '大行程',
  zdxccs            numeric(11,2)    not null                  comment '次数',
  liangan_length    numeric(11,2)    not null                  comment '距离',
  quzhou_zcj_dia    numeric(11,2)    not null                  comment '直径1',
  quzhou_qbj_dia    numeric(11,2)    not null                  comment '直径2',
  quzhou_qtm_dia    numeric(11,2)    not null                  comment '直径3',
  slide_fric_coe    numeric(4,3)     not null                  comment '系数',
  la                numeric(11,2)    null                      comment '长度',
  b                 numeric(11,2)    null                      comment '厚度',
  h                 numeric(11,2)    null                      comment '高度',
  r                 numeric(11,2)    null                      comment '距离',
  c                 numeric(11,2)    null                      comment '半径',
  qz_clmc           varchar(64)      null                      comment '材料',
  nominal_torsion   numeric(11,2)    not null                  comment '扭矩',
  qbjzdwqyl         numeric(11,2)    null                      comment '应力',
  zcjzdjqyl         numeric(11,2)    null                      comment '应力',
  nd                numeric(11,2)    null                      comment '挠度',
  primary key (pr_id)
) engine=innodb auto_increment=200 comment = '计算表';


-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
insert into tb_qzsjjs values(1, 'dzh001', 'quzhou',2,2500,7,150,40,300,80,60,50,0.05,180,9,100,60,35,'304L',33500,200,300,2);


