package com.souvik.Billify_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ExpenseBillModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int expenseBillId;
    int userId;
    Date date;
    String reason;
    int amount;

    public ExpenseBillModel(int userId, Date date, String reason, int amount) {
        this.userId = userId;
        this.date = date;
        this.reason = reason;
        this.amount = amount;
    }
}
