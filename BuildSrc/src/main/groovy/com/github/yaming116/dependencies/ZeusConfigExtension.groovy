package com.github.yaming116.dependencies


class ZeusConfigExtension{
    def pluginName = null
    def pluginMinVersion = 1
    def pluginVersion = 1
    def pluginMainClass = null
    def metaFileName = "zeusplugin.meta"
    def otherInfo = ""
    def flag = ""


    @Override
    public String toString() {
        return "ZeusConfigExtension{" +
                ", pluginName=" + pluginName +
                ", pluginMinVersion=" + pluginMinVersion +
                ", pluginVersion=" + pluginVersion +
                ", pluginMainClass=" + pluginMainClass +
                ", metaFileName=" + metaFileName +
                ", otherInfo=" + otherInfo +
                ", flag=" + flag +
                '}';
    }
}