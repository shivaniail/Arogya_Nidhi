//package com.example.arogyanidhi.ui.profile
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.arogyanidhi.domain.model.UserProfile
//import android.widget.Toast
//import androidx.compose.ui.platform.LocalContext
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ProfileScreen(
//    viewModel: ProfileViewModel,
//    onNavigateBack: () -> Unit
//) {
//    val userProfile by viewModel.userProfile.collectAsState()
//    val context = LocalContext.current
//    var name by remember { mutableStateOf("") }
//    var age by remember { mutableStateOf("") }
//    var district by remember { mutableStateOf("") }
//
//    LaunchedEffect(userProfile) {
//        userProfile?.let {
//            name = it.name
//            age = it.age.toString()
//            district = it.district
//        }
//    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("My Profile") },
//                navigationIcon = {
//                    IconButton(onClick = onNavigateBack) {
//                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//        }
//    ) { padding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .padding(16.dp)
//        ) {
//            OutlinedTextField(
//                value = name,
//                onValueChange = { name = it },
//                label = { Text("Full Name") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            OutlinedTextField(
//                value = age,
//                onValueChange = { age = it },
//                label = { Text("Age") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            OutlinedTextField(
//                value = district,
//                onValueChange = { district = it },
//                label = { Text("District") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//
////            Button(
////                onClick = {
////                    val profile = userProfile?.copy(
////                        name = name,
////                        age = age.toIntOrNull() ?: 0,
////                        district = district
////                    ) ?: UserProfile(name = name, age = age.toIntOrNull() ?: 0, district = district)
////                    viewModel.saveProfile(profile)
////                },
//            Button(
//                onClick = {
//
//                    val profile = userProfile?.copy(
//                        name = name,
//                        age = age.toIntOrNull() ?: 0,
//                        district = district
//                    ) ?: UserProfile(
//                        name = name,
//                        age = age.toIntOrNull() ?: 0,
//                        district = district
//                    )
//
//                    viewModel.saveProfile(profile)
//
//                    Toast.makeText(
//                        context,
//                        "Profile Saved",
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                    onNavigateBack()
//                },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Save Profile")
//            }
//        }
//    }
//}
package com.example.arogyanidhi.ui.profile

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.arogyanidhi.domain.model.UserProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onNavigateBack: () -> Unit
) {
    val userProfile by viewModel.userProfile.collectAsState()
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var district by remember { mutableStateOf("") }

    // ✅ FIX: Pre-fill fields whenever userProfile loads from Firestore
    // This was working before but the uid issue meant the profile was
    // saved to wrong document and never returned. Now with ProfileViewModel
    // fix, this will correctly pre-fill on reopen.
    LaunchedEffect(userProfile) {
        userProfile?.let {
            if (it.name.isNotBlank()) name = it.name
            if (it.age != 0) age = it.age.toString()
            if (it.district.isNotBlank()) district = it.district
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Profile", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1B5E20)
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF2E7D32),
                    focusedLabelColor = Color(0xFF2E7D32)
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF2E7D32),
                    focusedLabelColor = Color(0xFF2E7D32)
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = district,
                onValueChange = { district = it },
                label = { Text("District") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF2E7D32),
                    focusedLabelColor = Color(0xFF2E7D32)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // Basic validation
                    if (name.isBlank()) {
                        Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    val profile = userProfile?.copy(
                        name = name,
                        age = age.toIntOrNull() ?: 0,
                        district = district
                    ) ?: UserProfile(
                        name = name,
                        age = age.toIntOrNull() ?: 0,
                        district = district
                    )

                    viewModel.saveProfile(profile)

                    Toast.makeText(
                        context,
                        "Profile saved successfully!",
                        Toast.LENGTH_SHORT
                    ).show()

                    onNavigateBack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1B5E20)
                )
            ) {
                Text("Save Profile", color = Color.White)
            }
        }
    }
}