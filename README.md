# Greenbow

A free mobile application visualizing carbon emissions of companies.

Retail consumers are encouraged to used this application to understand the environmental impact caused by companies selling a product, in order to look for alternatives. For instance, Tom wants to purchase a Coffee from the most environmently friend coffee shop in the local area.

## Download

Currently under development.

## Build

This is a Clojurescript application using Reframe and React Native.
Created with 're-natal init greenbow'

### Development mode on real Android device

One time operation to tell figwheel use external react native components
```
re-natal require react-native-autocomplete-input
```

From terminal 1: use figwheel to start the application
```
adb reverse tcp:8081 tcp:8081
adb reverse tcp:3449 tcp:3449
re-natal use-android-device real
re-natal use-figwheel
lein figwheel android
```

From terminal 2: start the react native console
```
react-native run-android
```


### Run tests
`lein test-cljs` Run Clojurescript tests


### Production build
`lein prod-build` Production build
`cd android && ./gradlew assembleRelease` Generate release APK

One time command used to generate private key to sign the APK:
`keytool -genkeypair -v -keystore greebow-apk.keystore -alias greenbow -keyalg RSA -keysize 2048 -validity 10000` Located under android/app.


### External React Native modules
- react-native-autocomplete-input 3.6.0
      An auto-complete textbox displaying a list with entries matching the entered text.

See npm-deps in project.clj to import the nodejs module.
See ui.cljs to import module as react class


### Appendix
```
#npm install --save react-native-autocomplete-input
#re-natal enable-auto-require
#npm install klaw-sync -g
#re-natal {traverseAll: true} require-all
```
