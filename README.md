# firebase-authentication-app

This is an Android application template for Firebase Authentication. It includes the following features:

## Features

- **User Registration:** Create new user accounts using Firebase Authentication.
- **User Login:** Authenticate existing users with email and password.
- **User Logout:** Sign out the currently logged-in user.
- **Update User Profile:** Modify user display names.
- **Login Status Check:** Verify if a user is logged in.
- **Current User Info:** Retrieve the logged-in user's details (name, email, and profile picture).

## Technical Structure

### FirebaseManager

Manages Firebase Authentication operations, including:

- **User Registration:** `registerUser`
- **User Login:** `loginUser`
- **User Logout:** `logoutUser`
- **Update Profile:** `updateUserProfile`
- **Check Login Status:** `isUserLoggedIn`
- **Retrieve User Info:** `getCurrentUser`

### Activities

- **`LoginActivity`:**
    - Allows users to log in.
    - Redirects authenticated users to the `HomeActivity`.
    - Displays error messages for invalid credentials.
- **`HomeActivity`:**
    - Displays the current user's profile information (name, email, and profile picture).
    - Provides a logout button to sign out the user.
- **`RegisterActivity`:**
    - Allows new users to register.
    - Updates the user's profile with a display name after successful registration.

## Permissions

The app requests the following permissions to function properly:

- **Internet Access:** Required for Firebase Authentication and data retrieval.

## How to Use

1. Clone the repository and open the project in Android Studio.
2. Configure Firebase:
    - Create a Firebase project in the Firebase Console.
    - Add your Android app to the project.
    - Download the `google-services.json` file and place it in the `app` directory.
    - Add Firebase dependencies to the `build.gradle` files.
3. Build and run the application.
   
