//package com.example.arogyanidhi.ui.dashboard
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DashboardScreen(
//    viewModel: DashboardViewModel,
//    onNavigateToEligibility: () -> Unit,
//    onNavigateToSchemes: () -> Unit,
//    onNavigateToHospitals: () -> Unit,
//    onNavigateToProfile: () -> Unit,
//    onNavigateToSettings: () -> Unit
//) {
//
//    val userProfile by viewModel.userProfile.collectAsState()
//
//    Scaffold(
//
//        topBar = {
//
//            CenterAlignedTopAppBar(
//
//                title = {
//
//                    Text(
//                        text = "Arogya Nidhi",
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White
//                    )
//                },
//
//                actions = {
//
//                    IconButton(
//                        onClick = onNavigateToSettings
//                    ) {
//
//                        Icon(
//                            Icons.Default.Settings,
//                            contentDescription = "Settings",
//                            tint = Color.White
//                        )
//                    }
//                },
//
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                    containerColor = Color(0xFF1B5E20)
//                )
//            )
//        }
//
//    ) { padding ->
//
//        Column(
//
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .background(
//                    Brush.verticalGradient(
//                        colors = listOf(
//                            Color(0xFFE8F5E9),
//                            Color.White,
//                            Color(0xFFE3F2FD)
//                        )
//                    )
//                )
//        ) {
//
//            // HEADER CARD
//
//            Card(
//
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//
//                shape = RoundedCornerShape(28.dp),
//
//                colors = CardDefaults.cardColors(
//                    containerColor = Color(0xFF2E7D32)
//                ),
//
//                elevation = CardDefaults.cardElevation(
//                    defaultElevation = 10.dp
//                )
//            ) {
//
//                Column(
//                    modifier = Modifier.padding(24.dp)
//                ) {
//
//                    Text(
//                        text = "Welcome 👋",
//                        color = Color.White,
//                        style = MaterialTheme.typography.titleMedium
//                    )
//
//                    Spacer(modifier = Modifier.height(8.dp))
//
//                    Text(
//                        text = userProfile?.name ?: "User",
//                        color = Color.White,
//                        style = MaterialTheme.typography.headlineMedium,
//                        fontWeight = FontWeight.Bold
//                    )
//
//                    Spacer(modifier = Modifier.height(8.dp))
//
//                    Text(
//                        text = "Find hospitals, health schemes and eligibility details easily.",
//                        color = Color.White.copy(alpha = 0.9f)
//                    )
//                }
//            }
//
//            // SECTION TITLE
//
//            Text(
//                text = "Quick Services",
//                style = MaterialTheme.typography.titleLarge,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF1B5E20),
//                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // MENU ITEMS
//
//            val menuItems = listOf(
//
//                DashboardMenuItem(
//                    "🏥 Hospitals",
//                    Icons.Default.LocalHospital,
//                    Color(0xFFE57373),
//                    onNavigateToHospitals
//                ),
//
//                DashboardMenuItem(
//                    "📋 Schemes",
//                    Icons.Default.Assignment,
//                    Color(0xFF64B5F6),
//                    onNavigateToSchemes
//                ),
//
//                DashboardMenuItem(
//                    "✅ Eligibility",
//                    Icons.Default.CheckCircle,
//                    Color(0xFF81C784),
//                    onNavigateToEligibility
//                ),
//
//                DashboardMenuItem(
//                    "👤 Profile",
//                    Icons.Default.Person,
//                    Color(0xFFFFB74D),
//                    onNavigateToProfile
//                )
//            )
//
//            LazyVerticalGrid(
//
//                columns = GridCells.Fixed(2),
//
//                contentPadding = PaddingValues(16.dp),
//
//                horizontalArrangement = Arrangement.spacedBy(16.dp),
//
//                verticalArrangement = Arrangement.spacedBy(16.dp),
//
//                modifier = Modifier.weight(1f)
//
//            ) {
//
//                items(menuItems) { item ->
//
//                    DashboardCard(item)
//                }
//            }
//
//            // BOTTOM HEALTH CARD
//
//            Card(
//
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//
//                shape = RoundedCornerShape(24.dp),
//
//                colors = CardDefaults.cardColors(
//                    containerColor = Color(0xFFFB8C00)
//                )
//            ) {
//
//                Row(
//
//                    modifier = Modifier
//                        .padding(24.dp)
//                        .fillMaxWidth(),
//
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//
//                    Icon(
//                        Icons.Default.HealthAndSafety,
//                        contentDescription = null,
//                        tint = Color.White,
//                        modifier = Modifier.size(52.dp)
//                    )
//
//                    Spacer(modifier = Modifier.width(16.dp))
//
//                    Column {
//
//                        Text(
//                            text = "Stay Safe & Healthy",
//                            color = Color.White,
//                            style = MaterialTheme.typography.titleLarge,
//                            fontWeight = FontWeight.Bold
//                        )
//
//                        Spacer(modifier = Modifier.height(4.dp))
//
//                        Text(
//                            text = "Check eligibility for latest government schemes.",
//                            color = Color.White
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//data class DashboardMenuItem(
//    val title: String,
//    val icon: ImageVector,
//    val color: Color,
//    val onClick: () -> Unit
//)
//
//@Composable
//fun DashboardCard(item: DashboardMenuItem) {
//
//    Card(
//
//        onClick = item.onClick,
//
//        modifier = Modifier
//            .height(170.dp)
//            .fillMaxWidth(),
//
//        shape = RoundedCornerShape(26.dp),
//
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        ),
//
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 8.dp
//        )
//    ) {
//
//        Column(
//
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//
//            verticalArrangement = Arrangement.Center,
//
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Box(
//
//                modifier = Modifier
//                    .size(64.dp)
//                    .clip(CircleShape)
//                    .background(item.color.copy(alpha = 0.18f)),
//
//                contentAlignment = Alignment.Center
//            ) {
//
//                Icon(
//                    imageVector = item.icon,
//                    contentDescription = null,
//                    tint = item.color,
//                    modifier = Modifier.size(32.dp)
//                )
//            }
//
//            Spacer(modifier = Modifier.height(18.dp))
//
//            Text(
//                text = item.title,
//                style = MaterialTheme.typography.titleMedium,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF1B1B1B)
//            )
//        }
//    }
//}
package com.example.arogyanidhi.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    onNavigateToEligibility: () -> Unit,
    onNavigateToSchemes: () -> Unit,
    onNavigateToHospitals: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val userProfile by viewModel.userProfile.collectAsState()

    // ✅ FEATURE 1: Show real name from Profile in welcome card
    // If profile name is saved, show "Welcome, Ramesh!"
    // Otherwise fall back to Firebase display name, then "User"
    val displayName = when {
        !userProfile?.name.isNullOrBlank() -> userProfile!!.name
        else -> "User"
    }

    // ✅ FEATURE 3: Show district from profile if available
    val userDistrict = userProfile?.district ?: ""

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Arogya Nidhi",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                actions = {
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1B5E20)
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE8F5E9),
                            Color.White,
                            Color(0xFFE3F2FD)
                        )
                    )
                )
        ) {

            // ✅ FEATURE 1: Welcome card shows real name from Profile
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF2E7D32)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {

                    Text(
                        text = "Welcome 👋",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Shows "Ramesh" if profile name is saved
                    Text(
                        text = displayName,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // ✅ FEATURE 3: Show district if saved in profile
                    if (userDistrict.isNotBlank()) {
                        Text(
                            text = "📍 $userDistrict",
                            color = Color.White.copy(alpha = 0.85f),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    Text(
                        text = "Find hospitals, health schemes and eligibility details easily.",
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }

            Text(
                text = "Quick Services",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20),
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            val menuItems = listOf(
                DashboardMenuItem(
                    "🏥 Hospitals",
                    Icons.Default.LocalHospital,
                    Color(0xFFE57373),
                    onNavigateToHospitals
                ),
                DashboardMenuItem(
                    "📋 Schemes",
                    Icons.Default.Assignment,
                    Color(0xFF64B5F6),
                    onNavigateToSchemes
                ),
                DashboardMenuItem(
                    "✅ Eligibility",
                    Icons.Default.CheckCircle,
                    Color(0xFF81C784),
                    onNavigateToEligibility
                ),
                DashboardMenuItem(
                    "👤 Profile",
                    Icons.Default.Person,
                    Color(0xFFFFB74D),
                    onNavigateToProfile
                )
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(menuItems) { item ->
                    DashboardCard(item)
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFB8C00)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.HealthAndSafety,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(52.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Stay Safe & Healthy",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Check eligibility for latest government schemes.",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

data class DashboardMenuItem(
    val title: String,
    val icon: ImageVector,
    val color: Color,
    val onClick: () -> Unit
)

@Composable
fun DashboardCard(item: DashboardMenuItem) {
    Card(
        onClick = item.onClick,
        modifier = Modifier
            .height(170.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(item.color.copy(alpha = 0.18f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = item.color,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B1B1B)
            )
        }
    }
}