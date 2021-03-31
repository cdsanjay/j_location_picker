package com.jucodes.j_location_picker

import android.app.Activity
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import java.math.BigInteger
import java.security.MessageDigest

/** JLocationPickerPlugin */
class JLocationPickerPlugin: FlutterPlugin, MethodCallHandler {
  private lateinit var channel : MethodChannel
  var activity: Activity = Activity()
  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "j_location_picker")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    }

    if (call.method == "getSigningCertSha1") {
      try {
        val info: PackageInfo = activity.packageManager.getPackageInfo(call.arguments<String>(), PackageManager.GET_SIGNATURES)
        for (signature in info.signatures) {
          val md: MessageDigest = MessageDigest.getInstance("SHA1")
          md.update(signature.toByteArray())

          val bytes: ByteArray = md.digest()
          val bigInteger = BigInteger(1, bytes)
          val hex: String = String.format("%0" + (bytes.size shl 1) + "x", bigInteger)

          result.success(hex)
        }
      } catch (e: Exception) {
        result.error("ERROR", e.toString(), null)
      }
    }

    else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
