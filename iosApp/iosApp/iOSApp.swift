import SwiftUI

@main
struct iOSApp: App {
    // 注入 UIKit 的 AppDelegate，使其仍然可以响应系统事件
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
