package com.souvik.Billify_backend.service;

import com.souvik.Billify_backend.model.ExpenseBillModel;
import com.souvik.Billify_backend.model.TravelBillModel;
import com.souvik.Billify_backend.repo.TravelBillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service


public class TravelBillService {
    @Autowired
    TravelBillRepo repo;
    public TravelBillModel addTravelBill(int userId, Date date, String fromLocation, String toLocation, int amount){
        try {
            TravelBillModel ob = new TravelBillModel(userId, date, fromLocation, toLocation, amount);
            return  repo.save(ob);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<TravelBillModel> showTravelBill (int userId){
        try{
            return repo.findByUserId(userId);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TravelBillModel> dwonloadTravelBill(int userId, Date dateFrom,Date dateTo) {

            try {

                return repo.findByUserIdAndDateBetween(userId, dateFrom, dateTo);

            } catch (Exception e) {

                e.printStackTrace();
                return null;

            }
    }


    public boolean deleteTravelBill(int travelBillId) {


        try {

            repo.deleteByTravelBillId(travelBillId);
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }



    public boolean updateTravelBill(int travelBillId, int userId, Date date, String fromLocation, String toLocation, int amount) {


        try {

            TravelBillModel ob = new TravelBillModel(travelBillId,userId,date,fromLocation,toLocation,amount);
            repo.save(ob);
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    public int totalTravelBillCount(int userId) {
        try {
            List<TravelBillModel> ob = repo.findByUserId(userId);
            return ob.size();
        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        }
    }

    public int totalTravelBillAmount(int userId) {
        try {
            List<TravelBillModel> ob = repo.findByUserId(userId);
            int amount=0;
            for(TravelBillModel i : ob){
                amount= amount + i.getAmount();
            }
            return amount;
        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        }

    }

}
