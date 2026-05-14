//package com.example.arogyanidhi.ui.schemes
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.arogyanidhi.data.local.DocumentDao
//import com.example.arogyanidhi.data.local.DocumentEntity
//import com.example.arogyanidhi.domain.model.Scheme
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class SchemeDetailViewModel @Inject constructor(
//    private val documentDao: DocumentDao
//) : ViewModel() {
//
//    private val _scheme = MutableStateFlow<Scheme?>(null)
//    val scheme: StateFlow<Scheme?> = _scheme.asStateFlow()
//
//    private val _documents = MutableStateFlow<List<DocumentEntity>>(emptyList())
//    val documents: StateFlow<List<DocumentEntity>> = _documents.asStateFlow()
//
//    fun loadScheme(schemeId: String) {
//        // Mock loading
//        val mockScheme = Scheme(
//            id = schemeId,
//            name = "Ayushman Bharat",
//            description = "Health insurance for all",
//            documentsRequired = listOf("Aadhaar Card", "Ration Card", "Income Certificate")
//        )
//        _scheme.value = mockScheme
//
//        viewModelScope.launch {
//            documentDao.getDocumentsForScheme(schemeId).collect { docs ->
//                if (docs.isEmpty()) {
//                    // Initialize if empty
//                    mockScheme.documentsRequired.forEach { docName ->
//                        documentDao.insertDocument(DocumentEntity(id = "${schemeId}_$docName", schemeId = schemeId, name = docName))
//                    }
//                } else {
//                    _documents.value = docs
//                }
//            }
//        }
//    }
//
//    fun toggleDocument(document: DocumentEntity) {
//        viewModelScope.launch {
//            documentDao.updateDocument(document.copy(isReady = !document.isReady))
//        }
//    }
//}
package com.example.arogyanidhi.ui.schemes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arogyanidhi.data.local.DocumentDao
import com.example.arogyanidhi.data.local.DocumentEntity
import com.example.arogyanidhi.data.local.SchemeDataSource
import com.example.arogyanidhi.domain.model.Scheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchemeDetailViewModel @Inject constructor(
    private val documentDao: DocumentDao
) : ViewModel() {

    private val _scheme = MutableStateFlow<Scheme?>(null)
    val scheme: StateFlow<Scheme?> = _scheme.asStateFlow()

    private val _documents = MutableStateFlow<List<DocumentEntity>>(emptyList())
    val documents: StateFlow<List<DocumentEntity>> = _documents.asStateFlow()

    fun loadScheme(schemeId: String) {

        // ✅ FIXED: Look up the REAL scheme by ID from SchemeDataSource
        // Previously this always returned a hardcoded Ayushman Bharat mock
        // regardless of which scheme the user tapped.
        val realScheme = SchemeDataSource.allSchemes.find { it.id == schemeId }

        // Fallback: if somehow the id doesn't match (e.g. SchemeViewModel uses
        // different IDs), create a minimal placeholder instead of crashing.
        val schemeToLoad = realScheme ?: Scheme(
            id = schemeId,
            name = "Scheme Details",
            description = "Details for this scheme are being loaded.",
            documentsRequired = listOf("Aadhaar Card", "Income Certificate")
        )

        _scheme.value = schemeToLoad

        // Load or initialize document checklist in Room DB
        viewModelScope.launch {
            documentDao.getDocumentsForScheme(schemeId).collect { docs ->
                if (docs.isEmpty()) {
                    // First time viewing this scheme — seed Room DB with required docs
                    schemeToLoad.documentsRequired.forEach { docName ->
                        documentDao.insertDocument(
                            DocumentEntity(
                                id = "${schemeId}_${docName.replace(" ", "_")}",
                                schemeId = schemeId,
                                name = docName,
                                isReady = false
                            )
                        )
                    }
                } else {
                    // Subsequent visits — show saved checkbox state
                    _documents.value = docs
                }
            }
        }
    }

    fun toggleDocument(document: DocumentEntity) {
        viewModelScope.launch {
            documentDao.updateDocument(document.copy(isReady = !document.isReady))
        }
    }
}