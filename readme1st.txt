Project Summary:
================

For quick development this is implemneted using Spring Boot.


Project directory:
==================

	├───.settings
	├───postman
	├───src
	│   ├───main
	│   │   ├───java
	│   │   │   └───ordersystem
	│   │   │       ├───controller
	│   │   │       ├───database
	│   │   │       ├───exceptions
	│   │   │       ├───model
	│   │   │       ├───security
	│   │   │       ├───service
	│   │   │       └───utilities
	│   │   └───resources
	│   └───test
	│       ├───java
	│       └───resources
	└───target
		├───classes
		│   ├───META-INF
		│   │   └───maven
		│   │       └───org.food
		│   │           └───ordersystem
		│   └───ordersystem
		│       ├───controller
		│       ├───database
		│       ├───exceptions
		│       ├───model
		│       ├───security
		│       ├───service
		│       └───utilities
		└───test-classes


Test Data:
==========

Following are the contents of data.sql file.

INSERT INTO tax_rate (id, rate) VALUES (1, 5);


INSERT INTO app_user (user_name, password, enabled) VALUES ('czhao', 'welcome1', 'yes');
INSERT INTO app_user (user_name, password, enabled) VALUES ('jslow', 'welcome1', 'yes');
INSERT INTO app_user (user_name, password, enabled) VALUES ('fmario', 'welcome1', 'yes');
INSERT INTO app_user (user_name, password, enabled) VALUES ('admin', 'welcome1', 'yes');


INSERT INTO user_role (user_name, user_role) VALUES ('czhao', 'owner');
INSERT INTO user_role (user_name, user_role) VALUES ('jslow', 'customer');
INSERT INTO user_role (user_name, user_role) VALUES ('fmario', 'driver');
INSERT INTO user_role (user_name, user_role) VALUES ('admin', 'admin');


INSERT INTO restaurant (name, owner_id) VALUES ('SuperChanRestaurant', 'czhao');
INSERT INTO menu_item (id, name, title, description, menu_name, price, prep_time) VALUES (1, 'KungPaoChicken', 'Kung Pao Chicken', 'yummy yummy', 'SuperChanRestaurant', 5.5, 3);
INSERT INTO menu_item (id, name, title, description, menu_name, price, prep_time) VALUES (2, 'ChickenCaowMin', 'Chicken Chaow Min', 'delicious', 'SuperChanRestaurant', 6.5, 5);
INSERT INTO menu_item (id, name, title, description, menu_name, price, prep_time) VALUES (3, 'BrocoliBeef', 'Brocoli Beef', 'healthy choice', 'SuperChanRestaurant', 7.5, 6);
INSERT INTO menu_item (id, name, title, description, menu_name, price, prep_time) VALUES (4, 'SweetSourPork', 'Sweet Sour Pork', 'yucky yucky', 'SuperChanRestaurant', 8.5, 4);
INSERT INTO menu_item (id, name, title, description, menu_name, price, prep_time) VALUES (5, 'NoodleSoup', 'Noodle Soup', 'slirp it', 'SuperChanRestaurant', 9.5, 2);
INSERT INTO menu_item (id, name, title, description, menu_name, price, prep_time) VALUES (6, 'ChickenDumplings', 'Chicken Dumplings', 'bite at a time', 'SuperChanRestaurant', 10.5, 7);


INSERT INTO customer (user_name, full_name, address, distance_from_restaurant) VALUES ('jslow', 'john Slow', '123 4th Street, Up Town, WA 94688', 10);


INSERT INTO customer_order (id, customer_user_name, delivered, picked_up, delivery_time_mins, delivery_charge, tax,  total_price) VALUES (111, 'jslow', false, false, 29, 10.0, 1.0, 20.5);
INSERT INTO order_item (id, item_id, quantity, order_id) VALUES (100, 1, 1, 111);
INSERT INTO order_item (id, item_id, quantity, order_id) VALUES (200, 2, 1, 111);
INSERT INTO order_item (id, item_id, quantity, order_id) VALUES (300, 3, 1, 111);


		
Postman Collection:
===================

Following are the contents of the RestaurantOrderSystem.postman_collection.json file.

	Login:
		POST http://localhost:8080/authnticate
			{
				"username": "czhao",
				"password": "welcome1"
			}
		
	Logout:
		POST http://localhost:8080/invalidatetoken
			{
				"token": "l4HEC2ZbswwWhqIAqh1oI...."
			}		

	Get restaurant menu:	
		GET http://localhost:8080/restaurants/{name}
			
	List orders:
		GET http://localhost:8080/orders

	Get an order:
		GET http://localhost:8080/orders/{id}
	
	Print invoice as PDF file:
		GET http://localhost:8080/orders/invoice/{id}

	Place an order:
		POST http://localhost:8080/orders
			{
				"customer": {
					"userName": "jslow",
					"address": "123 4th Street, Up Town, WA 94688"
				},
				"orderItems": [
					{
						"quantity": 2,
						"menuItem": {
							"id": 2
						}
					},
					{
						"quantity": 2,
						"menuItem": {
							"id": 4
						}
					},
					{
						"quantity": 2,
						"menuItem": {
							"id": 6
						}
					}
				]
			}		
	
	Update order (pickedup and delivered only):
		PUT http://localhost:8080/orders
			{
				"pickedUp": true,
				"delivered": true
			}
	
	Cancel order:
		DELETE http://localhost:8080/orders/{id}
		
	
   