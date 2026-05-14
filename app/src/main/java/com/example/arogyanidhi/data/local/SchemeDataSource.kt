////package com.example.arogyanidhi.data.local
////
////import com.example.arogyanidhi.domain.model.Scheme
////
////object SchemeDataSource {
////
////    val allSchemes: List<Scheme> = listOf(
////
////        // ─────────────────────────────────────────
////        // 1. AYUSHMAN BHARAT (PM-JAY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "pmjay",
////            name = "Ayushman Bharat (PM-JAY)",
////            description = "Free health coverage up to ₹5 lakh per family " +
////                    "per year for secondary and tertiary hospitalization.",
////            eligibilityCriteria = "BPL family. Annual income below ₹1,00,000.",
////            documentsRequired = listOf(
////                "Aadhar Card (all family members)",
////                "BPL Ration Card",
////                "Income Certificate (below ₹1 lakh)",
////                "Family Photo (passport size)",
////                "Bank Passbook (first page)"
////            ),
////            benefits = "Cashless treatment up to ₹5 lakh/year at empaneled " +
////                    "hospitals. Covers surgery, ICU, medicines.",
////            applicationProcess = "Visit nearest Common Service Centre (CSC) " +
////                    "or empaneled hospital help desk with documents.",
////            category = "Health",
////            maxIncome = 100000,
////            requiresBPL = true,
////            occupations = emptyList(),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://pmjay.gov.in",
////            iconCategory = "health",
////            requiredGender = "",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 2. RASHTRIYA SWASTHYA BIMA YOJANA (RSBY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "rsby",
////            name = "Rashtriya Swasthya Bima Yojana (RSBY)",
////            description = "Health insurance coverage of ₹30,000 per family " +
////                    "per year for BPL families.",
////            eligibilityCriteria = "BPL household. Annual income below ₹1,50,000.",
////            documentsRequired = listOf(
////                "Aadhar Card",
////                "BPL Ration Card",
////                "Income Certificate",
////                "Proof of Residence",
////                "Family Photograph"
////            ),
////            benefits = "Cashless hospitalization up to ₹30,000. " +
////                    "Covers pre-existing diseases from day one.",
////            applicationProcess = "Register at district office or enrollment " +
////                    "camp with BPL card.",
////            category = "Health",
////            maxIncome = 150000,
////            requiresBPL = true,
////            occupations = emptyList(),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://rsby.gov.in",
////            iconCategory = "health",
////            requiredGender = "",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 3. JANANI SURAKSHA YOJANA (JSY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "jsy",
////            name = "Janani Suraksha Yojana (JSY)",
////            description = "Cash assistance to pregnant women for " +
////                    "institutional delivery.",
////            eligibilityCriteria = "Pregnant women from BPL or SC/ST families.",
////            documentsRequired = listOf(
////                "Aadhar Card (mother)",
////                "BPL / SC / ST Certificate",
////                "Mother & Child Protection (MCP) Card",
////                "Bank Account Details (for DBT)",
////                "Pregnancy Certificate from doctor/ANM",
////                "Proof of Residence"
////            ),
////            benefits = "₹1,400 cash for rural delivery, ₹1,000 for urban.",
////            applicationProcess = "Register at nearest Anganwadi Centre or " +
////                    "PHC with your ANM worker.",
////            category = "Health",
////            maxIncome = 200000,
////            requiresBPL = false,
////            occupations = emptyList(),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://nhm.gov.in",
////            iconCategory = "health",
////            requiredGender = "Female",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 4. PM MUDRA YOJANA (PMMY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "pmmy",
////            name = "PM Mudra Yojana (PMMY)",
////            description = "Loans up to ₹10 lakh for small businesses " +
////                    "and micro-enterprises.",
////            eligibilityCriteria = "Any Indian citizen with a small business. " +
////                    "No collateral required.",
////            documentsRequired = listOf(
////                "Aadhar Card",
////                "PAN Card",
////                "Business Plan / Proof of Business",
////                "Bank Statement (last 6 months)",
////                "Proof of Residence",
////                "2 Passport Size Photos",
////                "Caste Certificate (if SC/ST/OBC)"
////            ),
////            benefits = "Shishu: up to ₹50,000 | Kishore: ₹50K–5 lakh | " +
////                    "Tarun: ₹5–10 lakh. No collateral.",
////            applicationProcess = "Apply at any bank or online at mudra.org.in.",
////            category = "Employment",
////            maxIncome = Int.MAX_VALUE,
////            requiresBPL = false,
////            occupations = listOf(
////                "Business Owner", "Self Employed",
////                "Shopkeeper", "Farmer"
////            ),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://www.mudra.org.in",
////            iconCategory = "employment",
////            requiredGender = "",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 5. ATAL PENSION YOJANA (APY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "apy",
////            name = "Atal Pension Yojana (APY)",
////            description = "Guaranteed pension for unorganised sector " +
////                    "workers after age 60.",
////            eligibilityCriteria = "Indian citizen aged 18–40 with savings " +
////                    "bank account. Not a taxpayer.",
////            documentsRequired = listOf(
////                "Aadhar Card",
////                "Savings Bank Account",
////                "Mobile Number linked to bank",
////                "Date of Birth Proof",
////                "Nominee details with Aadhar"
////            ),
////            benefits = "Guaranteed monthly pension of ₹1,000–₹5,000 " +
////                    "after age 60.",
////            applicationProcess = "Visit bank branch or apply via net banking.",
////            category = "Social Security",
////            maxIncome = Int.MAX_VALUE,
////            requiresBPL = false,
////            occupations = listOf(
////                "Farmer", "Daily Wage Worker",
////                "Construction Worker", "Labourer",
////                "Tailor", "Electrician", "Plumber",
////                "Driver", "Housewife", "Unemployed"
////            ),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://npscra.nsdl.co.in",
////            iconCategory = "pension",
////            requiredGender = "",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 6. PM JEEVAN JYOTI BIMA YOJANA (PMJJBY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "pmjjby",
////            name = "PM Jeevan Jyoti Bima Yojana (PMJJBY)",
////            description = "Life insurance cover of ₹2 lakh at just " +
////                    "₹436 per year.",
////            eligibilityCriteria = "Age 18–50 with a savings bank account.",
////            documentsRequired = listOf(
////                "Aadhar Card",
////                "Savings Bank Account",
////                "Mobile Number",
////                "Enrollment Form (from bank)",
////                "Nominee details"
////            ),
////            benefits = "₹2 lakh life insurance. Only ₹436/year.",
////            applicationProcess = "Visit bank branch or apply via mobile banking.",
////            category = "Insurance",
////            maxIncome = Int.MAX_VALUE,
////            requiresBPL = false,
////            occupations = emptyList(),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://jansuraksha.gov.in",
////            iconCategory = "insurance",
////            requiredGender = "",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 7. PM SURAKSHA BIMA YOJANA (PMSBY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "pmsby",
////            name = "PM Suraksha Bima Yojana (PMSBY)",
////            description = "Accident insurance cover of ₹2 lakh at " +
////                    "only ₹20 per year.",
////            eligibilityCriteria = "Age 18–70 with a savings bank account.",
////            documentsRequired = listOf(
////                "Aadhar Card",
////                "Savings Bank Account",
////                "Mobile Number",
////                "Enrollment Form (from bank)"
////            ),
////            benefits = "₹2 lakh for accidental death. ₹1 lakh for " +
////                    "partial disability. Only ₹20/year.",
////            applicationProcess = "Enroll at bank branch or via mobile banking.",
////            category = "Insurance",
////            maxIncome = Int.MAX_VALUE,
////            requiresBPL = false,
////            occupations = emptyList(),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://jansuraksha.gov.in",
////            iconCategory = "insurance",
////            requiredGender = "",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 8. PM KISAN SAMMAN NIDHI
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "pmkisan",
////            name = "PM Kisan Samman Nidhi",
////            description = "₹6,000 per year direct income support to " +
////                    "small and marginal farmers.",
////            eligibilityCriteria = "Small/marginal farmer owning " +
////                    "up to 2 hectares of land.",
////            documentsRequired = listOf(
////                "Aadhar Card",
////                "Land Ownership Document (RTC / Pahani)",
////                "Savings Bank Account",
////                "Mobile Number",
////                "Caste Certificate (if SC/ST)"
////            ),
////            benefits = "₹6,000/year in 3 installments of ₹2,000 " +
////                    "directly to bank account.",
////            applicationProcess = "Apply via PM-KISAN portal or CSC " +
////                    "with land documents.",
////            category = "Agriculture",
////            maxIncome = Int.MAX_VALUE,
////            requiresBPL = false,
////            occupations = listOf("Farmer"),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://pmkisan.gov.in",
////            iconCategory = "agriculture",
////            requiredGender = "",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 9. PRADHAN MANTRI AWAS YOJANA (PMAY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "pmay",
////            name = "Pradhan Mantri Awas Yojana (PMAY)",
////            description = "Housing subsidy for EWS/LIG families to " +
////                    "build or buy a pucca house.",
////            eligibilityCriteria = "Annual income below ₹6 lakh. " +
////                    "No pucca house owned by family.",
////            documentsRequired = listOf(
////                "Aadhar Card (all family members)",
////                "Income Certificate",
////                "BPL Certificate (if applicable)",
////                "Land / Property Documents",
////                "Bank Account Details",
////                "Caste Certificate",
////                "No-house Ownership Affidavit"
////            ),
////            benefits = "Subsidy of ₹2.67 lakh on home loan interest.",
////            applicationProcess = "Apply at Common Service Centre or " +
////                    "PMAY official website.",
////            category = "Housing",
////            maxIncome = 600000,
////            requiresBPL = false,
////            occupations = emptyList(),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://pmaymis.gov.in",
////            iconCategory = "housing",
////            requiredGender = "",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 10. SUKANYA SAMRIDDHI YOJANA (SSY)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "ssy",
////            name = "Sukanya Samriddhi Yojana",
////            description = "High-interest savings scheme for girl child " +
////                    "education and marriage expenses.",
////            eligibilityCriteria = "Girl child below 10 years. " +
////                    "Only 2 accounts per family.",
////            documentsRequired = listOf(
////                "Girl Child's Birth Certificate",
////                "Aadhar Card (parent/guardian)",
////                "Proof of Residence",
////                "Photograph of child and parent",
////                "Initial Deposit (minimum ₹250)"
////            ),
////            benefits = "8.2% interest rate (tax-free). Matures at age 21.",
////            applicationProcess = "Open account at any post office or bank.",
////            category = "Social Welfare",
////            maxIncome = Int.MAX_VALUE,
////            requiresBPL = false,
////            occupations = emptyList(),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://www.indiapost.gov.in",
////            iconCategory = "welfare",
////            requiredGender = "Female",
////            requiresDisability = false
////        ),
////
////        // ─────────────────────────────────────────
////        // 11. ADIP SCHEME (Disability - BONUS)
////        // ─────────────────────────────────────────
////        Scheme(
////            id = "adip",
////            name = "ADIP Scheme (Disability Aid)",
////            description = "Free assistive devices for persons " +
////                    "with disabilities.",
////            eligibilityCriteria = "Person with disability. " +
////                    "Income below ₹2 lakh.",
////            documentsRequired = listOf(
////                "Aadhar Card",
////                "Disability Certificate (40%+ disability)",
////                "Income Certificate",
////                "Passport Size Photo",
////                "Bank Account Details"
////            ),
////            benefits = "Free hearing aids, wheelchairs, crutches, " +
////                    "artificial limbs and other assistive devices.",
////            applicationProcess = "Apply at District Disability " +
////                    "Rehabilitation Centre (DDRC).",
////            category = "Social Welfare",
////            maxIncome = 200000,
////            requiresBPL = false,
////            occupations = emptyList(),
////            minFamilySize = 0,
////            applicableStates = emptyList(),
////            officialLink = "https://disabilityaffairs.gov.in",
////            iconCategory = "welfare",
////            requiredGender = "",
////            requiresDisability = true
////        )
////    )
////}
//
//
//package com.example.arogyanidhi.data.local
//
//import com.example.arogyanidhi.domain.model.Scheme
//
//object SchemeDataSource {
//
//    val allSchemes = listOf(
//
//        // ── NATIONAL SCHEMES ─────────────────────────────────────────────
//
//        Scheme(
//            id = "1",
//            name = "Ayushman Bharat (PM-JAY)",
//            description = "World's largest health insurance scheme providing ₹5 lakh coverage per family per year for secondary and tertiary hospitalisation.",
//            eligibilityCriteria = "BPL families OR annual income below ₹1,20,000. Covers farmers, daily wage workers, construction workers, and other vulnerable groups.",
//            benefits = "Cashless treatment up to ₹5,00,000/year at any empaneled government or private hospital.",
//            applicationProcess = "Visit your nearest Common Service Centre (CSC) or Ayushman Mitra at empaneled hospital with Aadhaar and ration card.",
//            category = "Health Insurance",
//            maxIncome = 120000,
//            requiresBPL = false,
//            occupations = listOf(
//                "Farmer", "Daily Wage Worker", "Construction Worker",
//                "Labourer", "Housewife", "Unemployed", "Tailor",
//                "Electrician", "Plumber", "Driver"
//            ),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Aadhaar Card (all family members)",
//                "BPL Ration Card",
//                "Income Certificate from Tehsildar",
//                "Passport-size photograph",
//                "Bank passbook (first page)"
//            ),
//            officialLink = "https://pmjay.gov.in",
//            iconCategory = "health"
//        ),
//
//        Scheme(
//            id = "2",
//            name = "Janani Suraksha Yojana (JSY)",
//            description = "Safe motherhood scheme providing cash assistance for institutional delivery to reduce maternal and neonatal mortality.",
//            eligibilityCriteria = "Pregnant women from BPL families or SC/ST category. All pregnant women for deliveries in government health centres.",
//            benefits = "Cash of ₹1,400 (rural) or ₹1,000 (urban) directly to mother after delivery at government hospital.",
//            applicationProcess = "Register at your nearest PHC (Primary Health Centre) during pregnancy.",
//            category = "Maternal Health",
//            maxIncome = 180000,
//            requiresBPL = false,
//            requiredGender = "Female",
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Aadhaar Card",
//                "BPL Card or Income Certificate",
//                "MCH Card (Mother Child Health card from ANM)",
//                "Bank account details (for DBT)"
//            ),
//            officialLink = "https://nhm.gov.in/index1.php?lang=1&level=3&sublinkid=841&lid=309",
//            iconCategory = "health"
//        ),
//
//        Scheme(
//            id = "3",
//            name = "Rashtriya Swasthya Bima Yojana (RSBY)",
//            description = "Health insurance for unorganised sector workers providing hospitalisation coverage up to ₹30,000 per family per year.",
//            eligibilityCriteria = "BPL families in the unorganised sector — includes daily wage workers, domestic workers, construction labourers.",
//            benefits = "Cashless hospitalisation up to ₹30,000/year. Smart card based — works at any empaneled hospital.",
//            applicationProcess = "Enroll through your district labour office or nearest Common Service Centre.",
//            category = "Health Insurance",
//            maxIncome = 100000,
//            requiresBPL = true,
//            occupations = listOf(
//                "Daily Wage Worker", "Construction Worker",
//                "Labourer", "Housewife", "Unemployed", "Driver"
//            ),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "BPL Card (mandatory)",
//                "Aadhaar Card",
//                "Ration Card",
//                "Passport-size photograph (all family members)"
//            ),
//            officialLink = "https://www.rsby.gov.in",
//            iconCategory = "health"
//        ),
//
//        Scheme(
//            id = "4",
//            name = "PM Kisan Samman Nidhi (PM-KISAN)",
//            description = "Direct income support of ₹6,000 per year for farmer families across India in 3 equal instalments.",
//            eligibilityCriteria = "All small and marginal farmer families with cultivable land. Excludes income tax payers, government employees, and pensioners.",
//            benefits = "₹6,000/year directly in bank account in 3 instalments of ₹2,000 each.",
//            applicationProcess = "Apply at your local Patwari / Revenue Officer or online at pmkisan.gov.in with land records.",
//            category = "Agriculture",
//            maxIncome = 300000,
//            requiresBPL = false,
//            occupations = listOf("Farmer"),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Aadhaar Card",
//                "Land Ownership documents (Khasra/Khatauni)",
//                "Bank account details linked to Aadhaar",
//                "Mobile number"
//            ),
//            officialLink = "https://pmkisan.gov.in",
//            iconCategory = "agriculture"
//        ),
//
//        Scheme(
//            id = "5",
//            name = "Atal Pension Yojana (APY)",
//            description = "Government-backed pension scheme for unorganised sector workers ensuring a fixed monthly pension after age 60.",
//            eligibilityCriteria = "Indian citizens aged 18–40 years with a savings bank account. Not an income tax payer.",
//            benefits = "Fixed monthly pension of ₹1,000 to ₹5,000 after age 60, depending on contribution.",
//            applicationProcess = "Apply at your bank branch or through the bank's mobile app. Can also enroll via Common Service Centre.",
//            category = "Social Security",
//            maxIncome = Int.MAX_VALUE,
//            requiresBPL = false,
//            minAge = 18,
//            maxAge = 40,
//            occupations = listOf(
//                "Farmer", "Daily Wage Worker", "Self Employed",
//                "Construction Worker", "Labourer", "Housewife",
//                "Tailor", "Electrician", "Plumber", "Driver",
//                "Shopkeeper"
//            ),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Aadhaar Card",
//                "Active savings bank account",
//                "Mobile number linked to Aadhaar"
//            ),
//            officialLink = "https://npscra.nsdl.co.in/scheme-details.php",
//            iconCategory = "pension"
//        ),
//
//        Scheme(
//            id = "6",
//            name = "PM Jeevan Jyoti Bima Yojana (PMJJBY)",
//            description = "Affordable life insurance scheme providing ₹2 lakh coverage on death due to any reason. Premium is just ₹436/year.",
//            eligibilityCriteria = "Age group 18–50 years with a savings bank account. Auto-debits premium annually.",
//            benefits = "Life cover of ₹2,00,000 to nominee in case of death of insured.",
//            applicationProcess = "Enroll through your bank branch, bank's internet banking, or mobile banking.",
//            category = "Insurance",
//            maxIncome = 300000,
//            requiresBPL = false,
//            minAge = 18,
//            maxAge = 50,
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Aadhaar Card",
//                "Active savings bank account",
//                "Mobile number",
//                "Nominee details"
//            ),
//            officialLink = "https://jansuraksha.gov.in",
//            iconCategory = "insurance"
//        ),
//
//        Scheme(
//            id = "7",
//            name = "PM Suraksha Bima Yojana (PMSBY)",
//            description = "Accidental death and disability insurance at just ₹20/year premium — one of the cheapest safety nets available.",
//            eligibilityCriteria = "Age 18–70 years with a savings bank account. Auto-renews annually.",
//            benefits = "₹2,00,000 for accidental death or full disability. ₹1,00,000 for partial disability.",
//            applicationProcess = "Enroll at your bank branch or through net/mobile banking.",
//            category = "Insurance",
//            maxIncome = Int.MAX_VALUE,
//            requiresBPL = false,
//            minAge = 18,
//            maxAge = 70,
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Aadhaar Card",
//                "Active savings bank account",
//                "Mobile number"
//            ),
//            officialLink = "https://jansuraksha.gov.in",
//            iconCategory = "insurance"
//        ),
//
//        Scheme(
//            id = "8",
//            name = "Pradhan Mantri Awas Yojana – Gramin (PMAY-G)",
//            description = "Affordable housing scheme for rural BPL and low-income families to construct pucca houses with basic amenities.",
//            eligibilityCriteria = "Houseless or living in kutcha/dilapidated house. Priority to SC/ST, BPL, women-headed households.",
//            benefits = "₹1,20,000 (plains) or ₹1,30,000 (hills/NE) financial assistance for house construction. Also covers toilet and cooking gas connection.",
//            applicationProcess = "Apply through Gram Panchayat or online at pmayg.nic.in.",
//            category = "Housing",
//            maxIncome = 200000,
//            requiresBPL = true,
//            occupations = emptyList(),
//            minFamilySize = 1,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "BPL Card",
//                "Aadhaar Card",
//                "Bank account details",
//                "Land ownership document or NOC from Gram Panchayat",
//                "Job Card (if available)"
//            ),
//            officialLink = "https://pmayg.nic.in",
//            iconCategory = "housing"
//        ),
//
//        Scheme(
//            id = "9",
//            name = "Sukanya Samriddhi Yojana (SSY)",
//            description = "High-interest savings scheme for girl child's education and marriage under Beti Bachao Beti Padhao mission.",
//            eligibilityCriteria = "Parents or guardians of a girl child aged below 10 years. Max 2 accounts per family.",
//            benefits = "High interest rate (currently ~8.2%). Full tax exemption under 80C. Matures when girl turns 21.",
//            applicationProcess = "Open account at any post office or bank branch with girl's birth certificate and parent's Aadhaar.",
//            category = "Social Welfare",
//            maxIncome = Int.MAX_VALUE,
//            requiresBPL = false,
//            requiredGender = "Female",
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Girl child's Birth Certificate",
//                "Parent/Guardian Aadhaar Card",
//                "Photograph of parent and girl child",
//                "Address proof"
//            ),
//            officialLink = "https://www.indiapost.gov.in",
//            iconCategory = "welfare"
//        ),
//
//        Scheme(
//            id = "10",
//            name = "Pradhan Mantri Jan Dhan Yojana (PMJDY)",
//            description = "Financial inclusion scheme ensuring every household has a basic bank account with zero balance, RuPay debit card, and insurance cover.",
//            eligibilityCriteria = "Any Indian citizen without a bank account. No minimum balance required.",
//            benefits = "Zero balance savings account, RuPay debit card, ₹2 lakh accident insurance, ₹30,000 life cover, and overdraft up to ₹10,000.",
//            applicationProcess = "Visit any bank branch with Aadhaar card and photo. Account opens same day.",
//            category = "Banking",
//            maxIncome = Int.MAX_VALUE,
//            requiresBPL = false,
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Aadhaar Card",
//                "Passport-size photograph",
//                "Mobile number (optional but recommended)"
//            ),
//            officialLink = "https://pmjdy.gov.in",
//            iconCategory = "banking"
//        ),
//
//        Scheme(
//            id = "11",
//            name = "Disability Pension Scheme (NHFDC)",
//            description = "Financial assistance and loans at concessional rates for persons with disabilities for self-employment and livelihood.",
//            eligibilityCriteria = "Person with minimum 40% certified disability. Income below ₹3,00,000/year.",
//            benefits = "Concessional loans at 5% interest. Monthly pension support via state governments under NSAP.",
//            applicationProcess = "Apply at District Disability Rehabilitation Centre (DDRC) or Social Welfare department.",
//            category = "Disability Support",
//            maxIncome = 300000,
//            requiresBPL = false,
//            requiresDisability = true,
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Disability Certificate (minimum 40%)",
//                "Aadhaar Card",
//                "Income Certificate",
//                "Bank account details",
//                "Passport-size photograph"
//            ),
//            officialLink = "https://nhfdc.nic.in",
//            iconCategory = "disability"
//        ),
//
//        Scheme(
//            id = "12",
//            name = "PM Mudra Yojana (PMMY) – Shishu",
//            description = "Collateral-free small business loans for micro and small entrepreneurs to start or grow their business.",
//            eligibilityCriteria = "Small business owners, shopkeepers, vendors, artisans. Non-farm, non-corporate enterprises.",
//            benefits = "Shishu: loans up to ₹50,000. Kishore: ₹50,000–₹5 lakh. Tarun: ₹5–₹10 lakh. No collateral needed.",
//            applicationProcess = "Apply at any bank, MFI, or NBFC with business plan and Aadhaar. Also available at mudra.org.in.",
//            category = "Employment",
//            maxIncome = 500000,
//            requiresBPL = false,
//            occupations = listOf(
//                "Self Employed", "Shopkeeper", "Tailor",
//                "Electrician", "Plumber", "Driver", "Farmer"
//            ),
//            minFamilySize = 0,
//            applicableStates = emptyList(),
//            documentsRequired = listOf(
//                "Aadhaar Card",
//                "PAN Card",
//                "Business proof / address",
//                "Bank statement (last 6 months)",
//                "Passport-size photograph"
//            ),
//            officialLink = "https://www.mudra.org.in",
//            iconCategory = "employment"
//        ),
//
//        // ── STATE-SPECIFIC SCHEMES ──────────────────────────────────────
//
//        Scheme(
//            id = "13",
//            name = "Aarogyasri Health Care Trust (Andhra Pradesh)",
//            description = "State health insurance for BPL families in Andhra Pradesh providing free treatment for serious illnesses.",
//            eligibilityCriteria = "BPL White Ration Card holders in Andhra Pradesh only.",
//            benefits = "Free treatment for 2,500+ procedures at empaneled hospitals. No cap on coverage amount for listed diseases.",
//            applicationProcess = "Visit any empaneled hospital with White Ration Card. Aarogyamitra at hospital will assist.",
//            category = "Health Insurance",
//            maxIncome = 150000,
//            requiresBPL = true,
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = listOf("Andhra Pradesh"),
//            documentsRequired = listOf(
//                "White Ration Card (BPL)",
//                "Aadhaar Card",
//                "Passport-size photograph"
//            ),
//            officialLink = "https://www.aarogyasri.telangana.gov.in",
//            iconCategory = "health"
//        ),
//
//        Scheme(
//            id = "14",
//            name = "Mahatma Jyotiba Phule Jan Arogya Yojana (Maharashtra)",
//            description = "Health insurance scheme for yellow and orange ration card holders in Maharashtra for major surgeries and procedures.",
//            eligibilityCriteria = "Yellow or Orange ration card holders in Maharashtra. Covers major illnesses, accidents, and surgeries.",
//            benefits = "Coverage up to ₹1,50,000 for listed medical procedures at empaneled hospitals.",
//            applicationProcess = "Visit empaneled hospital with ration card and Aadhaar. District Health Officer can also help.",
//            category = "Health Insurance",
//            maxIncome = 200000,
//            requiresBPL = false,
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = listOf("Maharashtra"),
//            documentsRequired = listOf(
//                "Yellow or Orange Ration Card",
//                "Aadhaar Card",
//                "Photograph"
//            ),
//            officialLink = "https://www.jeevandayee.gov.in",
//            iconCategory = "health"
//        ),
//
//        Scheme(
//            id = "15",
//            name = "Arogyasri (Telangana)",
//            description = "Comprehensive health insurance for BPL families in Telangana covering major medical procedures and hospitalisation.",
//            eligibilityCriteria = "BPL families with white ration card in Telangana.",
//            benefits = "Free treatment for major illnesses. Coverage up to ₹2,00,000 at empaneled hospitals.",
//            applicationProcess = "Register at nearest PHC or directly approach empaneled hospital with ration card.",
//            category = "Health Insurance",
//            maxIncome = 150000,
//            requiresBPL = true,
//            occupations = emptyList(),
//            minFamilySize = 0,
//            applicableStates = listOf("Telangana"),
//            documentsRequired = listOf(
//                "White Ration Card",
//                "Aadhaar Card",
//                "Passport-size photograph"
//            ),
//            officialLink = "https://www.aarogyasri.telangana.gov.in",
//            iconCategory = "health"
//        )
//    )
//}

package com.example.arogyanidhi.data.local

import com.example.arogyanidhi.domain.model.Scheme

object SchemeDataSource {

    val allSchemes = listOf(

        // ── NATIONAL SCHEMES ─────────────────────────────────────────────

        Scheme(
            id = "1",
            name = "Ayushman Bharat (PM-JAY)",
            description = "World's largest health insurance scheme providing ₹5 lakh coverage per family per year for secondary and tertiary hospitalisation.",
            eligibilityCriteria = "BPL families OR annual income below ₹1,20,000. Covers farmers, daily wage workers, construction workers, and other vulnerable groups.",
            benefits = "Cashless treatment up to ₹5,00,000/year at any empaneled government or private hospital.",
            applicationProcess = "Visit your nearest Common Service Centre (CSC) or Ayushman Mitra at empaneled hospital with Aadhaar and ration card.",
            category = "Health Insurance",
            maxIncome = 120000,
            requiresBPL = false,
            occupations = listOf(
                "Farmer", "Daily Wage Worker", "Construction Worker",
                "Labourer", "Housewife", "Unemployed", "Tailor",
                "Electrician", "Plumber", "Driver"
            ),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Aadhaar Card (all family members)",
                "BPL Ration Card",
                "Income Certificate from Tehsildar",
                "Passport-size photograph",
                "Bank passbook (first page)"
            ),
            officialLink = "https://pmjay.gov.in",
            iconCategory = "health"
        ),

        Scheme(
            id = "2",
            name = "Janani Suraksha Yojana (JSY)",
            description = "Safe motherhood scheme providing cash assistance for institutional delivery to reduce maternal and neonatal mortality.",
            eligibilityCriteria = "Pregnant women from BPL families or SC/ST category. All pregnant women for deliveries in government health centres.",
            benefits = "Cash of ₹1,400 (rural) or ₹1,000 (urban) directly to mother after delivery at government hospital.",
            applicationProcess = "Register at your nearest PHC (Primary Health Centre) during pregnancy.",
            category = "Maternal Health",
            maxIncome = 180000,
            requiresBPL = false,
            requiredGender = "Female",
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Aadhaar Card",
                "BPL Card or Income Certificate",
                "MCH Card (Mother Child Health card from ANM)",
                "Bank account details (for DBT)"
            ),
            officialLink = "https://nhm.gov.in/index1.php?lang=1&level=3&sublinkid=841&lid=309",
            iconCategory = "health"
        ),

        Scheme(
            id = "3",
            name = "Rashtriya Swasthya Bima Yojana (RSBY)",
            description = "Health insurance for unorganised sector workers providing hospitalisation coverage up to ₹30,000 per family per year.",
            eligibilityCriteria = "BPL families in the unorganised sector — includes daily wage workers, domestic workers, construction labourers.",
            benefits = "Cashless hospitalisation up to ₹30,000/year. Smart card based — works at any empaneled hospital.",
            applicationProcess = "Enroll through your district labour office or nearest Common Service Centre.",
            category = "Health Insurance",
            maxIncome = 100000,
            requiresBPL = true,
            occupations = listOf(
                "Daily Wage Worker", "Construction Worker",
                "Labourer", "Housewife", "Unemployed", "Driver"
            ),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "BPL Card (mandatory)",
                "Aadhaar Card",
                "Ration Card",
                "Passport-size photograph (all family members)"
            ),
            officialLink = "https://www.rsby.gov.in",
            iconCategory = "health"
        ),

        Scheme(
            id = "4",
            name = "PM Kisan Samman Nidhi (PM-KISAN)",
            description = "Direct income support of ₹6,000 per year for farmer families across India in 3 equal instalments.",
            eligibilityCriteria = "All small and marginal farmer families with cultivable land. Excludes income tax payers, government employees, and pensioners.",
            benefits = "₹6,000/year directly in bank account in 3 instalments of ₹2,000 each.",
            applicationProcess = "Apply at your local Patwari / Revenue Officer or online at pmkisan.gov.in with land records.",
            category = "Agriculture",
            maxIncome = 300000,
            requiresBPL = false,
            occupations = listOf("Farmer"),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Aadhaar Card",
                "Land Ownership documents (Khasra/Khatauni)",
                "Bank account details linked to Aadhaar",
                "Mobile number"
            ),
            officialLink = "https://pmkisan.gov.in",
            iconCategory = "agriculture"
        ),

        Scheme(
            id = "5",
            name = "Atal Pension Yojana (APY)",
            description = "Government-backed pension scheme for unorganised sector workers ensuring a fixed monthly pension after age 60.",
            eligibilityCriteria = "Indian citizens aged 18–40 years with a savings bank account. Not an income tax payer.",
            benefits = "Fixed monthly pension of ₹1,000 to ₹5,000 after age 60, depending on contribution.",
            applicationProcess = "Apply at your bank branch or through the bank's mobile app. Can also enroll via Common Service Centre.",
            category = "Social Security",
            maxIncome = Int.MAX_VALUE,
            requiresBPL = false,
            minAge = 18,
            maxAge = 40,
            occupations = listOf(
                "Farmer", "Daily Wage Worker", "Self Employed",
                "Construction Worker", "Labourer", "Housewife",
                "Tailor", "Electrician", "Plumber", "Driver",
                "Shopkeeper"
            ),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Aadhaar Card",
                "Active savings bank account",
                "Mobile number linked to Aadhaar"
            ),
            officialLink = "https://npscra.nsdl.co.in/scheme-details.php",
            iconCategory = "pension"
        ),

        Scheme(
            id = "6",
            name = "PM Jeevan Jyoti Bima Yojana (PMJJBY)",
            description = "Affordable life insurance scheme providing ₹2 lakh coverage on death due to any reason. Premium is just ₹436/year.",
            eligibilityCriteria = "Age group 18–50 years with a savings bank account. Auto-debits premium annually.",
            benefits = "Life cover of ₹2,00,000 to nominee in case of death of insured.",
            applicationProcess = "Enroll through your bank branch, bank's internet banking, or mobile banking.",
            category = "Insurance",
            maxIncome = 300000,
            requiresBPL = false,
            minAge = 18,
            maxAge = 50,
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Aadhaar Card",
                "Active savings bank account",
                "Mobile number",
                "Nominee details"
            ),
            officialLink = "https://jansuraksha.gov.in",
            iconCategory = "insurance"
        ),

        Scheme(
            id = "7",
            name = "PM Suraksha Bima Yojana (PMSBY)",
            description = "Accidental death and disability insurance at just ₹20/year premium — one of the cheapest safety nets available.",
            eligibilityCriteria = "Age 18–70 years with a savings bank account. Auto-renews annually.",
            benefits = "₹2,00,000 for accidental death or full disability. ₹1,00,000 for partial disability.",
            applicationProcess = "Enroll at your bank branch or through net/mobile banking.",
            category = "Insurance",
            maxIncome = Int.MAX_VALUE,
            requiresBPL = false,
            minAge = 18,
            maxAge = 70,
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Aadhaar Card",
                "Active savings bank account",
                "Mobile number"
            ),
            officialLink = "https://jansuraksha.gov.in",
            iconCategory = "insurance"
        ),

        Scheme(
            id = "8",
            name = "Pradhan Mantri Awas Yojana – Gramin (PMAY-G)",
            description = "Affordable housing scheme for rural BPL and low-income families to construct pucca houses with basic amenities.",
            eligibilityCriteria = "Houseless or living in kutcha/dilapidated house. Priority to SC/ST, BPL, women-headed households.",
            benefits = "₹1,20,000 (plains) or ₹1,30,000 (hills/NE) financial assistance for house construction. Also covers toilet and cooking gas connection.",
            applicationProcess = "Apply through Gram Panchayat or online at pmayg.nic.in.",
            category = "Housing",
            maxIncome = 200000,
            requiresBPL = true,
            occupations = emptyList(),
            minFamilySize = 1,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "BPL Card",
                "Aadhaar Card",
                "Bank account details",
                "Land ownership document or NOC from Gram Panchayat",
                "Job Card (if available)"
            ),
            officialLink = "https://pmayg.nic.in",
            iconCategory = "housing"
        ),

        Scheme(
            id = "9",
            name = "Sukanya Samriddhi Yojana (SSY)",
            description = "High-interest savings scheme for girl child's education and marriage under Beti Bachao Beti Padhao mission.",
            eligibilityCriteria = "Parents or guardians of a girl child aged below 10 years. Max 2 accounts per family.",
            benefits = "High interest rate (currently ~8.2%). Full tax exemption under 80C. Matures when girl turns 21.",
            applicationProcess = "Open account at any post office or bank branch with girl's birth certificate and parent's Aadhaar.",
            category = "Social Welfare",
            maxIncome = Int.MAX_VALUE,
            requiresBPL = false,
            requiredGender = "Female",
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Girl child's Birth Certificate",
                "Parent/Guardian Aadhaar Card",
                "Photograph of parent and girl child",
                "Address proof"
            ),
            officialLink = "https://www.indiapost.gov.in",
            iconCategory = "welfare"
        ),

        Scheme(
            id = "10",
            name = "Pradhan Mantri Jan Dhan Yojana (PMJDY)",
            description = "Financial inclusion scheme ensuring every household has a basic bank account with zero balance, RuPay debit card, and insurance cover.",
            eligibilityCriteria = "Any Indian citizen without a bank account. No minimum balance required.",
            benefits = "Zero balance savings account, RuPay debit card, ₹2 lakh accident insurance, ₹30,000 life cover, and overdraft up to ₹10,000.",
            applicationProcess = "Visit any bank branch with Aadhaar card and photo. Account opens same day.",
            category = "Banking",
            maxIncome = Int.MAX_VALUE,
            requiresBPL = false,
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Aadhaar Card",
                "Passport-size photograph",
                "Mobile number (optional but recommended)"
            ),
            officialLink = "https://pmjdy.gov.in",
            iconCategory = "banking"
        ),

        Scheme(
            id = "11",
            name = "Disability Pension Scheme (NHFDC)",
            description = "Financial assistance and loans at concessional rates for persons with disabilities for self-employment and livelihood.",
            eligibilityCriteria = "Person with minimum 40% certified disability. Income below ₹3,00,000/year.",
            benefits = "Concessional loans at 5% interest. Monthly pension support via state governments under NSAP.",
            applicationProcess = "Apply at District Disability Rehabilitation Centre (DDRC) or Social Welfare department.",
            category = "Disability Support",
            maxIncome = 300000,
            requiresBPL = false,
            requiresDisability = true,
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Disability Certificate (minimum 40%)",
                "Aadhaar Card",
                "Income Certificate",
                "Bank account details",
                "Passport-size photograph"
            ),
            officialLink = "https://nhfdc.nic.in",
            iconCategory = "disability"
        ),

        Scheme(
            id = "12",
            name = "PM Mudra Yojana (PMMY) – Shishu",
            description = "Collateral-free small business loans for micro and small entrepreneurs to start or grow their business.",
            eligibilityCriteria = "Small business owners, shopkeepers, vendors, artisans. Non-farm, non-corporate enterprises.",
            benefits = "Shishu: loans up to ₹50,000. Kishore: ₹50,000–₹5 lakh. Tarun: ₹5–₹10 lakh. No collateral needed.",
            applicationProcess = "Apply at any bank, MFI, or NBFC with business plan and Aadhaar. Also available at mudra.org.in.",
            category = "Employment",
            maxIncome = 500000,
            requiresBPL = false,
            occupations = listOf(
                "Self Employed", "Shopkeeper", "Tailor",
                "Electrician", "Plumber", "Driver", "Farmer"
            ),
            minFamilySize = 0,
            applicableStates = emptyList(),
            documentsRequired = listOf(
                "Aadhaar Card",
                "PAN Card",
                "Business proof / address",
                "Bank statement (last 6 months)",
                "Passport-size photograph"
            ),
            officialLink = "https://www.mudra.org.in",
            iconCategory = "employment"
        ),

        // ── STATE-SPECIFIC SCHEMES ──────────────────────────────────────

        Scheme(
            id = "13",
            name = "Aarogyasri Health Care Trust (Andhra Pradesh)",
            description = "State health insurance for BPL families in Andhra Pradesh providing free treatment for serious illnesses.",
            eligibilityCriteria = "BPL White Ration Card holders in Andhra Pradesh only.",
            benefits = "Free treatment for 2,500+ procedures at empaneled hospitals. No cap on coverage amount for listed diseases.",
            applicationProcess = "Visit any empaneled hospital with White Ration Card. Aarogyamitra at hospital will assist.",
            category = "Health Insurance",
            maxIncome = 150000,
            requiresBPL = true,
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = listOf("Andhra Pradesh"),
            documentsRequired = listOf(
                "White Ration Card (BPL)",
                "Aadhaar Card",
                "Passport-size photograph"
            ),
            officialLink = "https://www.aarogyasri.telangana.gov.in",
            iconCategory = "health"
        ),

        Scheme(
            id = "14",
            name = "Mahatma Jyotiba Phule Jan Arogya Yojana (Maharashtra)",
            description = "Health insurance scheme for yellow and orange ration card holders in Maharashtra for major surgeries and procedures.",
            eligibilityCriteria = "Yellow or Orange ration card holders in Maharashtra. Covers major illnesses, accidents, and surgeries.",
            benefits = "Coverage up to ₹1,50,000 for listed medical procedures at empaneled hospitals.",
            applicationProcess = "Visit empaneled hospital with ration card and Aadhaar. District Health Officer can also help.",
            category = "Health Insurance",
            maxIncome = 200000,
            requiresBPL = false,
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = listOf("Maharashtra"),
            documentsRequired = listOf(
                "Yellow or Orange Ration Card",
                "Aadhaar Card",
                "Photograph"
            ),
            officialLink = "https://www.jeevandayee.gov.in",
            iconCategory = "health"
        ),

        Scheme(
            id = "15",
            name = "Arogyasri (Telangana)",
            description = "Comprehensive health insurance for BPL families in Telangana covering major medical procedures and hospitalisation.",
            eligibilityCriteria = "BPL families with white ration card in Telangana.",
            benefits = "Free treatment for major illnesses. Coverage up to ₹2,00,000 at empaneled hospitals.",
            applicationProcess = "Register at nearest PHC or directly approach empaneled hospital with ration card.",
            category = "Health Insurance",
            maxIncome = 150000,
            requiresBPL = true,
            occupations = emptyList(),
            minFamilySize = 0,
            applicableStates = listOf("Telangana"),
            documentsRequired = listOf(
                "White Ration Card",
                "Aadhaar Card",
                "Passport-size photograph"
            ),
            officialLink = "https://www.aarogyasri.telangana.gov.in",
            iconCategory = "health"
        )
    )
}