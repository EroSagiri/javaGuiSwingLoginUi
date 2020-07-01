package me.sagiri.java.swing.login

import java.awt.*
import java.awt.event.ItemEvent
import java.awt.event.WindowEvent
import java.awt.event.WindowFocusListener
import java.awt.image.ImageObserver
import java.net.URL
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.*
import javax.swing.plaf.OptionPaneUI

class LoginUi : JFrame {
    companion object {
        val LOGIN = "登录"
        val PASSWORD = "密码"
        val USERNAME = "用户名"
        val SUCCESS = "成功"
        val FAIL = "失败"
        val SAVEPASSWORD = "记住密码"
    }
    val sagiriImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/sagiri.png")
    val appIconImage =  ImageIcon("src/main/resources/icon.png").image
    val loginJButton = JButton(LOGIN)
    val usernameJLabel = JLabel(USERNAME)
    val passwordJLabel = JLabel(PASSWORD)
    val passwordJPasswordField = JPasswordField(20)
    val usernameJTextField = JTextField(20)
    val loginStatusJLabel = JLabel()
    val savePasswordJCheckBox = JCheckBox(SAVEPASSWORD, true)
    val logger = Logger.getLogger("Login")

    constructor() : super() {
        init()
    }

    constructor(windowNmae : String ) : super() {
        init(windowNmae)
    }

    private fun init(windowName : String = "sagiri") {
        add(usernameJLabel)
        add(usernameJTextField)
        add(passwordJLabel)
        add(passwordJPasswordField)
        add(savePasswordJCheckBox)
        add(loginJButton)
        add(loginStatusJLabel)

        title = windowName
        iconImage = appIconImage
        setSize(800, 600)
        setVisible(true)
        layout = null
        minimumSize = Dimension(500, 500)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE


        usernameJLabel.setBounds(20, 20, 50, 20)
        usernameJTextField.setBounds(80, 20, 200, 20)
        passwordJLabel.setBounds(20, 50, 50, 20)
        passwordJPasswordField.setBounds(80, 50, 200, 20)
        savePasswordJCheckBox.setBounds(80, 70, 100, 20)
        loginJButton.setBounds(20, 110, 100, 30)
        loginStatusJLabel.setBounds(20, 150, 50, 20)

        // 点击登录按钮事件
        loginJButton.addActionListener {
            val username = usernameJTextField.text
            val password = String(passwordJPasswordField.password)
            if (username == password && username.length > 0 && password.length > 0) {
                loginStatusJLabel.text = SUCCESS
            } else {
                loginStatusJLabel.text = FAIL
            }
            if (savePasswordJCheckBox.isSelected) {
                // 勾选保存密码
            }

            //JOptionPane.showMessageDialog(this, "Hi,Sagiri", "Sagiri", JOptionPane.ERROR_MESSAGE)
        }
        // 保存密码检查框选择事件
        savePasswordJCheckBox.addItemListener{ e ->
            if (e.stateChange == 1) {
                // 选择状态
                logger.info("select save")
            } else {
                // 非选择状态
                logger.info("not select save")
            }
        }
        // 窗口获得焦点和丢失焦点事件
        addWindowFocusListener(object  : WindowFocusListener {
            override fun windowGainedFocus(e: WindowEvent?) {
                iconImage = sagiriImage
            }

            override fun windowLostFocus(e: WindowEvent?) {
                iconImage = appIconImage
            }
        })

    }
}