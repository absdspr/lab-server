INSERT  INTO subject (id, name, short_name)  VALUES
(1, 'Проектирование информационных систем', 'ПрИС') ON CONFLICT DO NOTHING;
INSERT INTO subject (id, name, short_name) VALUES
(2, 'Системы искусственного интеллекта', 'СИИ') ON CONFLICT DO NOTHING;
INSERT INTO subject (id, name, short_name) VALUES
(3, 'Программная инженерия', 'ПИ') ON CONFLICT DO NOTHING;
INSERT INTO subject (id, name, short_name) VALUES
(4, 'Национальная система информационной безопасности', 'НСИБ') ON CONFLICT DO NOTHING;
INSERT INTO subject (id, name, short_name) VALUES
(5, 'Системный анализ', 'СисАнал') ON CONFLICT DO NOTHING;
INSERT INTO subject (id, name, short_name) VALUES
(6, 'Распределенные базы данных', 'РБД') ON CONFLICT DO NOTHING;
INSERT INTO subject (id, name, short_name) VALUES
(7, 'Системное программное обеспечение', 'СПО') ON CONFLICT DO NOTHING;

INSERT INTO exam_type(id, type) values
(1, 'Экзамен') ON CONFLICT DO NOTHING;
INSERT INTO exam_type(id, type) values
(2, 'Зачет') ON CONFLICT DO NOTHING;
INSERT INTO exam_type(id, type) values
(3, 'Зачет с оценкой') ON CONFLICT DO NOTHING;
INSERT INTO exam_type(id, type) values
(4, 'Курсовая') ON CONFLICT DO NOTHING;;

INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(1, 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(2, 1, 4) ON CONFLICT DO NOTHING;
INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(3, 2, 1) ON CONFLICT DO NOTHING;
INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(4, 3, 1) ON CONFLICT DO NOTHING;
INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(5, 4, 2) ON CONFLICT DO NOTHING;
INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(6, 5, 1) ON CONFLICT DO NOTHING;
INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(7, 6, 2) ON CONFLICT DO NOTHING;
INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(8, 7, 1) ON CONFLICT DO NOTHING;

INSERT INTO mark (id, name, value) VALUES
(1, 'Отлично', 5) ON CONFLICT DO NOTHING;
INSERT INTO mark (id, name, value) VALUES
(2, 'Хорошо', 4) ON CONFLICT DO NOTHING;
INSERT INTO mark (id, name, value) VALUES
(3, 'Удовлетворительно', 3) ON CONFLICT DO NOTHING;
INSERT INTO mark (id, name, value) VALUES
(4, 'Неудовлетворительно', 2) ON CONFLICT DO NOTHING;
INSERT INTO mark (id, name, value) VALUES
(5, 'Зачет', 'з') ON CONFLICT DO NOTHING;
INSERT INTO mark (id, name, value) VALUES
(6, 'Незачет', 'н') ON CONFLICT DO NOTHING;
INSERT INTO mark (id, name, value) VALUES
(7, 'Неявка', '') ON CONFLICT DO NOTHING;
