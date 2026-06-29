package com.souvik.Billify_backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class CompanyDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int companyDetailsId;
    String companyId;
    String companyName;
    String address;
    String phNo;


    public CompanyDetailsModel(String companyId, String companyName, String address, String phNo) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.address = address;
        this.phNo = phNo;
    }

}
