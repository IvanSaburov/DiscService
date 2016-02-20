SET DATABASE SQL SYNTAX MYS TRUE;
INSERT INTO users (username, password, authority, enabled) VALUES ('feb', 'feb', 'ROLE_USER', true);
INSERT INTO users (username, password, authority, enabled) VALUES ('admin', 'admin', 'ROLE_USER', true);
INSERT INTO users (username, password, authority, enabled) VALUES ('user', 'user', 'ROLE_USER', true);

INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('titanic', 'drama', 1996, 'feb', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('the crow', 'action', 1994, 'admin', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('terminator', 'action', 1988, 'admin', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('interstellar', 'drama', 2015, 'feb', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('marsianin', 'action', 2015, 'admin', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('parfumer', 'drama', 2006, 'user', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('secret window', 'drama', 2005, 'feb', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('spartak', 'action', 2000, 'user', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('requiem for a dream', 'drama', 2000, 'feb', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('green mile', 'drama', 1999, 'user', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('remember me', 'drama', 2010, 'user', true);
INSERT INTO disc (discName, genre, discyear, discOwner, discIsFree) VALUES ('memory', 'drama', 2004, 'admin', true);

	
	