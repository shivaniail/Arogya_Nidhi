//package com.example.arogyanidhi.ui.onboarding
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun OnboardingScreen(
//    onContinue: () -> Unit
//) {
//    Column(
//        modifier = Modifier.fillMaxSize().padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(text = "Welcome to Arogya Nidhi", style = MaterialTheme.typography.headlineLarge)
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = "Your guide to government healthcare schemes and eligibility.")
//        Spacer(modifier = Modifier.height(32.dp))
//        Button(onClick = onContinue, modifier = Modifier.fillMaxWidth()) {
//            Text("Get Started")
//        }
//    }
//}
package com.example.arogyanidhi.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingScreen(
    onContinue: () -> Unit
) {

    // 🌈 Gradient background
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF6A11CB), // purple
            Color(0xFF2575FC)  // blue
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Welcome to Arogya Nidhi",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2575FC)
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Check eligibility for government health schemes easily and quickly.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onContinue,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2575FC)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Get Started", color = Color.White)
                }
            }
        }
    }
}