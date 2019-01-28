# greenbow

A Clojurescript app created with 're-natal init greenbow'

## Development mode on real Android device

Application console:
```
adb reverse tcp:8081 tcp:8081
adb reverse tcp:3449 tcp:3449
re-natal use-android-device real
re-natal use-figwheel
lein figwheel android
```

React Native console:
```
react-native run-android
```
