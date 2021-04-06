package com.helplib.heghelpli

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.webkit.*
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.PublicKey
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher
class Magilos: AppCompatActivity() {

    private lateinit var amigo: AlertDialog
    private val polibos: Deque<String> = LinkedList()
    private val FILECHOOSER_RESULTCODE = 1
    private lateinit var lumenos: WebView
    private var appBundle: String? = null
    private var uri: Uri? = null
    var corcodar: String? = null
    var reg: String? = null
    var dep: String? = null
    private lateinit var progr: ProgressBar
    private lateinit var white: ImageView
    private lateinit var preferences: SharedPreferences
    private var camPhoto: String? = null
    var kekoli: String? = null
    var ioioioieee: String? = null
    var name: CharSequence? = null
    private lateinit var okHttpMain: OkHttpClient
    private var valueCallback: ValueCallback<Array<Uri>>? = null
    private var uriValueCallback: ValueCallback<Uri>? = null
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //// Layout description
        val layout = ConstraintLayout(this)
        val constraintSet = ConstraintSet()
        val layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT)

        lumenos = WebView(this).apply {
            id = View.generateViewId()
            setLayoutParams(ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT))
        }
        layout.addView(lumenos, 0)
        constraintSet.clone(layout)
        constraintSet.connect(lumenos.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP)
        constraintSet.connect(lumenos.id, ConstraintSet.LEFT, layout.id, ConstraintSet.LEFT)
        constraintSet.connect(lumenos.id, ConstraintSet.RIGHT, layout.id, ConstraintSet.RIGHT)
        constraintSet.connect(lumenos.id, ConstraintSet.BOTTOM, layout.id, ConstraintSet.BOTTOM)

        white = ImageView(this).apply {
            id = View.generateViewId()
            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.load))
            scaleType = ImageView.ScaleType.CENTER_CROP
            setLayoutParams(ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT))
        }
        layout.addView(white, 1)
        constraintSet.connect(white.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP)
        constraintSet.connect(white.id, ConstraintSet.LEFT, layout.id, ConstraintSet.LEFT)
        constraintSet.connect(white.id, ConstraintSet.RIGHT, layout.id, ConstraintSet.RIGHT)
        constraintSet.connect(white.id, ConstraintSet.BOTTOM, layout.id, ConstraintSet.BOTTOM)

        progr = ProgressBar(this).apply {
            id = View.generateViewId()
            setLayoutParams(ConstraintLayout.LayoutParams(
                100, 100
            ))
            visibility = View.INVISIBLE
        }
        layout.addView(progr, 2)
        constraintSet.connect(progr.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP)
        constraintSet.connect(progr.id, ConstraintSet.LEFT, layout.id, ConstraintSet.LEFT)
        constraintSet.connect(progr.id, ConstraintSet.RIGHT, layout.id, ConstraintSet.RIGHT)
        constraintSet.connect(progr.id, ConstraintSet.BOTTOM, layout.id, ConstraintSet.BOTTOM)
        constraintSet.applyTo(layout)
        setContentView(layout, layoutParams)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        appBundle = applicationContext.packageName
        preferences = this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        kekoli = intent.extras?.getString("url") + "&subid=${getsubid()}"
        nimobo()

        amigo = AlertDialog.Builder(this).apply {
            setTitle("No Internet Connection")
            setMessage("Turn on the the network")
            setCancelable(false)
            setFinishOnTouchOutside(false)
        }.create()

        white.isVisible = true
        progr.isVisible = true

        GlobalScope.launch(Dispatchers.Main) {govava()}

    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun govava() {


        Log.d("NE OZIDAL", "SIKA")
        handler.post(conversionTask)
        OneSignal.sendTag("holla", "2")
        OneSignal.sendTag("bundle", appBundle)
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(lumenos, true)
        }
        uytty()
        val webSettings =  lumenos.settings
        webSettings.javaScriptEnabled = true
        lumenos.settings.loadsImagesAutomatically = true
        lumenos.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        lumenos.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        lumenos.settings.allowContentAccess = true
        lumenos.settings.javaScriptCanOpenWindowsAutomatically = true;
        lumenos.settings.setAppCacheEnabled(true)
        lumenos.requestFocus(View.FOCUS_DOWN or View.FOCUS_UP)
        lumenos.settings.setPluginState(WebSettings.PluginState.ON)
        lumenos.settings.setSupportMultipleWindows(false)
        lumenos.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        lumenos.settings.domStorageEnabled = true
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS //no
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.savePassword = true
        webSettings.saveFormData = true
        webSettings.setEnableSmoothTransition(true)


        lumenos.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Uri.parse(url).getQueryParameter("caracaca_uio")
                    ?.let {

                        preferences.edit().putString("PREFS_QUERYID", it).apply()
                    }
                return false
            }

            override fun onPageFinished(view: WebView, url: String) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    CookieManager.getInstance().flush()

                }

                super.onPageFinished(view, url)

                val queryId = preferences.getString("PREFS_QUERYID", "")

            }

        }

        lumenos.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                valueCallback?.onReceiveValue(null)
                valueCallback = filePathCallback
                var takePintent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (takePintent!!.resolveActivity(packageManager) != null) {
                    var file: File? = null
                    try {
                        file = createImageFile()
                        takePintent.putExtra("PhotoPath", camPhoto)
                    } catch (ex: IOException) {
                    }
                    if (file != null) {
                        camPhoto = "file:" + file.absolutePath
                        takePintent!!.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(file)
                        )
                    } else {
                        takePintent = null
                    }
                }
                val contentselIntent = Intent(Intent.ACTION_GET_CONTENT)
                contentselIntent.addCategory(Intent.CATEGORY_OPENABLE)
                contentselIntent.type = "image/*"
                val intentArray: Array<Intent?>
                intentArray = takePintent.let { arrayOf(it) } ?: arrayOfNulls<Intent>(0)
                val chooserIntent = Intent(Intent.ACTION_CHOOSER)
                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentselIntent)
                chooserIntent.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser))
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
                startActivityForResult(
                    chooserIntent,
                    FILECHOOSER_RESULTCODE
                )
                return true
            }

            @Throws(IOException::class)
            private fun createImageFile(): File? {
                var directoryNameHere = File(
                    Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES
                    ), "DirectoryNameHere"
                )
                if (!directoryNameHere.exists()) {
                    directoryNameHere.mkdirs()
                }
                directoryNameHere = File(
                    directoryNameHere.toString() + File.separator + "IMG_" + System.currentTimeMillis()
                        .toString() + ".jpg"
                )
                return directoryNameHere
            }


            fun openFileChooser(uploadMsg: ValueCallback<Uri>, acceptType: String? = "") {
                uriValueCallback = uploadMsg
                try {
                    val nameHere = File(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                        "DirectoryNameHere"
                    )
                    if (!nameHere.exists()) {
                        nameHere.mkdirs()
                    }
                    val file = File(
                        nameHere.toString() + File.separator + "IMG_" + System.currentTimeMillis()
                            .toString() + ".jpg"
                    )
                    uri = Uri.fromFile(file)
                    val captureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
                    val i = Intent(Intent.ACTION_GET_CONTENT)
                    i.addCategory(Intent.CATEGORY_OPENABLE)
                    i.type = "image/*"
                    val chooserIntent = Intent.createChooser(i, getString(R.string.image_chooser))
                    chooserIntent.putExtra(
                        Intent.EXTRA_INITIAL_INTENTS,
                        arrayOf<Parcelable>(captureIntent)
                    )
                    startActivityForResult(
                        chooserIntent,
                        FILECHOOSER_RESULTCODE
                    )
                } catch (e: java.lang.Exception) {
                    Toast.makeText(baseContext, "Camera Exception:$e", Toast.LENGTH_LONG).show()
                }
            }

            fun openFileChooser(
                uploadMsg: ValueCallback<Uri>,
                acceptType: String?,
                capture: String?
            ) {
                openFileChooser(uploadMsg, acceptType)
            }
        }
        white.isVisible = false
        progr.isVisible = false



        kekoli?.let { lumenos.loadUrl(it) }




    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode == FILECHOOSER_RESULTCODE) {
                if (null == uriValueCallback) {
                    return
                }
                var result: Uri? = null
                try {
                    result = if (resultCode != RESULT_OK) {
                        null
                    } else {
                        // retrieve from the private variable if the intent is null
                        if (data == null) uri else data.data
                    }
                } catch (e: java.lang.Exception) {
                    Toast.makeText(applicationContext, "activity :$e", Toast.LENGTH_LONG).show()
                }
                uriValueCallback!!.onReceiveValue(result)
                uriValueCallback = null
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode != FILECHOOSER_RESULTCODE || valueCallback == null) {
                super.onActivityResult(requestCode, resultCode, data)
                return
            }
            var results: Array<Uri>? = null


            if (resultCode == RESULT_OK) {
                if (data == null || data.data == null) {
                    // if there is not data, then we may have taken a photo
                    if (camPhoto != null) {
                        results = arrayOf(Uri.parse(camPhoto))
                    }
                } else {
                    val dataString = data.dataString
                    if (dataString != null) {
                        results = arrayOf(Uri.parse(dataString))
                    }
                }
            }
            valueCallback!!.onReceiveValue(results)
            valueCallback = null
        }
    }
    private fun nimobo() {

        okHttpMain = OkHttpClient.Builder()
            .followSslRedirects(false)
            .followRedirects(false)
            .addNetworkInterceptor {
                it.proceed(
                    it.request().newBuilder()
                        .header("User-Agent", WebSettings.getDefaultUserAgent(this))
                        .build()
                )

            }.build()
    }
    private val conversionTask = object : Runnable {

        override fun run() {
            GlobalScope.launch {
                Log.d("cona1", "hol1")
                val json = getConversion()
                Log.d("condadwd", "awdawd" + json)
                try {
                    ioioioieee = json[0].toString()

                } catch (ex: Exception) {
                    Log.d("cona1ex", "hol1ex")
                }
                val deposit = "af_add_to_cart"
                val registr = "af_complited_registration"

                var checkdep = preferences.getString("COMPLETE_DEPOSIT", null)
                if (checkdep == null) {
                    try {
                        dep = (JSONObject(ioioioieee!!).get("sell")).toString()
                        if (dep == "null") {

                        } else {
                            sendAppsflyerEvent(deposit, "")
                            preferences.edit().putString("COMPLETE_DEPOSIT", dep)
                                .apply()
                        }
                    } catch (ex: Exception) {

                    }
                } else {

                }


                var checkreg = preferences.getString("COMPLETE_REGISTR", null)
                if (checkreg == null) {

                    try {
                        reg = (JSONObject(ioioioieee!!).get("reg")).toString()
                        if (reg == "null") {
                            Log.d("cona1null", "hol1null")
                        } else {
                            Log.d("sendaf", "sendaf")
                            sendAppsflyerEvent(registr, "")
                            preferences.edit().putString("COMPLETE_REGISTR", reg)
                                .apply()
                        }
                    } catch (ex: Exception) {
                        Log.d("cona2ex", "hol2ex")
                    }
                } else {

                }
            }

            handler.postDelayed(this, 15000)
        }
    }
    fun getConversion(): JSONArray {
        corcodar = "http://80.78.245.206/index.php/info?clickid="

        val conversionUrl = corcodar+ getsubid()

        return try {
            val response = okHttpMain
                .newCall(Request.Builder().url(corcodar + getsubid()).build())
                .execute()
            JSONArray(response.body?.string() ?: "[]")
        } catch (ex: Exception) {
            Log.d("conados", "bados" )
            JSONArray("[]")
        }
    }

    private fun sendAppsflyerEvent(key: String, value: String) {
        Log.d("cona2try", "hol2try")
        val values = HashMap<String, Any>()
        values[key] = value
        AppsFlyerLib.getInstance().trackEvent(this, key, values)
    }






    private fun getsubid(): String {

        var subid = preferences.getString("PREFS_CLICK_ID", null)
        if (subid == null) {
            subid = UUID.randomUUID().toString()
            preferences.edit().putString("PREFS_CLICK_ID", subid)
                .apply()
        }
        return subid
    }



    private fun uytty() {
        try {
            val cMan =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val builder = NetworkRequest.Builder()
            cMan.registerNetworkCallback(builder.build(), object :
                ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    amigo.hide()
                }
                override fun onLost(network: Network) {
                    super.onLost(network)
                    amigo.show()
                }
            })
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }

    override fun onBackPressed() {
        if (lumenos.canGoBack())
            lumenos.goBack()
        else
            super.onBackPressed()
    }

    override fun onStop() {
        super.onStop()
    }

}