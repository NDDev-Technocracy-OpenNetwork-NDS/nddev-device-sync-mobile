plugins {
    id("com.android.application")
    // Flutter follows the Android application plugin.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "ai.nddev.nds.nddev_device_sync_mobile"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "30.0.16248370"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        applicationId = "ai.nddev.nds.nddev_device_sync_mobile"
        // Match the minimum API linked by the locked native Rust toolchain.
        minSdk = 35
        targetSdk = flutter.targetSdkVersion
        // Uses the version code from pubspec.yaml. When using split APKs, 1000 * ABI_VERSION
        // is added automatically by Flutter. (https://developer.android.com/studio/build/configure-apk-splits#configure-APK-versions)
        // You can force using the value of versionCode by specifying the `-P force-version-code-ignoring-abi=true`
        // flag during build.
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            // Release signing is supplied only by an authorized release workflow.
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

flutter {
    source = "../.."
}
