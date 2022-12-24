package com.abdallah_abdelazim.shoestoreapp.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {

    private val _shoesListLiveData: MutableLiveData<List<ShoeUiModel>> =
        MutableLiveData(emptyList())
    val shoesListLiveData: LiveData<List<ShoeUiModel>>
        get() = _shoesListLiveData

    init {
        addDummyShoesData()
    }

    private fun addDummyShoesData() {
        _shoesListLiveData.value = listOf(
            ShoeUiModel(
                "Shoe 1",
                "Adidas",
                45,
                "This is an Adidas shoe"
            ),
            ShoeUiModel(
                "Shoe 2",
                "Nike",
                33,
                "This is a Nike shoe"
            ),
            ShoeUiModel(
                "Shoe 3",
                "New Balance",
                78,
                "This is a New Balance shoe"
            ),
            ShoeUiModel(
                "Shoe 4",
                "Puma",
                16,
                "This is a Puma shoe"
            ),
            ShoeUiModel(
                "Shoe 5",
                "Reebok",
                25,
                "This is a Reebok shoe"
            ),
            ShoeUiModel(
                "Shoe 6",
                "Converse",
                44,
                "This is a Converse shoe"
            ),
            ShoeUiModel(
                "Shoe 7",
                "Skechers",
                44,
                "This is a Skechers shoe"
            ),
        )
    }

    fun addShoe(shoe: ShoeUiModel) {
        val shoesList: MutableList<ShoeUiModel> = _shoesListLiveData.value!!.toMutableList()
        shoesList.add(shoe)
        _shoesListLiveData.value = shoesList
    }
}