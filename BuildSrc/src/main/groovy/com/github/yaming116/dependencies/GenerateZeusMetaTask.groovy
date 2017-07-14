package com.github.yaming116.dependencies

import org.gradle.api.*
import org.gradle.api.tasks.TaskAction;

class GenerateZeusMetaTask extends DefaultTask {

    @TaskAction
    void output(){

        println 'start run GenerateZeusMetaTask'

        println project.ZeusConfig.isApp
        println project.ZeusConfig.pluginName
        println project.ZeusConfig.pluginVersion
        println project.ZeusConfig.pluginMinVersion
        println project.ZeusConfig.pluginMainClass
        println project.ZeusConfig.metaFileName

        if (project.ZeusConfig.isApp) {
            
            println "当前打包是独立运行的App"
            return
        }

        println "当前打包的是插件"
        def metaFileName = "zeusplugin.meta"

        if (project.hasProperty("META_FILE_NAME")) {
            metaFileName = META_FILE_NAME + ".meta"
        }
    }
}