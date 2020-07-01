package me.sagiri.kjava.swing.login
import me.sagiri.java.swing.login.LoginUi
import java.awt.event.ActionEvent

fun main() {
    val mainWindow = LoginUi().apply {
        savePasswordJCheckBox.isSelected = false
    }
    Thread(object : Runnable{
        override fun run() {
            for(i in 1..10) {
                Thread.sleep(100)
                mainWindow.usernameJTextField.text += i
            }
            for(i in 1..10) {
                Thread.sleep(100)
                mainWindow.passwordJPasswordField.text += i
            }
            Thread.sleep(500)
            mainWindow.savePasswordJCheckBox.isSelected = true
            Thread.sleep(500)
            // 额，找不到点击按钮事件的接口，直接调用这个事件
            mainWindow.loginJButton.actionListeners[0].actionPerformed(null)
        }
    }).run()
}