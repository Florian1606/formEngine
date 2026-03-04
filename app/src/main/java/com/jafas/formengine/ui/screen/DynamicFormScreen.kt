
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jafas.formengine.data.model.FormSchema
import com.jafas.formengine.ui.engines.DynamicFormViewModel
import com.jafas.formengine.ui.engines.FormFactory

@Composable
fun DynamicFormScreen(
    schema: FormSchema,
    viewModel: DynamicFormViewModel
) {
    // Un conteneur qui permet de scroller si formulaire trop long
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Titre du formulaire
        Text(
            text = schema.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // On parcourt chaque élément du JSO
        schema.fields.forEach { champ ->
            FormFactory(field = champ, viewModel = viewModel)

            // Espace entre chaque brique
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Le bouton de validation
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                // TODO on affiche juste les données dans la console, plus tard on verra au service pour persister la data
                println("Données prêtes à être envoyées : ${viewModel.formData}")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Valider le contrôle ou form")
        }
    }
}