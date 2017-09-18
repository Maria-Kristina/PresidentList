package com.example.presidentlist;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private TextView detailView;
    private String info;
    private List<President> presidentList; //luokan oma presidenttilista
    private ListView listView; //listanäkymä
    private CustomAdapter customAdapter; //adapteri, joka määrittelee listviewssä näkyvät asiat


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailView = (TextView)findViewById(R.id.detailView);

        presidentList = new ArrayList<>();
        makePresidents();

        listView = (ListView) findViewById(R.id.ListView);
        customAdapter = new CustomAdapter(this, presidentList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("onItemClicked", String.valueOf(position));
                President itemValue = (President) listView.getItemAtPosition(position);
                Log.d("onItemClicked", itemValue.firstName);
                info = itemValue.lastName + ", " + itemValue.firstName + " " + itemValue.aloitusVuosi + " " + itemValue.lopetusVuosi + "\n" + itemValue.detail;
                detailView.setText(info);
            }
        });

    }

    public void makePresidents (){
        presidentList.add(new President("K. J.","Ståhlberg",1919,1925,"Esihistoriaa"));
        presidentList.add(new President("Lauri Kristian","Relander",1925,1931,"Kuka tietää"));
        presidentList.add(new President("P. E.","Svinhufvud",1931,1937,"Varmasti jokaiselle tuttu"));
        presidentList.add(new President("Kyösti","Kallio",1937,1940,"Kova jätkä"));
        presidentList.add(new President("Risto","Ryti",1940,1944,"Vielä kovempi jätkä"));
        presidentList.add(new President("Gustaf","Mannerheim",1944,1946,"Patsas, junou"));
        presidentList.add(new President("J. K.","Paasikivi",1946,1956,"Kivinen tyyppi"));
        presidentList.add(new President("Urho","Kekkonen",1956,1982,"isoisosetä!"));
        presidentList.add(new President("Mauno","Koivisto",1982,1994,"Vai Männikkö, heh heh"));
        presidentList.add(new President("Martti","Ahtisaari",1994,2000,"Nobel voittaja"));
        presidentList.add(new President("Tarja","Halonen",2000,2012,"Setan entinen puheenjohtaja!"));
        presidentList.add(new President("Sauli","Niinistö",2012,2018,"Nykyinen"));

    }
}
