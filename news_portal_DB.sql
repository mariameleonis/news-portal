--------------------------------------------------------
--  File created - вторник-апреля-19-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence NEWS_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##MARIA"."NEWS_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 241 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table AUTHORITIES
--------------------------------------------------------

  CREATE TABLE "C##MARIA"."AUTHORITIES" 
   (	"USERNAME" VARCHAR2(50 BYTE), 
	"AUTHORITY" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table NEWS
--------------------------------------------------------

  CREATE TABLE "C##MARIA"."NEWS" 
   (	"ID" NUMBER(10,0), 
	"TITLE" VARCHAR2(128 BYTE), 
	"BRIEF" VARCHAR2(256 BYTE), 
	"CONTENT" VARCHAR2(2048 BYTE), 
	"NEWS_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "C##MARIA"."USERS" 
   (	"USERNAME" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE), 
	"ENABLED" NUMBER(1,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into C##MARIA.AUTHORITIES
SET DEFINE OFF;
Insert into C##MARIA.AUTHORITIES (USERNAME,AUTHORITY) values ('masha','ROLE_ADMIN');
REM INSERTING into C##MARIA.NEWS
SET DEFINE OFF;
Insert into C##MARIA.NEWS (ID,TITLE,BRIEF,CONTENT,NEWS_DATE) values ('202','Nibh sodales litora convallis volutpat','Dignissim a lectus viverra odio turpis fringilla, iaculis donec adipiscing ligula dolor.','Blandit netus integer sodales diam pulvinar gravida hendrerit nam, magna scelerisque curae aliquet eget praesent. Posuere fames purus eu lobortis taciti et felis duis tellus nibh nascetur, laoreet viverra quisque aliquet amet cursus eget class magna mollis, primis enim orci magnis maximus praesent pretium pharetra proin himenaeos.',to_date('12.04.2022','DD.MM.RRRR'));
Insert into C##MARIA.NEWS (ID,TITLE,BRIEF,CONTENT,NEWS_DATE) values ('203','Risus ut ridiculus et facilisis nascetur viverra etiam erat','At eu nullam nam ut aliquam semper cubilia, parturient lobortis vel nisl fames metus dictum ipsum, vitae ex auctor dis felis vestibulum.','Class natoque maecenas libero lacinia facilisis a, tempus eu urna faucibus. Convallis curae vestibulum ante condimentum donec curabitur taciti velit urna, proin arcu tempus maecenas penatibus facilisi consectetur parturient fringilla vivamus, ad ac justo placerat ex sociosqu sed integer. Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.',to_date('11.04.2022','DD.MM.RRRR'));
Insert into C##MARIA.NEWS (ID,TITLE,BRIEF,CONTENT,NEWS_DATE) values ('221','Laoreet id efficitur congue','Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.','Class natoque maecenas libero lacinia facilisis a, tempus eu urna faucibus. Convallis curae vestibulum ante condimentum donec curabitur taciti velit urna, proin arcu tempus maecenas penatibus facilisi consectetur parturient fringilla vivamus, ad ac justo placerat ex sociosqu sed integer. Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.',to_date('16.04.2022','DD.MM.RRRR'));
Insert into C##MARIA.NEWS (ID,TITLE,BRIEF,CONTENT,NEWS_DATE) values ('222','Novost novost test novost test test','Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.','Class natoque maecenas libero lacinia facilisis a, tempus eu urna faucibus. Convallis curae vestibulum ante condimentum donec curabitur taciti velit urna, proin arcu tempus maecenas penatibus facilisi consectetur parturient fringilla vivamus, ad ac justo placerat ex sociosqu sed integer. Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.',to_date('17.04.2022','DD.MM.RRRR'));
Insert into C##MARIA.NEWS (ID,TITLE,BRIEF,CONTENT,NEWS_DATE) values ('225','20 April Novost novost test novost test test','Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.','Class natoque maecenas libero lacinia facilisis a, tempus eu urna faucibus. Convallis curae vestibulum ante condimentum donec curabitur taciti velit urna, proin arcu tempus maecenas penatibus facilisi consectetur parturient fringilla vivamus, ad ac justo placerat ex sociosqu sed integer. Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.',to_date('20.04.2022','DD.MM.RRRR'));
Insert into C##MARIA.NEWS (ID,TITLE,BRIEF,CONTENT,NEWS_DATE) values ('224','Novost 19 April test novost','Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.','Class natoque maecenas libero lacinia facilisis a, tempus eu urna faucibus. Convallis curae vestibulum ante condimentum donec curabitur taciti velit urna, proin arcu tempus maecenas penatibus facilisi consectetur parturient fringilla vivamus, ad ac justo placerat ex sociosqu sed integer. Laoreet id efficitur congue elementum nisl accumsan, ac per inceptos in.',to_date('19.04.2022','DD.MM.RRRR'));
REM INSERTING into C##MARIA.USERS
SET DEFINE OFF;
Insert into C##MARIA.USERS (USERNAME,PASSWORD,ENABLED) values ('masha','{noop}1234','1');
--------------------------------------------------------
--  DDL for Index AUTHORITIES_USERNAME_IDX
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MARIA"."AUTHORITIES_USERNAME_IDX" ON "C##MARIA"."AUTHORITIES" ("USERNAME", "AUTHORITY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index NEWS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MARIA"."NEWS_PK" ON "C##MARIA"."NEWS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MARIA"."USERS_PK" ON "C##MARIA"."USERS" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index AUTHORITIES_USERNAME_IDX
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MARIA"."AUTHORITIES_USERNAME_IDX" ON "C##MARIA"."AUTHORITIES" ("USERNAME", "AUTHORITY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index NEWS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MARIA"."NEWS_PK" ON "C##MARIA"."NEWS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MARIA"."USERS_PK" ON "C##MARIA"."USERS" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table NEWS
--------------------------------------------------------

  ALTER TABLE "C##MARIA"."NEWS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##MARIA"."NEWS" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "C##MARIA"."NEWS" MODIFY ("BRIEF" NOT NULL ENABLE);
  ALTER TABLE "C##MARIA"."NEWS" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "C##MARIA"."NEWS" MODIFY ("NEWS_DATE" NOT NULL ENABLE);
  ALTER TABLE "C##MARIA"."NEWS" ADD CONSTRAINT "NEWS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "C##MARIA"."USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "C##MARIA"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "C##MARIA"."USERS" MODIFY ("ENABLED" NOT NULL ENABLE);
  ALTER TABLE "C##MARIA"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table AUTHORITIES
--------------------------------------------------------

  ALTER TABLE "C##MARIA"."AUTHORITIES" ADD CONSTRAINT "FK_USERS" FOREIGN KEY ("USERNAME")
	  REFERENCES "C##MARIA"."USERS" ("USERNAME") ENABLE;
