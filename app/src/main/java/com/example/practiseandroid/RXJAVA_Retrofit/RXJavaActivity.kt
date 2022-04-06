package com.example.practiseandroid.RXJAVA_Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiseandroid.RXJAVA_Retrofit.Adapter.CatAdapter
import com.example.practiseandroid.RXJAVA_Retrofit.Network.Retrofit
import com.example.practiseandroid.R
import com.example.practiseandroid.RXJAVA_Retrofit.Model.CatItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

import kotlin.collections.ArrayList

class RXJavaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)
        catAdapter  = CatAdapter(this, ArrayList<CatItem>())
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@RXJavaActivity)
            adapter = catAdapter
        }
        val compositeDisposable = CompositeDisposable()
        compositeDisposable
            .add(getObservable().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response -> getObserver(response as ArrayList<CatItem>)},
                {t -> onFailure(t)})
        )
    }

    private fun getObservable():Observable<List<CatItem>>
    {
        return Retrofit.api.getAllData()
    }

    private fun getObserver(fooList : ArrayList<CatItem>){
        if(fooList != null && fooList.size > 0){
            catAdapter.setData(fooList)
        }
    }

    private fun onFailure(t:Throwable){
        Toast.makeText(applicationContext,"$t",Toast.LENGTH_SHORT).show()
    }

}