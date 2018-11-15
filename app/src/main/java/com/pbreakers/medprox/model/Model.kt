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

data class Notification(
    var idNotification: String = "",
    var dateDebut: Int = 0,
    var dateFin: Int = 0,
    var title: String = "",
    var contenu: String = "",
    var cible: String = "",
    var urlPhoto: String = ""
)