------------------table script Subject---------------------------

DROP TABLE HR.SUBJECTS CASCADE CONSTRAINTS;

CREATE TABLE HR.SUBJECTS
(
  SUBJECT_ID    VARCHAR2(10 BYTE)               NOT NULL,
  SUBJECT_NAME  VARCHAR2(50 BYTE)               NOT NULL
)
TABLESPACE AMLTEST
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MAXSIZE          UNLIMITED
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;


-------------------table script Class-----------------------------------------------
DROP TABLE HR.CLASSES CASCADE CONSTRAINTS;

CREATE TABLE HR.CLASSES
(
  CLASS_ID    VARCHAR2(10 BYTE)                 NOT NULL,
  CLASS_NAME  VARCHAR2(50 BYTE)                 NOT NULL
)
TABLESPACE AMLTEST
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MAXSIZE          UNLIMITED
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;

---------------------Table script Teacher----------------------
DROP TABLE HR.TEACHERS CASCADE CONSTRAINTS;

CREATE TABLE HR.TEACHERS
(
  TEACHER_ID    VARCHAR2(10 BYTE)               NOT NULL,
  TEACHER_NAME  VARCHAR2(50 BYTE)               NOT NULL
)
TABLESPACE AMLTEST
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MAXSIZE          UNLIMITED
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;
-----------------------table script student-------------------------
DROP TABLE HR.STUDENTS CASCADE CONSTRAINTS;

CREATE TABLE HR.STUDENTS
(
  ID            VARCHAR2(10 BYTE),
  STUDENT_NAME  VARCHAR2(50 BYTE),
  CLASS         VARCHAR2(50 BYTE)
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MAXSIZE          UNLIMITED
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;
-------------------table script for subject class map-----------------------
DROP TABLE HR.SUBJECT_CLAS_MAP CASCADE CONSTRAINTS;

CREATE TABLE HR.SUBJECT_CLAS_MAP
(
  SUB_CLASS_ID  VARCHAR2(10 BYTE)               NOT NULL,
  SUBJECT_ID    VARCHAR2(100 BYTE)              NOT NULL,
  CLASS_ID      VARCHAR2(10 BYTE)               NOT NULL
)
TABLESPACE AMLTEST
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MAXSIZE          UNLIMITED
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;
-------------------table script for teacher class subject map------------------
DROP TABLE HR.SUBJECT_CLAS_TEACHER_MAP CASCADE CONSTRAINTS;

CREATE TABLE HR.SUBJECT_CLAS_TEACHER_MAP
(
  SUB_CLASS_TEACH_ID  VARCHAR2(100 BYTE)        NOT NULL,
  SUBJECT_ID          VARCHAR2(100 BYTE)        NOT NULL,
  CLASS_ID            VARCHAR2(100 BYTE)        NOT NULL,
  TEACHER_ID          VARCHAR2(100 BYTE)        NOT NULL
)
TABLESPACE AMLTEST
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MAXSIZE          UNLIMITED
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;
---------------------------------------------Loging procedure---------------
CREATE OR REPLACE PROCEDURE HR.LOGIN_ADMIN (IN_USER       IN     VARCHAR2,
                                            IN_PASSWORD   IN     VARCHAR2,
                                            OUT_CODE         OUT NUMBER,
                                            OUT_MESSAGE      OUT VARCHAR2)
IS
   COUNTER      NUMBER;
   V_USER       VARCHAR2 (100);
   V_PASSWORD   VARCHAR2 (100);
BEGIN
   IF IN_USER IS NULL
   THEN
      OUT_MESSAGE := 'User Name Required';
   END IF;

   IF IN_PASSWORD IS NULL
   THEN
      OUT_MESSAGE := 'Password Required';
   END IF;

   BEGIN
      SELECT COUNT (*) USER_NAME
        INTO COUNTER
        FROM HR.INFO
       WHERE USER_NAME = IN_USER AND USER_PASSWORD = IN_PASSWORD;
   END;

   IF COUNTER > 0
   THEN
      SELECT USER_NAME, USER_PASSWORD
        INTO V_USER, V_PASSWORD
        FROM HR.INFO
       WHERE USER_NAME = IN_USER AND USER_PASSWORD = IN_PASSWORD;
       
       IF V_USER <> IN_USER AND V_PASSWORD <> IN_PASSWORD
       THEN
        OUT_CODE := 1;
        OUT_MESSAGE := 'User Credentials Not Matched !';
       ELSE
        OUT_CODE := 0;
        OUT_MESSAGE := 'Log in Successful!';
       
       END IF;
   ELSE
      OUT_CODE := 1;
      OUT_MESSAGE := 'User Credentials Not Matched !';
   END IF;
END;
/
------------------------Subject Add Procedure------------------
CREATE OR REPLACE PROCEDURE HR.ADD_SUBJECT (IN_ID         IN     VARCHAR2,
                                            IN_NAME       IN     VARCHAR2,
                                            OUT_MESSAGE      OUT VARCHAR2)
IS
   COUNTER   NUMBER;
BEGIN
   BEGIN
      IF IN_ID IS NULL
      THEN
         OUT_MESSAGE := 'Subject ID Required';
      END IF;
   END;

   BEGIN
      IF IN_NAME IS NULL
      THEN
         OUT_MESSAGE := 'Subject Name Required';
      END IF;
   END;

   BEGIN
      BEGIN
         SELECT COUNT (*) SUBJECT_NAME
           INTO COUNTER
           FROM HR.SUBJECTS
          WHERE SUBJECT_ID = IN_ID;
      END;

      IF COUNTER > 0
      THEN
         OUT_MESSAGE := 'Subject ID Already Exist,Enter New One';
      ELSE
         INSERT INTO HR.SUBJECTS (SUBJECT_ID, SUBJECT_NAME)
              VALUES (IN_ID, IN_NAME);

         OUT_MESSAGE := 'Add Subject Successfully';
      END IF;
   END;
END;
/
------------------------------Add Class Procedure---------------------
CREATE OR REPLACE PROCEDURE HR.ADD_CLASS (IN_ID         IN     VARCHAR2,
                                          IN_NAME       IN     VARCHAR2,
                                          OUT_MESSAGE      OUT VARCHAR2)
IS
   COUNTER   NUMBER;
BEGIN
   BEGIN
      IF IN_ID IS NULL
      THEN
         OUT_MESSAGE := 'Class ID Required';
      END IF;
   END;

   BEGIN
      IF IN_NAME IS NULL
      THEN
         OUT_MESSAGE := 'Class Name Required';
      END IF;
   END;

   BEGIN
      BEGIN
         SELECT COUNT (*) CLASS_NAME
           INTO COUNTER
           FROM HR.CLASSES
          WHERE CLASS_ID = IN_ID;
      END;

      IF COUNTER > 0
      THEN
         OUT_MESSAGE := 'Class ID Already Exist,Enter New One';
      ELSE
         INSERT INTO HR.CLASSES (CLASS_ID, CLASS_NAME)
              VALUES (IN_ID, IN_NAME);

         OUT_MESSAGE := 'Add Class Successfully';
      END IF;
   END;
END;
/
----------------------Add Teachers Procedure---------------
CREATE OR REPLACE PROCEDURE HR.ADD_TEACHERS(IN_ID IN VARCHAR2, IN_NAME IN VARCHAR2,OUT_MESSAGE OUT VARCHAR2)
IS
    COUNTER NUMBER;
BEGIN
    BEGIN
    IF IN_ID IS NULL
    THEN OUT_MESSAGE :='Teacher ID Required';
    END IF;
    END;
    
    BEGIN    
    IF IN_NAME IS NULL
    THEN OUT_MESSAGE :='Teacher Name Required';
    END IF;
    END;
    
    BEGIN
        SELECT COUNT(*) TEACHER_NAME INTO COUNTER  FROM HR.TEACHERS WHERE TEACHER_ID = IN_ID;
        IF COUNTER>0
        THEN 
           OUT_MESSAGE :='Teacher ID Already Exist,Enter New One';
           
        ELSE
            INSERT INTO HR.TEACHERS(TEACHER_ID,TEACHER_NAME) VALUES(IN_ID,IN_NAME);
             OUT_MESSAGE :='Add Teacher Successfully';
        END IF;
    END;
END;
/
-----------------------Add Student Procedure--------------
CREATE OR REPLACE PROCEDURE HR.ADD_STUDENTS(IN_ID IN VARCHAR2, IN_NAME IN VARCHAR2,IN_CLASS IN VARCHAR2,OUT_MESSAGE OUT VARCHAR2)
IS
    COUNTER NUMBER;
BEGIN
    BEGIN
    IF IN_ID IS NULL
    THEN OUT_MESSAGE :='Student ID Required';
    END IF;
    END;
    
    BEGIN    
    IF IN_NAME IS NULL
    THEN OUT_MESSAGE :='Student Name Required';
    END IF;
    END;
    
    BEGIN
        SELECT COUNT(*) STUDENT_NAME INTO COUNTER  FROM HR.STUDENTS WHERE ID = IN_ID;
        IF COUNTER>0
        THEN 
           OUT_MESSAGE :='Student ID Already Exist,Enter New One';
           
        ELSE
            INSERT INTO HR.STUDENTS(ID,STUDENT_NAME,CLASS) VALUES(IN_ID,IN_NAME,IN_CLASS);
             OUT_MESSAGE :='Add Student Successfully';
        END IF;
    END;
END;
/
---------------------------Procedure for Assign Subjects for classes---------------------
CREATE OR REPLACE PROCEDURE HR.ASSIGN_CLASS_SUBJECT (
   IN_CLASS_ID      IN     VARCHAR2,
   IN_SUBJECT_ID    IN     VARCHAR2,
   OUT_MESSAGE      OUT VARCHAR2)
IS
   COUNTER   NUMBER;
BEGIN    
   IF IN_CLASS_ID IS NULL
   THEN
      OUT_MESSAGE := 'Class Required';
   END IF;

   IF IN_SUBJECT_ID IS NULL
   THEN
      OUT_MESSAGE := 'Subject Name Required';
   END IF;

   BEGIN
       SELECT COUNT(*) SUB_CLASS_ID
        INTO COUNTER
        FROM HR.SUBJECT_CLAS_MAP A
       WHERE A.CLASS_ID = IN_CLASS_ID AND A.SUBJECT_ID = IN_SUBJECT_ID ;
       dbms_output.put_line('COUNTER--'||COUNTER);
       

      IF COUNTER > 0
      THEN
         OUT_MESSAGE := 'Subject Already Assinged,Enter New Subject';
      ELSE
         INSERT INTO HR.SUBJECT_CLAS_MAP (SUB_CLASS_ID, SUBJECT_ID, CLASS_ID)
              VALUES (SUB_CLASS_SEQ.NEXTVAL, IN_SUBJECT_ID, IN_CLASS_ID);

         OUT_MESSAGE := 'Assign Subject to Class Successfully';
      END IF;
      
   END;
END;
/
-----------------Procedure for Assign Teacher for Subjects and Classes--------------------
CREATE OR REPLACE PROCEDURE HR.ASSIGN_TEACH_CLAS_SUB (
   IN_TEACHER_ID    IN     VARCHAR2,
   IN_CLASS_ID      IN     VARCHAR2,
   IN_SUBJECT_ID    IN     VARCHAR2,
   OUT_MESSAGE      OUT VARCHAR2)
IS
   COUNTER   NUMBER;
   COUNTER2   NUMBER;
BEGIN
   IF IN_TEACHER_ID IS NULL
   THEN
      OUT_MESSAGE := 'Teacher Name Required';
   END IF;


   IF IN_CLASS_ID IS NULL
   THEN
      OUT_MESSAGE := 'Class Required';
   END IF;


   IF IN_SUBJECT_ID IS NULL
   THEN
      OUT_MESSAGE := 'Subject Name Required';
   END IF;



   BEGIN
        BEGIN
            SELECT COUNT(*) SUB_CLASS_TEACH_ID 
            INTO COUNTER
            FROM  HR.SUBJECT_CLAS_TEACHER_MAP A 
            WHERE A.TEACHER_ID = IN_TEACHER_ID
            AND  A.SUBJECT_ID = IN_SUBJECT_ID
            AND  A.CLASS_ID = IN_CLASS_ID;
        END;
        
        BEGIN
            SELECT COUNT(*) TEACHER_ID 
            INTO COUNTER2
            FROM  HR.SUBJECT_CLAS_TEACHER_MAP A 
            WHERE  A.SUBJECT_ID = IN_SUBJECT_ID
            AND  A.CLASS_ID = IN_CLASS_ID;
        END;
        
        
        
        IF COUNTER > 0
        THEN
            OUT_MESSAGE := 'Already Assign Teacher to this Class for this Subject';
        ELSE
            IF COUNTER2 > 0
            THEN
                OUT_MESSAGE := 'Already Assign Teacher to this Class for this Subject';
            ELSE          
              INSERT INTO HR.SUBJECT_CLAS_TEACHER_MAP (SUB_CLASS_TEACH_ID,
                                                       TEACHER_ID,
                                                       SUBJECT_ID,
                                                       CLASS_ID)
                   VALUES (TEACH_SUB_CLASS_SEQ.NEXTVAL,
                           IN_TEACHER_ID,
                           IN_SUBJECT_ID,
                           IN_CLASS_ID);

              OUT_MESSAGE := 'Assign Teacher to Class for Subjects Successfully';
           END IF;
        END IF;
   END;
END;
/

