package com.example.practiseandroid.BasicMVP

class MVPPresenter(private var mvpView: MVPView) {

    fun updateUserInfo(fullName : String,email :String){
        val updatedUser = User(fullName,email)
        mvpView.updateUserInfoTextView(updatedUser.toString())
    }
}