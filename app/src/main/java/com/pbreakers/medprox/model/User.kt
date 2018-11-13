package com.pbreakers.medprox.model

data class User(
    var id: String = "",
    var login: String = ""
)

data class TypePartenaire(
    var idType: String = "",
    var nomType: String = "",
    var descripType: String = ""
)