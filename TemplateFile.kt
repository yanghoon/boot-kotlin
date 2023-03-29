package com.example.bootkotlin.template

import org.springframework.core.io.Resource

class TemplateFile(
    path: String,
    content: Resource,
) {
    val PATH_PREFIX: String = "{"
    val PATH_SUFFIX: String = "}"

    val path: StringTemplate = StringTemplate(path, PATH_PREFIX, PATH_SUFFIX)
    val content: StringTemplate = FileTemplate(content)

    fun replacePath(vars: Map<String, Any>): String
        = path.replace(vars)

    fun replaceContent(vars: Map<String, Any>): String
        = content.replace(vars)

    fun replace(vars: Map<String, Any>): Pair<String, String>
        = replacePath(vars) to replaceContent(vars)
    
    private fun toString(resource: Resource): String
        = resource.inputStream.readAllBytes().toString()
}
