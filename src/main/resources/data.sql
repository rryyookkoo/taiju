truncate table taiju;
insert into taiju(recorded_at, weight) values(unix_timestamp('2015-04-04')*1000,40);

truncate table user;
insert into user(username, password, created_at) values('user', 'password',unix_timestamp('2015-04-01')*1000);