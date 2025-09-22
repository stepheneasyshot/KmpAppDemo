import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()

	var body: some View {
		Text(greet)
            .onTapGesture {
                print("文字被点击了！")
                fatalError("这是一个手动的error测试")
//                BugCreate_iosKt.createACrash()
            }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
