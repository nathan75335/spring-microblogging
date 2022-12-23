package com.godsonpeya.microblog.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class NotFoundException (message : String ) : Exception(message) {
}