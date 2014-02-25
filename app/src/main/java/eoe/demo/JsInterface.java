package eoe.demo;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by djzhang on 2/25/14.
 */ //javascript interface
public class JsInterface {
    private final Context context;

    public JsInterface(Context context) {
        this.context = context;
    }

    //function that will be called from assets/test.js
    //js example: android.log('my message');
    @JavascriptInterface
    public void log(String msg) {
        Log.d("MSG FROM JAVASCRIPT", msg);
        ShortcutUtils.addShortcut(context, msg, "baidu-shortcut");
        Toast.makeText(context, "添加成功！", Toast.LENGTH_SHORT).show();

    }
}
