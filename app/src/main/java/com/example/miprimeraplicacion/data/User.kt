package com.example.miprimeraplicacion.data

data class User(
    val userId : Int =0,
    val name: String ="",
    val email: String="invitado@gmail.com",
    val phoneNumber: String="11111111",
    val password: String ="123",
    val userName : String =""
){

    /*
    fun userValidation(): Boolean{
        return  (userName.equals("Admin") && password == "123456")
    }
     */

    /*
    fun userValidation() =
        (userName.equals("Admin") && password == "123456")
     */

    fun validateCredentials() : UserLoginStatus =
        if (userName.equals("Admin") && password == "123456")
            UserLoginStatus.SUCCESS
        else
            UserLoginStatus.FAILURE

}


enum class UserLoginStatus{
    SUCCESS, FAILURE
}