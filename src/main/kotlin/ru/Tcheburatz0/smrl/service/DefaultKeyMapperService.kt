package ru.Tcheburatz0smrl.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import ru.Tcheburatz0.smrl.model.Link
import ru.Tcheburatz0.smrl.model.repositories.LinkRepository
import ru.Tcheburatz0.smrl.service.KeyConverterService

/**
 * This class is developed by maxsyachin on 25.04.16
 * for smlr in version ru.fnnetrolle.smrl.service
 * under MIT license
 */
@Component
open class DefaultKeyMapperService: KeyMapperService {

    @Autowired
    lateinit var converter: KeyConverterService

    @Autowired
    lateinit var repo: LinkRepository

    @Transactional
    override fun add(link: String) =
            converter.idToKey(repo.save(Link(link)).id)

    override fun getLink(key: String): KeyMapperService.Get {
        val result = repo.findOne(converter.keyToId(key))
        return if (result.isPresent) {
            KeyMapperService.Get.Link(result.get().text)
        } else {
            KeyMapperService.Get.NotFound(key)
        }
    }
}
