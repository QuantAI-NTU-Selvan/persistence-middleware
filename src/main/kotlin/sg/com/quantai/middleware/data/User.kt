package sg.com.quantai.middleware.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DBRef
import java.time.LocalDateTime
import kotlin.collections.emptyList
import java.math.BigDecimal

@Document(collection = "users")
data class User (
        // Database columns
        @Id val _id: ObjectId = ObjectId.get(), // document id, it changes when updated via upsert
        @Indexed(unique = true) val uid: String = ObjectId.get().toString(),
        // Id columns
        val name: String,
        val email: String,
        val password: String? = null,
        // Security columns
        val salt: String? = null,
        val passwordToken: String? = null,
        val passwordTokenExpiration: LocalDateTime = LocalDateTime.now(),
        // Control columns
        val isRegistered: Boolean = false,
        val isGoogleLogin: Boolean = false,
        val isAdmin: Boolean = false,
        val has2fa: Boolean = false,
        val secret2FA: String? = null,
        val lastLogin: LocalDateTime? = null,
        val hasSessionTimeout: Boolean = true,
        val sessionDuration: BigDecimal = BigDecimal(180),
        // Timestamps columns
        val createdDate: LocalDateTime = LocalDateTime.now(),
        val updatedDate: LocalDateTime = LocalDateTime.now(),
        // Relationships columns
        @DBRef(lazy=true) val transactions: List<Transaction> = emptyList<Transaction>(),
        @DBRef(lazy=true) val strategies: List<NewStrategy> = emptyList<NewStrategy>(),
)