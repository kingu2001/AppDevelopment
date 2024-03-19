package com.example.tedo.view

sealed class Screen(val route : String) {
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
}