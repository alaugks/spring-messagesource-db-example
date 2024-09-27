-- ----------------------------
-- Table structure for messagesource
-- ----------------------------
DROP TABLE IF EXISTS "messagesource";
CREATE TABLE "messagesource" (
  "id" BIGINT AUTO_INCREMENT NOT NULL,
  "code" VARCHAR(255),
  "value" VARCHAR(255),
  "locale" VARCHAR(255),
  "domain" VARCHAR(255),
  CONSTRAINT "pk_messagesource" PRIMARY KEY ("id"),
  CONSTRAINT "transunit" UNIQUE ("code" ASC, "locale" ASC, "domain" ASC)
);

-- ----------------------------
-- Records of messagesource
-- ----------------------------
BEGIN;
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (1, 'headline', 'Headline', 'en', NULL);
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (2, 'postcode', 'Postcode', 'en', NULL);
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (3, 'headline', 'Überschrift', 'de', NULL);
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (4, 'postcode', 'Postleitzahl', 'de', NULL);
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (5, 'postcode', 'Zip code', 'en-US', NULL);
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (6, 'headline', 'Payment', 'en', 'payment');
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (7, 'expiry_date', 'Expire', 'en', 'payment');
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (8, 'headline', 'Zahlung', 'de', 'payment');
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (9, 'expiry_date', 'Ablaufdatum', 'de', 'payment');
INSERT INTO "messagesource" ("id", "code", "value", "locale", "domain") VALUES (10, 'expiry_date', 'Expiration date', 'en-US', 'payment');
COMMIT;
