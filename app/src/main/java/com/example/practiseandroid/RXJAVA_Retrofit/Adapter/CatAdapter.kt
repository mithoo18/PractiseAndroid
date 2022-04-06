package com.example.practiseandroid.RXJAVA_Retrofit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiseandroid.R
import com.example.practiseandroid.RXJAVA_Retrofit.Model.CatItem

class CatAdapter(
    private val context : Context,
    private var foodList : ArrayList<CatItem>
    ) : RecyclerView.Adapter<CatAdapter.FoodViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.name.text = food.created_at
        holder.price.text = food.id

    }

    fun setData(foodList: ArrayList<CatItem>){
        this.foodList = foodList
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int = foodList.size

    inner class FoodViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.name)
        val price : TextView = itemView.findViewById(R.id.price)
        //val image : ImageView = itemView.findViewById(R.id.image)
    }

}