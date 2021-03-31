import 'package:j_location_picker/j_location_picker.dart';

import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:j_location_picker/generated/l10n.dart' as location_picker;
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'generated/i18n.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  LocationResult _pickedLocation;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
//      theme: ThemeData.dark(),
      title: 'J_location picker',
      localizationsDelegates: const [
        location_picker.S.delegate,
        S.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      supportedLocales: const <Locale>[
        Locale('en', ''),
        Locale('ar', ''),
        Locale('pt', ''),
        Locale('tr', ''),
        Locale('es', ''),
        Locale('it', ''),
        Locale('ru', ''),
      ],
      home: Scaffold(
        appBar: AppBar(
          title: const Text('location picker'),
        ),
        floatingActionButton: FloatingActionButton(onPressed: () async {}),
        body: Builder(builder: (context) {
          return Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                TextButton(
                  onPressed: () async {
                    LocationResult result = await showLocationPicker(
                      context,
                      "Api key",
                      initialCenter: LatLng(31.1975844, 29.9598339),
                      myLocationButtonEnabled: true,
                      layersButtonEnabled: true,
                      desiredAccuracy: LocationAccuracy.best,
                    );
                    print("result = $result");
                    setState(() => _pickedLocation = result);
                  },
                  child: Text(
                    'choose  location',
                    style: TextStyle(color: Colors.black),
                  ),
                ),
                Text(_pickedLocation.toString()),
              ],
            ),
          );
        }),
      ),
    );
  }
}
