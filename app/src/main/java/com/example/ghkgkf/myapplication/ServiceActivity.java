package com.example.ghkgkf.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import static com.example.ghkgkf.myapplication.R.id.edtName;
import static com.example.ghkgkf.myapplication.R.id.info;

public class ServiceActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private ListView listView;
    private String[] loginStrings, nameStrings, dateStrings, detaStrings, qrCodeStrings ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        initialView();

        //Get Value From intent
        getValueFromIntent();

        createListView();

    }// Main Method

    private void createListView() {
        String tag = "27AtrilV2";
        String urlPHP = "http://swiftcodingthai.com/cph/getProduct.php";

        try {

            GetData getData = new GetData(ServiceActivity.this);
            getData.equals(urlPHP);
            String strJSON = getData.get();
            Log.d(tag, "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            nameStrings = new String[jsonArray.length()];
            dateStrings = new String[jsonArray.length()];
            detaStrings = new String[jsonArray.length()];
            qrCodeStrings = new String[jsonArray.length()];

            for (int i=0; i<jsonArray.length();i++) {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);
                nameStrings[i] = jsonObject.getString("name");
                dateStrings[i] = jsonObject.getString("date_Receive");
                detaStrings[i] = jsonObject.getString("Description");
                qrCodeStrings[i] = jsonObject.getString("QR_code");

            }



        } catch (Exception e) {
            Log.d(tag, "e createListView ==> " + e.toString());
        }

    }

    private void getValueFromIntent() {
        loginStrings = getIntent().getStringArrayExtra("Login");//ส่งค่ามาจากหน้าlogin
        textView.setText(loginStrings[1]);
    }

    private void initialView() {
        textView = (TextView) findViewById(R.id.txtName);
        imageView = (ImageView) findViewById(R.id.imvQR);
        listView = (ListView) findViewById(R.id.livProduct);

    }
}// Main class
