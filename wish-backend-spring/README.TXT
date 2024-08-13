
### REST <-> DB FLOW
*************************************
VIEW
↕
Controller
↕ 
Service
↕
ServiceImpl
↕
Mybatis-Mapper
↕
Mybatis-XML
↕
ORACLE
*************************************

### DOCKER ORACLE
https://hub.docker.com/r/oracleinanutshell/oracle-xe-11g?uuid=9A5BEEED-793A-4FDF-A4B3-80A65614CBC6
docker run -d -p 49161:1521 oracleinanutshell/oracle-xe-11g
$ docker exec -it fe7a /bin/bash


### SQL
DELETE FROM wish
INSERT INTO wish () VALUES ();
UPDATE wish SET
ALTER TABLE wish DROP COLUMN aaa;

DROP TABLE wish;

CREATE TABLE wish(
   id				NUMBER PRIMARY KEY,
   itemName			VARCHAR2(30),
   itemCategory		VARCHAR2(30),
   itemCode			NUMBER(30)
);

DROP SEQUENCE id_seq;

CREATE SEQUENCE id_seq	-- 시퀀스 이름
START WITH 1			-- 시퀀스 시작 숫자
INCREMENT BY 1			-- 시퀀스 증감 숫자
MINVALUE 1				-- 최솟값
MAXVALUE 100			-- 최댓값
NOCYCLE;				-- 순환하지 않음

ALTER SEQUENCE id_seq RESTART START WITH 1;

ALTER TABLE wish DROP COLUMN itemInfo;

SELECT * FROM wish ORDER BY ID;

INSERT INTO wish(id, itemName, itemCategory, itemCode)
VALUES (id_seq.nextval, 'AA', 'AA-category', 100001);
VALUES (id_seq.nextval, 'BB', 'BB-category', 100002);
VALUES (id_seq.nextval, 'CC', 'CC-category', 100003);
VALUES (id_seq.nextval, 'DD', 'DD-category', 100004);
VALUES (id_seq.nextval, 'EE', 'EE-category', 100005);

UPDATE wish SET 
    itemName = 'AA', 
    itemCategory = 'AA-category', 
    itemCode = 100001
WHERE id = #{id}

DELETE FROM wish;
DELETE FROM wish WHERE id = #{id};

COMMIT;


### MYBATIS

XML 파일을 열 때 해당 dtd 파일을 다운로드 하지 못해 발생할 수 있는데
다운로드 하도록 이클립스 상 설정을 변경해주면 된다.
윈도우 : Windows → Preferences → XML (Wild Web Developer)
□ Download external resources like referenced DTD, XSD
체크하고 적용시키면 눈엣가시 같은 에러가 사라진다.