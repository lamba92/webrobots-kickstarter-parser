package main

import parser.FileParser
import java.io.File

fun main(args: Array<String>){
    if(args.size != 1) throw Exception("PARAMETER ERROR")
    val c = ArrayList<File>()
    File(args[0]).walkTopDown().filter { it.extension == "json" }.toCollection(c)
    FileParser(c, createTempFile("out", ".csv", File(args[0]))).start()
}

fun String.changeChars(): String {
    var l = replace('T', '-')
    l = l.removeRange(l.indexOf('.'), l.length)
    return l
}