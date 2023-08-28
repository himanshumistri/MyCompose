package com.himanshu.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.himanshu.data.Fruit
import com.himanshu.utility.LogcatManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowLazyColumnViewModel @Inject constructor():ViewModel(){

    private val fruits = listOf(
        Fruit("Apple"),
        Fruit("Banana"),
        Fruit("Orange"),
        Fruit("Peach"),
        Fruit("Grapes"),
        Fruit("Apple-1"),
        Fruit("Banana-1"),
        Fruit("Orange-1"),
        Fruit("Peach-1"),
        Fruit("Grapes-1"),
        Fruit("Apple-2"),
        Fruit("Banana-2"),
        Fruit("Orange-2"),
        Fruit("Peach-2"),
        Fruit("Grapes-2")
    )

    //private var itemList = ArrayList<Fruit>()

    private var uiItemList = mutableStateListOf<Fruit>()

    fun getFruitList() : SnapshotStateList<Fruit> {
        uiItemList.addAll(fruits)
        return uiItemList
    }

    fun changeItemClick(itemPosition:Int){

        if(itemPosition >0 && itemPosition < uiItemList.size){

            if(itemPosition != (uiItemList.size.minus(1))){

                LogcatManager.v("TAG,","Event:: Item Click is $itemPosition")
                uiItemList[itemPosition+1].isSwitchOn.value = !uiItemList[itemPosition+1].isSwitchOn.value

            }

        }

    }

    fun addItemAtStart(){

        uiItemList.add(0,uiItemList[0].copy())

    }
}