# UserListView
============

A simple app to make a http call to user api, receive a http response, and display user image and user name


![My image1](/Img/Screenshot1.png)
![My image2](/Img/Screenshot2.png)


## License

Apache Version 2.0


## Acknowledgements

It uses open source libraries such as:
* Android Async HTTP
* UniversalImageLoader

## Building

The build requires [Gradle](http://www.gradleware.com/)
v1.6 and the [Android SDK](http://developer.android.com/sdk/index.html)
to be installed in your development environment. In addition you'll need to set
the `ANDROID_HOME` environment variable to the location of your SDK:

    export ANDROID_HOME=/opt/tools/android-sdk

After satisfying those requirements, the build is pretty simple:

* Run `gradle assemble` from the root directory to build the APK only
* Run `gradle build` from the root directory to build the app and also run
  the integration tests, this requires a connected Android device or running
  emulator.


