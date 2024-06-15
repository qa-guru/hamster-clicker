Описание настроек еще в процессе, примерный вариант
1. Настроить компьютер для запуска web-тестов https://github.com/qa-guru/getting-started-java/wiki

2. Настроить компьютер для запуска mobile-тестов
- Установить android studio https://developer.android.com/studio
- Прописать настройки:<br/>
Параметры Path:<br/>

**Windows**:<br/>
%ANDROID_HOME%\tools<br/>
%ANDROID_HOME%\tools\bin<br/>
%ANDROID_HOME%\platform-tools<br/>
Одной строкой, можно скопировать и добавить в конец Path: ;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools

**Mac**:<br/>
export ANDROID_HOME=/Users/stanislav/Library/Android/sdk<br/>
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools<br/>
source ~/.bash_profile

- Установить node.js - https://nodejs.org/en/download
- Установить Appium Server https://github.com/appium/appium<br/>
sudo npm install -g appium@next<br/>
- Установить драйвер uiautomator2
sudo appium driver install --source=npm uiautomator2 (если команда не подходит - можно выполнить эту appium driver install uiautomator2)
- Установить Appium Ispector https://github.com/appium/appium-inspector
- Запустить Appium Server<br/>
appium server --base-path /wd/hub