set shell := ["bash", "-euo", "pipefail", "-c"]

check:
    dart format --output=none --set-exit-if-changed lib
    flutter analyze --no-pub

build-android:
    CARGO_BUILD_JOBS=4 python3 scripts/build.py apk --debug --target-platform android-arm64
