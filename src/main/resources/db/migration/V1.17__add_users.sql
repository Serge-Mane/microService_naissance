insert into profiles (first_name, last_name, password, email, active, roles_id)
values
('Agent', 'chillo.tech', '$2a$10$OWWt4EEfhFr6LW/e4mx9n.3SnOSeUsxw3zSvxX/paTQ//h1bfOa4u', 'agent@chillo.tech', true, (select  id from roles where  name = 'AGENT')),
('Admin', 'chillo.tech', '$2a$10$OWWt4EEfhFr6LW/e4mx9n.3SnOSeUsxw3zSvxX/paTQ//h1bfOa4u', 'admin@chillo.tech', true, (select  id from roles where  name = 'ADMINISTRATOR'));