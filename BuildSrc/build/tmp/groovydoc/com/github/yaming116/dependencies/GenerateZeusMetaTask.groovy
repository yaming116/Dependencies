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
    }
}