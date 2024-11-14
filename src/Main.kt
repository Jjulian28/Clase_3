fun main() {
    val personas = mutableListOf<Persona>()

    repeat(5) {
        println("Ingrese el peso del usuario ${it + 1} en kg:")
        val peso = readLine()!!.toDouble()

        println("Ingrese la estatura del usuario ${it + 1} en metros:")
        val estatura = readLine()!!.toDouble()

        val persona = Persona(peso, estatura)
        personas.add(persona)
        println("Usuario ${it + 1} registrado con éxito.\n")
    }

    println("\nResumen de Usuarios Registrados:")
    personas.forEach {
        println(it.toCard())
    }
}

class Persona(val peso: Double, val estatura: Double) {
    val imc: Double = calcularIMC()
    val clasificacion: String = obtenerClasificacionIMC()

    init {
        println("Calculando IMC y clasificación...")
    }

    private fun calcularIMC(): Double {
        return peso / (estatura * estatura)
    }

    private fun obtenerClasificacionIMC(): String {
        return when {
            imc < 16.0 -> "Delgadez severa"
            imc in 16.0..16.99 -> "Delgadez moderada"
            imc in 17.0..18.49 -> "Delgadez leve"
            imc in 18.5..24.99 -> "Normal"
            imc in 25.0..29.99 -> "Preobeso"
            imc in 30.0..34.99 -> "Obesidad leve"
            imc in 35.0..39.99 -> "Obesidad media"
            else -> "Obesidad mórbida"
        }
    }

    fun toCard(): String {
        return """
            ============================
            | Peso:           $peso kg |
            | Estatura:       $estatura m |
            | IMC:            ${"%.2f".format(imc)} |
            | Clasificación:  $clasificacion |
            ============================
        """.trimIndent()
    }
}

