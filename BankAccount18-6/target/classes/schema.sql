create table if not exists SAVINGS_ACCOUNT (
  account_number varchar,
  balance double,
  open_time_stamp int,
)   ;

create table if not exists TRANSACTION (
  account_number varchar,
  timestamp bigint,
  amount int,
  description varchar,
)