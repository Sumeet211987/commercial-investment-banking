ALTER TABLE portfolio
ADD CONSTRAINT fk_user_id 
FOREIGN KEY (user_id)
REFERENCES users(id)
ON DELETE CASCADE;

ALTER TABLE users
ADD CONSTRAINT fk_portfolio_id 
FOREIGN KEY (portfolio_id)
REFERENCES portfolio(id)
ON DELETE CASCADE;