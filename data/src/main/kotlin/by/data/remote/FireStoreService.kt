package by.data.remote

import by.data.remote.entities.ProfileRemote
import by.data.remote.entities.UserRemote
import by.data.remote.utils.observeItemsFromFireStore
import by.domain.coroutines.DispatcherProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val USERS = "users"
private const val GROUPS = "groups"
private const val PROFILES = "profiles"
private const val COFFEE = "coffee"
private const val INFUSIONS = "infusions"

internal class RemoteServiceImpl @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val dispatchers: DispatcherProvider,
) : RemoteService {

    override suspend fun getUsersByName(name: String): Flow<List<UserRemote>> = observeItemsFromFireStore(
        dbRef = fireStore.collection(USERS),
        coroutineContext = dispatchers.io,
        keySearchQuery = "name",
        valueSearchQuery = name
    )

    override suspend fun getProfilesFromGroup(groupID: String): Flow<List<ProfileRemote>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProfileFromGroup(
        groupID: String,
        profileID: String,
    ): Flow<ProfileRemote> {
        TODO("Not yet implemented")
    }

    override suspend fun postProfileInGroup(groupID: String, profile: ProfileRemote) {
        fireStore.collection(GROUPS).document(groupID).collection(PROFILES).add(profile)
    }

}
