package br.com.githubclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView) findViewById(R.id.webViewRespositorio);

        String linkAcesso = getIntent().getStringExtra("linkRepositorio");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(linkAcesso);
    }
}
