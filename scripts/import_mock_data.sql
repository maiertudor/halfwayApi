INSERT INTO accounts(
            id, password, role, username, profile_id)
    VALUES ('402880715fc1de41015fc1e200410000', '$2a$10$hsNAa5J1xiNxjJVTLgC74eYLYVPTZWnLrgaCz3BLUmDJ1rDySJCbq', 'CLIENT', 'admin', ?);


INSERT INTO categories(
            id, name)
    VALUES (1, 'Marketing'), (2, 'IT'), (3, 'Relatii publice'), (4, 'Contabilitate'), (5, 'Traduceri');

INSERT INTO locations(
            id, name)
    VALUES (1, 'Cluj-Napoca'), (2, 'Satu Mare'), (3, 'Zalau'), (4, 'Oradea'), (5, 'Bucuresti');

INSERT INTO jobs(
            id, cost, created_at, description, ends_at, title, updated_at, 
            category_id, location_id, owner_id)
    VALUES (1, 10, '2017-09-29 03:00', 'short description', '2017-10-10 03:00', 'Babysister', '2017-09-30 03:00', 
            3, 1, '402880715fc1de41015fc1e200410000'),
            
            (2, 120, '2017-09-29 03:00', 'As a Junior Configuration Specialist, you will be part of our Solutions Delivery team, and your role will be to implement Darwin by configuring it to meet our Client specific requirements.', '2017-10-10 03:00', 'Junior Configuration Specialist', '2017-09-30 03:00', 
            2, 1, '402880715fc1de41015fc1e200410000'),
            
            (3, 130, '2017-09-29 03:00', 'consilier clienti ProCredit Bank client advisor', '2017-10-10 03:00', 'Consilier clienti', '2017-09-30 03:00', 
            3, 1, '402880715fc1de41015fc1e200410000'),
            
            (4, 20, '2017-09-29 03:00', 'Yardi Romania', '2017-10-10 03:00', 'Web Software Engineer', '2017-09-30 03:00', 
            2, 1, '402880715fc1de41015fc1e200410000'),
            
            (5, 30, '2017-09-29 03:00', 'SC Studio Moderna SA', '2017-10-10 03:00', 'Shop Assistant', '2017-09-30 03:00', 
            3, 3, '402880715fc1de41015fc1e200410000'),
            
            (6, 13, '2017-09-29 03:00', 'Industries Service International', '2017-10-10 03:00', 'Technical Programmer in automotive industry', '2017-09-30 03:00', 
            3, 4, '402880715fc1de41015fc1e200410000'),
            
            (7, 17, '2017-09-29 03:00', 'traduce orice', '2017-10-10 03:00', 'Traducator Engleza-Romana', '2017-09-30 03:00', 
            3, 2, '402880715fc1de41015fc1e200410000'),
            
            (8, 12, '2017-09-29 03:00', 'WPRiders', '2017-10-10 03:00', 'WordPress Theme & Plugin Developer - remote & in-off', '2017-09-30 03:00', 
            3, 3, '402880715fc1de41015fc1e200410000'),
            
            (9, 10, '2017-09-29 03:00', 'We welcome those hungry tech minds to our continuous journey of great technology within financial markets. Prove us you are passionate, analytical, open and we will nurture you and give you autonomy to grow.', '2017-10-10 03:00', 'IT BUSINESS Consultant', '2017-09-30 03:00', 
            2, 5, '402880715fc1de41015fc1e200410000'),
            
            (10, 101, '2017-09-29 03:00', 'Yardi Romania', '2017-10-10 03:00', 'SEO Specialist', '2017-09-30 03:00', 
            2, 3, '402880715fc1de41015fc1e200410000');