package com.lamti.listdemo

const val EMPTY = ""

// Το αντικείμενο που θα παίρνουμε από την βάση
// Για αρχή του έχουμε δώσει μόνο εικόνα και τίτλο
data class MyItem(
    val title: String = EMPTY,
    val imagePath: String = EMPTY,
    val description: String = EMPTY,
)