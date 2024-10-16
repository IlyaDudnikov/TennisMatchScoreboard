-- Добавление игроков (15)
INSERT INTO Players (Name) VALUES ('Roger Federer');
INSERT INTO Players (Name) VALUES ('Rafael Nadal');
INSERT INTO Players (Name) VALUES ('Novak Djokovic');
INSERT INTO Players (Name) VALUES ('Andy Murray');
INSERT INTO Players (Name) VALUES ('Serena Williams');
INSERT INTO Players (Name) VALUES ('Maria Sharapova');
INSERT INTO Players (Name) VALUES ('Pete Sampras');
INSERT INTO Players (Name) VALUES ('Boris Becker');
INSERT INTO Players (Name) VALUES ('Steffi Graf');
INSERT INTO Players (Name) VALUES ('Jim Courier');
INSERT INTO Players (Name) VALUES ('Andre Agassi');
INSERT INTO Players (Name) VALUES ('Venus Williams');
INSERT INTO Players (Name) VALUES ('Lleyton Hewitt');
INSERT INTO Players (Name) VALUES ('Chris Evert');
INSERT INTO Players (Name) VALUES ('Billie Jean King');

-- Добавление матчей (50)
INSERT INTO Matches (Player1, Player2, Winner) VALUES (1, 2, 1); -- Federer vs Nadal, Winner: Federer
INSERT INTO Matches (Player1, Player2, Winner) VALUES (3, 4, 3); -- Djokovic vs Murray, Winner: Djokovic
INSERT INTO Matches (Player1, Player2, Winner) VALUES (2, 5, 2); -- Nadal vs Williams, Winner: Nadal
INSERT INTO Matches (Player1, Player2, Winner) VALUES (1, 3, 3); -- Federer vs Djokovic, Winner: Djokovic
INSERT INTO Matches (Player1, Player2, Winner) VALUES (4, 5, 5); -- Murray vs Williams, Winner: Williams
INSERT INTO Matches (Player1, Player2, Winner) VALUES (1, 4, 1); -- Federer vs Murray, Winner: Federer
INSERT INTO Matches (Player1, Player2, Winner) VALUES (2, 3, 2); -- Nadal vs Djokovic, Winner: Nadal
INSERT INTO Matches (Player1, Player2, Winner) VALUES (5, 1, 5); -- Williams vs Federer, Winner: Williams
INSERT INTO Matches (Player1, Player2, Winner) VALUES (3, 2, 3); -- Djokovic vs Nadal, Winner: Djokovic
INSERT INTO Matches (Player1, Player2, Winner) VALUES (4, 1, 4); -- Murray vs Federer, Winner: Murray
INSERT INTO Matches (Player1, Player2, Winner) VALUES (1, 6, 1); -- Federer vs Sharapova, Winner: Federer
INSERT INTO Matches (Player1, Player2, Winner) VALUES (7, 8, 7); -- Sampras vs Becker, Winner: Sampras
INSERT INTO Matches (Player1, Player2, Winner) VALUES (9, 10, 10); -- Graf vs Courier, Winner: Graf
INSERT INTO Matches (Player1, Player2, Winner) VALUES (11, 12, 11); -- Agassi vs Venus, Winner: Agassi
INSERT INTO Matches (Player1, Player2, Winner) VALUES (13, 14, 14); -- Evert vs King, Winner: King
INSERT INTO Matches (Player1, Player2, Winner) VALUES (2, 7, 7); -- Nadal vs Sampras, Winner: Sampras
INSERT INTO Matches (Player1, Player2, Winner) VALUES (3, 8, 8); -- Djokovic vs Becker, Winner: Becker
INSERT INTO Matches (Player1, Player2, Winner) VALUES (4, 9, 9); -- Murray vs Graf, Winner: Graf
INSERT INTO Matches (Player1, Player2, Winner) VALUES (5, 10, 5); -- Williams vs Courier, Winner: Williams
INSERT INTO Matches (Player1, Player2, Winner) VALUES (6, 11, 6); -- Sharapova vs Agassi, Winner: Sharapova
INSERT INTO Matches (Player1, Player2, Winner) VALUES (12, 13, 12); -- Venus vs Evert, Winner: Venus
INSERT INTO Matches (Player1, Player2, Winner) VALUES (14, 15, 15); -- King vs Evert, Winner: King
INSERT INTO Matches (Player1, Player2, Winner) VALUES (1, 7, 1); -- Federer vs Sampras, Winner: Federer
INSERT INTO Matches (Player1, Player2, Winner) VALUES (2, 8, 2); -- Nadal vs Becker, Winner: Nadal
INSERT INTO Matches (Player1, Player2, Winner) VALUES (3, 9, 3); -- Djokovic vs Graf, Winner: Djokovic
INSERT INTO Matches (Player1, Player2, Winner) VALUES (4, 10, 4); -- Murray vs Courier, Winner: Murray
INSERT INTO Matches (Player1, Player2, Winner) VALUES (5, 11, 11); -- Williams vs Agassi, Winner: Agassi
INSERT INTO Matches (Player1, Player2, Winner) VALUES (6, 12, 12); -- Sharapova vs Venus, Winner: Venus
INSERT INTO Matches (Player1, Player2, Winner) VALUES (13, 1, 1); -- Evert vs Federer, Winner: Federer
INSERT INTO Matches (Player1, Player2, Winner) VALUES (2, 3, 2); -- Nadal vs Djokovic, Winner: Nadal
INSERT INTO Matches (Player1, Player2, Winner) VALUES (4, 5, 5); -- Murray vs Williams, Winner: Williams
INSERT INTO Matches (Player1, Player2, Winner) VALUES (6, 13, 13); -- Sharapova vs Evert, Winner: Evert
INSERT INTO Matches (Player1, Player2, Winner) VALUES (10, 15, 10); -- Courier vs King, Winner: Courier
INSERT INTO Matches (Player1, Player2, Winner) VALUES (1, 5, 1); -- Federer vs Williams, Winner: Federer
INSERT INTO Matches (Player1, Player2, Winner) VALUES (7, 10, 7); -- Sampras vs Courier, Winner: Sampras
INSERT INTO Matches (Player1, Player2, Winner) VALUES (3, 11, 11); -- Djokovic vs Agassi, Winner: Agassi
INSERT INTO Matches (Player1, Player2, Winner) VALUES (4, 12, 12); -- Murray vs Venus, Winner: Venus
INSERT INTO Matches (Player1, Player2, Winner) VALUES (9, 14, 9); -- Graf vs King, Winner: Graf
INSERT INTO Matches (Player1, Player2, Winner) VALUES (2, 6, 6); -- Nadal vs Sharapova, Winner: Sharapova
INSERT INTO Matches (Player1, Player2, Winner) VALUES (8, 13, 8); -- Becker vs Evert, Winner: Becker
INSERT INTO Matches (Player1, Player2, Winner) VALUES (1, 4, 1); -- Federer vs Murray, Winner: Federer
INSERT INTO Matches (Player1, Player2, Winner) VALUES (3, 2, 2); -- Djokovic vs Nadal, Winner: Nadal
INSERT INTO Matches (Player1, Player2, Winner) VALUES (5, 8, 5); -- Williams vs Becker, Winner: Williams
INSERT INTO Matches (Player1, Player2, Winner) VALUES (12, 9, 12); -- Venus vs Graf, Winner: Venus
INSERT INTO Matches (Player1, Player2, Winner) VALUES (15, 14, 15); -- King vs Evert, Winner: King
INSERT INTO Matches (Player1, Player2, Winner) VALUES (11, 1, 1); -- Agassi vs Federer, Winner: Federer
INSERT INTO Matches (Player1, Player2, Winner) VALUES (1, 9, 9);   -- Federer vs Graf, Winner: Graf
INSERT INTO Matches (Player1, Player2, Winner) VALUES (5, 15, 5);  -- Williams vs King, Winner: Williams
INSERT INTO Matches (Player1, Player2, Winner) VALUES (7, 4, 7);   -- Sampras vs Murray, Winner: Sampras
INSERT INTO Matches (Player1, Player2, Winner) VALUES (3, 12, 12); -- Djokovic vs Venus, Winner: Venus
