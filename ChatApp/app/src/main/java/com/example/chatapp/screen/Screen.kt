package com.example.chatapp.screen

sealed class Screen(val route : String){
    object loginScreen:Screen("loginScreen")
    object signupScreen:Screen("signupScreen")
    object chatRoomScreen:Screen("chatroomScreen")
    object chatScreen:Screen("chatScreen")
}