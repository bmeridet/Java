/* Admin */
insert into admin(id, admin_id, pwd) values (1, 'admin', 'password');

/* User */
insert into user(id, address, age, email, f_name, l_name, pwd) values (1, '123 test dr', 36, 'test1@test.com', 'ted', 'test', 'helloworld1');
insert into user(id, address, age, email, f_name, l_name, pwd) values (2, '456 test dr', 37, 'test2@test.com', 'joe', 'test', 'helloworld2');
insert into user(id, address, age, email, f_name, l_name, pwd) values (3, '789 test dr', 38, 'test3@test.com', 'bob', 'test', 'helloworld3');

/* Categories */
insert into category(id, name) values (1, 'dress');
insert into category(id, name) values (2, 'athletic');
insert into category(id, name) values (3, 'casual');
insert into category(id, name) values (4, 'swim');

/* Products */
insert into product(id, name, price, category_id) values (1, 'dress boots', 99.00, 1);
insert into product(id, name, price, category_id) values (2, 'max air', 120.00, 2);
insert into product(id, name, price, category_id) values (3, 'slippers', 70.00, 3);
insert into product(id, name, price, category_id) values (4, 'flip flops', 30.00, 4);

/* Purchase */
insert into purchase(id, total, user_id) values (1, 219.00, 1);
insert into purchase(id, total, user_id) values (2, 100.00, 2);

/* PurchaseItem */
insert into purchase_item(id, price, quantity, rate, product_id, purchase_id, user_id) values (1, 99.00, 1, 1, 1, 1, 1);
insert into purchase_item(id, price, quantity, rate, product_id, purchase_id, user_id) values (2, 120.00, 1, 1, 2, 1, 1);
insert into purchase_item(id, price, quantity, rate, product_id, purchase_id, user_id) values (3, 70.00, 1, 1, 3, 2, 2);
insert into purchase_item(id, price, quantity, rate, product_id, purchase_id, user_id) values (4, 30.00, 1, 1, 4, 2, 2);
