package com.farmani.xchess.model

class Chess {
    var pieces = mutableListOf<Piece>()

    init {
        reset()


    }

    private fun reset() {
        pieces.removeAll(pieces)
        for (col in 0..7) {
            pieces.add(Piece(1, col, Player.WHITE, Rank.PAWN))
            pieces.add(Piece(6, col, Player.BLACK, Rank.PAWN))

        }

        for (col in 0..1) {
            pieces.add(Piece(0, col * 7, Player.WHITE, Rank.ROOK))
            pieces.add(Piece(7, col * 7, Player.BLACK, Rank.ROOK))

            pieces.add(Piece(0, 1 + col * 5, Player.WHITE, Rank.KNIGHT))
            pieces.add(Piece(7, 1 + col * 5, Player.BLACK, Rank.KNIGHT))

            pieces.add(Piece(0, 2 + col * 3, Player.WHITE, Rank.BISHOP))
            pieces.add(Piece(7, 2 + col * 3, Player.BLACK, Rank.BISHOP))
        }

        pieces.add(Piece(0, 3, Player.WHITE, Rank.QUEEN))
        pieces.add(Piece(0, 4, Player.WHITE, Rank.KING))
        pieces.add(Piece(7, 3, Player.BLACK, Rank.QUEEN))
        pieces.add(Piece(7, 4, Player.BLACK, Rank.KING))
    }

    fun pieceAt(row: Int, col: Int): Piece? {
        for (piece in pieces) {
            if (row == piece.row && col == piece.col) {
                return piece
            }
        }
        return null
    }

    override fun toString(): String {
        var str = ""
        for (row in 7 downTo 0) {
            str += "$row"
            for (col in 0..7) {
                val piece = pieceAt(row, col)
                if (piece == null) {
                    str += " ."
                } else {
                    val white = piece.player == Player.WHITE
                    str += when (piece.rank) {
                        Rank.PAWN -> {
                            if (white) " P" else " p"
                        }

                        Rank.KNIGHT -> {
                            if (white) " KT" else " kt"
                        }

                        Rank.BISHOP -> {
                            if (white) " B" else " b"
                        }

                        Rank.ROOK -> {
                            if (white) " R" else " r"
                        }

                        Rank.QUEEN -> {
                            if (white) " Q" else " q"
                        }

                        Rank.KING -> {
                            if (white) " K" else " k"
                        }
                    }
                }
            }
            str += " \n"
        }
        str += "  0 1 2 3 4 5 6 7"
        return str
    }
}