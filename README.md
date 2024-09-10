Eka Care Assignment
This project is an Android application that demonstrates a form for entering user details and a list screen for displaying all saved entries. It uses MVVM architecture and Room database for data persistence. The app includes fields for Name, Age, DOB (with Calendar Picker), and Address. The data entered is saved locally and displayed on a separate screen.

Features
Two activities:
One for entering user data.
Another for displaying a list of all saved data.
Calendar Picker for selecting the Date of Birth (DOB).
Saves data to the local database using Room.
Displays all saved entries in a RecyclerView on a separate screen.
Implements MVVM architecture for separation of concerns.
Uses Android XML layouts for UI design.

Technologies Used
Kotlin for Android development.
Room for local database storage.
MVVM (Model-View-ViewModel) for structured application design.
LiveData for observing changes in data.
Coroutines for background thread management.
XML for UI design.
RecyclerView for displaying a list of data.

Installation
To run the project locally:

Clone the repository:

https://github.com/sahajvithani/EkaAssignment.git
Open the project in Android Studio.

Use jdk 11 for build project

Sync the project to install all dependencies.

Run the app on an emulator or a physical device.

Usage
Steps to use the app:
Enter details such as Name, Age, DOB, and Address in the input form in the AddUserActivity.
Select Date of Birth using the Calendar Picker.
Tap the Save button to store the details in the local Room database.
Switch to the UserListActivity to view all saved data in a list.

Architecture
This project follows MVVM Architecture, ensuring a clean separation of concerns:

Model: This layer holds the data and database logic. The User data class defines the structure, while UserRepository handles the interaction with the Room database.
ViewModel: The UserViewModel is responsible for preparing the data for the UI and handling user actions. It interacts with the repository to get and save data.
View (UI): The UI is built using XML layouts. It observes changes in the ViewModel using LiveData and updates the UI accordingly.

Flow
AddUserActivity: The user enters details in the form and clicks the Save button.
UserViewModel: The UserViewModel captures the input and passes it to the repository.
UserRepository: The UserRepository interacts with the Room database to save the data.
UserListActivity: Retrieves all saved data from the database and displays it in a RecyclerView.
