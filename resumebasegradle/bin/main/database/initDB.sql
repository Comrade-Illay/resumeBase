CREATE TABLE IF NOT EXISTS resumes (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (20) NOT NULL,
  surname VARCHAR (20) NOT NULL,
  e_mail VARCHAR(200),
  phone_number VARCHAR(200),
  skills VARCHAR(200),
  education VARCHAR(200),
  expirience VARCHAR(200)
);

ALTER TABLE `resumebasetest`.`resumes` 
ADD FULLTEXT INDEX `full_text_search` (`skills`, `education`) VISIBLE;
;