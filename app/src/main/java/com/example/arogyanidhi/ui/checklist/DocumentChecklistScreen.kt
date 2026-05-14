package com.example.arogyanidhi.ui.checklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.arogyanidhi.domain.model.Scheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentChecklistScreen(
    scheme: Scheme,
    onNavigateBack: () -> Unit
) {

    val checkedStates = remember {
        mutableStateListOf<Boolean>().apply {
            repeat(scheme.documentsRequired.size) {
                add(false)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("${scheme.name} Documents")
                },
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
                .padding(16.dp)
        ) {

            Text(
                text = "Required Documents",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {

                itemsIndexed(scheme.documentsRequired) { index, doc ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {

                            Checkbox(
                                checked = checkedStates[index],
                                onCheckedChange = {
                                    checkedStates[index] = it
                                }
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = doc,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}