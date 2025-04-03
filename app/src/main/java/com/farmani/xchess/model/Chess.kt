package com.farmani.xchess.model

class Chess {
    override fun toString(): String {
        var str = ""
        for (row in 7 downTo 0) {
            str += "$row"
            for (col in 0..7) {
                str += " ."
            }
            str += " \n"
        }
        str += "  0 1 2 3 4 5 6 7"
        return str
    }
}