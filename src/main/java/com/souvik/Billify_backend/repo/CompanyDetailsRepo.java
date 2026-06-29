package com.souvik.Billify_backend.repo;

import com.souvik.Billify_backend.model.CompanyDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetailsModel,Integer> {

}
