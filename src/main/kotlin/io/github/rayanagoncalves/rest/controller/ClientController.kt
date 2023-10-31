package io.github.rayanagoncalves.rest.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clients")
class ClientController {

    @RequestMapping(
        value = ["/hello/{name}", "api/hello"],
        method = [RequestMethod.GET],
        consumes = ["application/json", "application/xml"],
        produces = ["application/json", "application/xml"]
    )
    @ResponseBody
    fun helloClient(@PathVariable("name") nameClient: String): String {
        return "Hello $nameClient"
    }
}