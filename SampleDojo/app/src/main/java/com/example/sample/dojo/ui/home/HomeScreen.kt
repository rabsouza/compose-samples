package com.example.sample.dojo.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sample.dojo.ui.theme.SampleDojoTheme
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen() {

    val viewModel = koinViewModel<HomeViewModel>()
    var name by remember { mutableStateOf("") }

    HomeContent(name = name, onNameChange = { name = it }, viewModel = viewModel)
}

@Composable
fun HomeContent(viewModel: HomeViewModel, name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
        Spacer(modifier = Modifier.size(24.dp))
        Button(onClick = { viewModel.onLoginClick(name) }) {
            Text(text = "Clique aqui!!!")
        }
        Spacer(modifier = Modifier.size(24.dp))

        val visible by remember { viewModel.hasError }
        AnimatedVisibility(
            visible = visible
        ) {
            Text(
                viewModel.errorState.value.orEmpty(),
                style = MaterialTheme.typography.h5,
                color = Color.Red
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleDojoTheme {
        HomeScreen()
    }
}