package com.jucodes.j_location_picker_example

import io.flutter.embedding.android.FlutterActivity;

class MainActivity: FlutterActivity() {
   /* -  override fun onCreate(savedInstanceState: Bundle?) {
        -    super.onCreate(savedInstanceState)
        -    GeneratedPluginRegistrant.registerWith(this)
        -  }*/
}
/*import io.flutter.embedding.android.FlutterActivity
import android.os.Bundle


class MainActivity: FlutterActivity() {
   /* override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
    }*/
    override fun onCreate(savedInstanceState: FlutterEngine?) {
        super.onCreate(FlutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
    }
}
*/