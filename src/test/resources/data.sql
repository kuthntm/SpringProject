INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');

INSERT INTO article(title, content) VALUES('영화 추천', '댓글 부탁');
INSERT INTO article(title, content) VALUES('음식 추천', '댓글 달아주세요');
INSERT INTO article(title, content) VALUES('취미 추천', '부탁드립니다');

INSERT INTO comment(article_id, nickname, body) VALUES(4, '박', '아이언맨');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '김', '어벤져스');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '이', '헐크');

INSERT INTO comment(article_id, nickname, body) VALUES(5, '박', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '김', '바나나');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '이', '피자');

INSERT INTO comment(article_id, nickname, body) VALUES(6, '박', '게임');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '김', '산책');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '이', '배드민턴');