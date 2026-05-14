//package com.example.arogyanidhi.ui.schemes
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SchemeDetailScreen(
//    schemeId: String,
//    viewModel: SchemeDetailViewModel,
//    onNavigateBack: () -> Unit
//) {
//    val scheme by viewModel.scheme.collectAsState()
//    val documents by viewModel.documents.collectAsState()
//
//    LaunchedEffect(schemeId) {
//        viewModel.loadScheme(schemeId)
//    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(scheme?.name ?: "Scheme Details") },
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
//            scheme?.let {
//                Text(text = it.description, style = MaterialTheme.typography.bodyLarge)
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(text = "Required Documents", style = MaterialTheme.typography.titleMedium)
//
//                LazyColumn(modifier = Modifier.weight(1f)) {
//                    items(documents) { doc ->
//                        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
//                            Checkbox(
//                                checked = doc.isReady,
//                                onCheckedChange = { viewModel.toggleDocument(doc) }
//                            )
//                            Text(text = doc.name)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
package com.example.arogyanidhi.ui.schemes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchemeDetailScreen(
    schemeId: String,
    viewModel: SchemeDetailViewModel,
    onNavigateBack: () -> Unit
) {
    val scheme by viewModel.scheme.collectAsState()
    val documents by viewModel.documents.collectAsState()

    LaunchedEffect(schemeId) {
        viewModel.loadScheme(schemeId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = scheme?.name ?: "Scheme Details",
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
                .padding(padding)
                .padding(16.dp)
        ) {
            scheme?.let { s ->

                // Description card
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = s.category,
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFFB8C00),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = s.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.DarkGray
                        )
                        if (s.benefits.isNotBlank()) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Benefit: ${s.benefits}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF1B5E20),
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Documents section header
                Text(
                    text = "📋 Required Documents",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B5E20)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Document checklist
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(documents) { doc ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (doc.isReady)
                                    Color(0xFFE8F5E9)
                                else
                                    Color.White
                            ),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Checkbox(
                                    checked = doc.isReady,
                                    onCheckedChange = { viewModel.toggleDocument(doc) },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFF1B5E20)
                                    )
                                )
                                Text(
                                    text = doc.name,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = if (doc.isReady) Color(0xFF1B5E20) else Color.DarkGray
                                )
                            }
                        }
                    }
                }

                // Progress summary
                if (documents.isNotEmpty()) {
                    val readyCount = documents.count { it.isReady }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$readyCount of ${documents.size} documents ready",
                        style = MaterialTheme.typography.bodySmall,
                        color = if (readyCount == documents.size) Color(0xFF1B5E20) else Color.Gray,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}