package com.lixm.notesimport android.app.Activityimport android.content.Intentimport android.os.Bundleimport android.util.Logimport android.view.Viewimport androidx.appcompat.app.AppCompatActivityimport com.lixm.notes.adaptation.density.DensityActivityimport com.lixm.notes.adaptation.px.PxTestActivityimport com.lixm.notes.eventconflict.EventConflictActivityimport com.lixm.notes.factory.FactoryTestActivityimport com.lixm.notes.mvvm.LoginActivityimport com.lixm.notes.redbook.RedBookActivityimport com.lixm.notes.refresh.SecondFloorPracticeActivityimport kotlinx.android.synthetic.main.activity_main.*class MainActivity : AppCompatActivity() ,View.OnClickListener{    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContentView(R.layout.activity_main)        btn_tao_bao.setOnClickListener(this)        btn_little_red_book.setOnClickListener(this)        btn_mvvm.setOnClickListener(this)        btn_factory.setOnClickListener(this)        btn_appearance.setOnClickListener(this)        btn_event_conflict.setOnClickListener(this)        btn_px_adapter.setOnClickListener(this)        btn_density.setOnClickListener(this)//        btn_go_login.setOnClickListener {//            startActivity(TestLoginActivity.getIntent(this))//        }////        val sp = SpannableStringBuilder("。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。")//        //获取一张图片//        sp.insert(0," ")//        val drawable = resources.getDrawable(R.mipmap.ic_launcher)//        drawable.setBounds(0, 0, 22, 22)//        //居中对齐imageSpan//        val imageSpan = CenterAlignImageSpan(drawable)//        sp.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)//        //普通imageSpan 做对比//        val imageSpan2 = ImageSpan(drawable)//        sp.setSpan(imageSpan2, 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)//        tv_content.text = sp//        val toast: Toast = Toast.makeText(//            this,//            null,//            Toast.LENGTH_SHORT//        )//        toast.setText("hello world")//        toast.show()////        et_input.filters = arrayOf(typeFilter)    }    override fun onClick(v: View?) {        var id = v?.id        when(id){            R.id.btn_tao_bao -> {//仿淘宝二楼                startActivity(SecondFloorPracticeActivity.getIntent(this))            }            R.id.btn_little_red_book -> {//小红书                startActivity(RedBookActivity.getIntent(this))            }            R.id.btn_mvvm -> {//mvvm                startActivity(LoginActivity.getIntent(this))            }            R.id.btn_factory -> {//工程模式                startActivity(FactoryTestActivity.getIntent(this))            }            R.id.btn_appearance -> {//外观模式            }            R.id.btn_event_conflict -> {//事件冲突                startActivity(EventConflictActivity.getIntent(this))            }            R.id.btn_px_adapter -> {//像素适配                startActivity(PxTestActivity.getIntent(this))            }            R.id.btn_density -> {//密度适配                startActivity(DensityActivity.getIntent(this))            }        }    }    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {        super.onActivityResult(requestCode, resultCode, data)        if(resultCode != Activity.RESULT_OK) return        if(requestCode == 1000){            Log.d("debug","===>"+ data?.getStringExtra("key_test"))        }    }//    var typeFilter = InputFilter { source, start, end, dest, dstart, dend ->//        val p =//            Pattern.compile("[\u4e00-\u9fa5]+")//        val m: Matcher = p.matcher(source.toString())//        if (m.matches()) "" else null//    }}