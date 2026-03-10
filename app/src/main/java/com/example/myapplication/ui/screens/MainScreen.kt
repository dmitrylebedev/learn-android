package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun MainScreen(
    onOpenSecondActivity: (String) -> Unit,
    onDialPhone: (String) -> Unit,
    onShareText: (String) -> Unit
) {
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(top = 32.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text(text = stringResource(R.string.input_label)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Button(
            onClick = { onOpenSecondActivity(inputText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.open_second_activity))
        }

        Button(
            onClick = { onDialPhone(inputText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.call_friend))
        }

        Button(
            onClick = { onShareText(inputText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.share_text))
        }
    }
}
