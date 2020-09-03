CREATE SCHEMA TransactionsIO;

CREATE TABLE Transactions (
id INT auto_increment PRIMARY KEY,
transactionType VARCHAR(50),
transactionDescription VARCHAR(50),
amount decimal,
transactionDate DATE
);