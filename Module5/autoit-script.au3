WinWait("Open", "", 5)
ControlFocus("Open", "", "Edit1")
Sleep(2000)
ControlSetText("Open", "", "Edit1", "C:\Code\Java\Repos\Module5\selenium.png")
Sleep(2000)
ControlClick("Open", "", "Button1")