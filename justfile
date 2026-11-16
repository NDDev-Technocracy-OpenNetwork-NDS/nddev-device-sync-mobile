set shell := ["bash", "-euo", "pipefail", "-c"]

# Prepares locked Dart packages without compiling an application.
setup:
    flutter pub get --enforce-lockfile

# Reads source only; native compilation/provenance are separate CI targets.
check:
    just --fmt --check
    dart format --output=none --set-exit-if-changed lib
    flutter analyze --no-pub

build-android:
    CARGO_BUILD_JOBS=4 python3 scripts/build.py apk --debug --target-platform android-arm64
