--liquibase formatted sql

--changeset MateuszChmielewski:alter-food-items-emoji-column
ALTER TABLE food_items MODIFY emoji VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;