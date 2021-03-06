plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val compose_version = "1.1.0"
val accompanist_version = "0.23.0"

android {
    compileSdk = 32

    signingConfigs {
        create("release") {
            keyAlias = "alias"
            keyPassword = "12345678"
            storeFile = file("$rootDir/keystore.jks")
            storePassword = "12345678"
        }
    }

    defaultConfig {
        applicationId = "ru.ikarenkov.podlodca.compose"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        signingConfig = signingConfigs.getByName("release")
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")

    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.material:material-icons-core:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0")

    implementation("com.google.accompanist:accompanist-insets:$accompanist_version")
    implementation("com.google.accompanist:accompanist-insets-ui:$accompanist_version")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanist_version")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")

    debugImplementation("androidx.compose.ui:ui-tooling:$compose_version")
}