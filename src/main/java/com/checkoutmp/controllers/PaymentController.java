package com.checkoutmp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import com.checkoutmp.models.FormData;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Payment.Status;
import com.mercadopago.resources.datastructures.payment.Payer;

@Controller
public class PaymentController {
	
	@PostMapping(value = "/pay")
	public String createpayment(FormData data, ModelMap model) throws MPException {
		
		MercadoPago.SDK.setAccessToken("TEST-2318480319735397-071217-715101e600b5c3f0043c10bd714cb71d-298946804");

        Payment payment = new Payment()
                .setTransactionAmount((float) data.amount)
                .setToken(data.token)
                .setDescription("description")
                .setInstallments(data.installmentsOption)
                .setPaymentMethodId(data.paymentMethodId)
                .setPayer(new Payer()
                        .setEmail("teste@email.com"));

        payment.save();      
              
        //System.out.println(payment);                
        float transaction_amount = payment.getTransactionAmount();
        int installments = payment.getInstallments();
        Status status = payment.getStatus();
        String status_detail = payment.getStatusDetail();
        String payment_id = payment.getId();
        String payment_method = payment.getPaymentMethodId();
        java.util.Date date_created = payment.getDateCreated();
        
        model.addAttribute("transaction_amount", transaction_amount);
        model.addAttribute("installments", installments);
        model.addAttribute("status", status);
        model.addAttribute("status_detail", status_detail);
        model.addAttribute("payment_id", payment_id);
        model.addAttribute("date_created", date_created);
        model.addAttribute("payment_method", payment_method);
                        
		return ("status.jsp");
	}
}





