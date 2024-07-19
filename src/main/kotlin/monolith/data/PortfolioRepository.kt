package monolith.data

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface PortfolioRepository : MongoRepository<Portfolio, String> {
    fun findOneByUid(uid: String): Portfolio
    fun findByOwner(owner: User): List<Portfolio>
    fun findByOwnerAndSymbol(owner: User, symbol: String): List<Portfolio>
    fun deleteByUid(id: String)
    override fun deleteAll()
}