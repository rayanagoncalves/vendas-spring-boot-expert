package io.github.rayanagoncalves

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

class CustomPageRequest : PageRequest {

    constructor(page: Int, size: Int) : super(page - 1, size, Sort.unsorted())

    constructor(page: Int, size: Int, sort: Sort) : super(page - 1, size, sort)

    override fun getPageNumber(): Int {
        return super.getPageNumber() + 1
    }

    companion object {
        fun of(page: Int, size: Int): Pageable {
            return CustomPageRequest(page, size)
        }

        fun of(page: Int, size: Int, sort: Sort): Pageable {
            return CustomPageRequest(page, size, sort)
        }
    }
}