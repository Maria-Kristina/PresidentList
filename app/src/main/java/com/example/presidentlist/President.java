package com.example.presidentlist;

import java.util.Comparator;

/**
 * Created by User1 on 23.8.2017.
 */

public class President {
    String firstName;
    String lastName;
    int aloitusVuosi;
    int lopetusVuosi;
    String detail;

    public President (String firstName, String lastName, int aloitusVuosi, int lopetusVuosi, String detail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.aloitusVuosi = aloitusVuosi;
        this.lopetusVuosi = lopetusVuosi;
        this.detail = detail;
    }

}
