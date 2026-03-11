package br.com.fiap.mybmi.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.mybmi.model.Weight
import kotlinx.coroutines.flow.Flow


@Dao
interface WeightDao {
    @Insert
    suspend fun insertWeight(weight: Weight): Long

    // Listar todas as pesagens ordenadas pelo id
    @Query("SELECT * FROM TB_WEIGHT ORDER BY id ASC")
    fun listWeights(): Flow<List<Weight>>

    // Buscar uma pesagem pelo id
    @Query("SELECT * FROM TB_WEIGHT WHERE id = :id")
    suspend fun findWeightByID(id: Int): Weight

    // Deletar uma pesagem
    @Delete
    suspend fun deleteWeight(weight: Weight): Int

    // Atualizar uma pesagem
    @Update
    suspend fun updateWeight(weight: Weight): Int

}
