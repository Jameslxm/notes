package com.lixm.notes.eventconflict

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lixm.notes.R

/**
 * Desc
 * Author xm li
 * Date :2021/3/21
 */
class EventConflictActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_conflict)
    }
    companion object{
        fun getIntent(context: Context): Intent{
            return Intent(context,EventConflictActivity::class.java)
        }
    }
}