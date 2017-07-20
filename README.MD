Dependencies
====

[zeus](https://github.com/iReaderAndroid/ZeusPlugin)编译插件的插件助手，方便生成*zeusplugin.meta*文件和*jar文件依赖问题*

插件会根据 **isApp** 处理当前项目文件夹 **sdk-jars** 文件夹中的jar包是 **compile** 还是 **provided**

Usege
===

添加如下信息到: `app/build.gradle`

```gradle
buildscript {
    repositories {
        jcenter()
        maven {url 'https://raw.githubusercontent.com/yaming116/Dependencies/master/repo'}
    }
    dependencies {
        classpath 'com.github.yaming116:dependencies:1.0.0'
    }
}
ext{
    //这个需要在声明插件之前，否则不起效果
    isApp = true
}
apply plugin: 'zeus-plugin'


ZeusConfig{
    pluginName = "test" //必填
    pluginMainClass = "com.teset" //必填
    pluginMinVersion = 1 //可以不填写，默认值为：1
    pluginVersion = 1 //可以不填写，默认值为：1
    metaFileName = "zeusplugin.meta" //可以不填写，默认值为：zeusplugin.meta
}

```

运行 **gradlew GenerateZeusMetaTask**


License
===

Copyright (C) 2011 花开堪折枝 Software Ltd

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
