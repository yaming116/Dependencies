package com.github.yaming116.dependencies

import org.apache.commons.lang.NullArgumentException
import org.gradle.api.*
import org.gradle.api.tasks.TaskAction;

class GenerateZeusMetaTask extends DefaultTask {

    @TaskAction
    void output(){

        println 'start run GenerateZeusMetaTask'

        println project.ZeusConfig.pluginName
        println project.ZeusConfig.pluginVersion
        println project.ZeusConfig.pluginMinVersion
        println project.ZeusConfig.pluginMainClass
        println project.ZeusConfig.metaFileName

        if (project.ext.isApp) {
            println "当前打包是独立运行的App"
            return
        }

        if (project.ZeusConfig.pluginName == null) {
            println("ZeusConfig.pluginName 不能为空")
            throw new NullArgumentException("ZeusConfig.pluginName 不能为空")
        }

        if (project.ZeusConfig.pluginMainClass == null) {
            println("ZeusConfig.pluginMainClass 不能为空")
            throw new NullArgumentException("ZeusConfig.pluginMainClass 不能为空")
        }

        println "当前打包的是插件"
        def metaFileName = "zeusplugin.meta"

        if (project.ZeusConfig.metaFileName != null) {
            metaFileName = project.ZeusConfig.metaFileName
        }

        def rootDir = project.projectDir.absolutePath
        def metaPath = "$rootDir/src/main/assets/$metaFileName"

        def metaDir = new File(metaPath).getParentFile();
        if (!metaDir.exists()) {
            metaDir.mkdirs()
        }

        def out = new File(metaPath).newPrintWriter();
        def pluginMeta = "{\n" +
                "   \"name\" : \"$project.ZeusConfig.pluginName\", \n" +
                "   \"minVersion\" : \"$project.ZeusConfig.pluginMinVersion\", \n" +
                "   \"version\" : \"$project.ZeusConfig.pluginVersion\", \n" +
                "   \"mainClass\" : \"$project.ZeusConfig.pluginMainClass\" \n" +
                "   \"otherInfo\" : \"$project.ZeusConfig.otherInfo\" \n" +
                "   \"flag\" : \"$project.ZeusConfig.flag\" \n" +
                "}"
        out.write(pluginMeta)
        out.flush()
        out.close()

        println "assets中$metaFileName 中配置已经被修改并成功写入为：\n $pluginMeta"
    }
}