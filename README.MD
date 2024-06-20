Описание настроек еще в процессе, примерный вариант:
1. Настроить компьютер для запуска web-тестов https://github.com/qa-guru/getting-started-java/wiki
2. Настроить компьютер для запуска mobile-тестов

## Установка Android studio
Скачать и установить: [https://developer.android.com/studio](https://developer.android.com/studio)

## Прописать настройки, параметры Path:

### Windows:
%ANDROID_HOME%\tools
%ANDROID_HOME%\tools\bin
%ANDROID_HOME%\platform-tools

Одной строкой, можно скопировать и добавить в конец Path: ;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools

### Mac:
```
export ANDROID_HOME=/Users/$USER/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
source ~/.bash_profile
```

## Установка node.js
Если команда в терминале:
```
node -v
```
не показывает версию, например: **v18.17.1**
то переходим по ссылке для установки: [https://nodejs.org/en/download](https://nodejs.org/en/download)

## Установка Appium Server

Переходим по ссылке: [https://github.com/appium/appium](https://github.com/appium/appium)
Ознакамливаемся с инструкцией

Установить можно командой в терминале:
```
sudo npm i -g appium
```

## Установка драйвера UiAutomator2 Driver
Переходим по ссылке: [https://appium.io/docs/en/2.0/quickstart/uiauto2-driver/](https://appium.io/docs/en/2.0/quickstart/uiauto2-driver/)
Ознакамливаемся с инструкцией
```
sudo appium driver install uiautomator2
```
## Установка Appium Inspector
Скачать и установить под свою OS: [https://github.com/appium/appium-inspector/releases](https://github.com/appium/appium-inspector/releases)

## Установка appium/doctor
Инструкция: [https://www.npmjs.com/package/@appium/doctor](https://www.npmjs.com/package/@appium/doctor)
<br>Очень полезная утилита - позволит узнать что у Вас не в порядке
<br>Запускает командой:
```
appium-doctor 
```
и предоставляет отчёт

## Примерный порядок запуска:

### Действия со смартфоном:

Найти в гугле как перевести свою модель телефона в **Developer mode:**
<br>Как правило в разделе о телефоне, кликнуть 7 раз по **build number**
<br>В **developer options** выбрать опции:
<br>USB debugging
<br>Disable adb authorization timeout
<br>Disable permission monitoring

### Дальнейшие действия:
* Запустить IDE
* Подключить кабелем Android телефон к компьютеру и выбрать режим передачи данных
* В терминале набрать команду:
```
appium server --base-path /wd/hub
```
Если будет ошибка, что файл не исполняемый, то выполнить команды в терминале:
```
chmod -R u+w /Users/ЗАМЕНИТЬНАИМЯВАШЕГОПОЛЬЗОВАТЕЛЯ/.appium
```
и
```
sudo chown -R ЗАМЕНИТЬНАИМЯВАШЕГОПОЛЬЗОВАТЕЛЯ /Users/ЗАМЕНИТЬНАИМЯВАШЕГОПОЛЬЗОВАТЕЛЯ/.appium
```

В случае глобальных проблем Appium server переустанавливается командой
```
npm uninstall -g appium
```

и устанавливается далее командой в терминале:
```
npm install -g appium
```

На всякий случай можно обновить npm в случае проблем:
```
npm install -g npm
```
Сбросить кэш npm:
```
npm cache clean --force
```
Данные команды в зависимости от возникаемых ошибок выполнять если appium server
не стартует

### Далее запускаем Appium inspector
Указываем следующие параметры:
**Remote Host:** localhost<br>
**Remote Path:** /wd/hub

В Capability Builder
заполняете Name и Value значения так:

| name                       | value       |
|----------------------------|--------------------------------|
| platformName               | android                        |
| deviceName                 | серийный номер вашего телефона |
| automationName             | UiAutomator2                   |
| ignoreHiddenApiPolicyError | true                           |

Последнее свойство ignoreHiddenApiPolicyError требовалось конкретно для моей
модели телефона

Нажимаете на кнопку **Start Session**
