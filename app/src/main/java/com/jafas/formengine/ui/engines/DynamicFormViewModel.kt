package com.jafas.formengine.ui.engines

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel

class DynamicFormViewModel : ViewModel() {

    // Ici on stocke toutes les réponses
    // La clé est le 'key' du JSON
    // La valeur est la réponse de l'utilisateur
    val formData = mutableStateMapOf<String, Any>()

    // Fonction pour mettre à jour une réponse quand l'utilisateur tape ... clique
    fun updateField(key: String, value: Any) {
        formData[key] = value
    }

    // Fonction utilitaire pour récupérer une réponse en texte de manière sécurisée
    fun getStringValue(key: String): String {
        return (formData[key] as? String) ?: ""
    }
}