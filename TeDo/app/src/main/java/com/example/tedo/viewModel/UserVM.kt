package com.example.tedo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tedo.data.Graph
import com.example.tedo.data.UserRepository
import com.example.tedo.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserVM(
    private val userRepository: UserRepository = Graph.userRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState : StateFlow<LoginState> = _loginState
    suspend fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val findUser = userRepository.getUsers().filter {
                it.username == username && it.password == password
            }.firstOrNull()

            withContext(Dispatchers.Main) {
                _loginState.value = if(findUser != null){
                    LoginState.Success(findUser)
                } else{
                    LoginState.Error("Invalid username or password!")
                }
            }
        }
    }

    fun register(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
        }
    }
}

sealed class LoginState{
    object Idle : LoginState()
    data class Success(val user : User) : LoginState()
    data class Error(val message : String) : LoginState()
}