# Greenbow

A free mobile application visualizing carbon emissions of companies.

Retail consumers are encouraged to used this application to understand the environmental impact caused by companies selling a product, in order to look for alternatives. For instance, Tom wants to purchase a Coffee from the most environmently friend coffee shop in the local area.

## Download

Currently under development.

## Build

This is a Clojurescript application using Reframe and React Native.
Created with 're-natal init greenbow'

### Development mode on real Android device

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
