package com.checkoutmp.models;

public class FormData {
	
	public String paymentMethodId;
	public int amount;
    public int installmentsOption;
    public String token;
    
    public String getPaymentMethodId() {
        return paymentMethodId;
    }
    
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getInstallmentsOption() {
        return installmentsOption;
    }
    
    public void setInstallmentsOption(int installmentsOption) {
        this.installmentsOption = installmentsOption;
    }	
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token+"data [paymentMethodId="+paymentMethodId+",amount="+amount+",installmentsOption="+installmentsOption+",token="+token+"]";
    }
}
