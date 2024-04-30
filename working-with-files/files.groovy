println "#### Escribir en un archivo #####"
fileLog = new File("application-groovy.log")
fileLog.write("")
fileLog.append("""{"timestamp": "2024-09-29 11:00:00","code": 200,"msg": "Validación OK"} \n""")
fileLog.append("""{"timestamp": "2024-09-30 12:00:00","code": 500,"msg": "Error del Servidor"} \n""")

println "#### Leer desde un archivo #####"
lineas = fileLog.readLines()
lineas.each { linea ->
    println linea
}

println "#### Listar los archivos de un directorio #####"
directorio = new File("folder1")
// https://docs.groovy-lang.org/latest/html/groovy-jdk/java/io/File.html
directorio.eachFile { file ->
    if( file.isFile() ) {
        println file.name
    }
}

println "#### Listar los archivos de un directorio con condición #####"
directorio = new File("folder1")
directorio.eachFile { file ->
    if( file.isFile() ) {
        // https://docs.groovy-lang.org/latest/html/gapi/org/codehaus/groovy/runtime/StringGroovyMethods.html
        if( file.name.endsWith('.csv') ) {
            println file.name
        }
    }
}

println "#### Ingresar data #####"
println "Ingresa tu banda favorita"
System.in.withReader { reader ->
    banda = reader.readLine()
}
println "Tu banda favorita es ${banda}"
