INSERT INTO users (username, password, enabled)
VALUES ("user2", "pass", true)
INSERT INTO authorities (username, authority)
VALUES ("user2", "ROLE_USER")

INSERT INTO users (username, password, enabled)
VALUES ("admin2", "pass", true)
INSERT INTO authorities (username, authority)
VALUES ("admin2", "ROLE_ADMIN")

#.password( bCryptPasswordEncoder.encode("pass" ) )

