package br.com.fiap.mybmi.repository

import br.com.fiap.mybmi.dao.WeightDao
import br.com.fiap.mybmi.model.Weight
import kotlinx.coroutines.flow.Flow

class WeightRepository(private val weightDao: WeightDao) {

    suspend fun insertWeight(weight: Weight): Long {
        return weightDao.insertWeight(weight)
    }

    val listWeights: Flow<List<Weight>> = weightDao.listWeights()

    suspend fun findWeightById(id: Int): Weight {
        return weightDao.findWeightByID(id)
    }


    suspend fun deleteWeight(weight: Weight): Int {
        return weightDao.deleteWeight(weight)
    }


    suspend fun updateWeight(weight: Weight): Int {
        return weightDao.updateWeight(weight)
    }
}