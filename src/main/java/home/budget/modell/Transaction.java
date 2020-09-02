package home.budget.modell;

import java.util.Date;

public class Transaction {
    private Long ID;
    private String transactionType;
    private String transactionDescription;
    private Double amount;
    private Date transactionDate;

    public Transaction() {
    }

    public Transaction(String transactionType, String transactionDescription, Double amount, Date transactionDate) {
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Transaction(Long ID, String transactionType, String transactionDescription, Double amount, Date transactionDate) {
        this.ID = ID;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "ID=" + ID +
                ", transactionType=" + transactionType +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
