insert into profiles (first_name, last_name, password, email, active, roles_id)
values
('Agent', 'sam.tech', '$2a$10$ngP6vB0m5BnzZ3suFfJ4cuTPQmhTCOx.AXbi1atG5aiYoneoxGrSm', 'agent@sam.tech', true, (select  id from roles where  name = 'AGENT')),
('Admin', 'sam.tech', '$2a$10$ngP6vB0m5BnzZ3suFfJ4cuTPQmhTCOx.AXbi1atG5aiYoneoxGrSm', 'admin@sam.tech', true, (select  id from roles where  name = 'ADMINISTRATOR'));