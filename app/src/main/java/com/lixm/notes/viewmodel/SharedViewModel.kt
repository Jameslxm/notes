package com.lixm.notes.viewmodelimport androidx.lifecycle.MutableLiveDataimport androidx.lifecycle.ViewModelimport com.lixm.notes.viewmodel.bean.Itemclass SharedViewModel : ViewModel() {    val selected = MutableLiveData<Item>()    fun select(item: Item){        selected.value = item    }}