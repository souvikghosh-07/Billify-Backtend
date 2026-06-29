package com.souvik.Billify_backend.repo;

import com.souvik.Billify_backend.model.ExpenseBillModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ExpenseBillRepo extends JpaRepository<ExpenseBillModel,Integer> {
    List<ExpenseBillModel> findByUserId(int userId);
    List<ExpenseBillModel> findByUserIdAndDateBetween(
            int userId,
            Date dateFrom,
            Date dateTo
    );

    @Transactional
    void deleteByExpenseBillId(int expenseBillId);
}

