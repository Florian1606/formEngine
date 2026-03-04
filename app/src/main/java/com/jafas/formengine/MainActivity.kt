package com.jafas.formengine

import DynamicFormScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

import com.jafas.formengine.data.model.FormSchema
import com.jafas.formengine.ui.engines.DynamicFormViewModel
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // LA PORTE MAGIQUE : Tout ce qui est visuel doit être dans setContent
        setContent {
            // On utilise le thème Material3 standard pour faire simple
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


// 1. Lecture du fichier JSON depuis le dossier assets
                    val jsonString = remember {
                        assets.open("test_remorque.json").bufferedReader().use { it.readText() }
                    }

// 2. MAGIE GSON : On transforme le texte en objet sans aucun plugin
                    val formSchema = remember {
                        com.google.gson.Gson().fromJson(jsonString, FormSchema::class.java)
                    }

                    val viewModel: DynamicFormViewModel = viewModel()

                    // 5. Lancement de l'écran en lui passant le plan (schema) et la mémoire (viewModel)
                    DynamicFormScreen(schema = formSchema, viewModel = viewModel)

                }
            }
        }
    }
}