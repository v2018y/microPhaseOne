package org.vany.invoice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PaymentInvoice {

	@GetMapping(value="/invoice")
    public String getHello() {
        return "Welcome to Invoice Project";
    }
}
