package com.spencerandbrown.midwifeclienttracker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SESA60180 on 8/24/2016.
 */
public class ClientList {
    public static final List<Client> clients = new ArrayList<Client>();
    public static final Map<Integer, Client> ITEM_MAP = new HashMap<Integer, Client>();

    private int clientCount = 1;

    static {
        Client c = new Client("test name1");
        c.id=1;
        c.dueDate=new Date(2016, 9,12);
        clients.add(c);
        ITEM_MAP.put(c.id, c);
    }
}
