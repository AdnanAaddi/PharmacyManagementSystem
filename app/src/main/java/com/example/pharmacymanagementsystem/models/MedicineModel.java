package com.example.pharmacymanagementsystem.models;

public class MedicineModel {
    private String med;
    private String pr;
    private String qty;
    private String amount;
    private String batch;
    private String expdate;
    private String key;
    private String orgqty;

    public MedicineModel(String med, String pr, String qty, String amount, String batch, String expdate, String key, String orgqty) {
        this.med = med;
        this.pr = pr;
        this.qty = qty;
        this.amount = amount;
        this.batch = batch;
        this.expdate = expdate;
        this.key = key;
        this.orgqty = orgqty;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOrgqty() {
        return orgqty;
    }

    public void setOrgqty(String orgqty) {
        this.orgqty = orgqty;
    }
}
