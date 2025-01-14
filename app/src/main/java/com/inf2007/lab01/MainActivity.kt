//package com.inf2007.lab01
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.testTag
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.inf2007.lab01.ui.theme.Lab01Theme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MainScreen()
//        }
//    }
//}
//
//@Composable
//fun MainScreen() {
//    Lab01Theme {
//        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            var username by remember { mutableStateOf("") }
//            var showGreeting by remember { mutableStateOf(false) }
//
//            Column(
//                modifier = Modifier
//                    .padding(innerPadding)
//                    .fillMaxSize()
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                UserInput(
//                    name = username,
//                    onNameChange = { username = it },
//                    modifier = Modifier.testTag("nameInput")
//                )
//
//                Button(
//                    onClick = {
//                        if (username.isNotBlank()) {
//                            showGreeting = true
//                        }
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .testTag("submitButton")
//                ) {
//                    Text("Submit")
//                }
//
//                if (showGreeting) {
//                    Greeting(
//                        name = username,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 16.dp)
//                    )
//
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun UserInput(name: String, onNameChange: (String) -> Unit, modifier: Modifier = Modifier) {
//    TextField(
//        value = name,
//        onValueChange = { onNameChange(it) },
//        label = { Text("Enter your Name") },
//        modifier = modifier
//            .fillMaxWidth()
//            .testTag("UserInput")
//    )
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!, Welcome to InF2007!",
//        modifier = Modifier
//            .fillMaxWidth()
//            .testTag("greeting")
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MainScreen()
//}

package com.inf2007.lab01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inf2007.lab01.ui.theme.Lab01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Lab01Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            var username by remember { mutableStateOf("") }
            var showGreeting by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Input Field for Username
                UserInput(
                    name = username,
                    onNameChange = { username = it },
                    modifier = Modifier.testTag("nameInput") // Matches the test case tag
                )

                // Submit Button
                Button(
                    onClick = {
                        showGreeting = username.isNotBlank() // Show greeting only if input is not blank
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("submitButton") // Matches the test case tag
                ) {
                    Text("Submit")
                }

                // Greeting Message
                if (showGreeting) {
                    Greeting(
                        name = username,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .testTag("greetingMsg") // Matches the test case tag
                    )
                }
            }
        }
    }
}

@Composable
fun UserInput(name: String, onNameChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = name,
        onValueChange = { onNameChange(it) },
        label = { Text("Enter your Name") },
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!, Welcome to INF2007!", // Matches the exact greeting format from the test case
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}
