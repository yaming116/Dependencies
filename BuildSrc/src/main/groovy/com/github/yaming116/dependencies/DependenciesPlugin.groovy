package com.github.yaming116.dependencies

import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin implements Plugin<Project> {


    @Override
    void apply(Project project) {
        project.extensions.create('ZeusConfig', ZeusConfigExtension)

        project.task('GenerateZeusMetaTask', type: GenerateZeusMetaTask)

        if (project.ZeusConfig.isApp) {
            project.dependencies.add("compile", project.fileTree(include: ['*.jar'], dir: 'sdk-jars'))
        }else {
            project.dependencies.add("provided", project.fileTree(include: ['*.jar'], dir: 'sdk-jars'))
        }
    }
}