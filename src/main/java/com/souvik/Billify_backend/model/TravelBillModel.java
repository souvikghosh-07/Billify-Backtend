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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelBillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int travelBillId;
    int userId;
    Date date;
    String fromLocation;
    String toLocation;
    int amount;

    public TravelBillModel( int userId, Date date, String fromLocation, String toLocation, int amount) {
        this.amount = amount;
        this.toLocation = toLocation;
        this.fromLocation = fromLocation;
        this.date = date;
        this.userId = userId;
    }

}
