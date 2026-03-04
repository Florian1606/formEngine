package com.jafas.formengine.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jafas.formengine.data.model.FormField

@Composable
fun StdTextField(
    field: FormField,          // définition issue du JSON
    currentValue: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = currentValue,
        onValueChange = { nouvelleValeur ->
            onValueChange(nouvelleValeur) // On remonte la valeur au moteur
        },
        label = {
            // On affiche le label, et on ajoute une petite étoile si c'est requis
            val texteLabel = if (field.required) "${field.label} *" else field.label
            Text(texteLabel)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        // Si plus tard on a un type NUMBER, on pourra forcer le clavier numérique ici
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        singleLine = true
    )
}