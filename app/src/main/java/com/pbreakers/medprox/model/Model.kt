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
) {
    companion object {
        const val ID_USER = "idUser"
        const val NOM_USER = "nomUser"
        const val POSTNOM_USER = "postNomUser"
        const val PRENOM_USER = "prenomUser"
        const val ADRESSE_USER = "adressUser"
        const val LOGIN_USER = "loginUser"
        const val PASSWORD_USER = "password"
        const val GENRE_USER = "genre"
        const val DATE_ENREG_USER = "dateEnregistrement"
        const val PROFILE_USER = "urlProfilUser"
        const val KEY_USER = "user-info"
    }
}

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
) {
    companion object {
        const val ID_NOTIFICATION = "idNotification"
        const val DATE_DEBUT_NOTIFICATION  = "dateDebut"
        const val DATE_FIN_NOTIFICATION  = "dateFin"
        const val TITRE_NOTIFICATION  = "title"
        const val CONTENU_NOTIFICATION  = "contenu"
        const val CIBLE_NOTIFICATION = "cible"
        const val URL_PHOTO_NOTIFICATION = "urlPhoto"
    }
}