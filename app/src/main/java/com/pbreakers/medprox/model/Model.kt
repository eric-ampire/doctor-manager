package com.pbreakers.medprox.model

data class User(
    var idUser: String = "",
    var nomUser: String = "",
    var postNomUser: String = "",
    var prenomUser: String = "",
    var adressUser: String = "",
    var loginUser: String = "",
    var urlProfilUser: String = "",
    var password: String = "",
    var genre: String = "",
    var dateEnregistrement: String = ""
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