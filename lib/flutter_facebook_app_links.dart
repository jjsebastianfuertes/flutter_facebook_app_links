import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class FlutterFacebookAppLinks {
  static const MethodChannel _channel =
      const MethodChannel("plugins.remedia.it/flutter_facebook_app_links");
      

  static Future<dynamic> initFBLinks() async {

    try{
      var data = await _channel.invokeMethod('initFBLinks');

      if(data==null) return null;

      final Map<String, dynamic> result = new Map.from(data);
      return result;
      
    }catch(e){
      debugPrint("Error retrieving deferred deep link: $e");

      return null;
    }
    
  }

}
