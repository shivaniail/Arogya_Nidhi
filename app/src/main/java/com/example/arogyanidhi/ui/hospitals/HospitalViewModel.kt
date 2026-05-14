////package com.example.arogyanidhi.ui.hospitals
////
////import androidx.lifecycle.ViewModel
////import androidx.lifecycle.viewModelScope
////import com.example.arogyanidhi.domain.model.Hospital
////import com.example.arogyanidhi.util.LocationHelper
////import dagger.hilt.android.lifecycle.HiltViewModel
////import kotlinx.coroutines.flow.*
////import kotlinx.coroutines.launch
////import javax.inject.Inject
////
////@HiltViewModel
////class HospitalViewModel @Inject constructor(
////    private val locationHelper: LocationHelper
////) : ViewModel() {
////
////    private val allHospitals = listOf(
////        // Govt Hospitals
////        Hospital(id = "G1", name = "Victoria Hospital", district = "Bangalore Urban", address = "Fort Road, near City Market", contact = "080-26701150", type = "Govt", latitude = 12.9634, longitude = 77.5756),
////        Hospital(id = "G2", name = "Bowring and Lady Curzon Hospital", district = "Bangalore Urban", address = "Shivajinagar, Bangalore", contact = "080-25591362", type = "Govt", latitude = 12.9837, longitude = 77.6015),
////        Hospital(id = "G3", name = "District Hospital, Ramanagara", district = "Ramanagara", address = "B.M Road, Ramanagara", contact = "080-27271224", type = "Govt", latitude = 12.7230, longitude = 77.2764),
////        Hospital(id = "G4", name = "K.C. General Hospital", district = "Bangalore Urban", address = "Malleswaram, Bangalore", contact = "080-23344483", type = "Govt", latitude = 12.9922, longitude = 77.5714),
////        Hospital(id = "G5", name = "General Hospital, Tumakuru", district = "Tumakuru", address = "B.H. Road, Tumakuru", contact = "0816-2278455", type = "Govt", latitude = 13.3379, longitude = 77.1006),
////
////        // Private Hospitals
////        Hospital(id = "P1", name = "Apollo Hospital", district = "Bangalore Urban", address = "154, IIM, Bannerghatta Main Rd", contact = "080-26304050", type = "Private", latitude = 12.8953, longitude = 77.6010),
////        Hospital(id = "P2", name = "Fortis Hospital", district = "Bangalore Urban", address = "154/9, Bannerghatta Main Rd", contact = "080-66214444", type = "Private", latitude = 12.8943, longitude = 77.5990),
////        Hospital(id = "P3", name = "Manipal Hospital", district = "Bangalore Urban", address = "98, Old Airport Road", contact = "080-25024444", type = "Private", latitude = 12.9593, longitude = 77.6444),
////        Hospital(id = "P4", name = "Columbia Asia Referral Hospital", district = "Bangalore Urban", address = "Yeshwanthpur, Bangalore", contact = "080-39898969", type = "Private", latitude = 13.0130, longitude = 77.5516),
////        Hospital(id = "P5", name = "Narayana Health City", district = "Bangalore Rural", address = "Bommasandra Industrial Area", contact = "080-71222222", type = "Private", latitude = 12.8105, longitude = 77.6936),
////        Hospital(id = "P6", name = "Aster CMI Hospital", district = "Bangalore Urban", address = "Sahakar Nagar, Hebbal", contact = "080-43420100", type = "Private", latitude = 13.0534, longitude = 77.5929),
////        Hospital(id = "P7", name = "Sakra World Hospital", district = "Bangalore Urban", address = "Outer Ring Rd, Marathahalli", contact = "080-49694969", type = "Private", latitude = 12.9304, longitude = 77.6881),
////
////        // Clinics
////        Hospital(id = "C1", name = "Practo Care Surgeries", district = "Bangalore Urban", address = "HSR Layout, Bangalore", contact = "080-47101234", type = "Clinic", latitude = 12.9121, longitude = 77.6445),
////        Hospital(id = "C2", name = "Cloudnine Clinic", district = "Bangalore Urban", address = "Jayanagar, Bangalore", contact = "1860-500-9999", type = "Clinic", latitude = 12.9250, longitude = 77.5897),
////        Hospital(id = "C3", name = "Apollo Clinic", district = "Bangalore Urban", address = "Indiranagar, Bangalore", contact = "080-41261111", type = "Clinic", latitude = 12.9784, longitude = 77.6408),
////        Hospital(id = "C4", name = "Vasan Eye Care", district = "Bangalore Urban", address = "Koramangala, Bangalore", contact = "080-39890000", type = "Clinic", latitude = 12.9352, longitude = 77.6245),
////        Hospital(id = "C5", name = "Dr. Batra’s Homeopathy", district = "Bangalore Urban", address = "M.G. Road, Bangalore", contact = "080-25553333", type = "Clinic", latitude = 12.9750, longitude = 77.6070)
////    )
////
////    private val _userLocation = MutableStateFlow<android.location.Location?>(null)
////    private val _isLocationEnabled = MutableStateFlow(false)
////    val isLocationEnabled: StateFlow<Boolean> = _isLocationEnabled.asStateFlow()
////
////    private val _hospitals = MutableStateFlow<List<Hospital>>(allHospitals)
////    val hospitals: StateFlow<List<Hospital>> = _hospitals.asStateFlow()
////
////    fun toggleLocation(enabled: Boolean) {
////        _isLocationEnabled.value = enabled
////        if (enabled) {
////            startLocationUpdates()
////        } else {
////            _hospitals.value = allHospitals
////            _userLocation.value = null
////        }
////    }
////
////    private fun startLocationUpdates() {
////        viewModelScope.launch {
////            locationHelper.getLocationUpdates().collect { location ->
////                if (_isLocationEnabled.value) {
////                    _userLocation.value = location
////                    filterHospitals(location)
////                }
////            }
////        }
////    }
////
////    private fun filterHospitals(location: android.location.Location?) {
////        if (location == null || !_isLocationEnabled.value) {
////            _hospitals.value = allHospitals
////            return
////        }
////
////        val nearby = allHospitals.filter { hospital ->
////            val distance = locationHelper.calculateDistance(
////                location.latitude, location.longitude,
////                hospital.latitude, hospital.longitude
////            )
////            distance <= 100.0
////        }.sortedBy { hospital ->
////            locationHelper.calculateDistance(
////                location.latitude, location.longitude,
////                hospital.latitude, hospital.longitude
////            )
////        }
////        _hospitals.value = nearby
////    }
////
////    fun getDistance(hospital: Hospital): String {
////        val location = _userLocation.value ?: return ""
////        val distance = locationHelper.calculateDistance(
////            location.latitude, location.longitude,
////            hospital.latitude, hospital.longitude
////        )
////        return String.format("%.1f km", distance)
////    }
////}
//package com.example.arogyanidhi.ui.hospitals
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.arogyanidhi.domain.model.Hospital
//import com.example.arogyanidhi.domain.repository.AuthRepository
//import com.example.arogyanidhi.domain.repository.UserRepository
//import com.example.arogyanidhi.util.LocationHelper
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.*
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class HospitalViewModel @Inject constructor(
//    private val locationHelper: LocationHelper,
//    private val authRepository: AuthRepository,
//    private val userRepository: UserRepository
//) : ViewModel() {
//
//    private val allHospitals = listOf(
//        Hospital(id = "G1", name = "Victoria Hospital", district = "Bangalore Urban", address = "Fort Road, near City Market", contact = "080-26701150", type = "Govt", latitude = 12.9634, longitude = 77.5756),
//        Hospital(id = "G2", name = "Bowring and Lady Curzon Hospital", district = "Bangalore Urban", address = "Shivajinagar, Bangalore", contact = "080-25591362", type = "Govt", latitude = 12.9837, longitude = 77.6015),
//        Hospital(id = "G3", name = "District Hospital, Ramanagara", district = "Ramanagara", address = "B.M Road, Ramanagara", contact = "080-27271224", type = "Govt", latitude = 12.7230, longitude = 77.2764),
//        Hospital(id = "G4", name = "K.C. General Hospital", district = "Bangalore Urban", address = "Malleswaram, Bangalore", contact = "080-23344483", type = "Govt", latitude = 12.9922, longitude = 77.5714),
//        Hospital(id = "G5", name = "General Hospital, Tumakuru", district = "Tumakuru", address = "B.H. Road, Tumakuru", contact = "0816-2278455", type = "Govt", latitude = 13.3379, longitude = 77.1006),
//        Hospital(id = "P1", name = "Apollo Hospital", district = "Bangalore Urban", address = "154, IIM, Bannerghatta Main Rd", contact = "080-26304050", type = "Private", latitude = 12.8953, longitude = 77.6010),
//        Hospital(id = "P2", name = "Fortis Hospital", district = "Bangalore Urban", address = "154/9, Bannerghatta Main Rd", contact = "080-66214444", type = "Private", latitude = 12.8943, longitude = 77.5990),
//        Hospital(id = "P3", name = "Manipal Hospital", district = "Bangalore Urban", address = "98, Old Airport Road", contact = "080-25024444", type = "Private", latitude = 12.9593, longitude = 77.6444),
//        Hospital(id = "P4", name = "Columbia Asia Referral Hospital", district = "Bangalore Urban", address = "Yeshwanthpur, Bangalore", contact = "080-39898969", type = "Private", latitude = 13.0130, longitude = 77.5516),
//        Hospital(id = "P5", name = "Narayana Health City", district = "Bangalore Rural", address = "Bommasandra Industrial Area", contact = "080-71222222", type = "Private", latitude = 12.8105, longitude = 77.6936),
//        Hospital(id = "P6", name = "Aster CMI Hospital", district = "Bangalore Urban", address = "Sahakar Nagar, Hebbal", contact = "080-43420100", type = "Private", latitude = 13.0534, longitude = 77.5929),
//        Hospital(id = "P7", name = "Sakra World Hospital", district = "Bangalore Urban", address = "Outer Ring Rd, Marathahalli", contact = "080-49694969", type = "Private", latitude = 12.9304, longitude = 77.6881),
//        Hospital(id = "C1", name = "Practo Care Surgeries", district = "Bangalore Urban", address = "HSR Layout, Bangalore", contact = "080-47101234", type = "Clinic", latitude = 12.9121, longitude = 77.6445),
//        Hospital(id = "C2", name = "Cloudnine Clinic", district = "Bangalore Urban", address = "Jayanagar, Bangalore", contact = "1860-500-9999", type = "Clinic", latitude = 12.9250, longitude = 77.5897),
//        Hospital(id = "C3", name = "Apollo Clinic", district = "Bangalore Urban", address = "Indiranagar, Bangalore", contact = "080-41261111", type = "Clinic", latitude = 12.9784, longitude = 77.6408),
//        Hospital(id = "C4", name = "Vasan Eye Care", district = "Bangalore Urban", address = "Koramangala, Bangalore", contact = "080-39890000", type = "Clinic", latitude = 12.9352, longitude = 77.6245),
//        Hospital(id = "C5", name = "Dr. Batra's Homeopathy", district = "Bangalore Urban", address = "M.G. Road, Bangalore", contact = "080-25553333", type = "Clinic", latitude = 12.9750, longitude = 77.6070)
//    )
//
//    private val _hospitals = MutableStateFlow<List<Hospital>>(allHospitals)
//    val hospitals: StateFlow<List<Hospital>> = _hospitals.asStateFlow()
//
//    // ✅ FEATURE 3: Expose district from profile so HospitalListScreen
//    // can pre-fill the search bar automatically
//    private val _profileDistrict = MutableStateFlow("")
//    val profileDistrict: StateFlow<String> = _profileDistrict.asStateFlow()
//
//    init {
//        // Load district from saved profile
//        viewModelScope.launch {
//            authRepository.currentUser.collect { user ->
//                user?.let {
//                    userRepository.getUserProfile(it.uid).collect { profile ->
//                        profile?.let { p ->
//                            if (p.district.isNotBlank()) {
//                                _profileDistrict.value = p.district
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private val _userLocation = MutableStateFlow<android.location.Location?>(null)
//    private val _isLocationEnabled = MutableStateFlow(false)
//    val isLocationEnabled: StateFlow<Boolean> = _isLocationEnabled.asStateFlow()
//
//    fun toggleLocation(enabled: Boolean) {
//        _isLocationEnabled.value = enabled
//        if (enabled) {
//            startLocationUpdates()
//        } else {
//            _hospitals.value = allHospitals
//            _userLocation.value = null
//        }
//    }
//
//    private fun startLocationUpdates() {
//        viewModelScope.launch {
//            locationHelper.getLocationUpdates().collect { location ->
//                if (_isLocationEnabled.value) {
//                    _userLocation.value = location
//                    filterHospitals(location)
//                }
//            }
//        }
//    }
//
//    private fun filterHospitals(location: android.location.Location?) {
//        if (location == null || !_isLocationEnabled.value) {
//            _hospitals.value = allHospitals
//            return
//        }
//        val nearby = allHospitals.filter { hospital ->
//            val distance = locationHelper.calculateDistance(
//                location.latitude, location.longitude,
//                hospital.latitude, hospital.longitude
//            )
//            distance <= 100.0
//        }.sortedBy { hospital ->
//            locationHelper.calculateDistance(
//                location.latitude, location.longitude,
//                hospital.latitude, hospital.longitude
//            )
//        }
//        _hospitals.value = nearby
//    }
//
//    fun getDistance(hospital: Hospital): String {
//        val location = _userLocation.value ?: return ""
//        val distance = locationHelper.calculateDistance(
//            location.latitude, location.longitude,
//            hospital.latitude, hospital.longitude
//        )
//        return String.format("%.1f km", distance)
//    }
//}
package com.example.arogyanidhi.ui.hospitals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arogyanidhi.domain.model.Hospital
import com.example.arogyanidhi.domain.repository.AuthRepository
import com.example.arogyanidhi.domain.repository.UserRepository
import com.example.arogyanidhi.util.LocationHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HospitalViewModel @Inject constructor(
    private val locationHelper: LocationHelper,
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val allHospitals = listOf(

        // ── GOVT HOSPITALS ──
        Hospital(
            id = "G1", name = "Victoria Hospital",
            district = "Bangalore Urban",
            address = "Fort Road, near City Market",
            contact = "080-26701150", type = "Govt",
            latitude = 12.9634, longitude = 77.5756,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)", "RSBY", "ESI"
            )
        ),
        Hospital(
            id = "G2", name = "Bowring and Lady Curzon Hospital",
            district = "Bangalore Urban",
            address = "Shivajinagar, Bangalore",
            contact = "080-25591362", type = "Govt",
            latitude = 12.9837, longitude = 77.6015,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "Janani Suraksha Yojana (JSY)", "RSBY"
            )
        ),
        Hospital(
            id = "G3", name = "District Hospital, Ramanagara",
            district = "Ramanagara",
            address = "B.M Road, Ramanagara",
            contact = "080-27271224", type = "Govt",
            latitude = 12.7230, longitude = 77.2764,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "Janani Suraksha Yojana (JSY)"
            )
        ),
        Hospital(
            id = "G4", name = "K.C. General Hospital",
            district = "Bangalore Urban",
            address = "Malleswaram, Bangalore",
            contact = "080-23344483", type = "Govt",
            latitude = 12.9922, longitude = 77.5714,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)", "RSBY",
                "Atal Pension Yojana (APY)"
            )
        ),
        Hospital(
            id = "G5", name = "General Hospital, Tumakuru",
            district = "Tumakuru",
            address = "B.H. Road, Tumakuru",
            contact = "0816-2278455", type = "Govt",
            latitude = 13.3379, longitude = 77.1006,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "Janani Suraksha Yojana (JSY)"
            )
        ),

        // ── PRIVATE HOSPITALS ──
        Hospital(
            id = "P1", name = "Apollo Hospital",
            district = "Bangalore Urban",
            address = "154, IIM, Bannerghatta Main Rd",
            contact = "080-26304050", type = "Private",
            latitude = 12.8953, longitude = 77.6010,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)", "ESI"
            )
        ),
        Hospital(
            id = "P2", name = "Fortis Hospital",
            district = "Bangalore Urban",
            address = "154/9, Bannerghatta Main Rd",
            contact = "080-66214444", type = "Private",
            latitude = 12.8943, longitude = 77.5990,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),
        Hospital(
            id = "P3", name = "Manipal Hospital",
            district = "Bangalore Urban",
            address = "98, Old Airport Road",
            contact = "080-25024444", type = "Private",
            latitude = 12.9593, longitude = 77.6444,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)", "ESI"
            )
        ),
        Hospital(
            id = "P4", name = "Columbia Asia Referral Hospital",
            district = "Bangalore Urban",
            address = "Yeshwanthpur, Bangalore",
            contact = "080-39898969", type = "Private",
            latitude = 13.0130, longitude = 77.5516,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),
        Hospital(
            id = "P5", name = "Narayana Health City",
            district = "Bangalore Rural",
            address = "Bommasandra Industrial Area",
            contact = "080-71222222", type = "Private",
            latitude = 12.8105, longitude = 77.6936,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)", "RSBY"
            )
        ),
        Hospital(
            id = "P6", name = "Aster CMI Hospital",
            district = "Bangalore Urban",
            address = "Sahakar Nagar, Hebbal",
            contact = "080-43420100", type = "Private",
            latitude = 13.0534, longitude = 77.5929,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)", "ESI"
            )
        ),
        Hospital(
            id = "P7", name = "Sakra World Hospital",
            district = "Bangalore Urban",
            address = "Outer Ring Rd, Marathahalli",
            contact = "080-49694969", type = "Private",
            latitude = 12.9304, longitude = 77.6881,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),

        // ── CLINICS ──
        Hospital(
            id = "C1", name = "Practo Care Surgeries",
            district = "Bangalore Urban",
            address = "HSR Layout, Bangalore",
            contact = "080-47101234", type = "Clinic",
            latitude = 12.9121, longitude = 77.6445,
            acceptedSchemes = listOf("ESI")
        ),
        Hospital(
            id = "C2", name = "Cloudnine Clinic",
            district = "Bangalore Urban",
            address = "Jayanagar, Bangalore",
            contact = "1860-500-9999", type = "Clinic",
            latitude = 12.9250, longitude = 77.5897,
            acceptedSchemes = listOf(
                "Janani Suraksha Yojana (JSY)"
            )
        ),
        Hospital(
            id = "C3", name = "Apollo Clinic",
            district = "Bangalore Urban",
            address = "Indiranagar, Bangalore",
            contact = "080-41261111", type = "Clinic",
            latitude = 12.9784, longitude = 77.6408,
            acceptedSchemes = listOf(
                "ESI", "Ayushman Bharat (PM-JAY)"
            )
        ),
        Hospital(
            id = "C4", name = "Vasan Eye Care",
            district = "Bangalore Urban",
            address = "Koramangala, Bangalore",
            contact = "080-39890000", type = "Clinic",
            latitude = 12.9352, longitude = 77.6245,
            acceptedSchemes = listOf("ESI")
        ),
        Hospital(
            id = "C5", name = "Dr. Batra's Homeopathy",
            district = "Bangalore Urban",
            address = "M.G. Road, Bangalore",
            contact = "080-25553333", type = "Clinic",
            latitude = 12.9750, longitude = 77.6070,
            acceptedSchemes = emptyList()
        ),
        // ───────────────── DHARWAD ─────────────────

        Hospital(
            id = "D1",
            name = "District Hospital Dharwad",
            district = "Dharwad",
            address = "PB Road, Dharwad",
            contact = "0836-2441234",
            type = "Govt",
            latitude = 15.4589,
            longitude = 75.0078,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "RSBY"
            )
        ),

        Hospital(
            id = "D2",
            name = "SDM Hospital",
            district = "Dharwad",
            address = "Manjushree Nagar, Dharwad",
            contact = "0836-2477777",
            type = "Private",
            latitude = 15.4700,
            longitude = 75.0100,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "ESI"
            )
        ),

        // ───────────────── CHIKKAMAGALURU ─────────────────

        Hospital(
            id = "CM1",
            name = "District Hospital Chikkamagaluru",
            district = "Chikkamagaluru",
            address = "MG Road, Chikkamagaluru",
            contact = "08262-230101",
            type = "Govt",
            latitude = 13.3161,
            longitude = 75.7720,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),

        Hospital(
            id = "CM2",
            name = "Vasavi Hospital",
            district = "Chikkamagaluru",
            address = "Basavanahalli Main Road",
            contact = "08262-220220",
            type = "Private",
            latitude = 13.3145,
            longitude = 75.7750,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "ESI"
            )
        ),

        // ───────────────── DAVANAGERE ─────────────────

        Hospital(
            id = "DV1",
            name = "Chigateri General Hospital",
            district = "Davanagere",
            address = "PJ Extension, Davanagere",
            contact = "08192-234061",
            type = "Govt",
            latitude = 14.4644,
            longitude = 75.9218,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "JSY"
            )
        ),

        Hospital(
            id = "DV2",
            name = "SS Hospital",
            district = "Davanagere",
            address = "Hadadi Road, Davanagere",
            contact = "08192-221111",
            type = "Private",
            latitude = 14.4700,
            longitude = 75.9260,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),

        // ───────────────── BALLARI ─────────────────

        Hospital(
            id = "BL1",
            name = "VIMS Hospital",
            district = "Ballari",
            address = "Cantonment Area, Ballari",
            contact = "08392-235500",
            type = "Govt",
            latitude = 15.1394,
            longitude = 76.9214,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),

        Hospital(
            id = "BL2",
            name = "Arunodaya Hospital",
            district = "Ballari",
            address = "Parvathi Nagar, Ballari",
            contact = "08392-256789",
            type = "Private",
            latitude = 15.1450,
            longitude = 76.9270,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "ESI"
            )
        ),

        // ───────────────── KALABURAGI ─────────────────

        Hospital(
            id = "K1",
            name = "District Hospital Kalaburagi",
            district = "Kalaburagi",
            address = "Sedam Road, Kalaburagi",
            contact = "08472-220099",
            type = "Govt",
            latitude = 17.3297,
            longitude = 76.8343,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "RSBY"
            )
        ),

        Hospital(
            id = "K2",
            name = "United Hospital",
            district = "Kalaburagi",
            address = "Super Market Area, Kalaburagi",
            contact = "08472-245678",
            type = "Private",
            latitude = 17.3350,
            longitude = 76.8400,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),

        // ───────────────── VIJAYAPURA ─────────────────

        Hospital(
            id = "V1",
            name = "District Hospital Vijayapura",
            district = "Vijayapura",
            address = "Station Road, Vijayapura",
            contact = "08352-250100",
            type = "Govt",
            latitude = 16.8302,
            longitude = 75.7100,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),

        Hospital(
            id = "V2",
            name = "BLDEA Hospital",
            district = "Vijayapura",
            address = "Solapur Road, Vijayapura",
            contact = "08352-262770",
            type = "Private",
            latitude = 16.8355,
            longitude = 75.7155,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "ESI"
            )
        ),

        // ───────────────── BIDAR ─────────────────

        Hospital(
            id = "BD1",
            name = "Bidar District Hospital",
            district = "Bidar",
            address = "Old City Area, Bidar",
            contact = "08482-225522",
            type = "Govt",
            latitude = 17.9133,
            longitude = 77.5301,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),
        // ───────────────── MANGALORE ─────────────────

        Hospital(
            id = "MG1",
            name = "Wenlock Hospital",
            district = "Mangalore",
            address = "Hampankatta, Mangalore",
            contact = "0824-2444590",
            type = "Govt",
            latitude = 12.8698,
            longitude = 74.8436,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "RSBY",
                "ESI"
            )
        ),

        Hospital(
            id = "MG2",
            name = "A.J. Hospital",
            district = "Mangalore",
            address = "Kuntikana, Mangalore",
            contact = "0824-2225533",
            type = "Private",
            latitude = 12.9141,
            longitude = 74.8559,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "ESI"
            )
        ),

        Hospital(
            id = "MG3",
            name = "KMC Hospital Attavar",
            district = "Mangalore",
            address = "Attavar, Mangalore",
            contact = "0824-2445858",
            type = "Private",
            latitude = 12.8615,
            longitude = 74.8424,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)"
            )
        ),

        Hospital(
            id = "MG4",
            name = "Indiana Hospital",
            district = "Mangalore",
            address = "Pumpwell Circle, Mangalore",
            contact = "0824-2880000",
            type = "Private",
            latitude = 12.8707,
            longitude = 74.8552,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "RSBY"
            )
        ),

        Hospital(
            id = "MG5",
            name = "Father Muller Medical College Hospital",
            district = "Mangalore",
            address = "Kankanady, Mangalore",
            contact = "0824-2238000",
            type = "Private",
            latitude = 12.8719,
            longitude = 74.8558,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "ESI",
                "Janani Suraksha Yojana (JSY)"
            )
        ),

        Hospital(
            id = "BD2",
            name = "Asha Hospital",
            district = "Bidar",
            address = "Shivaji Chowk, Bidar",
            contact = "08482-222333",
            type = "Private",
            latitude = 17.9180,
            longitude = 77.5340,
            acceptedSchemes = listOf(
                "Ayushman Bharat (PM-JAY)",
                "ESI"
            )
        )

    )

    // ── STATE ──
    private val _hospitals = MutableStateFlow<List<Hospital>>(allHospitals)
    val hospitals: StateFlow<List<Hospital>> = _hospitals.asStateFlow()

    // Eligible scheme names passed from results screen
    private val _eligibleSchemes = MutableStateFlow<List<String>>(emptyList())
    val eligibleSchemes: StateFlow<List<String>> = _eligibleSchemes.asStateFlow()

    // Profile district for pre-filling search bar
    private val _profileDistrict = MutableStateFlow("")
    val profileDistrict: StateFlow<String> = _profileDistrict.asStateFlow()

    private val _userLocation = MutableStateFlow<android.location.Location?>(null)
    private val _isLocationEnabled = MutableStateFlow(false)
    val isLocationEnabled: StateFlow<Boolean> = _isLocationEnabled.asStateFlow()

    init {
        // Load district from saved profile
        viewModelScope.launch {
            authRepository.currentUser.collect { user ->
                user?.let {
                    userRepository.getUserProfile(it.uid).collect { profile ->
                        profile?.let { p ->
                            if (p.district.isNotBlank()) {
                                _profileDistrict.value = p.district
                            }
                        }
                    }
                }
            }
        }
    }

    // ✅ Called from Eligibility Results screen
    // Stores eligible scheme names so UI can show green badges
    fun setEligibleSchemes(schemeNames: List<String>) {
        _eligibleSchemes.value = schemeNames
        // Sort: hospitals accepting eligible schemes come first
        _hospitals.value = allHospitals.sortedByDescending { hospital ->
            hospital.acceptedSchemes.any { scheme ->
                schemeNames.any { eligible ->
                    scheme.contains(eligible, ignoreCase = true) ||
                            eligible.contains(scheme, ignoreCase = true)
                }
            }
        }
    }

    // ✅ Called when user opens hospital screen from Home (no scheme context)
    fun resetToAll() {
        _eligibleSchemes.value = emptyList()
        _hospitals.value = allHospitals
    }

    // ✅ Check if a hospital accepts any of the user's eligible schemes
    fun isSchemeMatch(hospital: Hospital): Boolean {
        val eligible = _eligibleSchemes.value
        if (eligible.isEmpty()) return false
        return hospital.acceptedSchemes.any { scheme ->
            eligible.any { e ->
                scheme.contains(e, ignoreCase = true) ||
                        e.contains(scheme, ignoreCase = true)
            }
        }
    }

    fun toggleLocation(enabled: Boolean) {
        _isLocationEnabled.value = enabled
        if (enabled) {
            startLocationUpdates()
        } else {
            _hospitals.value = allHospitals
            _userLocation.value = null
        }
    }

    private fun startLocationUpdates() {
        viewModelScope.launch {
            locationHelper.getLocationUpdates().collect { location ->
                if (_isLocationEnabled.value) {
                    _userLocation.value = location
                    filterByLocation(location)
                }
            }
        }
    }

    private fun filterByLocation(location: android.location.Location?) {
        if (location == null || !_isLocationEnabled.value) {
            _hospitals.value = allHospitals
            return
        }
        val nearby = allHospitals.filter { hospital ->
            val distance = locationHelper.calculateDistance(
                location.latitude, location.longitude,
                hospital.latitude, hospital.longitude
            )
            distance <= 100.0
        }.sortedBy { hospital ->
            locationHelper.calculateDistance(
                location.latitude, location.longitude,
                hospital.latitude, hospital.longitude
            )
        }
        _hospitals.value = nearby
    }

    fun getDistance(hospital: Hospital): String {
        val location = _userLocation.value ?: return ""
        val distance = locationHelper.calculateDistance(
            location.latitude, location.longitude,
            hospital.latitude, hospital.longitude
        )
        return String.format("%.1f km", distance)
    }
}