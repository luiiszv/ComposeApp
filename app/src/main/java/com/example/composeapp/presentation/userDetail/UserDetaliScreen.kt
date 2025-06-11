package com.example.composeapp.presentation.userDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController



@Composable
fun UserDetaliScreen (
    navController: NavHostController,
    userId: String?
//    viewModel: UserDetailViewModel = hiltViewModel()
){

    Box (modifier = Modifier.fillMaxSize()){

        Text(text = "Detail")

        Spacer(modifier = Modifier.padding(25.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.popBackStack()
            },
        ) {
            Text(text = "Volver")


        }
    }

}


@Preview(showBackground = true)
@Composable
fun UserDetaliPreview(

) {

    UserDetaliScreen(
        navController = rememberNavController(),
        userId = "12"
    )
}