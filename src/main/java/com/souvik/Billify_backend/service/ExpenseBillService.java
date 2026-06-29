package com.souvik.Billify_backend.service;

import com.souvik.Billify_backend.model.ExpenseBillModel;
import com.souvik.Billify_backend.model.TravelBillModel;
import com.souvik.Billify_backend.repo.ExpenseBillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class ExpenseBillService {
    @Autowired
    ExpenseBillRepo repo;
    public ExpenseBillModel addExpenseBill (int userId, Date date, String reason, int amount){
        try{
            ExpenseBillModel ob = new ExpenseBillModel(userId, date, reason, amount);
            return repo.save(ob);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public List<ExpenseBillModel> showExpenseBill (int userId){
        try{
          return repo.findByUserId(userId);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ExpenseBillModel> dwonloadExpenseBill(int userId, Date dateFrom, Date dateTo) {

        try {

            return repo.findByUserIdAndDateBetween(userId, dateFrom, dateTo);

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }

    public boolean deleteExpenseBill(int expenseBillId) {
        try {

            repo.deleteByExpenseBillId(expenseBillId);
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    public boolean updateExpenseBill(int expenseBillId, int userId, Date date, String reason, int amount) {
        try {

            ExpenseBillModel ob= new ExpenseBillModel(expenseBillId, userId, date, reason, amount);
            repo.save(ob);
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    public int totalExpenseBillCount(int userId) {try {
        List<ExpenseBillModel> ob = repo.findByUserId(userId);
        return ob.size();
    } catch (Exception e) {

        e.printStackTrace();
        return 0;

    }


    }



    public int totalExpenseBillAmount(int userId) {

        try {
            List<ExpenseBillModel> ob = repo.findByUserId(userId);
            int amount=0;
            for(ExpenseBillModel i : ob){
                amount= amount + i.getAmount();
            }
            return amount;
        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        }

    }
}
