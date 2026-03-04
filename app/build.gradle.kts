plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.jafas.formengine"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.jafas.formengine"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // 1. Navigation dans Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // 2. ViewModel pour Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    // 3. Parsing JSON (Kotlin Serialization est parfait pour Kotlin pur)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    // 4. Chargement d'images (pour la preview des photos)
    implementation("io.coil-kt:coil-compose:2.6.0")

    // 5. Hilt pour l'Injection de Dépendances (DI)
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-android-compiler:2.51")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")


    // 6. Icônes étendues (pour avoir le camion, le chariot, etc.)
    implementation("androidx.compose.material:material-icons-extended")

    // Adieu kotlinx, bonjour Gson (0 configuration requise)
    implementation("com.google.code.gson:gson:2.10.1")
}