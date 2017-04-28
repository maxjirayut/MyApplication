package com.example.ghkgkf.myapplication;

/**
 * Created by ghkgkf on 28/4/2560.
 */

public class MyConstant {

    private String urlGetProductWhereQR = "http://swiftcodingthai.com/cph/getProductWhereQRjirayut.php";

    public String[] getColumnProduct() {
        return columnProduct;
    }

    private String urlGetUserWhereID = "http://swiftcodingthai.com/cph/getUserWhereID.php";

    public String getUrlGetUserWhereID() {
        return urlGetUserWhereID;
    }

    private  String[] columnProduct = new  String[]{"id", "Name", "QR_code", "id_Receive", "Description", "Date_Receive"};

    public String getUrlGetProductWhereQR() {
        return urlGetProductWhereQR;
    }


}//main class
