package com.checkoutmp.controllers;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;

@PropertySource("classpath:properties")
@Controller
public class checkoutmpController {

	
	@PostMapping(value="/checkout")
	public String checkout(ModelMap model) throws MPException {
		
		MercadoPago.SDK.setAccessToken("TEST-2318480319735397-071217-715101e600b5c3f0043c10bd714cb71d-298946804");
		
		//MercadoPago.SDK.setClientSecret("5349866562381140");
		//MercadoPago.SDK.setClientId("xT9onHQ1eznRjQTWXJMIO2UpjZyu36SP");
		
		Preference preference = new Preference();

		Item item = new Item(); 
		item.setTitle("Smartphone")
		    .setQuantity(1)
		    .setUnitPrice((float) 200);
		preference.appendItem(item);
		
		Payer payer = new Payer();
		payer.setEmail("emailteste@email.com");
		preference.setPayer(payer);
		preference.save();
				
		String preference_id = String.valueOf(preference.getId());
		
		System.out.println("preference_id: "+preference_id);
		
		model.addAttribute("preference_id", preference_id);
		
		return ("checkout.jsp");
	}
}
