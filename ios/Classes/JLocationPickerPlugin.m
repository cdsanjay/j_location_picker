#import "JLocationPickerPlugin.h"
#if __has_include(<j_location_picker/j_location_picker-Swift.h>)
#import <j_location_picker/j_location_picker-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "j_location_picker-Swift.h"
#endif

@implementation JLocationPickerPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftJLocationPickerPlugin registerWithRegistrar:registrar];
}
@end
