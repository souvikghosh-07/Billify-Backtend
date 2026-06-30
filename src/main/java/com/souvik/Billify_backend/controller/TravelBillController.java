package com.souvik.Billify_backend.controller;

import com.souvik.Billify_backend.model.ExpenseBillModel;
import com.souvik.Billify_backend.model.TravelBillModel;
import com.souvik.Billify_backend.service.TravelBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://billify-frontend.vercel.app","https://billify-frontend-b7wuqn4z8-souvik07.vercel.app"})
public class TravelBillController {

    @Autowired
    TravelBillService service;

    @PostMapping("/addtravelbill")
    public TravelBillModel addTravelBill(@RequestParam int userId, @RequestParam
                                             @DateTimeFormat(pattern = "yyyy-MM-dd")
                                             Date date,@RequestParam String fromLocation,
                                         @RequestParam String toLocation,@RequestParam int amount){
        System.out.println(userId +" "+ date+" "+fromLocation+" "+ toLocation+" "+amount);
        return service.addTravelBill(userId, date, fromLocation, toLocation, amount);
    }


    @PostMapping("/showtravelbill")
    public List<TravelBillModel> showTravelBill (@RequestParam int userId){
        return service.showTravelBill(userId);
    }


    @PostMapping("/downloadtravelbill")
    public List<TravelBillModel> downloadTravelBill (@RequestParam int userId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo){
        return service.dwonloadTravelBill(userId,dateFrom,dateTo);
    }


    @DeleteMapping("/deletetravelbill")
    public boolean deleteTravelBill(@RequestParam int travelBillId) {
        return service.deleteTravelBill(travelBillId);
    }


    @PutMapping("/updatetravelbill")
    public boolean updateTravelBill (@RequestParam int travelBillId,@RequestParam int userId, @RequestParam
                                         @DateTimeFormat(pattern = "yyyy-MM-dd")
                                         Date date,@RequestParam String fromLocation,
                                     @RequestParam String toLocation,@RequestParam int amount) {
        return service.updateTravelBill(travelBillId,userId,date,fromLocation,toLocation,amount);
    }


    @PostMapping("/totaltavelbillcount")
    public int totalTravelBillCount(@RequestParam int userId) {
        return service.totalTravelBillCount(userId);
    }

    @PostMapping("/totaltavelbillamount")
    public int totalTravelBillAmount(@RequestParam int userId) {
        return service.totalTravelBillAmount(userId);
    }

}
