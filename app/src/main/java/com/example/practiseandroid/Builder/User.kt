package com.example.practiseandroid.Builder

internal class User(builder:UserBuilder){

    val firstname : String = builder.firstname
    val lastName : String = builder.lastName
    val phone : String? = builder.phone
    val address : String? = builder.address
    val age : Int = builder.age

    class UserBuilder(val firstname: String,val lastName : String){
        var phone : String? = null
        var address : String? = null
        var age = 0

        fun age(age : Int) : UserBuilder{
            this.age = age
            return this
        }

        fun address(address : String?) : UserBuilder{
            this.address = address
            return this
        }

        fun phone(phone :String?) : UserBuilder{
            this.phone = phone
            return this
        }

        fun build():User{
            val user = User(this)
            require(user.age <= 25){ "Age cannot be more than 25!"}
            return user
        }

        fun logUserData(): String{
            return ("First Name :" + firstname + ", Last Name :"+ lastName +", Age :" + age +", Phone "
                    + phone +", Address :" + address)
        }

    }
}