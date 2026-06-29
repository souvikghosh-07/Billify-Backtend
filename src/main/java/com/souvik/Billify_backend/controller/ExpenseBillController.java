package com.souvik.Billify_backend.controller;

import com.souvik.Billify_backend.model.ExpenseBillModel;
import com.souvik.Billify_backend.service.ExpenseBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")

public class ExpenseBillController {

    @Autowired
    ExpenseBillService service;

    @PostMapping("/expensebill")
    public ExpenseBillModel addExpenseBill(@RequestParam int userId, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                           @RequestParam String reason, @RequestParam int amount){
        return service.addExpenseBill(userId, date, reason, amount);
    }


    @PostMapping("/showexpensebill")
    public List<ExpenseBillModel> showExpenseBill (@RequestParam int userId){
        return service.showExpenseBill(userId);
    }

    @PostMapping("/downloadexpensebill")
    public List<ExpenseBillModel> downloadExpenseBill (@RequestParam int userId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
                                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo){
        return service.dwonloadExpenseBill(userId,dateFrom,dateTo);
    }



    @DeleteMapping("/deleteexpensebill")
    public boolean deleteExpenseBill (@RequestParam int expenseBillId) {
        return service.deleteExpenseBill(expenseBillId );
    }



    @PutMapping("/updateexpensebill")
    public boolean updateExpenseBill (@RequestParam int expenseBillId,@RequestParam int userId, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                      @RequestParam String reason, @RequestParam int amount) {
        return service.updateExpenseBill(expenseBillId,userId,date,reason,amount);
    }


    @PostMapping("/totalexpensebillcount")
    public int totalExpenseBillCount(@RequestParam int userId) {
        return service.totalExpenseBillCount(userId);
    }


    @PostMapping("/totalexpensebillamount")
    public int totalExpenseBillAmount(@RequestParam int userId) {
        return service.totalExpenseBillAmount(userId);
    }
}


