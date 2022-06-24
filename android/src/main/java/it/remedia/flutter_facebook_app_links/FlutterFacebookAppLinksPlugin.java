package it.remedia.flutter_facebook_app_links;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
//import android.util.Log;

import com.facebook.applinks.AppLinkData;
import com.facebook.FacebookSdk;

import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterFacebookAppLinksPlugin */
public class FlutterFacebookAppLinksPlugin implements MethodCallHandler {

  private Context mContext;
  private Activity mActivity;

  private static final String CHANNEL = "plugins.remedia.it/flutter_facebook_app_links";

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), CHANNEL);

    FlutterFacebookAppLinksPlugin instance = new FlutterFacebookAppLinksPlugin(registrar);
    channel.setMethodCallHandler(instance);
  }

  // Constructor to initialize plugin inside the 'registerWith' method
  private FlutterFacebookAppLinksPlugin(PluginRegistry.Registrar registrar){

    this.mContext = registrar.activeContext();
    this.mActivity = registrar.activity();

  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if(call.method.equals("initFBLinks")){
      Uri targetUrl =
      AppLinks.getTargetUrlFromInboundIntent(this, getIntent());
      if (targetUrl != null) {
          result.success(targetUrl);
          Log.i("Activity", "App Link Target URL: " + targetUrl.toString());
      }
      Log.i("Activity", "App Link NOT TARGET URL"));

    } else {
      result.notImplemented();
    }
  }
}
