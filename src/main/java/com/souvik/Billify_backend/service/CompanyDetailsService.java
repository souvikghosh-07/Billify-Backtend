package com.souvik.Billify_backend.service;

import com.souvik.Billify_backend.model.CompanyDetailsModel;
import com.souvik.Billify_backend.repo.CompanyDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CompanyDetailsService {
    @Autowired
    CompanyDetailsRepo repo;
    public CompanyDetailsModel addCompanyDetails (String companyId,String companyName,String address,String phNo) {
        try {
            CompanyDetailsModel ob = new CompanyDetailsModel(companyId, companyName, address, phNo);
            return repo.save(ob);
        }
        catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public CompanyDetailsModel updateCompanyDetails (int companyDetailsId,String companyId,String companyName,String address,String phNo) {
        try{
            CompanyDetailsModel ob = new CompanyDetailsModel(companyDetailsId,companyId, companyName, address, phNo);
            return repo.save(ob);
        }
        catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
