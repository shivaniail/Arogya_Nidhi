//package com.example.arogyanidhi.ui.settings
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SettingsScreen(
//    viewModel: SettingsViewModel,
//    onNavigateBack: () -> Unit,
//    onLogout: () -> Unit
//) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Settings") },
//                navigationIcon = {
//                    IconButton(onClick = onNavigateBack) {
//                        Icon(
//                            Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back"
//                        )
//                    }
//                }
//            )
//        }
//    ) { padding ->
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//
//            // App Info Section
//            Card {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text("Arogya-Nidhi", style = MaterialTheme.typography.titleMedium)
//                    Text("Version 1.0")
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text("Health Scheme Eligibility Checker")
//                    Text("✔ Eligibility Check")
//                    Text("✔ Scheme Recommendations")
//                    Text("✔ Document Checklist")
//                    Text("✔ Hospital Finder")
//                }
//            }
//
//            // Reset Onboarding
//            Button(
//                onClick = {
//                    viewModel.resetOnboarding()
//                },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Reset Onboarding")
//            }
//
//            // Logout Button
//            Button(
//                onClick = {
//                    viewModel.logout()
//                    onLogout()
//                },
//                modifier = Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = MaterialTheme.colorScheme.error
//                )
//            ) {
//                Text("Logout")
//            }
//        }
//    }
//}
package com.example.arogyanidhi.ui.settings

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onNavigateBack: () -> Unit,
    onLogout: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // App Info
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Arogya-Nidhi", style = MaterialTheme.typography.titleMedium)
                    Text("Version 1.0")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Health Scheme Eligibility Checker")
                    Text("✔ Eligibility Check")
                    Text("✔ Scheme Recommendations")
                    Text("✔ Document Checklist")
                    Text("✔ Hospital Finder")
                }
            }

            // Reset Onboarding
            // FIX: Now calls viewModel AND shows a Toast so the user knows it worked.
            // The effect only shows on next app launch — that's expected behaviour.
            Button(
                onClick = {
                    viewModel.resetOnboarding()
                    Toast.makeText(
                        context,
                        "Onboarding reset! Restart the app to see it.",
                        Toast.LENGTH_LONG
                    ).show()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reset Onboarding")
            }

            // Logout
            Button(
                onClick = {
                    viewModel.logout()
                    onLogout()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text("Logout")
            }
        }
    }
}