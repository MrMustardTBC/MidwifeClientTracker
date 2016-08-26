package com.spencerandbrown.midwifeclienttracker.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    public Integer id;
    public String name;
    public Date dueDate;
    public Date LMPDate;
    public Date deliveryDate;
    public String notes;
    public Date conceptionDate;

    public Client(String name) {
     this.name=name;
    }

    public String dueDateText () {
        return FormatDate(dueDate);
    }

    public String LMPDateText () {
        return FormatDate(LMPDate);
    }

    public String deliveryDateText () {
        return FormatDate(deliveryDate);
    }

    public String conceptionDateText () {
        return FormatDate(conceptionDate);
    }

    private String FormatDate(Date dateToFormat){
        DateFormat format= DateFormat.getDateInstance();
        if(dateToFormat!=null)
            return format.format(dateToFormat);
        else
            return "";
    }
}
