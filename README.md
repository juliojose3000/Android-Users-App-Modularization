# Users App Modularization 📱

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

A modern Android application implementing a modular architecture for managing user data, built with Jetpack Compose and following clean architecture principles.

## 📱 Overview

Users App Modularization is an Android application that demonstrates best practices in modern Android development through a modular architecture approach. The app uses edge-to-edge design and follows Material Design principles.

## 🚀 Features

- Clean Architecture implementation with modular design
- Edge-to-edge UI design
- User management functionality
- Network connectivity for user data retrieval
- Material Design themed interface

## 🛠️ Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: Clean Architecture with MVVM
- **Dependency Injection**: Hilt
- **Build System**: Gradle (Kotlin DSL)
- **Minimum SDK**: 21 (inferred from modern Android practices)

## 🏗️ Project Structure

The project follows a modular architecture with the following modules:

```
├── app/                  # Main application module
├── core/                 # Core functionality and utilities
├── data/                 # Data layer implementation
├── domain/              # Business logic and entities
├── features/            # Feature modules
```

### Module Responsibilities

- **app**: Main application setup, navigation, and UI theme
- **core**: Shared utilities and base components
- **data**: Data sources and repositories
- **domain**: Business logic and use cases
- **features**: Feature-specific implementations

## 📋 Prerequisites

- Android Studio Arctic Fox or newer
- JDK 11 or higher
- Android SDK with minimum API 21
- Kotlin 1.8 or higher

## ⚙️ Installation & Setup

1. Clone the repository:
```bash
git clone https://github.com/yourusername/UsersApp-Modularization.git
```

2. Open the project in Android Studio

3. Sync project with Gradle files

4. Build the project:
```bash
./gradlew build
```

## 📱 Running the Application

1. Select a target device or emulator
2. Click the "Run" button in Android Studio or execute:
```bash
./gradlew installDebug
```

## 🔧 Configuration

The project uses the following key configurations:

- AndroidX enabled
- Non-transitive R class
- Kotlin official code style
- Memory settings: `-Xmx2048m`

## 🏗️ Architecture

The application implements:
- Clean Architecture principles
- MVVM pattern with ViewModels
- Dependency injection using Hilt
- Modular design for better separation of concerns

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

---

**Note**: This project is still under development. Screenshots and additional documentation will be added as the project progresses.

[⬆ back to top](#users-app-modularization-)
