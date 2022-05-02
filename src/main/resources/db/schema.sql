create table posts (
  id serial primary key,
  name varchar(2000),
  description text,
  calendar timestamp without time zone not null default now(),
  topic_id int references topic(id),
  user_id int references users(id)
);
