package atm

import org.uqbar.commons.model.exceptions.UserException

class NoCreditException(message: String): UserException(message)
