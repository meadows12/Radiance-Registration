package com.example.radianceregistration;

import java.util.Map;

public class ParticipantInfo {
    private String Participant1,Email,Collegename,Year;
    private int contactno;                  //originally int so convert it into string
    private Map<String,String> mapi;      //event name and his partner
    private int Amount;

    public ParticipantInfo(String participant1) {
        Participant1 = participant1;
    }

    public String getParticipant1() {
        return Participant1;
    }

    public void setParticipant1(String participant1) {
        Participant1 = participant1;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCollegename() {
        return Collegename;
    }

    public void setCollegename(String collegename) {
        Collegename = collegename;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public int getContactno() {
        return contactno;
    }

    public void setContactno(int contactno) {
        this.contactno = contactno;
    }

    public Map<String, String> getMapi() {
        return mapi;
    }

    public void setMapi(Map<String, String> mapi) {
        this.mapi = mapi;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
