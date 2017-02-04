package com.geek.fatma.e_shamba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by fatma on 2/3/17.
 */
public class MoistureFragment extends android.support.v4.app.Fragment {

    private WebView wv;
    private String url;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.moisturefragment, container, false);
        wv = (WebView) v.findViewById(R.id.webView3);
        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);


        url = "<iframe width=\"350\" height=\"260\" style=\"border: 1px solid #cccccc;\" src=\"https://thingspeak.com/channels/218057/charts/3?width=330&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15\"></iframe>";
        wv.loadData(url, "text/html", null);

        return v;

    }

}