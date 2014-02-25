package eoe.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * 通过应用程序创建快捷方式
 *
 * @author jiqinlin
 */

public class ShortCutActionActivity extends Activity {
    private WebView wv;
    private Context context;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.context = this;

        //create interface
        JsInterface jsInterface = new JsInterface(this.context);

        //get webview and enable js
        wv = (WebView) findViewById(R.id.web_view);
        wv.getSettings().setJavaScriptEnabled(true);

        //add interface
        wv.addJavascriptInterface(jsInterface, "android");//android is the keyword that will be exposed in js

        //load file
        wv.loadUrl("file:///android_asset/shortcut.html");
    }
}