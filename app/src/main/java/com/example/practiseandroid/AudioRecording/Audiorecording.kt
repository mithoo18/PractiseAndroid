package com.example.practiseandroid.AudioRecording

import android.annotation.SuppressLint
import android.media.MediaRecorder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.MotionEvent
import com.example.practiseandroid.R
import com.example.practiseandroid.databinding.ActivityAudiorecordingBinding

class Audiorecording : AppCompatActivity() {
    private lateinit var binding : ActivityAudiorecordingBinding

    private var recordAudio = RecordAudio()
    private var playAudio = PlayAudio()
    private val recorder by lazy { getMediaRecorder() }

    private val recordingFileName : String by lazy {
        Environment.getExternalStorageDirectory().absolutePath + "/audiorecord.3gp"
    }

    private fun getMediaRecorder() : MediaRecorder {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            MediaRecorder(this)
        }
        else{
            MediaRecorder()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityAudiorecordingBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setSupportActionBar(toolbar)

            txtView.text =  "Press and hold record button to record"
            fabRec.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        txtView.text = "Recording Started"
                        recordAudio.startRecording(recorder, recordingFileName)
                    }
                    MotionEvent.ACTION_UP -> {
                        txtView.text = "Press and hold record button to record\nRecording Stopped"
                        recordAudio.stopRecording()
                    }
                }
                true
            }
            fabPlay.setOnClickListener {
                if(playAudio.isPlayingAudio){
                    txtView.text = ""
                    playAudio.stopPlaying()
                }
                else{
                    txtView.text = "Audio play started"
                    playAudio.startPlaying(recordingFileName)
                }
            }

        }
    }

    override fun onPause() {
        super.onPause()
        recordAudio.releaseMediaRecorder()
        playAudio.releaseMediaPlayer()
    }

}

