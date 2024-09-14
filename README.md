
# Quiz App

Welcome to the Quiz App! This Android application, developed using Kotlin and Jetpack Compose, offers a dynamic and engaging quiz experience with modern UI design and robust features.

## Features

- **Dynamic Question Generation**: The app selects and presents a random set of quiz questions to ensure a fresh experience with each session.
- **Navigation**: Utilizes Jetpack Compose Navigation to handle seamless transitions between screens, such as the quiz and summary screens.
- **Data Management**: User answers and quiz results are efficiently managed and fetched using Kotlin's coroutines and LiveData.
- **MVVM Architecture**: The app is designed using the MVVM (Model-View-ViewModel) pattern, promoting a clean separation of concerns and enhancing testability and maintainability.

## Screenshots

Here are some screenshots of the app showcasing the user interface and functionality:

<img src="https://github.com/user-attachments/assets/8d2a5abc-835c-4c88-85de-64848e46731d" width="300" alt="Question Screen">
<img src="https://github.com/user-attachments/assets/bde3e544-c6e2-4733-b475-22896c074cdb" width="300" alt="Summary Screen">

## Architecture

- **MVVM Pattern**: The app follows the MVVM architecture, where:
  - **Model**: Represents the data and business logic.
  - **View**: Displays the data and user interface using Jetpack Compose.
  - **ViewModel**: Acts as a bridge, handling UI-related data and business logic, and ensuring that the data is updated in response to user interactions.
- **Navigation**: The app uses Jetpack Compose Navigation for managing screen transitions, making the user experience seamless.
- **Data Management**: Kotlin coroutines and LiveData are used for fetching and managing quiz data and user interactions efficiently.

  ## Getting Started

To run the app locally:

1. Clone the repository:
   ```bash
   git clone <repository_url>
2.Navigate into the project directory: cd quiz_app
3.Open the project in Android Studio.
4.Sync the project with Gradle files.
5.Build and run the app on an emulator or physical device.
