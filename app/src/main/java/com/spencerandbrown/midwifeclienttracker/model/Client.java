package com.spencerandbrown.midwifeclienttracker.model;

import java.util.Date;

g/**
 * Created by mbb on 8/24/2016.
 */
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
        return dueDate.toString();
    }

    public String LMPDateText () {
        return LMPDate.toString();
    }

    public String deliveryDateText () {
        return deliveryDate.toString();
    }

    public String conceptionDateText () {
        return conceptionDate.toString();
    }
}
