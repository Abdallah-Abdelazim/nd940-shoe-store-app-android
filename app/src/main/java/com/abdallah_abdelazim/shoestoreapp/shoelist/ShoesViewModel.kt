package com.abdallah_abdelazim.shoestoreapp.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {

    private val _shoesListLiveData: MutableLiveData<List<ShoeUiModel>> =
        MutableLiveData(emptyList())
    val shoesListLiveData: LiveData<List<ShoeUiModel>>
        get() = _shoesListLiveData

    fun addShoe(shoe: ShoeUiModel) {
        val shoesList: MutableList<ShoeUiModel> = _shoesListLiveData.value!!.toMutableList()
        shoesList.add(shoe)
        _shoesListLiveData.value = shoesList
    }
}