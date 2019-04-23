package com.lixm.notes.webview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lixm.notes.R
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
//        webview.loadUrl("https://www.baidu.com")

//        val unencodedHtml =
//            "&lt;html&gt;&lt;body&gt;'%23' is the percent code for ‘#‘ &lt;/body&gt;&lt;/html&gt;"
//        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
//        webview.loadData(encodedHtml, "text/html", "base64")

        webview.loadUrl("file:////android_asset/webview.html")
        webview.settings.javaScriptEnabled = true
        webview.addJavascriptInterface(WebAppInterface(this),"Android")
        webview.webViewClient = MyWebViewClient()
    }

    class WebAppInterface(private val mContext: Context) {
        @JavascriptInterface
        fun showToast(toastString: String) {
            Toast.makeText(mContext,toastString,Toast.LENGTH_LONG).show()
        }
    }
    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (Uri.parse(url).host != "https://www.baidu.com") {
                // This is my website, so do not override; let my WebView load the page
                return false
            }
            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
            return true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()){
            webview.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}