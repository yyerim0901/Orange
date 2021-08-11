-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema project_orange
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `project_orange`;

-- -----------------------------------------------------
-- Schema project_orange
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project_orange` DEFAULT CHARACTER SET utf8;
USE `project_orange`;

-- -----------------------------------------------------
-- Table `project_orange`.`categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`categories`;

CREATE TABLE IF NOT EXISTS `project_orange`.`categories`
(
    `category_id`   INT         NOT NULL AUTO_INCREMENT,
    `category_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`category_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`periods`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`periods`;

CREATE TABLE IF NOT EXISTS `project_orange`.`periods`
(
    `period_id`   INT         NOT NULL AUTO_INCREMENT,
    `period_name` VARCHAR(10) NOT NULL,
    `period_days` INT         NOT NULL,
    PRIMARY KEY (`period_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`challenges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`challenges`;

CREATE TABLE IF NOT EXISTS `project_orange`.`challenges`
(
    `challenge_id`       INT         NOT NULL AUTO_INCREMENT,
    `manager_id`         INT         NOT NULL,
    `challenge_title`    VARCHAR(45) NOT NULL,
    `challenge_describe` LONGTEXT    NULL DEFAULT NULL,
    `category_id`        INT         NOT NULL,
    `period_id`          INT         NOT NULL,
    `start_date`         DATETIME    NOT NULL,
    `end_date`           DATETIME    NOT NULL,
    `total_point`        INT         NULL DEFAULT NULL,
    `min_members`        INT         NOT NULL,
    `max_members`        INT         NOT NULL,
    `current_members`    INT         NULL DEFAULT 1,
    `image_path`         MEDIUMTEXT  NULL DEFAULT NULL,
    PRIMARY KEY (`challenge_id`),
    INDEX `period_id_idx` (`period_id` ASC) VISIBLE,
    INDEX `category_id_idx` (`category_id` ASC) VISIBLE,
    CONSTRAINT `category_id`
        FOREIGN KEY (`category_id`)
            REFERENCES `project_orange`.`categories` (`category_id`),
    CONSTRAINT `period_id`
        FOREIGN KEY (`period_id`)
            REFERENCES `project_orange`.`periods` (`period_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`users`;

CREATE TABLE IF NOT EXISTS `project_orange`.`users`
(
    `user_id`            INT          NOT NULL AUTO_INCREMENT,
    `email`              VARCHAR(45)  NOT NULL,
    `nickname`           VARCHAR(16)  NOT NULL,
    `password`           VARCHAR(400) NULL DEFAULT NULL,
    `token`              MEDIUMTEXT   NULL DEFAULT NULL,
    `profile_image_path` MEDIUMTEXT   NULL DEFAULT NULL,
    `salt`               INT          NULL DEFAULT NULL,
    `username`           VARCHAR(30)  NULL DEFAULT NULL,
    `role`               VARCHAR(10)  NULL DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
    INDEX `salt` (`salt` ASC) VISIBLE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 17
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`articles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`articles`;

CREATE TABLE IF NOT EXISTS `project_orange`.`articles`
(
    `article_id`        INT         NOT NULL AUTO_INCREMENT,
    `challenge_id`      INT         NOT NULL,
    `user_id`           INT         NOT NULL,
    `title`             VARCHAR(45) NOT NULL,
    `article_content`   LONGTEXT    NULL     DEFAULT NULL,
    `article_writetime` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `verified`          TINYINT     NOT NULL DEFAULT '0',
    PRIMARY KEY (`article_id`),
    INDEX `challenge_id_idx` (`challenge_id` ASC) VISIBLE,
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `articles_fk_challenge_id`
        FOREIGN KEY (`challenge_id`)
            REFERENCES `project_orange`.`challenges` (`challenge_id`),
    CONSTRAINT `articles_fk_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `project_orange`.`users` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`article_images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`article_images`;

CREATE TABLE IF NOT EXISTS `project_orange`.`article_images`
(
    `id`         INT        NOT NULL AUTO_INCREMENT,
    `article_id` INT        NOT NULL,
    `image_path` MEDIUMTEXT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `article_id_idx` (`article_id` ASC) VISIBLE,
    CONSTRAINT `images_fk_article_id`
        FOREIGN KEY (`article_id`)
            REFERENCES `project_orange`.`articles` (`article_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`badge_types`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`badge_types`;

CREATE TABLE IF NOT EXISTS `project_orange`.`badge_types`
(
    `badge_type_id`   INT         NOT NULL AUTO_INCREMENT,
    `badge_type_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`badge_type_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`badges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`badges`;

CREATE TABLE IF NOT EXISTS `project_orange`.`badges`
(
    `badge_id`         INT         NOT NULL AUTO_INCREMENT,
    `badge_title`      VARCHAR(45) NOT NULL,
    `badge_describe`   VARCHAR(45) NOT NULL,
    `badge_type_id`    INT         NOT NULL,
    `badge_image_path` MEDIUMTEXT  NOT NULL,
    PRIMARY KEY (`badge_id`),
    INDEX `badge_type_id_idx` (`badge_type_id` ASC) VISIBLE,
    CONSTRAINT `badges_fk_badge_type_id`
        FOREIGN KEY (`badge_type_id`)
            REFERENCES `project_orange`.`badge_types` (`badge_type_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`badges_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`badges_users`;

CREATE TABLE IF NOT EXISTS `project_orange`.`badges_users`
(
    `id`              INT     NOT NULL AUTO_INCREMENT,
    `badge_id`        INT     NOT NULL,
    `user_id`         INT     NOT NULL,
    `badge_count`     INT     NULL DEFAULT 1,
    `represent_badge` TINYINT NULL DEFAULT 0,
    PRIMARY KEY (`id`),
    INDEX `badge_id_idx` (`badge_id` ASC) VISIBLE,
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `badges_users_fk_badge_id`
        FOREIGN KEY (`badge_id`)
            REFERENCES `project_orange`.`badges` (`badge_id`),
    CONSTRAINT `badges_users_fk_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `project_orange`.`users` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`battle_matching`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`battle_matching`;

CREATE TABLE IF NOT EXISTS `project_orange`.`battle_matching`
(
    `id`        INT NOT NULL AUTO_INCREMENT,
    `blue_team` INT NOT NULL,
    `red_team`  INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_battle_matching_challenges1_idx` (`red_team` ASC) VISIBLE,
    INDEX `fk_battle_matching_challenges2_idx` (`blue_team` ASC) VISIBLE,
    CONSTRAINT `battle_matching_fk_challenges1`
        FOREIGN KEY (`red_team`)
            REFERENCES `project_orange`.`challenges` (`challenge_id`),
    CONSTRAINT `battle_matching_fk_challenges2`
        FOREIGN KEY (`blue_team`)
            REFERENCES `project_orange`.`challenges` (`challenge_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`comments`;

CREATE TABLE IF NOT EXISTS `project_orange`.`comments`
(
    `comment_id`        INT         NOT NULL AUTO_INCREMENT,
    `article_id`        INT         NOT NULL,
    `user_id`           INT         NOT NULL,
    `comment_content`   VARCHAR(64) NOT NULL,
    `comment_writetime` DATETIME    NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`comment_id`),
    INDEX `article_id_idx` (`article_id` ASC) VISIBLE,
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `comments_fk_article_id`
        FOREIGN KEY (`article_id`)
            REFERENCES `project_orange`.`articles` (`article_id`),
    CONSTRAINT `comments_fk_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `project_orange`.`users` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`follower_following`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`follower_following`;

CREATE TABLE IF NOT EXISTS `project_orange`.`follower_following`
(
    `id`   INT NOT NULL AUTO_INCREMENT,
    `from` INT NOT NULL,
    `to`   INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `from_idx` (`from` ASC) VISIBLE,
    INDEX `to_idx` (`to` ASC) VISIBLE,
    CONSTRAINT `follow_fk_from`
        FOREIGN KEY (`from`)
            REFERENCES `project_orange`.`users` (`user_id`),
    CONSTRAINT `follow_fk_to`
        FOREIGN KEY (`to`)
            REFERENCES `project_orange`.`users` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`notifications`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`notifications`;

CREATE TABLE IF NOT EXISTS `project_orange`.`notifications`
(
    `notification_id`      INT         NOT NULL AUTO_INCREMENT,
    `user_id`              INT         NOT NULL,
    `notification_title`   VARCHAR(45) NOT NULL,
    `notification_content` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`notification_id`),
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `notifications_fk_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `project_orange`.`users` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`report_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`report_categories`;

CREATE TABLE IF NOT EXISTS `project_orange`.`report_categories`
(
    `report_category_id`   INT         NOT NULL AUTO_INCREMENT,
    `report_category_name` VARCHAR(32) NOT NULL,
    PRIMARY KEY (`report_category_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`reports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`reports`;

CREATE TABLE IF NOT EXISTS `project_orange`.`reports`
(
    `report_id`          INT        NOT NULL AUTO_INCREMENT,
    `article_id`         INT        NOT NULL,
    `report_category_id` INT        NOT NULL,
    `report_content`     MEDIUMTEXT NOT NULL,
    PRIMARY KEY (`report_id`),
    INDEX `report_category_id_idx` (`report_category_id` ASC) VISIBLE,
    INDEX `reports_fk_article_id_idx` (`article_id` ASC) VISIBLE,
    CONSTRAINT `reports_fk_article_id`
        FOREIGN KEY (`article_id`)
            REFERENCES `project_orange`.`articles` (`article_id`),
    CONSTRAINT `reports_fk_report_category_id`
        FOREIGN KEY (`report_category_id`)
            REFERENCES `project_orange`.`report_categories` (`report_category_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`salt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`salt`;

CREATE TABLE IF NOT EXISTS `project_orange`.`salt`
(
    `id`   INT          NOT NULL AUTO_INCREMENT,
    `salt` VARCHAR(400) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 8
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `project_orange`.`users_challenges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_orange`.`users_challenges`;

CREATE TABLE IF NOT EXISTS `project_orange`.`users_challenges`
(
    `id`           INT     NOT NULL AUTO_INCREMENT,
    `user_id`      INT     NOT NULL,
    `challenge_id` INT     NOT NULL,
    `point`        INT     NULL DEFAULT 100,
    `is_manager`   TINYINT NULL DEFAULT 0,
    PRIMARY KEY (`id`),
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    INDEX `challenge_id_idx` (`challenge_id` ASC) VISIBLE,
    CONSTRAINT `users_challengers_fk_challenge_id`
        FOREIGN KEY (`challenge_id`)
            REFERENCES `project_orange`.`challenges` (`challenge_id`),
    CONSTRAINT `users_challenges_fk_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `project_orange`.`users` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;


-- 기본 더미 데이터 주입
use project_orange;

-- 뱃지 타입
insert into badge_types(badge_type_name)
values ("활동 뱃지");
insert into badge_types(badge_type_name)
values ("1:1 배틀 뱃지");
insert into badge_types(badge_type_name)
values ("시즌 배틀 뱃지");

-- 활동 뱃지
insert into badges(badge_title, badge_describe, badge_type_id, badge_image_path)
values ("Here comes a new challenger!", "첫 챌린지 참여", 1, "badge_image_path"),
       ("손에 손 잡고", "첫 챌린지 개최", 1, "badge_image_path"),
       ("와우 친구들, 대머리 아저씨야", "'운동' 카테고리 챌린지 첫 완수", 1, "badge_image_path"),
       ("이제 바질을 곁들인", "'식단' 카테고리 챌린지 첫 완수", 1, "badge_image_path"),
       ("약 드실 시간입니다", "'영양제' 카테고리 챌린지 첫 완수", 1, "badge_image_path"),
       ("삼위일체", "모든 카테고리 챌린지를 한 번씩 완수", 1, "badge_image_path"),
       ("내 동료가 돼라", "최초로 다른 사용자를 follow", 1, "badge_image_path"),
       ("우린 이제 칭구칭긔", "최초로 다른 사용자가 나를 follow", 1, "badge_image_path"),
       ("나, 강림", "최초로 게시글 작성", 1, "badge_image_path"),
       ("무플방지위원회", "최초로 댓글 작성", 1, "badge_image_path"),
       ("나는 필연적인 존재다", "이 뱃지를 제외한 모든 활동 뱃지 수집 완료", 1, "badge_image_path");

-- 챌린지 기간
insert into periods(period_name, period_days)
values ("15일", 15),
       ("30일", 30),
       ("60일", 60),
       ("100일", 100),
       ("180일", 180),
       ("1년", 365);

-- 챌린지 카테고리
insert into categories(category_name)
values ("운동"),
       ("음식"),
       ("영양제");

-- 신고 항목
insert into report_categories(report_category_name)
values ("올바르지 않은 인증 게시물");

