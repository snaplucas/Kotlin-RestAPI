package rest.api.configuration

import com.mongodb.MongoClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration


@Configuration
open class MongoConfig : AbstractMongoConfiguration() {

    override fun getDatabaseName() = "test"

    override fun mongo() = MongoClient("127.0.0.1", 27017)
}