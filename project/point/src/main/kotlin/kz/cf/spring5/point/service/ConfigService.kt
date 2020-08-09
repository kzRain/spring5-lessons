package kz.cf.spring5.point.service

import kz.cf.spring5.point.model.Config
import kz.cf.spring5.point.repo.ConfigRepository
import org.springframework.stereotype.Service

interface ConfigService {
    fun save(config: Config): Config
}

@Service
class ConfigServiceImpl(private val configRepository: ConfigRepository) : ConfigService {
    override fun save(config: Config): Config {
        return configRepository.save(config)
    }


}