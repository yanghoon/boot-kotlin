package com.example.bootkotlin.template

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.apache.commons.text.StringSubstitutor

@SpringBootTest
class StringTemplateTest {
    val SOURCE_1 = "\${key} = \${value}"
    val SOURCE_2 = "{key} = {value}"
    val RESULT = "k1 = v1"

    @Test
    fun test_stringsubtituter(){
        val vars: Map<String, String> = mapOf("key" to "k1", "value" to "v1")
        val sub = StringSubstitutor(vars)
        
        assertEquals("k1 = v1", sub.replace(SOURCE_1))
    }

    @Test
    fun test_stringsubtituter_with_custom_prefix(){
        val vars: Map<String, String> = mapOf("key" to "k1", "value" to "v1")
        val sub = StringSubstitutor(vars, "{", "}")
        
        assertEquals("k1 = v1", sub.replace(SOURCE_2))
    }

    @Test
    fun test_filetemplate(){
        val resource = ClassPathResource("templates/sample.yaml");
        val template = FileTemplate(resource.file)
        // val template = FileTemplate("{key}/{value}.yaml", resource)
        val vars: Map<String, String> = mapOf("key" to "k1", "value" to "v1")

        val content = template.replace(vars)

        println(content!!)
    }
}