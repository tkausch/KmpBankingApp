# KMP Banking App

A full-stack Kotlin Multiplatform banking demo app with Android and iOS clients and a Ktor backend server.

## Architecture

The project is split into four Gradle modules:

| Module | Purpose |
|---|---|
| `:androidApp` | Android entry point (Compose UI) |
| `:shared` | KMP shared code — UI, business logic, Ktor HTTP client |
| `:shared-api` | KMP DTOs and service interfaces shared by client and server |
| `:server` | Ktor backend server with JWT authentication |

### Client layers (`:shared`)

```
UI Layer        — Compose screens (LoginScreen, BankingScreen)
Business Layer  — ViewModels, repositories, domain models
Service Layer   — Ktor HTTP services (KtorAuthService, KtorAccountService)
```

Dependency wiring is done via `ServiceFactory` (object singleton).  
JWT tokens are stored in `SessionManager` after a successful login.

### Server (`:server`)

- Ktor + Netty on port `8080`
- JWT authentication (HMAC256, 1-hour expiry)
- REST endpoints:
  - `POST /api/auth/login` — returns a JWT token
  - `GET  /api/account` — returns account info (requires Bearer token)
  - `GET  /api/account/transactions` — returns transaction list (requires Bearer token)

Demo credentials: `demo` / `password`

## Modules

### `:shared-api`

Shared between client and server. Contains:
- `AccountService` / `AuthService` interfaces
- `AccountDto`, `TransactionDto`, `LoginRequestDTO`, `LoginResponse`, `ErrorResponse`

### `:shared`

KMP module targeting Android and iOS. Contains:
- Compose Multiplatform UI screens
- `BankingViewModel`, `AccountRepository`
- Ktor client services (`KtorAuthService`, `KtorAccountService`)
- `expect`/`actual` `BASE_URL` (`10.0.2.2:8080` for Android emulator, `localhost:8080` for iOS simulator)

## Running the app

### Start the server

```bash
./gradlew :server:run
```

The server starts on `http://localhost:8080`.

### Run the Android app

```bash
./gradlew :androidApp:assembleDebug
```

Or use the run configuration in Android Studio / IntelliJ IDEA.

### Run the iOS app

Open `iosApp/iosApp.xcodeproj` in Xcode and run on a simulator.

## Running tests

```bash
./gradlew :shared:testAndroidHostTest
./gradlew :shared:iosSimulatorArm64Test
```

## Tech stack

- Kotlin `2.4.0`
- Compose Multiplatform `1.11.1`
- Ktor `3.1.3` (client + server)
- `kotlinx.serialization` `1.8.1`
- AGP `9.0.0-alpha06`
- JWT (`java-jwt` + `jwks-rsa`)
