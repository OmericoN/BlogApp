package io.github.omericon.blogapp.dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import io.github.omericon.blogapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Repository
public class FirebaseRepository implements UserRepository {
    private static final String COLLECTION_NAME = "users";
    private static final Firestore db = FirestoreClient.getFirestore();
    @Override
    public String saveUser(User user) {
        db.collection(COLLECTION_NAME).document(user.getId()).set(user);
        return user.getId();
    }

    @Override
    public Optional<User> getUserById(String id) {
        try {
            DocumentSnapshot snapshot = db.collection(COLLECTION_NAME).document(id).get().get();
            return snapshot.exists() ? Optional.of(snapshot.toObject(User.class)) : Optional.empty();

        } catch (InterruptedException | ExecutionException e){
            return Optional.empty();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            ApiFuture<QuerySnapshot> querySnapshot = db.collection("users").get();
            List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

            List<User> users = new ArrayList<>();
            for (QueryDocumentSnapshot doc : documents) {
                users.add(doc.toObject(User.class));
            }
            return users;
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteUser(String id) {
        db.collection(COLLECTION_NAME).document(id).delete();
        return true;
    }
}
