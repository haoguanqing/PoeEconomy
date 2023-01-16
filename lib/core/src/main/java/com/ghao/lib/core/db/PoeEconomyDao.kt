package com.ghao.lib.core.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ghao.lib.core.data.Transaction
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface PoeEconomyDao {
    @Query("SELECT * FROM `Transaction`")
    fun getAll(): Single<List<Transaction>>

    @Query("SELECT * FROM `Transaction` WHERE id == (:transactionId)")
    fun findById(transactionId: Long): Single<Transaction>

    @Query("SELECT * FROM `Transaction` WHERE id IN (:ids)")
    fun findAllByIds(ids: IntArray): Single<List<Transaction>>

    @Query("SELECT * FROM `Transaction` ORDER BY date DESC")
    fun getAllOrderByDate(): Single<List<Transaction>>

    @Query("SELECT * FROM `Transaction` ORDER BY merchant_name DESC")
    fun getAllOrderByMerchantName(): Single<List<Transaction>>

    @Query("SELECT * FROM `Transaction` ORDER BY merchant_category DESC")
    fun getAllOrderByMerchantCategory(): Single<List<Transaction>>

    @Insert
    fun insertAll(transactions: List<Transaction>): Completable

    @Delete
    fun delete(transaction: Transaction): Completable
}
