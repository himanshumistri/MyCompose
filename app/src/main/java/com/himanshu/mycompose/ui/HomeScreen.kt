package com.himanshu.mycompose.ui

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshu.mycompose.R
import com.himanshu.mycompose.ui.HomeScreen.TAG
import com.himanshu.mycompose.ui.theme.MyComposeTheme


object HomeScreen {

    const val TAG="HomeScreen"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowHomeScreen(){

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
                    ListItem(it)
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }

}


@Composable
fun ListItem(labelName: String){
    Button(modifier = Modifier.fillMaxWidth(0.8F),onClick = {

    }, elevation = ButtonDefaults.buttonElevation()) {

        Text(text = labelName, color = Color.White, style = MaterialTheme.typography.bodyMedium )
    }
}


@Preview
@Composable
fun ShowPreview(){
    ShowHomeScreen()
}