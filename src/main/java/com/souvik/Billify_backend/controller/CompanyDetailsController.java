package com.souvik.Billify_backend.controller;

import com.souvik.Billify_backend.model.CompanyDetailsModel;
import com.souvik.Billify_backend.service.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins =  {"http://localhost:5173", "https://billify-frontend.vercel.app"})

public class CompanyDetailsController {
    @Autowired
    CompanyDetailsService service;

    @PostMapping("/addcompanydetails")
    public CompanyDetailsModel addCompanyDetails (@RequestParam String companyId,@RequestParam String companyName,
                                                  @RequestParam String address,@RequestParam String phNo) {
        return service.addCompanyDetails(companyId, companyName, address, phNo);
    }


    @PutMapping("/updatecompanydetails")
    public CompanyDetailsModel updateCompanyDetails (@RequestParam int CompanyDetailsId,@RequestParam String companyId,@RequestParam String companyName,
                                                  @RequestParam String address,@RequestParam String phNo) {
        return service.updateCompanyDetails(CompanyDetailsId,companyId, companyName, address, phNo);
    }
}
