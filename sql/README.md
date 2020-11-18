## music-web

### 模型
**管理员admin**

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值 |
| name | varchar(45) | not_null unique | 用户名 |
| password | varchar(255) | not_null | 加密后的密码 |

```sql
create table `admin` (
	`id` int(10) not null AUTO_INCREMENT primary key,
	`name` varchar(45) not null unique,
	`password` varchar(255)  not null comment '加密后的密码'
)ENGINE=InnoDB DEFAULT CHARSET=utf8
```


**用户user**

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值 |
| username | varchar(255) | not_null unique | 用户名 |
| password | varchar(255) | not_null | 加密后的密码|
| sex | tinyint(4) | default 0 | 1-男 0-女 |
| phone_num | char(15) | default null | 手机号码 |
| email | varchar(30) | default null | 邮箱 |
| birth | datetime | default null | 生日 |
| introduction | varchar(45) | default null | 简介|
| location | varchar(45) | default null | 位置|
| avator | varchar(255) | default null | 头像 |
| create_time | datetime | not null| 创建时间|
| update_time | datetime | not null| 更新时间|

```sql
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL COMMENT '加密后的密码',
  `sex` tinyint(4) DEFAULT '0' COMMENT '0-女|1-男',
  `phone_num` char(15) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `introduction` varchar(45) DEFAULT NULL COMMENT '简介',
  `location` varchar(45) DEFAULT NULL COMMENT '位置',
  `avator` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```


**歌手singer**

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值|
| name | varchar(45) | not null | 姓名|
| sex| tinyint(4) | not null default 0| 性别1-男 0-女|
| pic | varchar(255) | default null | 图片|
| birth | datetime | default null | 生日|
| location | varchar(45) | default null |  位置|
| introduction | varchar(255) | default null | 介绍|

```sql
CREATE TABLE `singer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sex` tinyint(4) DEFAULT '0' COMMENT '0-女|1-男',
  `birth` datetime DEFAULT NULL,
  `introduction` varchar(45) DEFAULT NULL COMMENT '简介',
  `location` varchar(45) DEFAULT NULL COMMENT '位置',
  `pic` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```


**歌曲song**

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值|
| singer_id | int | FOREIGN KEY singer| 歌手名|
| name | varchar(45) | not null | 歌曲名|
| introduction | varchar(45) | default null | 介绍|
| pic | varchar(255) | default null | 图片|
| lyric | text | default null | 歌词|
| url | varchar(255) | not null | 歌曲的url|
| create_time | datetime | not null| 创建时间|
| update_time | datetime | not null| 更新时间|

```sql
create table `song` (
	`id` int(10) not null AUTO_INCREMENT primary key,
	`name` varchar(45) not null unique,
	`introduction` varchar(45) default null comment '简介',
	`pic` varchar(255) default null comment '头像',
	`lyric` text default null comment '歌词',
	`url` varchar(255) not null comment '歌曲url',
	`create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `singer_id` int not null,
    foreign key (`singer_id`) references singer(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
```
 
 
**歌单song_list**

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值|
| title | varchar(45) | not null | 标题|
| pic | varchar(255) | not  null | 图片|
| introduction | text | not null | 介绍|
| style | varchar(10) | default null | 类型|

```sql
create table `song_list` (
	`id` int(10) not null AUTO_INCREMENT primary key,
	`title` varchar(45) not null,
	`introduction` varchar(45) default null comment '简介',
	`pic` varchar(255) default null comment '头像',
	`style` varchar(10) default null comment '类型'
)ENGINE=InnoDB DEFAULT CHARSET=utf8
```


**歌单歌曲list_song**
歌单和歌曲是多对多的关系，需要使用map表来映射

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值|
| song_id| int | foreign key | 歌曲id|
| song_list_id| int | foreign key | 歌单id|


```sql
create table `list_song` (
	`id` int(10) not null AUTO_INCREMENT primary key,
	`song_id` int not null,
	`song_list_id` int not null,
	foreign key (`song_id`) references song(`id`),
	foreign key (`song_list_id`) references song_list(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
```


**歌单评分rank**

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值|
| song_list_id | int | foreign key | 歌单id|
| user_id | int | foreign key | 用户id|
| score| int(10)| not null default 0 | 分数0-10|

```sql
create table `rank` (
	`id` int(10) not null AUTO_INCREMENT primary key,
	`song_list_id` int not null,
	`user_id` int not null,
	`score` int not null default 0,
	foreign key (`user_id`) references user(`id`),
	foreign key (`song_list_id`) references song_list(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
```


**评论comment**

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值|
| user_id | int | foreign key | 用户id|
| song_id | int | foreign key default null| 歌曲id|
| song_list_id | int | foreign key default null| 
| content | varchar(255) | not null | 评价内容|
| create_time | datetime | not null| 创建时间|
| type| tinyint(4)|not null | 歌单（1）/歌曲（0）|
| up | int(10) | no null | 点赞 |

```sql
create table `comment` (
	`id` int(10) not null AUTO_INCREMENT primary key,
	`song_list_id` int not null,
	`song_id` int not null,
	`user_id` int not null,
	`content` varchar(255) not null,
	`create_time` datetime NOT NULL COMMENT '创建时间',
    `type` tinyint(4) not null comment '1-歌单|0-歌曲',
    `up` int(10) not null,
	foreign key (`user_id`) references user(`id`),
	foreign key (`song_id`) references song(`id`),
	foreign key (`song_list_id`) references song_list(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
```



**收藏collect**

| 字段名 | 类型 | 属性 | 含义 |
| :---: | :---: | :---: | :---: |
| id | int | auto_increment 主键 | id值|
| user_id | int | foreign key|用户|
| type | tinyint(4) | not null | 歌单（1）/歌曲（0）|
| song_id | int | foreign key default null| 歌曲id|
| song_list_id | int | foreign key default null| 
| create_time | datetime | not null| 创建时间|

```sql
create table `collect` (
	`id` int(10) not null AUTO_INCREMENT primary key,
	`song_list_id` int not null,
	`song_id` int not null,
	`user_id` int not null,
	`create_time` datetime NOT NULL COMMENT '创建时间',
    `type` tinyint(4) not null comment '1-歌单|0-歌曲',
	foreign key (`user_id`) references user(`id`),
	foreign key (`song_id`) references song(`id`),
	foreign key (`song_list_id`) references song_list(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
```


### 分析
1. 角色： 
    - 管理员 
    - 普通用户

2. 操作
    1. 普通用户：
        - 添加收藏
        - 评论
        - 打分
        - 修改个人资料
    2. 管理员
        - 添加歌手
        - 添加歌曲
        - 创建歌单
        - 统计信息
        