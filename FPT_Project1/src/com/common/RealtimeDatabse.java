package com.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.bean.Notification;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RealtimeDatabse {
	private static DatabaseReference ref = null;

	public RealtimeDatabse() {
		FileInputStream serviceAccount;
		try {
			serviceAccount = new FileInputStream(
					"C:\\Users\\trann\\Downloads\\FPT_Project1\\WebContent\\json\\fptproject-1819-firebase-adminsdk-98g5c-f00a673633.json");
			FirebaseOptions options;
			try {
				options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
						.setDatabaseUrl("https://fptproject-1819.firebaseio.com").build();
				if (FirebaseApp.getApps().isEmpty()) {
					FirebaseApp.initializeApp(options);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ref = FirebaseDatabase.getInstance().getReference("notifications/NotificationID");
	}

	public List<Notification> getListNotitfications() {
		CountDownLatch done = new CountDownLatch(1);
		List<Notification> list = new ArrayList<>();
		ref.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
					Notification notification = dataSnapshot2.getValue(Notification.class);
					System.out.println(notification.getContent());
					list.add(notification);
				}
				done.countDown();
			}

			@Override
			public void onCancelled(DatabaseError error) {
			}
		});
		try {
			done.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertNotification(String title, String datecreate, String content, String managerid) {
		CountDownLatch done = new CountDownLatch(1);
		String id = ref.push().getKey();
		Notification notification = new Notification(title, datecreate, content, managerid);
		ref.child(id).setValue(notification, new CompletionListener() {

			public void onComplete(DatabaseError databaseError, DatabaseReference arg1) {
				if (databaseError != null) {
					System.out.println("Data could not be saved " + databaseError.getMessage());
				} else {
					System.out.println("Data saved successfully.");
					done.countDown();
				}
			}
		});
		try {
			done.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RealtimeDatabse databse = new RealtimeDatabse();
		databse.insertNotification("okea", "okea", "Test count lần 5 ", "okae");
		databse.getListNotitfications();
	}
}
