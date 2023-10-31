package io.github.rayanagoncalves.rest.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clients")
class ClientController {

    @GetMapping(value = ["/hello/{name}"])
    @ResponseBody
    fun helloClient(@PathVariable("name") nameClient: String): String {
        return "Hello $nameClient"
    }
}