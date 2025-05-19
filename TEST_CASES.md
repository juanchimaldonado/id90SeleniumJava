# 📋 Test Cases - Login Functionality

This document describes the test cases covered in the feature file: `login.feature`.

---

## ✅ Feature: Login functionality

| TC ID | Scenario Name                           | Description                                                     | Expected Result                                                                           |
|-------|-----------------------------------------|-----------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| TC01  | Successful login with valid credentials | User logs in with valid company, email, and password            | User is logged in adn redirected to the main screen and sees the user icon at the top bar |
| TC02  | Try to login with invalid user email    | Login attempt with incorrect email and all other fields correct | Invalid credentials alert is shown                                                        |
| TC03  | Try to login with invalid password      | Login attempt with incorrect password and all other fields correct| Invalid credentials alert is shown                                                        |
| TC04  | Try to login with an empty company field| Login attempt without entering company name                     | "Company is required" alert is shown                                                      |
| TC05  | Try to login with an empty user email field| Login attempt without entering user email                       | "Email is required" alert is shown                                                        |
| TC06  | Try to login with an empty password field| Login attempt without entering password                         | "Password is required" alert is shown                                                     |

---

## 🧪 Mapping to Feature File

Feature file path: `src/test/resources/features/login.feature`

Each test case corresponds directly to a Gherkin `Scenario` with the same name.
