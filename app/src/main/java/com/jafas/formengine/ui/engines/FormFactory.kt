package com.jafas.formengine.ui.engines

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jafas.formengine.data.model.FieldType
import com.jafas.formengine.data.model.FormField
import com.jafas.formengine.ui.components.StdTextField

@Composable
fun FormFactory(field: FormField, viewModel: DynamicFormViewModel) {
    when (field.type) {
        FieldType.TEXT -> {
            // On appelle notre composant créé
            StdTextField(
                field = field,
                currentValue = viewModel.getStringValue(field.key),
                onValueChange = { newValue ->
                    viewModel.updateField(field.key, newValue)
                }
            )
        }
        FieldType.SELECT -> {
            // Pour l'instant on met juste un texte
            Text("Bientôt: Liste déroulante pour ${field.label}", color = Color.Gray)
        }
        FieldType.PHOTO -> {
            // Pour l'instant on met juste un texte
            Text("Bientôt: Appareil photo pour ${field.label}", color = Color.Gray)
        }
        FieldType.NUMBER -> {
            Text("Bientôt: Champ numérique pour ${field.label}", color = Color.Gray)
        }
    }
}