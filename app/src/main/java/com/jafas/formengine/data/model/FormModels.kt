package com.jafas.formengine.data.model


// Le conteneur principal
data class FormSchema(
    val id: String,
    val title: String,
    val fields: List<FormField>
)

// La brique individuelle / commune
data class FormField(
    val type: FieldType,
    val key: String,
    val label: String,
    val required: Boolean = false,

    // Champs optionnels : selon le type de brique (pour les selects)
    val options: List<SelectOption>? = null,
    val data_source: String? = null,
    val dataSource: String? = null
)

// Le modèle pour les listes déroulantes
data class SelectOption(
    val id: String,
    val label: String
)

// Les types de champs supportés par le moteur
enum class FieldType {
    TEXT,
    NUMBER,
    SELECT,
    PHOTO
}