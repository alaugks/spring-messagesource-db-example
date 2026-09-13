-- ----------------------------
-- Table structure for messagesource
-- ----------------------------
DROP TABLE IF EXISTS "messagesource";
CREATE TABLE "messagesource" (
  "id" BIGINT AUTO_INCREMENT NOT NULL,
  "code" VARCHAR(255),
  "value" VARCHAR(255),
  "locale" VARCHAR(255),
  CONSTRAINT "pk_messagesource" PRIMARY KEY ("id"),
  CONSTRAINT "transunit" UNIQUE ("code" ASC, "locale" ASC)
);

-- ----------------------------
-- Records of messagesource
-- ----------------------------
BEGIN;
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (1, 'headline', 'Headline', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (2, 'postcode', 'Postcode', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (3, 'headline', 'Überschrift', 'de');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (4, 'postcode', 'Postleitzahl', 'de');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (5, 'postcode', 'Zip code', 'en-US');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (6, 'payment.headline', 'Payment', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (7, 'payment.expiry_date', 'Expire', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (8, 'payment.headline', 'Zahlung', 'de');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (9, 'payment.expiry_date', 'Ablaufdatum', 'de');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (10, 'payment.expiry_date', 'Expiration date', 'en-US');
COMMIT;
