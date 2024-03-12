package com.example.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState : State<RecipeState> = _categoriesState

    /** In order to get the data and store it in the phone. On initialization the categories will be fetched **/
    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        /** ViewModel Scope provides a launch for suspend functions to be processed **/
        viewModelScope.launch {
            /** CoroutineScope **/
            try{
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e : Exception) {
                _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }
    }
}
    data class RecipeState(
        val loading:Boolean = true,
        val list:List<Category> = emptyList(),
        val error:String? = null
    )
