-- Добавление игроков в таблицу Players
INSERT INTO Players (ID, Name) VALUES (1, 'Roger Federer');
INSERT INTO Players (ID, Name) VALUES (2, 'Rafael Nadal');
INSERT INTO Players (ID, Name) VALUES (3, 'Novak Djokovic');
INSERT INTO Players (ID, Name) VALUES (4, 'Andy Murray');
INSERT INTO Players (ID, Name) VALUES (5, 'Serena Williams');

-- Добавление матчей в таблицу Matches
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (1, 1, 2, 1); -- Federer vs Nadal, Winner: Federer
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (2, 3, 4, 3); -- Djokovic vs Murray, Winner: Djokovic
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (3, 2, 5, 2); -- Nadal vs Williams, Winner: Nadal
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (4, 1, 3, 3); -- Federer vs Djokovic, Winner: Djokovic
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (5, 4, 5, 5); -- Murray vs Williams, Winner: Williams
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (6, 1, 4, 1); -- Federer vs Murray, Winner: Federer
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (7, 2, 3, 2); -- Nadal vs Djokovic, Winner: Nadal
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (8, 5, 1, 5); -- Williams vs Federer, Winner: Williams
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (9, 3, 2, 3); -- Djokovic vs Nadal, Winner: Djokovic
INSERT INTO Matches (ID, Player1, Player2, Winner) VALUES (10, 4, 1, 4); -- Murray vs Federer, Winner: Murray
