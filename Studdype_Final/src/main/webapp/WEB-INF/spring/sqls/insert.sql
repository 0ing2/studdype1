-- 규칙: 테이블명 주석달기
-- 예시: -- 모임 --모임댓글

--스터디 카테고리 
INSERT INTO STUDY_CATEGORY VALUES(CATEGORYSEQ.NEXTVAL, 'IT');
INSERT INTO STUDY_CATEGORY VALUES(CATEGORYSEQ.NEXTVAL, '자격증');
INSERT INTO STUDY_CATEGORY VALUES(CATEGORYSEQ.NEXTVAL, '공무원');
INSERT INTO STUDY_CATEGORY VALUES(CATEGORYSEQ.NEXTVAL, '뷰티');
INSERT INTO STUDY_CATEGORY VALUES(CATEGORYSEQ.NEXTVAL, '대입/수능');
INSERT INTO STUDY_CATEGORY VALUES(CATEGORYSEQ.NEXTVAL, '어학/회화');
INSERT INTO STUDY_CATEGORY VALUES(CATEGORYSEQ.NEXTVAL, '취업스터디');
INSERT INTO STUDY_CATEGORY VALUES(CATEGORYSEQ.NEXTVAL, '기타');

SELECT * FROM STUDY_CATEGORY;

--멤버 테이블
INSERT INTO MEMBER VALUES(MEMBERSEQ.NEXTVAL, 'leader1', 'leader1', '테스트팀장', '960308-1010101', 'M', '010-8801-9068', 'bin3005@naver.com');
INSERT INTO MEMBER VALUES(MEMBERSEQ.NEXTVAL, 'bin3005', 'bin3005', '이승빈', '960308-1110101', 'M', '010-8201-9068', 'bin2205@naver.com');

SELECT * FROM MEMBER;
--자유 게시판
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '1번째 글입니다.', 1,  '1번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '2번째 글입니다.', 1,  '2번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '3번째 글입니다.', 1,  '3번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '4번째 글입니다.', 1,  '4번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '5번째 글입니다.', 1,  '5번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '6번째 글입니다.', 1,  '6번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '7번째 글입니다.', 1,  '7번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '8번째 글입니다.', 1,  '8번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '9번째 글입니다.', 1,  '9번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '10번째 글입니다.', 1,  '10번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '11번째 글입니다.', 1,  '11번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '12번째 글입니다.', 1,  '12번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '13번째 글입니다.', 1,  '13번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '14번째 글입니다.', 1,  '14번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '15번째 글입니다.', 1,  '15번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '16번째 글입니다.', 1,  '16번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '17번째 글입니다.', 1,  '17번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '18번째 글입니다.', 1,  '18번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '19번째 글입니다.', 1,  '19번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '20번째 글입니다.', 1,  '20번째 글 내용 입니다', SYSDATE, 0);
INSERT INTO FREE_BOARD VALUES(FREEBOARDSEQ.NEXTVAL, 1, '24번째 글입니다.', 2,  '24번째 글 내용 입니다', SYSDATE, 0);
SELECT * FROM FREE_BOARD;

--스터디 생성

INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름1', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름2', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름3', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름4', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름5', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름6', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름7', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름8', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름9', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름10', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름11', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름12', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름13', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름14', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름15', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름16', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '스터디 이름17', '스터디 한줄 소개2', '스터디 자세한 소개1', NULL, 1, 1, 1, 10, 5);
INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, '안녕하세요', '스터디할사람', '우리 스터디는 재밋어요', NULL, 2, 2, 2, 15, 0);


INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 1, 'JAVA를 잡아', '프로그래밍언어 JAVA를 배우는 스터디 모임', '프로그래밍언어 JAVA를 배우는 스터디 모임 \n 주로 대학생으로 이루어져있음!! ','사진',1,1,1,6,1 );

INSERT INTO STUDY VALUES(STUDYSEQ.NEXTVAL, 2, '취직하자', '취직이 하고싶은  스터디 모임', '취직연습','사진',1,1,1,6,1 );

SELECT * FROM STUDY;







COMMIT;
