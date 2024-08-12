https://hub.docker.com/r/oracleinanutshell/oracle-xe-11g?uuid=9A5BEEED-793A-4FDF-A4B3-80A65614CBC6
docker run -d -p 49161:1521 oracleinanutshell/oracle-xe-11g
$ docker exec -it fe7a /bin/bash




CREATE TABLE wish(
   id			number PRIMARY KEY,
   title		varchar2(30),
   info			varchar2(100),
   country		varchar2(30),
   countryCode	number(30)
);

CREATE SEQUENCE id_seq	-- 시퀀스 이름
INCREMENT BY 1			-- 시퀀스 증감 숫자
START WITH 1			-- 시퀀스 시작 숫자
MINVALUE 1				-- 최솟값
MAXVALUE 100			-- 최댓값
NOCYCLE;				-- 순환하지 않음

INSERT INTO wish(id, title, info, country, countryCode)
VALUES (id_seq.nextval, 'AA', 'AA-info', 'Africa', 100001);

INSERT INTO wish(id, title, info, country, countryCode)
VALUES (id_seq.nextval, 'BB', 'BB-info', 'Brazil', 100002);

INSERT INTO wish(id, title, info, country, countryCode)
VALUES (id_seq.nextval, 'CC', 'CC-info', 'China', 100003);

INSERT INTO wish(id, title, info, country, countryCode)
VALUES (id_seq.nextval, 'DD', 'DD-info', 'Denmark', 100004);

INSERT INTO wish(id, title, info, country, countryCode)
VALUES (id_seq.nextval, 'EE', 'EE-info', 'England', 100005);

COMMIT;


XML 파일을 열 때 해당 dtd 파일을 다운로드 하지 못해 발생할 수 있는데
다운로드 하도록 이클립스 상 설정을 변경해주면 된다.
윈도우 : Windows → Preferences → XML (Wild Web Developer)
□ Download external resources like referenced DTD, XSD
체크하고 적용시키면 눈엣가시 같은 에러가 사라진다.