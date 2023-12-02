plugins {
    id("com.android.application")
}

android {
    namespace = "com.google.codelabs.mdc.java.shinre"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.google.codelabs.mdc.java.shinre"
        minSdk = 34
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    api ("com.google.android.material:material:1.12.0-alpha01")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("com.android.volley:volley:1.2.1")  // Volley
    implementation ("com.google.code.gson:gson:2.8.9") // Gson
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test:core:1.5.0")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test:runner:1.6.0-alpha04")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.6.0-alpha01")
}