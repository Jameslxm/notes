package com.lixm.notes.login.utilimport android.app.Activityimport android.content.Intentimport android.util.Logimport com.lixm.notes.login.LoginActivity/** * Desc * Author xm li * Date :2020/11/5 */object LoginUtils {    var mILogin : ILogin? = null    fun setILogin(activity: Activity, iLogin: ILogin){        isLogin(activity,iLogin)    }    fun isLogin(activity: Activity, iLogin: ILogin){        mILogin = iLogin        if(false){            mILogin?.onLogin()        }else{            Log.d("debug","未登录")            var intent = Intent(activity, LoginActivity::class.java)            activity.startActivity(intent)        }    }    interface ILogin{        fun onLogin()    }}