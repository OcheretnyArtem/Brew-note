package by.ocheretny.domain.repositories

import by.ocheretny.domain.entity.Coffee
import by.ocheretny.domain.entity.Infusion
import by.ocheretny.domain.entity.Profile
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    suspend fun getProfileById(id: Int): Profile

    suspend fun getAllProfiles() : Flow<List<Profile>>

    suspend fun insert(profile: Profile)

    suspend fun insert(coffee: Coffee)

    suspend fun insert(infusion: Infusion)

    suspend fun insert(infusions: List<Infusion>)

    suspend fun delete(coffee: Coffee)

    suspend fun delete(profile: Profile)

}