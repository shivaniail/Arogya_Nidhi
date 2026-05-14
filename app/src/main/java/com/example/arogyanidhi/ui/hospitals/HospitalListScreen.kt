////package com.example.arogyanidhi.ui.hospitals
////
////import android.content.Intent
////import android.net.Uri
////import androidx.compose.foundation.background
////import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.lazy.LazyColumn
////import androidx.compose.foundation.lazy.items
////import androidx.compose.foundation.shape.RoundedCornerShape
////import androidx.compose.material.icons.Icons
////import androidx.compose.material.icons.automirrored.filled.ArrowBack
////import androidx.compose.material.icons.filled.Directions
////import androidx.compose.material.icons.filled.LocationOn
////import androidx.compose.material.icons.filled.Phone
////import androidx.compose.material.icons.filled.Search
////import androidx.compose.material3.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.graphics.Brush
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.platform.LocalContext
////import androidx.compose.ui.text.font.FontWeight
////import androidx.compose.ui.unit.dp
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun HospitalListScreen(
////    viewModel: HospitalViewModel,
////    onNavigateBack: () -> Unit
////) {
////
////    val hospitals by viewModel.hospitals.collectAsState()
////    val context = LocalContext.current
////
////    var searchQuery by remember {
////        mutableStateOf("")
////    }
////
////    val filteredHospitals = hospitals.filter {
////
////        it.district.contains(
////            searchQuery,
////            ignoreCase = true
////        ) ||
////
////                it.name.contains(
////                    searchQuery,
////                    ignoreCase = true
////                )
////    }
////
////    Scaffold(
////
////        topBar = {
////
////            TopAppBar(
////
////                title = {
////                    Text("Empaneled Hospitals")
////                },
////
////                navigationIcon = {
////
////                    IconButton(onClick = onNavigateBack) {
////
////                        Icon(
////                            Icons.AutoMirrored.Filled.ArrowBack,
////                            contentDescription = "Back"
////                        )
////                    }
////                },
////
////                colors = TopAppBarDefaults.topAppBarColors(
////                    containerColor = Color(0xFF1B5E20),
////                    titleContentColor = Color.White,
////                    navigationIconContentColor = Color.White
////                )
////            )
////        }
////
////    ) { padding ->
////
////        Column(
////
////            modifier = Modifier
////                .fillMaxSize()
////                .background(
////                    Brush.verticalGradient(
////                        colors = listOf(
////                            Color(0xFFE8F5E9),
////                            Color.White
////                        )
////                    )
////                )
////                .padding(padding)
////                .padding(16.dp)
////        ) {
////
////            // SEARCH BAR
////
////            OutlinedTextField(
////
////                value = searchQuery,
////
////                onValueChange = {
////                    searchQuery = it
////                },
////
////                label = {
////                    Text("Search by District")
////                },
////
////                leadingIcon = {
////
////                    Icon(
////                        Icons.Default.Search,
////                        contentDescription = null
////                    )
////                },
////
////                modifier = Modifier.fillMaxWidth(),
////
////                shape = RoundedCornerShape(14.dp),
////
////                colors = OutlinedTextFieldDefaults.colors(
////                    focusedBorderColor = Color(0xFF2E7D32),
////                    focusedLabelColor = Color(0xFF2E7D32),
////                    cursorColor = Color(0xFF2E7D32)
////                )
////            )
////
////            Spacer(modifier = Modifier.height(20.dp))
////
////            if (filteredHospitals.isEmpty()) {
////
////                Box(
////                    modifier = Modifier.fillMaxSize(),
////                    contentAlignment = Alignment.Center
////                ) {
////
////                    Text(
////                        text = "No hospitals found",
////                        color = Color.Gray
////                    )
////                }
////
////            } else {
////
////                LazyColumn(
////                    verticalArrangement = Arrangement.spacedBy(12.dp)
////                ) {
////
////                    items(filteredHospitals) { hospital ->
////
////                        Card(
////
////                            modifier = Modifier.fillMaxWidth(),
////
////                            shape = RoundedCornerShape(20.dp),
////
////                            elevation = CardDefaults.cardElevation(
////                                defaultElevation = 4.dp
////                            ),
////
////                            colors = CardDefaults.cardColors(
////                                containerColor = Color.White
////                            )
////                        ) {
////
////                            Column(
////                                modifier = Modifier.padding(18.dp)
////                            ) {
////
////                                Text(
////                                    text = hospital.name,
////                                    style = MaterialTheme.typography.titleMedium,
////                                    fontWeight = FontWeight.Bold,
////                                    color = Color(0xFF1B5E20)
////                                )
////
////                                Spacer(modifier = Modifier.height(8.dp))
////
////                                Text(
////                                    text = hospital.type,
////                                    color = Color(0xFF2E7D32)
////                                )
////
////                                Spacer(modifier = Modifier.height(10.dp))
////
////                                Row(
////                                    verticalAlignment = Alignment.CenterVertically
////                                ) {
////
////                                    Icon(
////                                        Icons.Default.LocationOn,
////                                        contentDescription = null,
////                                        tint = Color.Gray
////                                    )
////
////                                    Spacer(modifier = Modifier.width(6.dp))
////
////                                    Text(hospital.address)
////                                }
////
////                                Spacer(modifier = Modifier.height(6.dp))
////
////                                Text(
////                                    text = "District: ${hospital.district}",
////                                    color = Color.DarkGray
////                                )
////
////                                Spacer(modifier = Modifier.height(6.dp))
////
////                                Row(
////                                    verticalAlignment = Alignment.CenterVertically
////                                ) {
////
////                                    Icon(
////                                        Icons.Default.Phone,
////                                        contentDescription = null,
////                                        tint = Color.Gray
////                                    )
////
////                                    Spacer(modifier = Modifier.width(6.dp))
////
////                                    Text(hospital.contact)
////                                }
////
////                                Spacer(modifier = Modifier.height(16.dp))
////
////                                Button(
////
////                                    onClick = {
////
////                                        val uri = Uri.parse(
////                                            "google.navigation:q=${hospital.latitude},${hospital.longitude}"
////                                        )
////
////                                        val intent = Intent(
////                                            Intent.ACTION_VIEW,
////                                            uri
////                                        )
////
////                                        intent.setPackage(
////                                            "com.google.android.apps.maps"
////                                        )
////
////                                        context.startActivity(intent)
////                                    },
////
////                                    colors = ButtonDefaults.buttonColors(
////                                        containerColor = Color(0xFFFB8C00)
////                                    ),
////
////                                    shape = RoundedCornerShape(12.dp),
////
////                                    modifier = Modifier.fillMaxWidth()
////                                ) {
////
////                                    Icon(
////                                        Icons.Default.Directions,
////                                        contentDescription = null
////                                    )
////
////                                    Spacer(modifier = Modifier.width(8.dp))
////
////                                    Text("Get Directions")
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////        }
////    }
////}
////package com.example.arogyanidhi.ui.hospitals
////
////import android.content.Intent
////import android.net.Uri
////import androidx.compose.foundation.background
////import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.lazy.LazyColumn
////import androidx.compose.foundation.lazy.items
////import androidx.compose.foundation.shape.RoundedCornerShape
////import androidx.compose.material.icons.Icons
////import androidx.compose.material.icons.automirrored.filled.ArrowBack
////import androidx.compose.material.icons.filled.Directions
////import androidx.compose.material.icons.filled.LocationOn
////import androidx.compose.material.icons.filled.Phone
////import androidx.compose.material.icons.filled.Search
////import androidx.compose.material3.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.graphics.Brush
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.platform.LocalContext
////import androidx.compose.ui.text.font.FontWeight
////import androidx.compose.ui.unit.dp
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun HospitalListScreen(
////    viewModel: HospitalViewModel,
////    onNavigateBack: () -> Unit
////) {
////
////    val hospitals by viewModel.hospitals.collectAsState()
////    val context = LocalContext.current
////
////    var searchQuery by remember { mutableStateOf("") }
////
////    // ✅ IMPROVED SEARCH LOGIC (STEP 3 FIX)
////    val filteredHospitals = remember(hospitals, searchQuery) {
////
////        if (searchQuery.isBlank()) {
////            hospitals
////        } else {
////            hospitals.filter { hospital ->
////                val query = searchQuery.trim()
////
////                hospital.district.contains(query, ignoreCase = true) ||
////                        hospital.name.contains(query, ignoreCase = true)
////            }
////        }
////    }
////
////    Scaffold(
////
////        topBar = {
////
////            TopAppBar(
////
////                title = {
////                    Text("Empaneled Hospitals")
////                },
////
////                navigationIcon = {
////
////                    IconButton(onClick = onNavigateBack) {
////
////                        Icon(
////                            Icons.AutoMirrored.Filled.ArrowBack,
////                            contentDescription = "Back"
////                        )
////                    }
////                },
////
////                colors = TopAppBarDefaults.topAppBarColors(
////                    containerColor = Color(0xFF1B5E20),
////                    titleContentColor = Color.White,
////                    navigationIconContentColor = Color.White
////                )
////            )
////        }
////
////    ) { padding ->
////
////        Column(
////
////            modifier = Modifier
////                .fillMaxSize()
////                .background(
////                    Brush.verticalGradient(
////                        colors = listOf(
////                            Color(0xFFE8F5E9),
////                            Color.White
////                        )
////                    )
////                )
////                .padding(padding)
////                .padding(16.dp)
////        ) {
////
////            // SEARCH BAR
////            OutlinedTextField(
////
////                value = searchQuery,
////
////                onValueChange = {
////                    searchQuery = it
////                },
////
////                label = {
////                    Text("Search by District")
////                },
////
////                leadingIcon = {
////
////                    Icon(
////                        Icons.Default.Search,
////                        contentDescription = null
////                    )
////                },
////
////                modifier = Modifier.fillMaxWidth(),
////
////                shape = RoundedCornerShape(14.dp),
////
////                colors = OutlinedTextFieldDefaults.colors(
////                    focusedBorderColor = Color(0xFF2E7D32),
////                    focusedLabelColor = Color(0xFF2E7D32),
////                    cursorColor = Color(0xFF2E7D32)
////                )
////            )
////
////            Spacer(modifier = Modifier.height(20.dp))
////
////            // EMPTY STATE
////            if (filteredHospitals.isEmpty()) {
////
////                Box(
////                    modifier = Modifier.fillMaxSize(),
////                    contentAlignment = Alignment.Center
////                ) {
////
////                    Text(
////                        text = "No hospitals found",
////                        color = Color.Gray
////                    )
////                }
////
////            } else {
////
////                // LIST
////                LazyColumn(
////                    verticalArrangement = Arrangement.spacedBy(12.dp)
////                ) {
////
////                    items(filteredHospitals) { hospital ->
////
////                        Card(
////
////                            modifier = Modifier.fillMaxWidth(),
////
////                            shape = RoundedCornerShape(20.dp),
////
////                            elevation = CardDefaults.cardElevation(
////                                defaultElevation = 4.dp
////                            ),
////
////                            colors = CardDefaults.cardColors(
////                                containerColor = Color.White
////                            )
////                        ) {
////
////                            Column(
////                                modifier = Modifier.padding(18.dp)
////                            ) {
////
////                                Text(
////                                    text = hospital.name,
////                                    style = MaterialTheme.typography.titleMedium,
////                                    fontWeight = FontWeight.Bold,
////                                    color = Color(0xFF1B5E20)
////                                )
////
////                                Spacer(modifier = Modifier.height(8.dp))
////
////                                Text(
////                                    text = hospital.type,
////                                    color = Color(0xFF2E7D32)
////                                )
////
////                                Spacer(modifier = Modifier.height(10.dp))
////
////                                Row(verticalAlignment = Alignment.CenterVertically) {
////
////                                    Icon(
////                                        Icons.Default.LocationOn,
////                                        contentDescription = null,
////                                        tint = Color.Gray
////                                    )
////
////                                    Spacer(modifier = Modifier.width(6.dp))
////
////                                    Text(hospital.address)
////                                }
////
////                                Spacer(modifier = Modifier.height(6.dp))
////
////                                Text(
////                                    text = "District: ${hospital.district}",
////                                    color = Color.DarkGray
////                                )
////
////                                Spacer(modifier = Modifier.height(6.dp))
////
////                                Row(verticalAlignment = Alignment.CenterVertically) {
////
////                                    Icon(
////                                        Icons.Default.Phone,
////                                        contentDescription = null,
////                                        tint = Color.Gray
////                                    )
////
////                                    Spacer(modifier = Modifier.width(6.dp))
////
////                                    Text(hospital.contact)
////                                }
////
////                                Spacer(modifier = Modifier.height(16.dp))
////
////                                Button(
////
////                                    onClick = {
////
////                                        val uri = Uri.parse(
////                                            "google.navigation:q=${hospital.latitude},${hospital.longitude}"
////                                        )
////
////                                        val intent = Intent(Intent.ACTION_VIEW, uri)
////
////                                        intent.setPackage(
////                                            "com.google.android.apps.maps"
////                                        )
////
////                                        context.startActivity(intent)
////                                    },
////
////                                    colors = ButtonDefaults.buttonColors(
////                                        containerColor = Color(0xFFFB8C00)
////                                    ),
////
////                                    shape = RoundedCornerShape(12.dp),
////
////                                    modifier = Modifier.fillMaxWidth()
////                                ) {
////
////                                    Icon(
////                                        Icons.Default.Directions,
////                                        contentDescription = null
////                                    )
////
////                                    Spacer(modifier = Modifier.width(8.dp))
////
////                                    Text("Get Directions")
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////        }
////    }
////}
//package com.example.arogyanidhi.ui.hospitals
//
//import android.content.Intent
//import android.net.Uri
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material.icons.filled.Directions
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.icons.filled.Phone
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HospitalListScreen(
//    viewModel: HospitalViewModel,
//    onNavigateBack: () -> Unit
//) {
//    val hospitals by viewModel.hospitals.collectAsState()
//    val profileDistrict by viewModel.profileDistrict.collectAsState()
//    val context = LocalContext.current
//
//    // ✅ FEATURE 3: Pre-fill search with user's district from Profile
//    // If they saved "Bangalore Urban" in profile, search bar starts with that
//    var searchQuery by remember(profileDistrict) {
//        mutableStateOf(profileDistrict)
//    }
//
//    val filteredHospitals = remember(hospitals, searchQuery) {
//        if (searchQuery.isBlank()) {
//            hospitals
//        } else {
//            hospitals.filter { hospital ->
//                hospital.district.contains(searchQuery.trim(), ignoreCase = true) ||
//                        hospital.name.contains(searchQuery.trim(), ignoreCase = true)
//            }
//        }
//    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Empaneled Hospitals", color = Color.White) },
//                navigationIcon = {
//                    IconButton(onClick = onNavigateBack) {
//                        Icon(
//                            Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back",
//                            tint = Color.White
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xFF1B5E20),
//                    titleContentColor = Color.White,
//                    navigationIconContentColor = Color.White
//                )
//            )
//        }
//    ) { padding ->
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    Brush.verticalGradient(
//                        colors = listOf(Color(0xFFE8F5E9), Color.White)
//                    )
//                )
//                .padding(padding)
//                .padding(16.dp)
//        ) {
//
//            // ✅ Search bar — pre-filled with profile district if available
//            OutlinedTextField(
//                value = searchQuery,
//                onValueChange = { searchQuery = it },
//                label = {
//                    Text(
//                        if (profileDistrict.isNotBlank())
//                            "Showing hospitals near ${profileDistrict}"
//                        else
//                            "Search by District"
//                    )
//                },
//                leadingIcon = {
//                    Icon(Icons.Default.Search, contentDescription = null)
//                },
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(14.dp),
//                colors = OutlinedTextFieldDefaults.colors(
//                    focusedBorderColor = Color(0xFF2E7D32),
//                    focusedLabelColor = Color(0xFF2E7D32),
//                    cursorColor = Color(0xFF2E7D32)
//                )
//            )
//
//            // Show hint if district came from profile
//            if (profileDistrict.isNotBlank()) {
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = "📍 Based on your saved district. You can change it above.",
//                    style = MaterialTheme.typography.bodySmall,
//                    color = Color(0xFF2E7D32)
//                )
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            if (filteredHospitals.isEmpty()) {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                        Text(
//                            text = "No hospitals found",
//                            color = Color.Gray,
//                            style = MaterialTheme.typography.titleMedium
//                        )
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(
//                            text = "Try searching a different district name",
//                            color = Color.Gray,
//                            style = MaterialTheme.typography.bodySmall
//                        )
//                    }
//                }
//            } else {
//                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
//                    items(filteredHospitals) { hospital ->
//                        Card(
//                            modifier = Modifier.fillMaxWidth(),
//                            shape = RoundedCornerShape(20.dp),
//                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//                            colors = CardDefaults.cardColors(containerColor = Color.White)
//                        ) {
//                            Column(modifier = Modifier.padding(18.dp)) {
//
//                                Text(
//                                    text = hospital.name,
//                                    style = MaterialTheme.typography.titleMedium,
//                                    fontWeight = FontWeight.Bold,
//                                    color = Color(0xFF1B5E20)
//                                )
//
//                                Spacer(modifier = Modifier.height(4.dp))
//
//                                Text(
//                                    text = hospital.type,
//                                    color = Color(0xFF2E7D32),
//                                    style = MaterialTheme.typography.bodySmall
//                                )
//
//                                Spacer(modifier = Modifier.height(10.dp))
//
//                                Row(verticalAlignment = Alignment.CenterVertically) {
//                                    Icon(
//                                        Icons.Default.LocationOn,
//                                        contentDescription = null,
//                                        tint = Color.Gray,
//                                        modifier = Modifier.size(16.dp)
//                                    )
//                                    Spacer(modifier = Modifier.width(6.dp))
//                                    Text(
//                                        text = hospital.address,
//                                        style = MaterialTheme.typography.bodySmall
//                                    )
//                                }
//
//                                Spacer(modifier = Modifier.height(4.dp))
//
//                                Text(
//                                    text = "District: ${hospital.district}",
//
//
//
//
//
//                                    color = Color.DarkGray,
//                                    style = MaterialTheme.typography.bodySmall
//                                )
//
//                                Spacer(modifier = Modifier.height(4.dp))
//
//                                Row(verticalAlignment = Alignment.CenterVertically) {
//                                    Icon(
//                                        Icons.Default.Phone,
//                                        contentDescription = null,
//                                        tint = Color.Gray,
//                                        modifier = Modifier.size(16.dp)
//                                    )
//                                    Spacer(modifier = Modifier.width(6.dp))
//                                    Text(
//                                        text = hospital.contact,
//                                        style = MaterialTheme.typography.bodySmall
//                                    )
//                                }
//
//                                Spacer(modifier = Modifier.height(16.dp))
//
//                                Button(
//                                    onClick = {
//                                        val uri = Uri.parse(
//                                            "google.navigation:q=${hospital.latitude},${hospital.longitude}"
//                                        )
//                                        val intent = Intent(Intent.ACTION_VIEW, uri)
//                                        intent.setPackage("com.google.android.apps.maps")
//                                        context.startActivity(intent)
//                                    },
//                                    colors = ButtonDefaults.buttonColors(
//                                        containerColor = Color(0xFFFB8C00)
//                                    ),
//                                    shape = RoundedCornerShape(12.dp),
//                                    modifier = Modifier.fillMaxWidth()
//                                ) {
//                                    Icon(Icons.Default.Directions, contentDescription = null)
//                                    Spacer(modifier = Modifier.width(8.dp))
//                                    Text("Get Directions")
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
package com.example.arogyanidhi.ui.hospitals

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalListScreen(
    viewModel: HospitalViewModel,
    onNavigateBack: () -> Unit
) {
    val hospitals by viewModel.hospitals.collectAsState()
    val profileDistrict by viewModel.profileDistrict.collectAsState()
    val eligibleSchemes by viewModel.eligibleSchemes.collectAsState()
    val context = LocalContext.current

    val comingFromEligibility = eligibleSchemes.isNotEmpty()

    var searchQuery by remember(profileDistrict) {
        mutableStateOf(profileDistrict)
    }

    // Filter by search query on top of already-sorted list
    val filteredHospitals = remember(hospitals, searchQuery) {
        if (searchQuery.isBlank()) {
            hospitals
        } else {
            hospitals.filter { hospital ->
                hospital.district.contains(searchQuery.trim(), ignoreCase = true) ||
                        hospital.name.contains(searchQuery.trim(), ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (comingFromEligibility)
                            "Hospitals for Your Schemes"
                        else
                            "Empaneled Hospitals",
                        color = Color.White
                    )
                },
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
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFE8F5E9), Color.White)
                    )
                )
                .padding(padding)
                .padding(16.dp)
        ) {

            // ── ELIGIBLE SCHEMES BANNER ──
            // Shown only when coming from eligibility screen
            if (comingFromEligibility) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE8F5E9)
                    ),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "🏥 Showing hospitals for your eligible schemes",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B5E20),
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        // Scheme chips
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(eligibleSchemes) { scheme ->
                                Surface(
                                    shape = RoundedCornerShape(20.dp),
                                    color = Color(0xFF2E7D32)
                                ) {
                                    Text(
                                        text = scheme,
                                        color = Color.White,
                                        fontSize = 11.sp,
                                        modifier = Modifier.padding(
                                            horizontal = 10.dp, vertical = 4.dp
                                        )
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "✅ Green bordered cards accept your scheme",
                            color = Color(0xFF388E3C),
                            fontSize = 11.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            // ── SEARCH BAR ──
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = {
                    Text(
                        if (profileDistrict.isNotBlank())
                            "Showing hospitals near $profileDistrict"
                        else
                            "Search by District or Hospital Name"
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF2E7D32),
                    focusedLabelColor = Color(0xFF2E7D32),
                    cursorColor = Color(0xFF2E7D32)
                )
            )

            if (profileDistrict.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "📍 Based on your saved district. You can change it above.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF2E7D32)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ── RESULTS COUNT ──
            Text(
                text = "${filteredHospitals.size} hospitals found",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ── HOSPITAL LIST ──
            if (filteredHospitals.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Default.LocalHospital,
                            contentDescription = null,
                            tint = Color.LightGray,
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "No hospitals found",
                            color = Color.Gray,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Try searching a different district name",
                            color = Color.Gray,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredHospitals) { hospital ->

                        // ✅ Check if this hospital matches user's eligible schemes
                        val isMatch = viewModel.isSchemeMatch(hospital)

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                // Green border for scheme-matching hospitals
                                .then(
                                    if (isMatch)
                                        Modifier.border(
                                            width = 2.dp,
                                            color = Color(0xFF2E7D32),
                                            shape = RoundedCornerShape(20.dp)
                                        )
                                    else Modifier
                                ),
                            shape = RoundedCornerShape(20.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = if (isMatch) 6.dp else 2.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isMatch)
                                    Color(0xFFF1F8E9) // light green tint
                                else
                                    Color.White
                            )
                        ) {
                            Column(modifier = Modifier.padding(18.dp)) {

                                // Header row — name + match badge
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = hospital.name,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF1B5E20),
                                        modifier = Modifier.weight(1f)
                                    )
                                    if (isMatch) {
                                        Surface(
                                            shape = RoundedCornerShape(8.dp),
                                            color = Color(0xFF2E7D32)
                                        ) {
                                            Text(
                                                text = "✅ Your Scheme",
                                                color = Color.White,
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(
                                                    horizontal = 8.dp, vertical = 3.dp
                                                )
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                // Hospital type
                                Text(
                                    text = hospital.type,
                                    color = Color(0xFF2E7D32),
                                    style = MaterialTheme.typography.bodySmall
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                // Address
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        Icons.Default.LocationOn,
                                        contentDescription = null,
                                        tint = Color.Gray,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = hospital.address,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = "District: ${hospital.district}",
                                    color = Color.DarkGray,
                                    style = MaterialTheme.typography.bodySmall
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                // Phone
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        Icons.Default.Phone,
                                        contentDescription = null,
                                        tint = Color.Gray,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = hospital.contact,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }

                                // ✅ ACCEPTED SCHEMES LIST
                                if (hospital.acceptedSchemes.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Accepted Schemes:",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.DarkGray
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    hospital.acceptedSchemes.forEach { scheme ->
                                        val schemeIsEligible = eligibleSchemes.any { e ->
                                            scheme.contains(e, ignoreCase = true) ||
                                                    e.contains(scheme, ignoreCase = true)
                                        }
                                        Text(
                                            text = if (schemeIsEligible)
                                                "✅ $scheme"
                                            else
                                                "• $scheme",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = if (schemeIsEligible)
                                                Color(0xFF2E7D32)
                                            else
                                                Color.Gray
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                // Get Directions button
                                Button(
                                    onClick = {
                                        val uri = Uri.parse(
                                            "google.navigation:q=${hospital.latitude},${hospital.longitude}"
                                        )
                                        val intent = Intent(Intent.ACTION_VIEW, uri)
                                        intent.setPackage("com.google.android.apps.maps")
                                        context.startActivity(intent)
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFFB8C00)
                                    ),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Icon(
                                        Icons.Default.Directions,
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Get Directions")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}