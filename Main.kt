//         Renatto Esteban Guzmán Sosa       Carné 21646      24/07/2022
//                         L A B O R A T O R I O   3

data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)

fun main() {
    val result = processList(listOf(10, "Enero", null, true))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    if (inputList == null){
        return null
    }
    val outputList = ArrayList<ItemData>(0)
    var tipo: String? = "" ; var info: String? = "" // Declarar variables
    for ((position, item) in inputList.withIndex()) {
        if (item != null) {
            when(item){
                is String -> {tipo = "cadena"; info = "L" + item.toList().size}
                is Int -> {tipo = "entero"
                    var numFinal: Int = 0
                    numFinal = if(item % 10 == 0){10}
                    else if (item % 5 == 0){5}
                    else if (item % 2 == 0){2}
                    else 0
                    info = if (numFinal != 0)
                        "M$numFinal"
                    else null}
                is Boolean -> {tipo = "booleano"
                    info = if (item){
                        "Verdadero"}
                    else {"Falso"}}
                else -> {tipo = null ; info = null}
            }
            outputList.add(ItemData(position, item, tipo, info))}
    }
    return outputList
}