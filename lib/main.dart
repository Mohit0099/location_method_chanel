// import 'package:flutter/material.dart';
// import 'package:flutter/services.dart';

// void main() {
//   runApp(const MyApp());
// }

// class MyApp extends StatelessWidget {
//   const MyApp({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: 'Background Location',
//       theme: ThemeData(primarySwatch: Colors.blue),
//       home: const BackgroundLocationPage(),
//     );
//   }
// }

// class BackgroundLocationPage extends StatefulWidget {
//   const BackgroundLocationPage({super.key});

//   @override
//   _BackgroundLocationPageState createState() => _BackgroundLocationPageState();
// }

// class _BackgroundLocationPageState extends State<BackgroundLocationPage> {
//   static const platform = MethodChannel('com.example.locationcheck/location');

//   String _location = "Unknown";

//   @override
//   void initState() {
//     super.initState();
//     platform.setMethodCallHandler(_onMethodCall);
//     _startLocationTracking();
//   }

//   // Function to start location tracking from Flutter
//   Future<void> _startLocationTracking() async {
//     try {
//       final String result =
//           await platform.invokeMethod('startBackgroundLocation');
//       print(result); // "Location tracking started"
//     } on PlatformException catch (e) {
//       print("Failed to start location tracking: ${e.message}");
//     }
//   }

//   // Method to handle method calls from Android (e.g., location updates)
//   Future<void> _onMethodCall(MethodCall call) async {
//     if (call.method == 'updateLocation') {
//       setState(() {
//         _location = call.arguments; // Update location data from Android
//       });
//     }
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(title: const Text("Background Location")),
//       body: Center(
//         child: Column(
//           mainAxisAlignment: MainAxisAlignment.center,
//           children: [
//             const Text("Current Location:", style: TextStyle(fontSize: 20)),
//             const SizedBox(height: 10),
//             Text(
//               _location,
//               style: const TextStyle(fontSize: 16, color: Colors.grey),
//               textAlign: TextAlign.center,
//             ),
//           ],
//         ),
//       ),
//     );
//   }
// }

// import 'package:flutter/material.dart';
// import 'package:flutter/services.dart';

// void main() {
//   runApp(const MyApp());
// }

// class MyApp extends StatelessWidget {
//   const MyApp({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: 'Background Location',
//       theme: ThemeData(primarySwatch: Colors.blue),
//       home: const BackgroundLocationPage(),
//     );
//   }
// }

// class BackgroundLocationPage extends StatefulWidget {
//   const BackgroundLocationPage({super.key});

//   @override
//   _BackgroundLocationPageState createState() => _BackgroundLocationPageState();
// }

// class _BackgroundLocationPageState extends State<BackgroundLocationPage> {
//   static const platform = MethodChannel('com.example.locationcheck/location');

//   String _location = "Unknown";

//   @override
//   void initState() {
//     super.initState();
//     platform.setMethodCallHandler(_onMethodCall);
//     _startLocationTracking();
//   }

//   // Function to start location tracking from Flutter
//   Future<void> _startLocationTracking() async {
//     try {
//       await platform.invokeMethod('startBackgroundLocation');
//     } on PlatformException catch (e) {
//       print("Failed to start location tracking: ${e.message}");
//     }
//   }

//   // Method to handle method calls from Android (e.g., location updates)
//   Future<void> _onMethodCall(MethodCall call) async {
//     if (call.method == 'updateLocation') {
//       setState(() {
//         _location = call.arguments; // Update location data from Android
//       });
//     }
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(title: const Text("Background Location")),
//       body: Center(
//         child: Column(
//           mainAxisAlignment: MainAxisAlignment.center,
//           children: [
//             const Text("Current Location:", style: TextStyle(fontSize: 20)),
//             const SizedBox(height: 10),
//             Text(
//               _location,
//               style: const TextStyle(fontSize: 16, color: Colors.grey),
//               textAlign: TextAlign.center,
//             ),
//           ],
//         ),
//       ),
//     );
//   }
// }
// import 'package:flutter/material.dart';
// import 'package:flutter/services.dart';

// void main() {
//   runApp(const MyApp());
// }

// class MyApp extends StatelessWidget {
//   const MyApp({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: 'Background Location',
//       theme: ThemeData(primarySwatch: Colors.blue),
//       home: const BackgroundLocationPage(),
//     );
//   }
// }

// class BackgroundLocationPage extends StatefulWidget {
//   const BackgroundLocationPage({super.key});

//   @override
//   _BackgroundLocationPageState createState() => _BackgroundLocationPageState();
// }

// class _BackgroundLocationPageState extends State<BackgroundLocationPage> {
//   static const platform = MethodChannel('com.example.locationcheck/location');

//   String _location = "Unknown";

//   @override
//   void initState() {
//     super.initState();
//     platform.setMethodCallHandler(_onMethodCall);
//     _startLocationTracking();
//   }

//   // Function to start location tracking from Flutter
//   Future<void> _startLocationTracking() async {
//     try {
//       final String result =
//           await platform.invokeMethod('startBackgroundLocation');
//       print(result); // "Location tracking started"
//     } on PlatformException catch (e) {
//       print("Failed to start location tracking: ${e.message}");
//     }
//   }

//   // Method to handle method calls from Android (e.g., location updates)
//   Future<void> _onMethodCall(MethodCall call) async {
//     if (call.method == 'updateLocation') {
//       setState(() {
//         _location = call.arguments; // Update location data from Android
//       });
//     }
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(title: const Text("Background Location")),
//       body: Center(
//         child: Column(
//           mainAxisAlignment: MainAxisAlignment.center,
//           children: [
//             const Text("Current Location:", style: TextStyle(fontSize: 20)),
//             const SizedBox(height: 10),
//             Text(
//               _location,
//               style: const TextStyle(fontSize: 16, color: Colors.grey),
//               textAlign: TextAlign.center,
//             ),
//           ],
//         ),
//       ),
//     );
//   }
// }
import 'dart:async'; // Add this import for Timer functionality
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Background Location',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const BackgroundLocationPage(),
    );
  }
}

class BackgroundLocationPage extends StatefulWidget {
  const BackgroundLocationPage({super.key});

  @override
  _BackgroundLocationPageState createState() => _BackgroundLocationPageState();
}

class _BackgroundLocationPageState extends State<BackgroundLocationPage> {
  static const platform = MethodChannel('com.example.locationcheck/location');

  String _location = "Unknown";
  int _counter = 0; // Variable to store the counter value

  late Timer _timer; // Declare the timer

  @override
  void initState() {
    super.initState();
    platform.setMethodCallHandler(_onMethodCall);
    _startLocationTracking();
    _startCounter(); // Start the counter when the page loads
  }

  // Function to start location tracking from Flutter
  Future<void> _startLocationTracking() async {
    try {
      final String result =
          await platform.invokeMethod('startBackgroundLocation');
      print(result); // "Location tracking started"
    } on PlatformException catch (e) {
      print("Failed to start location tracking: ${e.message}");
    }
  }

  // Method to handle method calls from Android (e.g., location updates)
  Future<void> _onMethodCall(MethodCall call) async {
    if (call.method == 'updateLocation') {
      setState(() {
        _location = call.arguments; // Update location data from Android
      });
    }
  }

  // Function to start the counter and update every 10 seconds
  void _startCounter() {
    _timer = Timer.periodic(const Duration(seconds: 10), (Timer t) {
      setState(() {
        _counter++; // Increment counter every 10 seconds
      });
    });
  }

  @override
  void dispose() {
    _timer.cancel(); // Cancel the timer when the widget is disposed
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Background Location")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text("Current Location:", style: TextStyle(fontSize: 20)),
            const SizedBox(height: 10),
            Text(
              _location,
              style: const TextStyle(fontSize: 16, color: Colors.grey),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 20),
            const Text("Counter (every 10 seconds):",
                style: TextStyle(fontSize: 20)),
            Text(
              '$_counter',
              style: const TextStyle(fontSize: 30, color: Colors.blue),
            ),
          ],
        ),
      ),
    );
  }
}
