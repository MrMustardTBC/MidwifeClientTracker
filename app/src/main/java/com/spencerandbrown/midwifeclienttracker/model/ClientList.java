package com.spencerandbrown.midwifeclienttracker.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mbb on 8/24/2016.
 */
public class ClientList {
    public static final ObservableArrayList<Client> clients = new ObservableArrayList<Client>();
    public static final ObservableArrayMap<Integer, Client> ITEM_MAP = new ObservableArrayMap<>();

    private int clientCount = 1;

    static public void AddClient(Client c){
        clients.add(c);
        ITEM_MAP.put(c.id,c);
    }
    static {
        Client c = new Client("test name1");
        c.id=1;
        c.dueDate=new Date(2016, 9,12);
        AddClient(c);

        c=new Client("New Name");
        c.id=2;
        c.dueDate = new Date(2016, 8, 30);
        AddClient(c);
    }
}
