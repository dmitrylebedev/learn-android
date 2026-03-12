package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.screens.MainScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.padding(16.dp)) {
                    MainScreen(
                        onOpenSecondActivity = { text ->
                            if (text.isBlank()) {
                                Toast.makeText(
                                    this,
                                    R.string.error_empty_input,
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@MainScreen
                            }

                            val intent = Intent(this, SecondActivity::class.java).apply {
                                putExtra(SecondActivity.EXTRA_MESSAGE, text)
                            }
                            startActivity(intent)
                        },
                        onDialPhone = { phone ->
                            val cleanedPhone = phone.trim()
                            if (cleanedPhone.isBlank()
                                || !Patterns.PHONE.matcher(cleanedPhone).matches()
                            ) {
                                Toast.makeText(
                                    this,
                                    R.string.error_invalid_phone,
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@MainScreen
                            }

                            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:$cleanedPhone")
                            }
                            startActivity(dialIntent)
                        },
                        onShareText = { textToShare ->
                            if (textToShare.isBlank()) {
                                Toast.makeText(
                                    this,
                                    R.string.error_empty_input,
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@MainScreen
                            }

                            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, textToShare)
                            }
                            startActivity(
                                Intent.createChooser(shareIntent, getString(R.string.share_via))
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyApplicationTheme {
        MainScreen(
            onOpenSecondActivity = {},
            onDialPhone = {},
            onShareText = {}
        )
    }
}