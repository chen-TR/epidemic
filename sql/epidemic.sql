/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/2/24 14:29:01                           */
/*==============================================================*/


drop table if exists epidemics;

drop table if exists provinces;

drop table if exists users;

/*==============================================================*/
/* Table: epidemics                                             */
/*==============================================================*/
create table epidemics
(
   serial_id            int not null auto_increment,
   province_id          int,
   data_year            smallint,
   data_month           smallint,
   data_day             smallint,
   affirmed             int,
   suspected            int,
   isolated             int,
   dead                 int,
   cured                int,
   user_id              int,
   input_date           datetime,
   primary key (serial_id)
);

/*==============================================================*/
/* Table: provinces                                             */
/*==============================================================*/
create table provinces
(
   province_id          int not null,
   province_name        varchar(10),
   province_py          varchar(30),
   del_flag             smallint,
   primary key (province_id)
);

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   user_id              int not null auto_increment,
   account              varchar(30),
   password             varchar(100),
   user_name            varchar(30),
   del_flag             smallint,
   primary key (user_id)
);

alter table epidemics add constraint FK_epid_prov foreign key (province_id)
      references provinces (province_id) on delete restrict on update restrict;

alter table epidemics add constraint FK_epid_user foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

