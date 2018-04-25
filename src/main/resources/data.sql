

INSERT INTO Contacts ( CONTACT_ID ) VALUES
(1), (2),(3);

INSERT INTO Applications (APPLICATION_ID, PRODUCT_NAME,DT_CREATED,CONTACT_ID)
VALUES (1, 'card', '2017-10-10',1),
(2, 'credit', '2017-12-10',1),
(3, 'card', '2018-10-10T22:22:00',1),
(4, 'credit', '2018-01-01',2),
(5, 'card', '2018-02-02',2),
(6, 'credit', '2017-12-12',2);
