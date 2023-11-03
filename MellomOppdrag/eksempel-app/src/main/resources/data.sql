INSERT INTO users (username, password, enabled)
VALUES ('user2', '$2a$10$iZ86.z/R1L79aCnQwnu2KeMv2bUrdfNlWkkslGac0PiCfUGoz9xgy', true);
--.password( bCryptPasswordEncoder.encode("pass" ) )
INSERT INTO authorities (username, authority)
VALUES ('user2', 'ROLE_USER');


INSERT INTO users (username, password, enabled)
VALUES ('admin2', '$2a$10$v0x5.8unVE/Ec3gUL90Vv.7ymoIg/U4KuKUzDv1ORJ9hxi013B/5.', true);
--.password( bCryptPasswordEncoder.encode("pass" ) )
INSERT INTO authorities (username, authority)
VALUES ('admin2', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled)
VALUES ('sa', '$2a$10$jRFW9L3ZASpHsLxdYMR/HuW2azSvEhxhp.g8zH5S7WRgIvJezyRK6', true);
--.password( bCryptPasswordEncoder.encode("password" ) )
INSERT INTO authorities (username, authority)
VALUES ('sa', 'ROLE_ADMIN');
