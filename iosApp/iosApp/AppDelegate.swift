//
//  AppDelegate.swift
//  iosApp
//
//  Created by Stephen Zhan on 2025/9/22.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation

import UIKit

class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        // 应用程序启动完成后调用
        print("✅ 应用已启动")
        
        // 1. 创建一个 BuglyConfig 实例
        let config = BuglyConfig()

        // 2. 设置一些自定义配置（可选）
        config.debugMode = true                  // 开启 Debug 模式，查看 SDK 内部日志
        config.channel = "AppStore"              // 自定义渠道，比如 "AppStore", "Test", "Internal"
        config.version = "1.0.0"                 // 自定义版本号（如果和 Xcode 的不一致）
        config.blockMonitorEnable = true         // 开启卡顿监控
        config.blockMonitorTimeout = 2.0         // 卡顿超时时间（秒）
        config.unexpectedTerminatingDetectionEnable = true // 开启非正常退出检测
        config.viewControllerTrackingEnable = true // 开启页面信息记录（默认开启）

        // 如果你想接收回调，比如崩溃时带上额外信息，可以实现 BuglyDelegate
        // config.delegate = self  // （需遵循 BuglyDelegate 协议）

        // 3. 使用配置启动 Bugly
        Bugly.start(withAppId: "5875922631",
                    developmentDevice:true,
                    config: config)

        return true
    }

    // 当应用即将进入后台
    func applicationWillResignActive(_ application: UIApplication) {
    }

    // 应用进入后台
    func applicationDidEnterBackground(_ application: UIApplication) {
    }

    // 应用即将进入前台
    func applicationWillEnterForeground(_ application: UIApplication) {
    }

    // 应用进入前台并处于活跃状态
    func applicationDidBecomeActive(_ application: UIApplication) {
    }

    // 应用即将终止
    func applicationWillTerminate(_ application: UIApplication) {
    }
}
