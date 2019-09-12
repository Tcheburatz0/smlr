package ru.Tcheburatz0.smrl.model.repositories

import org.springframework.data.repository.Repository
import ru.Tcheburatz0.smrl.model.Link
import java.util.*

/**
 * This class is developed by maxsyachin on 17.05.16
 * for smlr in version ru.Tcheburatz0.smrl.model.repositories
 * under MIT license
 */
interface LinkRepository : Repository<Link, Long> {
    fun findOne(id: Long?): Optional<Link>
    fun save(link: Link): Link
    fun findAll(): List<Link>
}