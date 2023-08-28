package com.himanshu.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.himanshu.compose.R

import com.himanshu.compose.ui.HomeScreen.TAG
import com.himanshu.compose.ui.theme.MyComposeTheme
import com.himanshu.data.Screen
import com.himanshu.utility.LogcatManager


object HomeScreen {

    const val TAG="HomeScreen"
}


@Composable
fun ShowHomeScreen(navController: NavHostController) {

    LogcatManager.v("App","Event:: ShowHomeScreen composed called")
    val resource =LocalContext.current.resources

     val itemList = remember {
         mutableListOf<String>()
     }

    val itemStateList = remember {
        mutableStateListOf<String>()
    }

    LaunchedEffect(key1 = TAG ){
        val list =resource.getStringArray(R.array.home_items)
        itemList.addAll(list)
        itemStateList.addAll(list)
    }

    ShowHomeUI(itemStateList,navController)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowHomeUI(itemStateList: SnapshotStateList<String>,navController: NavHostController) {

    val navRouteIndex = remember {
        hashMapOf(4 to Screen.LazyList.route)
    }
    LogcatManager.i("App","Event:: ShowHomeUI composed called")

    MyComposeTheme{
        Column (modifier = Modifier.fillMaxSize()){
            TopAppBar(title = { Text(text = stringResource(id = R.string.home),
                style = MaterialTheme.typography.titleLarge, color = Color.White) },
                colors = topAppBarColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)
            )
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),horizontalAlignment = Alignment.CenterHorizontally){
                itemsIndexed(itemStateList){index,it->
                    ListItem(it,index){
                        navRouteIndex[it]?.let {
                            it1 -> navController.navigate(it1)
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}


@Composable
fun ListItem(labelName: String,itemIndex:Int,onClick:(clickIndex:Int)->Unit){
    Button(modifier = Modifier.fillMaxWidth(0.8F),onClick = {
            onClick.invoke(itemIndex)
    }, elevation = ButtonDefaults.buttonElevation()) {
        Text(text = labelName, color = Color.White, style = MaterialTheme.typography.bodyMedium )
    }
}


@Preview
@Composable
fun ShowPreview(){
    //ShowHomeScreen(navController)
}