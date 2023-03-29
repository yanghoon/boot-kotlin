package com.example.bootkotlin.template

import org.apache.commons.text.StringSubstitutor

open class StringTemplate(
    template: String,
    prefix: String = "\${",
    suffix: String = "}"
): TextTemplate<String> {
    open override val template: String = template
    open override var prefix: String = prefix
    open override var suffix: String = suffix

    override fun replace(vars: Map<String, Any>)
        = StringSubstitutor.replace(template, vars, prefix, suffix)
}
