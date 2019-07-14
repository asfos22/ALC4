/**
 * Author: Asante Foster
 * Email: asantefoster22@gmail.com
 * Phone:+2332459644406
 */

package com.andela.challenge.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {

    private WebView webView;
    private Button refreshButton;

    private class AndelaWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_b_webview);
        webView = findViewById(R.id.andelaWebView);
        refreshButton = findViewById(R.id.refreshButton);

        /** load web view*/
        loadWebView();

        /**On ClickListener event **/
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** reload load web view*/
                loadWebView();
            }
        });


    }


    /**
     * load content web view
     **/

    public void loadWebView() {
        if (DeviceInternetConnection.checkDeviceConnection(getApplicationContext())) {
            // Its Available...

            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            webView.setWebViewClient(new AndelaWebViewClient());
            webView.loadUrl("https://andela.com/alc/");

            // -- hide refresh button
            refreshButton.setVisibility(View.GONE);

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (!url.equals("about:blank")) {
                        view.loadUrl(url);
                    }
                    return false;
                }

                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed();
                }
            });
        } else {
            // Not Available...
            Toast.makeText(getApplicationContext(), R.string.no_internet_available, Toast.LENGTH_SHORT).show();

            // -- show refresh button
            refreshButton.setVisibility(View.VISIBLE);
        }
    }

    /**
     * internet connectivity
     ***/

    public static class DeviceInternetConnection {

        /**
         * internet connectivity is available or not
         */
        public static boolean checkDeviceConnection(Context context) {
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null) { // connected to the internet

                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    return true;
                } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    // connected to the mobile provider's data plan
                    return true;
                }
            }
            return false;
        }
    }
}
