package com.example.pharmacymanagementsystem.models;

public class Modelinventory {
    private String einame;
    private String ebatchNo;
    private String eqty;
    private String eexpdate;
    private String emrp;
    private String esp;
    private String ecName;
    private String ecode;
    private String ecp;
    private String edesc;
    private String itemId;
    private String eunit;
    public Modelinventory() {

    }


    public Modelinventory(String einame, String ebatchNo, String eqty, String eexpdate,
                          String emrp, String esp, String ecName, String ecode, String ecp,
                          String edesc, String itemId, String eunit) {
        this.einame = einame;
        this.ebatchNo = ebatchNo;
        this.eqty = eqty;
        this.eexpdate = eexpdate;
        this.emrp = emrp;
        this.esp = esp;
        this.ecName = ecName;
        this.ecode = ecode;
        this.ecp = ecp;
        this.edesc = edesc;
        this.itemId = itemId;
        this.eunit = eunit;
    }

    public String getEiname() {
        return einame;
    }

    public void setEiname(String einame) {
        this.einame = einame;
    }

    public String getEbatchNo() {
        return ebatchNo;
    }

    public void setEbatchNo(String ebatchNo) {
        this.ebatchNo = ebatchNo;
    }

    public String getEqty() {
        return eqty;
    }

    public void setEqty(String eqty) {
        this.eqty = eqty;
    }

    public String getEexpdate() {
        return eexpdate;
    }

    public void setEexpdate(String eexpdate) {
        this.eexpdate = eexpdate;
    }

    public String getEmrp() {
        return emrp;
    }

    public void setEmrp(String emrp) {
        this.emrp = emrp;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public String getEcName() {
        return ecName;
    }

    public void setEcName(String ecName) {
        this.ecName = ecName;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getEcp() {
        return ecp;
    }

    public void setEcp(String ecp) {
        this.ecp = ecp;
    }

    public String getEdesc() {
        return edesc;
    }

    public void setEdesc(String edesc) {
        this.edesc = edesc;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getEunit() {
        return eunit;
    }

    public void setEunit(String eunit) {
        this.eunit = eunit;
    }
}
