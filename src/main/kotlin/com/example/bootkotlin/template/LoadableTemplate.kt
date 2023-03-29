package com.example.bootkotlin.template

import java.io.File

abstract class LoadableTemplate<T>(
    source: T,
    // val loader: (source:T) -> String = {s -> s.toString()},
    loader: ( source:T ) -> String,
    prefix: String = "\${",
    suffix: String = "}"): StringTemplate(loader(source), prefix, suffix)
{

    override val template: String = load(source)
    override var prefix: String = prefix
    override var suffix: String = suffix
    
    companion object {
        fun <T> load(source: T): String
            = source.toString()
            // = resource.inputStream.readAllBytes().toString()
    }
}

class FileTemplate(
    source: File,
    prefix: String = "\${",
    suffix: String = "}"
): LoadableTemplate<File>(source, { s -> s.toString() }, prefix, suffix)
