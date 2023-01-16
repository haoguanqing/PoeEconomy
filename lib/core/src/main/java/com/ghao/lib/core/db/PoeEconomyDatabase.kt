package com.ghao.lib.core.db

import android.content.Context
import androidx.room.Room
import com.ghao.lib.core.data.Transaction
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PoeEconomyDatabase @Inject constructor(
    @ApplicationContext private val appContext: Context
) {

    private val dao by lazy {
        Room.databaseBuilder(
                appContext,
                PoeRoomDatabase::class.java,
                PoeRoomDatabase.DB_NAME
            )
            .build()
            .poeEconomyDao()
    }

    fun insertAll(transactions: List<Transaction>): Completable {
        return dao.insertAll(transactions)
    }

    fun getAllTransactions(orderBy: OrderBy = OrderBy.DEFAULT): Single<List<Transaction>> {
        return when (orderBy) {
            OrderBy.DEFAULT -> dao.getAll()
            OrderBy.DATE -> dao.getAllOrderByDate()
            OrderBy.MERCHANT_NAME -> dao.getAllOrderByMerchantName()
            OrderBy.MERCHANT_CATEGORY -> dao.getAllOrderByMerchantCategory()
        }
    }

    fun findTransactionById(id: Long): Single<Transaction> {
        return dao.findById(id)
    }

    enum class OrderBy {
        DEFAULT, DATE, MERCHANT_NAME, MERCHANT_CATEGORY
    }
}