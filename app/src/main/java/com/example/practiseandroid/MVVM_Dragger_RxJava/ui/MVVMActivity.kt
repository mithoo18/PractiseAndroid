package com.example.practiseandroid.MVVM_Dragger_RxJava.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiseandroid.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.logging.Logger
import javax.inject.Inject

class MVVMActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel
    private lateinit var compositeDisposable: CompositeDisposable
    private var disposable : Disposable? = null

    companion object{
        val Log = Logger.getLogger(MVVMActivity::class.java.name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmactivity)

        compositeDisposable = CompositeDisposable()

    }
}