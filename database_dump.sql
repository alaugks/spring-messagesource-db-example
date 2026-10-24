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
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (11, 'salutation', '{salutation, plural, =1 {Ms.} =2 {Mr.} =3 {Mx.} other {Unknown}}', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (12, 'salutation', '{salutation, plural, =1 {Frau} =2 {Herr} =3 {Divers} other {Unbekannt}}', 'de');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (13, 'payment.expiry_info', 'Your card expires on {expiryDate, date, long}.', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (14, 'payment.expiry_info', 'Ihre Karte läuft am {expiryDate, date, long} ab.', 'de');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (15, 'file_deleted', '{count, plural, =0 {You deleted no files.} =1 {You deleted one file.} other {You deleted # files.}}', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (16, 'file_deleted', '{count, plural, =0 {Sie haben keine Dateien gelöscht.} =1 {Sie haben eine Datei gelöscht.} other {Sie haben # Dateien gelöscht.}}', 'de');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (17, 'greeting', '{recipient_gender, select, feminine {How is she?} masculine {How is he?} other {How are they?}}', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (18, 'greeting', '{recipient_gender, select, feminine {Wie geht''s ihr?} masculine {Wie geht''s ihm?} other {Wie geht''s ihnen?}}', 'de');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (19, 'device_hint', '{device, select, mobile {Open the app on your phone.} desktop {Open the app on your computer.} other {Open the app.}}', 'en');
INSERT INTO "messagesource" ("id", "code", "value", "locale") VALUES (20, 'device_hint', '{device, select, mobile {Öffnen Sie die App auf Ihrem Smartphone.} desktop {Öffnen Sie die App auf Ihrem Computer.} other {Öffnen Sie die App.}}', 'de');
COMMIT;
