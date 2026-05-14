package com.example.arogyanidhi.util

import com.example.arogyanidhi.domain.model.Scheme

object DummySchemes {

    val schemes = listOf(

        // ── 1. Ayushman Bharat PM-JAY ─────────────────────────────
        Scheme(
            id = "1",
            name = "Ayushman Bharat (PM-JAY)",
            description = "Free health coverage up to ₹5 lakh per family per year for secondary and tertiary hospitalization.",
            eligibilityCriteria = "Low income families with annual income below ₹5 lakh",
            documentsRequired = listOf(
                "Aadhar Card",
                "Income Certificate",
                "Ration Card",
                "BPL Card (if applicable)",
                "Passport Size Photo"
            ),
            benefits = "Cashless treatment up to ₹5 lakh at empanelled hospitals",
            applicationProcess = "Visit nearest empanelled hospital or apply at Common Service Centre",
            category = "Health",
            maxIncome = 500000,
            requiresBPL = false,
            occupations = listOf(
                "farmer",
                "daily wage worker",
                "unemployed",
                "self employed"
            ),
            minFamilySize = 0
        ),

        // ── 2. RSBY ───────────────────────────────────────────────
        Scheme(
            id = "2",
            name = "Rashtriya Swasthya Bima Yojana (RSBY)",
            description = "Health insurance coverage of ₹30,000 per family per year for BPL families.",
            eligibilityCriteria = "BPL families with annual income below ₹1 lakh",
            documentsRequired = listOf(
                "BPL Card",
                "Aadhar Card",
                "Family Photo",
                "Ration Card"
            ),
            benefits = "Hospitalization coverage up to ₹30,000",
            applicationProcess = "Register at nearest government office with BPL card",
            category = "Insurance",
            maxIncome = 100000,
            requiresBPL = true,
            occupations = emptyList(),
            minFamilySize = 0
        ),

        // ── 3. ESIC ───────────────────────────────────────────────
        Scheme(
            id = "3",
            name = "ESIC Medical Coverage",
            description = "Comprehensive medical coverage for salaried employees and their families.",
            eligibilityCriteria = "Salaried employees earning up to ₹21,000 per month",
            documentsRequired = listOf(
                "Employee ID Card",
                "Aadhar Card",
                "Salary Slip",
                "Bank Passbook"
            ),
            benefits = "Full medical care, maternity benefit, disability benefit",
            applicationProcess = "Register through employer at ESIC office",
            category = "Employee Health",
            maxIncome = 2000000,
            requiresBPL = false,
            occupations = listOf("salaried employee"),
            minFamilySize = 0
        ),

        // ── 4. Janani Suraksha Yojana ─────────────────────────────
        Scheme(
            id = "4",
            name = "Janani Suraksha Yojana (JSY)",
            description = "Cash assistance to pregnant women for institutional delivery.",
            eligibilityCriteria = "Pregnant women from BPL or low income families",
            documentsRequired = listOf(
                "Aadhar Card",
                "BPL Card",
                "Pregnancy Certificate",
                "Bank Passbook"
            ),
            benefits = "Cash assistance for institutional delivery",
            applicationProcess = "Register at nearest government hospital",
            category = "Maternal Health",
            maxIncome = 200000,
            requiresBPL = false,
            occupations = emptyList(),
            minFamilySize = 0
        ),

        // ── 5. PM Mudra Yojana ────────────────────────────────────
        Scheme(
            id = "5",
            name = "PM Mudra Yojana (PMMY)",
            description = "Loans up to ₹10 lakh for small businesses.",
            eligibilityCriteria = "Self employed or small business owners",
            documentsRequired = listOf(
                "Aadhar Card",
                "PAN Card",
                "Business Plan",
                "Bank Statement"
            ),
            benefits = "Business loans under Shishu, Kishore and Tarun categories",
            applicationProcess = "Apply at banks or NBFCs",
            category = "Employment",
            maxIncome = 1000000,
            requiresBPL = false,
            occupations = listOf(
                "self employed",
                "daily wage worker",
                "farmer"
            ),
            minFamilySize = 0
        ),

        // ── 6. PMAY ───────────────────────────────────────────────
        Scheme(
            id = "6",
            name = "Pradhan Mantri Awas Yojana (PMAY)",
            description = "Housing subsidy scheme for low income families.",
            eligibilityCriteria = "Families without pucca house",
            documentsRequired = listOf(
                "Aadhar Card",
                "Income Certificate",
                "Land Documents",
                "Bank Passbook"
            ),
            benefits = "Housing loan subsidy",
            applicationProcess = "Apply online or through CSC",
            category = "Housing",
            maxIncome = 300000,
            requiresBPL = false,
            occupations = emptyList(),
            minFamilySize = 2
        ),

        // ── 7. Atal Pension Yojana ────────────────────────────────
        Scheme(
            id = "7",
            name = "Atal Pension Yojana (APY)",
            description = "Guaranteed pension for unorganised workers.",
            eligibilityCriteria = "Indian citizens aged 18-40",
            documentsRequired = listOf(
                "Aadhar Card",
                "Bank Passbook",
                "Mobile Number"
            ),
            benefits = "Monthly pension after age 60",
            applicationProcess = "Apply through bank or post office",
            category = "Social Security",
            maxIncome = Int.MAX_VALUE,
            requiresBPL = false,
            occupations = listOf(
                "farmer",
                "daily wage worker",
                "self employed",
                "unemployed"
            ),
            minFamilySize = 0
        ),

        // ── 8. PMJJBY ─────────────────────────────────────────────
        Scheme(
            id = "8",
            name = "PM Jeevan Jyoti Bima Yojana (PMJJBY)",
            description = "Life insurance cover of ₹2 lakh.",
            eligibilityCriteria = "Bank account holders aged 18-50",
            documentsRequired = listOf(
                "Aadhar Card",
                "Bank Passbook"
            ),
            benefits = "₹2 lakh insurance cover",
            applicationProcess = "Apply through bank",
            category = "Insurance",
            maxIncome = Int.MAX_VALUE,
            requiresBPL = false,
            occupations = emptyList(),
            minFamilySize = 0
        ),

        // ── 9. PMSBY ──────────────────────────────────────────────
        Scheme(
            id = "9",
            name = "PM Suraksha Bima Yojana (PMSBY)",
            description = "Accidental insurance cover of ₹2 lakh.",
            eligibilityCriteria = "Bank account holders aged 18-70",
            documentsRequired = listOf(
                "Aadhar Card",
                "Bank Passbook"
            ),
            benefits = "Accidental insurance coverage",
            applicationProcess = "Apply through bank",
            category = "Insurance",
            maxIncome = Int.MAX_VALUE,
            requiresBPL = false,
            occupations = emptyList(),
            minFamilySize = 0
        ),

        // ── 10. Divyangjan Scheme ─────────────────────────────────
        Scheme(
            id = "10",
            name = "Divyangjan Swavalamban Yojana",
            description = "Support scheme for persons with disabilities.",
            eligibilityCriteria = "Families with disabled member",
            documentsRequired = listOf(
                "Disability Certificate",
                "Aadhar Card",
                "Income Certificate"
            ),
            benefits = "Financial assistance and support",
            applicationProcess = "Apply at Social Welfare Office",
            category = "Disability Support",
            maxIncome = 500000,
            requiresBPL = false,
            occupations = emptyList(),
            minFamilySize = 0
        ),

        // ── 11. PM Kisan ──────────────────────────────────────────
        Scheme(
            id = "11",
            name = "PM Kisan Samman Nidhi",
            description = "Income support for farmers.",
            eligibilityCriteria = "Small and marginal farmers",
            documentsRequired = listOf(
                "Aadhar Card",
                "Land Documents",
                "Bank Passbook"
            ),
            benefits = "₹6,000 yearly financial support",
            applicationProcess = "Apply through CSC or online",
            category = "Agriculture",
            maxIncome = 500000,
            requiresBPL = false,
            occupations = listOf("farmer"),
            minFamilySize = 0
        ),

        // ── 12. Sukanya Samriddhi Yojana ──────────────────────────
        Scheme(
            id = "12",
            name = "Sukanya Samriddhi Yojana",
            description = "Savings scheme for girl child.",
            eligibilityCriteria = "Families with girl child below 10 years",
            documentsRequired = listOf(
                "Birth Certificate",
                "Parent Aadhar Card",
                "Address Proof"
            ),
            benefits = "High interest savings and tax benefits",
            applicationProcess = "Open account at bank or post office",
            category = "Social Welfare",
            maxIncome = Int.MAX_VALUE,
            requiresBPL = false,
            occupations = emptyList(),
            minFamilySize = 2
        )
    )
}