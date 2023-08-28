
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.himanshu.compose.R
import com.himanshu.data.Fruit
import com.himanshu.utility.LogcatManager
import com.himanshu.viewmodel.ShowLazyColumnViewModel


@Composable
fun ShowLazyColumnScreen(){

    val showLazyColumnViewModel = hiltViewModel<ShowLazyColumnViewModel>()

    LogcatManager.i("TAG","Event:: ShowLazyColumnScreen Composed")

    val itemList = remember {
        showLazyColumnViewModel.getFruitList()
    }


    LaunchedEffect(key1 = "ShowLazyColumnScreen"){
        //itemList.addAll(showLazyColumnViewModel.getFruitList())
    }

    Column {
        Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center){
            Button(modifier = Modifier.width(100.dp),onClick = {

            }, elevation = ButtonDefaults.buttonElevation()) {
                Text(text = stringResource(id = R.string.minus), color = Color.White, style = MaterialTheme.typography.bodyLarge )
            }
            Button(modifier = Modifier.width(100.dp),onClick = {
                showLazyColumnViewModel.addItemAtStart()
            }, elevation = ButtonDefaults.buttonElevation()) {
                Text(text = stringResource(id = R.string.plus), color = Color.White, style = MaterialTheme.typography.bodyLarge )
            }
        }

        LazyColumn(){
            itemsIndexed(itemList){ index,item->
                LogcatManager.i("TAG","Event:: LazyColumn Compose called for item $index")
                RowItem(item,index){
                    showLazyColumnViewModel.changeItemClick(it)
                }
            }
        }
    }


}

@Composable
fun RowItem(fruit: Fruit,index:Int,onItemClick:(itemPosition:Int)->Unit){

    LogcatManager.v("TAG","Event:: RowItem Compose called for item $index")
     var isTxtTurnOn by remember {
         //This will auto trigger compose based on value change of
         // isSwitchOn when user turn on the switch
         mutableStateOf(fruit.isSwitchOn)
         //In this case system will not trigger compose automatically
        //mutableStateOf(fruit.isSwitchOn.value)
    }

    Row (modifier = Modifier
        .height(60.dp)
        .border(color = Color.Cyan, width = 1.dp)
        .clickable(enabled = true) {
            onItemClick.invoke(index)
        }){
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight(), contentAlignment = Alignment.CenterStart) {
            Row {
                Text(text = fruit.fruitName, fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = if (isTxtTurnOn.value) {
                        stringResource(id = R.string.on)
                    } else {
                        stringResource(id = R.string.off)
                    }, fontSize = 18.sp,
                    color =  if (isTxtTurnOn.value) {
                        Color.Green
                    } else {
                        Color.Red
                    }
                )
            }

        }
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight(), contentAlignment = Alignment.Center) {
            Switch(
                checked = fruit.isSwitchOn.value,
                onCheckedChange = {
                    fruit.isSwitchOn.value = it

                     //This will call compose of item only
                    //isTxtTurnOn = it
                }
            )
        }
    }

}