INSERT INTO Players (Name) VALUES ('Roger Federer');
INSERT INTO Players (Name) VALUES ('Rafael Nadal');
INSERT INTO Players (Name) VALUES ('Novak Djokovic');
INSERT INTO Players (Name) VALUES ('Andy Murray');
INSERT INTO Players (Name) VALUES ('Serena Williams');

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
