package main

import parser.FileParser
import java.io.File

fun main(args: Array<String>){
    if(args.size != 1) throw Exception("PARAMETER ERROR")
    val c = ArrayList<Thread>()
    File(args[0]).walkTopDown().filter { it.extension == "json" }.forEach {
        c.add(Thread{FileParser(it, File("${args[0]}\\${it.nameWithoutExtension}.csv")).start()}.apply { start() })
    }
    c.forEach { it.join() }
}

fun String.changeChars(): String {
    var l = replace('T', '-')
    l = l.removeRange(l.indexOf('.'), l.length)
    return l
}