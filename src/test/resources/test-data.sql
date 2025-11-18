-- Only insert data that's needed for specific tests
-- Use INSERT IGNORE to skip if already exists

-- Make sure we have a test user
INSERT IGNORE INTO user (id, login, email, password, role) VALUES
(999, 'testuser', 'test@example.com', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'ROLE_USER');

-- Make sure we have test categories
INSERT IGNORE INTO category (id, title, alias, enabled, image, parent_id, all_parent_ids) VALUES
(999, 'Test Electronics', 'test-electronics', true, 'electronics.jpg', NULL, NULL);

-- Make sure we have a test vendor
INSERT IGNORE INTO vendor (id, title) VALUES (999, 'Test Vendor');

-- Make sure we have test products
INSERT IGNORE INTO product (id, title, alias, description, price, image, category_id, vendor_id) VALUES
(999, 'Test Product', 'test-product', 'Test Description', 99.99, 'test.jpg', 999, 999);