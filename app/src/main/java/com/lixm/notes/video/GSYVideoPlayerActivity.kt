package com.lixm.notes.video

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.lixm.notes.R
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_gsy_video_player.*

class GSYVideoPlayerActivity : AppCompatActivity() {
    var orientationUtils :OrientationUtils?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gsy_video_player)
        val source1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4"
        player.setUp(source1,true,"测试视频标题")

        //增加封面
        var imageView = ImageView(this)
        imageView.scaleType=ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(R.mipmap.ic_launcher)
        player.thumbImageView=imageView

        //隐藏标题
        player.titleTextView.visibility = View.GONE

        player.backButton.visibility = View.GONE

        orientationUtils= OrientationUtils(this,player)
        player.fullscreenButton.setOnClickListener {
            orientationUtils?.resolveByClick()
        }

        player.setIsTouchWiget(true)
        player.startPlayLogic()
    }

    override fun onResume() {
        super.onResume()
        player.onVideoResume()
    }
    override fun onPause() {
        super.onPause()
        player.onVideoPause()
    }
    override fun onDestroy() {
        super.onDestroy()
        GSYVideoManager.releaseAllVideos()
        orientationUtils?.releaseListener()
    }
}