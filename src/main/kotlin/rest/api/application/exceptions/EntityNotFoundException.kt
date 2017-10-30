package rest.api.application.exceptions

import java.lang.Exception

class EntityNotFoundException(override var message: String) : Exception()