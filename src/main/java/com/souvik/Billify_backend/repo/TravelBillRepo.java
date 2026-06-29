package com.souvik.Billify_backend.repo;

import com.souvik.Billify_backend.model.ExpenseBillModel;
import com.souvik.Billify_backend.model.TravelBillModel;
import jakarta.transaction.Transactional;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TravelBillRepo extends JpaRepository<TravelBillModel,Integer> {

    List<TravelBillModel> findByUserId(int userId);

    List<TravelBillModel> findByUserIdAndDateBetween(int userId, Date dateFrom, Date dateTo);

    @Transactional
    void deleteByTravelBillId(int travelBillId);
}
