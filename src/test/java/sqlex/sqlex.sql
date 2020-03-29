
/*1. Get 10 cities (only) from the city table in descending alphabetical order.*/
	SELECT Name 
	FROM world.city
	Order by Name Asc
	Limit 10;
	
/*2. Get all films from the films table where the title contains "airplane".*/
	SELECT title 
	FROM sakila.film
	WHERE title LIKE '%airplane%';
	
/* 3. Get the highest payment amount from the payment table. */
	SELECT MAX(amount) as highest_amount 
	FROM sakila.payment;

/* 4. Count the number of records in the customer table for store id #1. */

	SELECT COUNT(*) AS total_records 
	FROM sakila.customer 
	WHERE store_id = 1;

/* 5. Get all payments from the payments table where customer email is "NANCY.THOMAS@sakilacustomer.org" */

	SELECT amount, email
	FROM sakila.payment p
	JOIN sakila.customer c
		ON c.customer_id = p.customer_id
	WHERE c.email = "NANCY.THOMAS@sakilacustomer.org";

/* 6. Get the film info for actor Bob Fawcett. Hint: Use Views. */


	CREATE VIEW sakila.associate_films as
	SELECT fa.actor_id, f.*
	FROM sakila.film_actor fa
	Inner Join sakila.film f
		ON f.film_id = fa.film_id;

	SELECT af.*
	FROM sakila.associate_films af
	INNER JOIN sakila.actor a 
		ON af.actor_id = a.actor_id
    WHERE a.first_name = "Bob" AND a.last_name = "Fawcett";
    
	DROP VIEW sakila.associate_films;

/* 7. Get the 4 inventory ids for the film "Alien Center" at Store #2. Hint: Use variables & Stored Procedures. */

	DELIMITER //
 
	CREATE PROCEDURE GetInventoryIds(IN movie_title varchar(24))
	BEGIN
    	SELECT i.inventory_id 
		FROM sakila.inventory i
		JOIN sakila.store s
			ON s.store_id = i.store_id
		JOIN sakila.film f
			ON i.film_id = f.film_id
		WHERE f.title = movie_title;
	END //
 
	DELIMITER ;

/* 8. Insert a new store in the store table. Ensure that you use TRANSACTION. */

	START Transaction;

	INSERT INTO sakila.staff (first_name, last_name, address_id, picture, email, store_id, active, username, password, last_update)
		VALUES("Phu", "Kazu", 5, NULL, "waffle@discord.com", 2, 1, "CultOfPhu", NULL, NOW());

	SET @last_staff_id = LAST_INSERT_ID();

	INSERT INTO sakila.store (manager_staff_id, address_id, last_update) Values(@last_staff_id, 5, NOW());

	SET @last_store_id = Last_Insert_ID();

	UPDATE sakila.staff
		SET store_id = @last_store_id
    	WHERE staff_id = @last_staff_id;

	COMMIT;

/* 9. Update the timestamp (last_update) to the current date/time for the new store you entered in the previous question. */\
	SET @last_store_id = (SELECT Max(store_id) FROM sakila.store);
	UPDATE sakila.store
		SET last_update = now()
    	WHERE store_id = @last_store_id;

/* 10. Delete the new store from the store table. */
	SET @last_staff_id = (SELECT Max(staff_id) FROM sakila.staff);
	SET @last_store_id = (SELECT Max(store_id) FROM sakila.store);
	UPDATE sakila.staff
		SET store_id = 2
    	WHERE staff_id = @last_staff_id;

	DELETE FROM sakila.store where store_id = @last_store_id;
	DELETE FROM sakila.staff where staff_id = @last_staff_id;