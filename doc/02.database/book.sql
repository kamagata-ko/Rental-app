CREATE TABLE "t_book" (
  "id" serial PRIMARY KEY,
  "book_name" varchar(100) NOT NULL,
  "author" varchar(100),
  "publisher" varchar(100),
  "status" integer NOT NULL DEFAULT (0),
  "arrival_date" timestamp NOT NULL DEFAULT (now()),
  "register_date" timestamp NOT NULL DEFAULT (now()),
  "update_date" timestamp,
  "delete_flg" integer NOT NULL DEFAULT (0)
);

CREATE TABLE "t_customer" (
  "id" serial PRIMARY KEY,
  "password" varchar(100) NOT NULL,
  "name" varchar(10) NOT NULL,
  "gender" integer CHECK (gender IN (1, 2, 3)),
  "birthday" date,
  "mail_address" varchar(60) NOT NULL,
  "telephone_number" varchar(60) NOT NULL,
  "register_date" timestamp NOT NULL DEFAULT (now()),
  "update_date" timestamp,
  "delete_flg" integer NOT NULL DEFAULT (0)
);

/* 未実装 */
CREATE TABLE "t_staff" (
  "id" char PRIMARY KEY,
  "name" varchar,
  "authority_flg" integer NOT NULL DEFAULT (0),
  "update_date" timestamp,
  "koushin_date" timestamp
);

CREATE TABLE "t_rental" (
  "id" serial PRIMARY KEY,
  "customer_id" varchar(10) NOT NULL,
  "book_id" varchar(10) NOT NULL,
  "rental_start_date" timestamp NOT NULL DEFAULT (now()),
  "scheduled_return_date" timestamp NOT NULL,
  "return_completion_date" timestamp
);

/* 未実装 */
CREATE TABLE "t_kubunti" (
  "id" char PRIMARY KEY,
  "kubun_code" char NOT NULL,
  "kubun_name" varchar NOT NULL
);

ALTER TABLE "t_rental" ADD FOREIGN KEY ("customer_id") REFERENCES "t_customer" ("id");

ALTER TABLE "t_rental" ADD FOREIGN KEY ("book_id") REFERENCES "t_book" ("id");
