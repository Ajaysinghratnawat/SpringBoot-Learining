INSERT INTO orders (order_status, total_Price) VALUES
('PENDING', 1599.99),
('CONFIRMED', 2499.50),
('CONFIRMED', 999.00),
('DELIVERED', 3499.99),
('CANCELLED', 799.50);

INSERT INTO order_item (product_id, quantity, order_id) VALUES
(1, 2, 1),
(2, 1, 1),
(3, 4, 2),
(4, 2, 2),
(5, 1, 3),
(1, 3, 3),
(2, 5, 4),
(4, 1, 4),
(3, 2, 5),
(5, 6, 5);