package com.example.arogyanidhi.ui.eligibility

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EligibilityScreen(
    viewModel: EligibilityViewModel,
    navController: NavController,
    onNavigateBack: () -> Unit
) {
    val eligibilityData by viewModel.eligibilityData.collectAsState()
    val eligibleSchemes by viewModel.eligibleSchemes.collectAsState()

    var currentStep by remember { mutableStateOf(0) }
    var errorMessage by remember { mutableStateOf("") }
    var eligibilityChecked by remember { mutableStateOf(false) }

    var occupationExpanded by remember { mutableStateOf(false) }
    var stateExpanded by remember { mutableStateOf(false) }

    val occupations = listOf(
        "Farmer", "Daily Wage Worker", "Self Employed",
        "Salaried Employee", "Government Employee",
        "Private Employee", "Business Owner", "Shopkeeper",
        "Student", "Teacher", "Driver",
        "Construction Worker", "Labourer", "Housewife",
        "Unemployed", "Retired", "Healthcare Worker",
        "Tailor", "Electrician", "Plumber"
    )

    val states = listOf(
        "Andhra Pradesh", "Arunachal Pradesh", "Assam",
        "Bihar", "Chhattisgarh", "Goa", "Gujarat",
        "Haryana", "Himachal Pradesh", "Jharkhand",
        "Karnataka", "Kerala", "Madhya Pradesh",
        "Maharashtra", "Manipur", "Meghalaya", "Mizoram",
        "Nagaland", "Odisha", "Punjab", "Rajasthan",
        "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
        "Uttar Pradesh", "Uttarakhand", "West Bengal",
        "Andaman and Nicobar Islands", "Chandigarh",
        "Dadra and Nagar Haveli and Daman and Diu",
        "Delhi", "Jammu and Kashmir", "Ladakh",
        "Lakshadweep", "Puducherry"
    )

    val genders = listOf("Male", "Female", "Other")

    // Step labels for progress indicator
    val stepLabels = listOf(
        "Finance", "Occupation",
        "Gender", "Age",
        "Disability", "State"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Eligibility Checker") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1B5E20),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                ),
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
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE8F5E9),
                            Color.White
                        )
                    )
                )
                .padding(padding)
                .padding(16.dp)
        ) {

            if (!eligibilityChecked) {

                // ── STEP PROGRESS INDICATOR ──────────────
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    stepLabels.forEachIndexed { index, label ->
                        Column(
                            horizontalAlignment =
                                Alignment.CenterHorizontally
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(32.dp)
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(50),
                                    color = if (index <= currentStep)
                                        Color(0xFF2E7D32)
                                    else
                                        Color(0xFFBDBDBD),
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Box(
                                        contentAlignment =
                                            Alignment.Center
                                    ) {
                                        Text(
                                            text = "${index + 1}",
                                            color = Color.White,
                                            style = MaterialTheme
                                                .typography.labelMedium
                                        )
                                    }
                                }
                            }
                            Text(
                                text = label,
                                style = MaterialTheme
                                    .typography.labelSmall,
                                color = if (index <= currentStep)
                                    Color(0xFF2E7D32)
                                else
                                    Color.Gray
                            )
                        }
                    }
                }

                // ── ERROR MESSAGE ────────────────────────
                if (errorMessage.isNotEmpty()) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFEBEE)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = errorMessage,
                            color = Color.Red,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }

                when (currentStep) {

                    // ── STEP 1: FINANCIAL INFO ───────────
                    0 -> {
                        StepHeader("Step 1: Financial Information")
                        Spacer(modifier = Modifier.height(20.dp))

                        OutlinedTextField(
                            value = if (eligibilityData.income == 0.0)
                                "" else eligibilityData.income.toString(),
                            onValueChange = {
                                viewModel.updateIncome(
                                    it.toDoubleOrNull() ?: 0.0
                                )
                            },
                            label = { Text("Annual Income (₹)") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF2E7D32),
                                focusedLabelColor = Color(0xFF2E7D32),
                                cursorColor = Color(0xFF2E7D32)
                            )
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = eligibilityData.isBpl,
                                onCheckedChange = {
                                    viewModel.updateBpl(it)
                                }
                            )
                            Text("BPL Status")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        NextButton {
                            if (eligibilityData.income <= 0.0) {
                                errorMessage =
                                    "Please enter valid income"
                            } else {
                                errorMessage = ""
                                currentStep = 1
                            }
                        }
                    }

                    // ── STEP 2: OCCUPATION ───────────────
                    1 -> {
                        StepHeader("Step 2: Occupation")
                        Spacer(modifier = Modifier.height(20.dp))

                        ExposedDropdownMenuBox(
                            expanded = occupationExpanded,
                            onExpandedChange = {
                                occupationExpanded = !occupationExpanded
                            }
                        ) {
                            OutlinedTextField(
                                value = eligibilityData.occupation,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Select Occupation") },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults
                                        .TrailingIcon(
                                            expanded = occupationExpanded
                                        )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .menuAnchor(),
                                shape = RoundedCornerShape(14.dp)
                            )

                            ExposedDropdownMenu(
                                expanded = occupationExpanded,
                                onDismissRequest = {
                                    occupationExpanded = false
                                }
                            ) {
                                occupations.forEach { occ ->
                                    DropdownMenuItem(
                                        text = { Text(occ) },
                                        onClick = {
                                            viewModel.updateOccupation(occ)
                                            occupationExpanded = false
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        NextButton {
                            if (eligibilityData.occupation.isBlank()) {
                                errorMessage =
                                    "Please select occupation"
                            } else {
                                errorMessage = ""
                                currentStep = 2
                            }
                        }
                    }

                    // ── STEP 3: GENDER ───────────────────
                    2 -> {
                        StepHeader("Step 3: Gender")
                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            shape = RoundedCornerShape(14.dp),
                            elevation = CardDefaults.cardElevation(2.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                genders.forEach { gender ->
                                    Row(
                                        verticalAlignment =
                                            Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                    ) {
                                        RadioButton(
                                            selected =
                                                eligibilityData.gender
                                                        == gender,
                                            onClick = {
                                                viewModel
                                                    .updateGender(gender)
                                            },
                                            colors =
                                                RadioButtonDefaults.colors(
                                                    selectedColor =
                                                        Color(0xFF2E7D32)
                                                )
                                        )
                                        Text(
                                            text = gender,
                                            modifier = Modifier
                                                .padding(start = 8.dp)
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        NextButton {
                            if (eligibilityData.gender.isBlank()) {
                                errorMessage = "Please select gender"
                            } else {
                                errorMessage = ""
                                currentStep = 3
                            }
                        }
                    }

                    // ── STEP 4: DISABILITY ───────────────
                    // ── STEP 4: AGE ─────────────────────
                    3 -> {
                        StepHeader("Step 4: Age")
                        Spacer(modifier = Modifier.height(20.dp))

                        OutlinedTextField(
                            value = if (eligibilityData.age == 0)
                                "" else eligibilityData.age.toString(),
                            onValueChange = {
                                viewModel.updateAge(
                                    it.toIntOrNull() ?: 0
                                )
                            },
                            label = { Text("Enter Age") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF2E7D32),
                                focusedLabelColor = Color(0xFF2E7D32),
                                cursorColor = Color(0xFF2E7D32)
                            )
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        NextButton {
                            if (eligibilityData.age <= 0) {
                                errorMessage = "Please enter valid age"
                            } else {
                                errorMessage = ""
                                currentStep = 4
                            }
                        }
                    }





                    4 -> {
                        StepHeader("Step 4: Disability")
                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            shape = RoundedCornerShape(14.dp),
                            elevation = CardDefaults.cardElevation(2.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                verticalAlignment =
                                    Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Checkbox(
                                    checked =
                                        eligibilityData.hasDisability,
                                    onCheckedChange = {
                                        viewModel.updateDisability(it)
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFF2E7D32)
                                    )
                                )
                                Column(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                ) {
                                    Text(
                                        text = "Do you have a disability?",
                                        style = MaterialTheme
                                            .typography.titleSmall
                                    )
                                    Text(
                                        text = "Check if you have 40%+ " +
                                                "certified disability",
                                        style = MaterialTheme
                                            .typography.bodySmall,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        NextButton {
                            errorMessage = ""
                            currentStep = 5
                        }
                    }

                    // ── STEP 5: STATE ────────────────────
                    5-> {
                        StepHeader("Step 5: State")
                        Spacer(modifier = Modifier.height(20.dp))

                        ExposedDropdownMenuBox(
                            expanded = stateExpanded,
                            onExpandedChange = {
                                stateExpanded = !stateExpanded
                            }
                        ) {
                            OutlinedTextField(
                                value = eligibilityData.state,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Select State") },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults
                                        .TrailingIcon(
                                            expanded = stateExpanded
                                        )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .menuAnchor(),
                                shape = RoundedCornerShape(14.dp)
                            )

                            ExposedDropdownMenu(
                                expanded = stateExpanded,
                                onDismissRequest = {
                                    stateExpanded = false
                                }
                            ) {
                                states.forEach { state ->
                                    DropdownMenuItem(
                                        text = { Text(state) },
                                        onClick = {
                                            viewModel.updateState(state)
                                            stateExpanded = false
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = {
                                if (eligibilityData.state.isBlank()) {
                                    errorMessage = "Please select state"
                                } else {
                                    errorMessage = ""
                                    eligibilityChecked = true
                                    viewModel.checkEligibility()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFB8C00)
                            ),
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp)
                        ) {
                            Text("Check Eligibility")
                        }
                    }
                }

            } else {

                // ── RESULTS ──────────────────────────────
                if (eligibleSchemes.isEmpty()) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFEBEE)
                        ),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                text = "No eligible schemes found 😔",
                                style = MaterialTheme
                                    .typography.titleLarge,
                                color = Color(0xFFC62828)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Try adjusting your income " +
                                        "or other details.",
                                color = Color.Gray
                            )
                        }
                    }

                } else {

                    Text(
                        text = "🎉 You qualify for " +
                                "${eligibleSchemes.size} schemes!",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF1B5E20)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn {
                        items(eligibleSchemes) { scheme ->
                            Card(
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 6.dp
                                ),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                )
                            ) {
                                Column(
                                    modifier = Modifier.padding(18.dp)
                                ) {
                                    Text(
                                        text = scheme.name,
                                        style = MaterialTheme
                                            .typography.titleMedium,
                                        color = Color(0xFF1B5E20)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = scheme.category,
                                        style = MaterialTheme
                                            .typography.labelSmall,
                                        color = Color(0xFFFB8C00)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = scheme.description,
                                        color = Color.DarkGray
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))

                                    // Documents needed
                                    if (scheme.documentsRequired
                                            .isNotEmpty()
                                    ) {
                                        Text(
                                            text = "📋 Documents Needed:",
                                            style = MaterialTheme
                                                .typography.labelMedium,
                                            color = Color(0xFF2E7D32)
                                        )
                                        Spacer(
                                            modifier =
                                                Modifier.height(4.dp)
                                        )
                                        scheme.documentsRequired
                                            .forEach { doc ->
                                                Text(
                                                    text = "• $doc",
                                                    style = MaterialTheme
                                                        .typography.bodySmall,
                                                    color = Color.DarkGray
                                                )
                                            }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        viewModel.resetEligibility()
                        eligibilityChecked = false
                        currentStep = 0
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1B5E20)
                    ),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text("Check Again")
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedButton(
                    onClick = onNavigateBack,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text("Go Back")
                }
            }
        }
    }
}

// ── REUSABLE COMPOSABLES ──────────────────────────────────────

@Composable
private fun StepHeader(title: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2E7D32)
        ),
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
private fun NextButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFB8C00)
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {
        Text("Next")
    }
}