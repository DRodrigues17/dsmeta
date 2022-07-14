package com.devsuperior.dsmeta.controller;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SalesService;
import com.devsuperior.dsmeta.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/sales")
public class SalesController {

    @Autowired
    private SalesService service;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page<Sale> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                Pageable pageable){
        return service.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/Notifications")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
