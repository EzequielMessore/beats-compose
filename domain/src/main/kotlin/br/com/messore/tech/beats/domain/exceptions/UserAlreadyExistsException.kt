package br.com.messore.tech.beats.domain.exceptions

class UserAlreadyExistsException : Throwable("User already exists, try to login")

class UserNotFoundException :
    Throwable("We can't find you user, check you username and password and try again ")
