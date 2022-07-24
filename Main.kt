/**
 *          Renatto Esteban Guzmán Sosa                  *
 *          Carné 21646                                  *
 *          Programación de Plataformas Móviles          *
 *          Profesor Francisco Anzueto                   *
 *          17/07/2022                                   *
 *                                                       *
 *          MI PRIMER PROGRAMA CON KOTLIN                *
*/

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(true, 57, "ProbandoUnDosTres", 3.0))
    println(result)
}


fun processList(inputList: List<Any?>?): List<ItemData>? {

    if (inputList == null){
        return null
    }

    var outputList: MutableList<ItemData>? = ArrayList<ItemData>(0)

    var dataItem: ItemData? = null
    var position: Int = 0
    for (item in inputList) {

        if (item != null) {
            when(item){
                is String -> dataItem = esString(position, item)
                is Int -> dataItem= esInt(position, item)
                is Boolean -> dataItem = esBoolean(position, item)
                else -> dataItem = esOtro(position, item)

            }
            if (outputList != null) {
                outputList.add(dataItem)
            }
        }

        position++
    }
    return outputList
}



fun esString(posi: Int, valor: String): ItemData{

    val cantLetras: Int = valor.toList().size

    val itemString = ItemData(
        originalPos = posi,
        originalValue = valor,
        type = "cadena",
        info = "L$cantLetras"
    )
    return itemString
}

fun esInt(posi: Int, valor: Int): ItemData{
    var numFinal: Int = 0
    if(valor % 10 == 0){
        numFinal = 10
    }
    else if (valor % 5 == 0){
        numFinal = 5
    }
    else if (valor % 2 == 0){
        numFinal = 2
    }
    else numFinal = 0

    var msg: String? = " "
    msg = if (numFinal != 0)
        "M$numFinal"
    else null

    val itemString = ItemData(
        originalPos = posi,
        originalValue = valor,
        type = "entero",
        info = msg
    )
    return itemString
}

fun esBoolean(posi: Int, valor: Boolean): ItemData{

    var msg: String = " "

    msg = if (valor){
        "Verdadero"
    }
    else {"Falso"}

    val itemString = ItemData(
        originalPos = posi,
        originalValue = valor,
        type = "booleano",
        info = msg
    )
    return itemString

}

fun esOtro(posi: Int, valor: Any): ItemData{

    val itemString = ItemData(
        originalPos = posi,
        originalValue = valor,
        type = null,
        info = null
    )
    return itemString
}