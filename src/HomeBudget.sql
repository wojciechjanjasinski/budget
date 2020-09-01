CREATE SCHEMA TransactionsIO;

CREATE TABLE Transactions (
id INT auto_increment PRIMARY KEY,
transactionType float8,
transactionDescription VARCHAR(50),
amount float8,
transactionDate DATE
);