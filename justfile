set shell := ["bash", "-euo", "pipefail", "-c"]

# List the project commands.
default:
    @just --list

check:
    just --fmt --check
    dart format --output=none --set-exit-if-changed lib
    flutter analyze --no-pub

build-android:
    CARGO_BUILD_JOBS=4 python3 scripts/build.py apk --debug --target-platform android-arm64

# Prepare the locked Flutter dependencies.
setup:
    flutter pub get --enforce-lockfile

# Run the complete mobile source contract.
verify: check
