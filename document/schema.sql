create table if not exists demo_users (
  username varchar(256),
  password varchar(256),
  enabled boolean
) ENGINE =InnoDB DEFAULT CHARSET=utf8;

create table if not exists demo_authorities (
  username varchar(256),
  authority varchar(256)
) ENGINE =InnoDB DEFAULT CHARSET=utf8;

create table if not exists common_user (
  uid int (10) unsigned NOT NULL AUTO_INCREMENT,
  addr varchar (255) DEFAULT NULL,
  mobile varchar (16) DEFAULT NULL,
  username varchar (32) DEFAULT NULL,
  display_name varchar (32) DEFAULT NULL,
  user_login varchar (32) NOT NULL,
  password varchar (64) NOT NULL,
  email varchar (255) DEFAULT NULL,
  account_balance decimal (13, 5) NOT NULL DEFAULT '0.00' ,
  user_type varchar (16) NOT NULL DEFAULT 'defalut' ,
  is_avatar tinyint(4) DEFAULT 0,
  level tinyint(4) DEFAULT 0,
  status tinyint(4) DEFAULT 0,
  reg_time datetime DEFAULT NULL,
  reg_ip varchar (32) DEFAULT NULL,
  last_login_time datetime DEFAULT NULL,
  PRIMARY KEY ( uid),
  UNIQUE KEY ( username),
  UNIQUE KEY ( email),
  UNIQUE KEY ( mobile)
) ENGINE =InnoDB DEFAULT CHARSET=utf8;