package com.lixm.notesimport androidx.appcompat.app.AppCompatActivityimport android.os.Bundleimport com.lixm.notes.login.TestLoginActivityimport kotlinx.android.synthetic.main.activity_main.*class MainActivity : AppCompatActivity() {    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContentView(R.layout.activity_main)        btn_go_login.setOnClickListener {            startActivity(TestLoginActivity.getIntent(this))        }    }}