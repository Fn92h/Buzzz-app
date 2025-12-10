# Buzzz App

This repository contains a bare React Native 0.74 project skeleton with Google Maps and location permission boilerplate for both iOS and Android.

## What is included
- React Native entry files (`App.js`, `index.js`, `app.json`).
- iOS scaffolding (`AppDelegate` configured for Google Maps, `Info.plist` with location/background usage, placeholder `GoogleService-Info.plist`, Podfile with Google Maps pods).
- Android scaffolding (Gradle config, `AndroidManifest.xml` with foreground/background location permissions, Google Maps API key metadata, foreground service stub for background location).
- Basic `MapView` usage via `react-native-maps` demonstrating Google provider and user location display.

## Setup
1. Install dependencies (Yarn or npm) in the `BuzzzApp` directory.
2. Replace `YOUR_IOS_GOOGLE_MAPS_API_KEY` and `YOUR_ANDROID_GOOGLE_MAPS_API_KEY` with your actual keys.
3. For iOS, run `cd ios && pod install` after installing JS dependencies.
4. Start the Metro bundler with `npm run start` (or `yarn start`), then build/run on the desired platform.
