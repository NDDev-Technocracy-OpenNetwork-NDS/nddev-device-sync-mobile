# nddev-device-sync-mobile

Thin Android/iOS runners for [NDDev OpenNetwork](https://nddev.ai), AGPL-3.0-only.
Shared en/ru presentation and the generated native bridge come from the desktop
repository. Rust owns identity/session storage; Flutter never receives tokens.

Use the Flutter/Dart and Rust pins from Shared. Android builds use API 36,
JDK 25, NDK 30.0.16248370 and the Rust target for the device architecture. The native
client requires Android 15/API 35 or newer. Run
`flutter pub get --enforce-lockfile`, `just check` and `just build-android`.
An iOS build and Keychain interaction require macOS/Xcode; an Android result
is not evidence for iOS. Release signing is deliberately not configured.

Enter an HTTPS NDS server origin in the app. Native credential storage must be
available. GitHub is offered only when enabled by that server. The desktop
repository's `scripts/identity-acceptance.py --fixture /private/fixture.json
--app /path/to/this/repository --device emulator-PORT` exercises the shared UI
against an explicitly owned PostgreSQL/Mailpit fixture using ADB loopback
forwarding. It restores the temporary debug-only configuration afterward.

CI bootstraps from the immutable shared UI source, builds Android ARM64 and
unsigned iOS device/simulator targets, and checks that test harnesses are absent.
It does not sign or publish a release, or substitute for native-device acceptance.

Company administration and invitation verification reuse the selected Shared
Organizations/Accounts Rust client and presentation. Administrative changes are
online; an uncertain command can be retried without replacing its identity.
Native invitation links are explicitly imported into the signed-out client;
OS app/universal-link associations remain deployment-specific.
