# Magical Arena Battle Project

This is a Java-based simulation project that mimics a magical battle arena. In this game, two players with different attributes (Health, Strength, and Attack) fight each other in a turn-based combat system. The players' stats influence their attacks and defenses, and the battle continues until one of them loses all their health.

## Table of Contents

1. [Project Description](#project-description)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Setup and Installation](#setup-and-installation)
5. [Usage](#usage)
6. [API Endpoint](#api-endpoint)
7. [Database Schema](#database-schema)
8. [Testing](#testing)
9. [Contributing](#contributing)
10. [License](#license)

## Project Description

The **Magical Arena Battle Project** simulates a battle between two players. Each player has three primary attributes: **Health**, **Strength**, and **Attack**. Players attack in turns, rolling dice to determine the damage inflicted and defended. The battle continues until one player's health reaches zero.

- **Health**: The player's health points (HP). When this reaches 0, the player dies.
- **Strength**: The player's defensive strength, used to defend against attacks.
- **Attack**: The player's offensive power used to inflict damage.


# Project Structure Diagram

## Simplified Project Structure (without Database and Utility Layer)

```plaintext
+-------------------------+      +-------------------------+
|                         |      |                         |
|     Controller Layer    |      |   Service/Logic Layer   |
|                         |      |                         |
|  +-------------------+  |      |  +-------------------+  |
|  |  BattleController |  | ---- |  |  BattleService    |  |
|  +-------------------+  |      |  +-------------------+  |
|  |  PlayerController |  |      |  +-------------------+  |
|  +-------------------+  |      |  |  PlayerService    |  |
|                         |      |  +-------------------+  |
+-------------------------+      +-------------------------+
           |                              |
           V                              V
+-------------------------+      +-------------------------+
|                         |      |                         |
|     Model Layer         |      |   API Layer             |
|                         |      |                         |
|  +-------------------+  |      |  +--------------------+ |
|  |   Player          |  |      |  |   BattleController | |
|  +-------------------+  |      |  |   PlayerController | |
|  |   Battle          |  |      |  |   API Routes       | |
|  +-------------------+  |      |  +--------------------+ |
|  |   Dice            |  |      |                         |
|  +-------------------+  |      |                         |
|                         |      |                         |
+-------------------------+      +-------------------------+
           |                              |
           V                              V
   +---------------------+       +------------------------+
   |    Testing Layer    |       |   Presentation Layer   | 
   |                     |       |  (Frontend or Client)  |
   |  +----------------+ |       |  +-------------------+ |
   |  |  JUnit Tests   | |       |  |  REST API Client  | |
   |  +----------------+ |       |  +-------------------+ |
   |                     |       |                        |
   +---------------------+       +------------------------+
```

## Features

- **Player Creation**: Create players with customizable stats: health, strength, and attack.
- **Turn-based Battle**: Players take turns attacking and defending.
- **Dice Rolling**: Both players roll dice for each attack and defense calculation.
- **Battle Simulation**: Simulate battles between two players and determine the winner.
- **API Endpoint**: Expose battle simulation through a REST API (using Spring Boot).
- **Database**: Track player and battle data with a relational database (MySQL/PostgreSQL).

## Prerequisites

To run this project, ensure you have the following installed:

- **Java 11+**: Java Development Kit (JDK) to run and compile the Java code.
- **Maven**: Build and manage dependencies.
- **Spring Boot**: For the web API.
- **MySQL/PostgreSQL** (optional): For database management.
- **JUnit**: For unit testing.
- **IDE**: An IDE such as IntelliJ IDEA or Eclipse (optional but recommended).

## Setup and Installation

Follow these steps to set up the project on your local machine.

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/magical-arena-battle.git
```
### 2. Install Dependencies
Ensure you have Maven installed. Navigate to the project folder and run:

```bash
mvn install
```
This will download the necessary dependencies.

### 3. Run the Application
You can run the application with Maven:

```bash
mvn spring-boot:run
```
Alternatively, you can run the Application.java class from your IDE.

### 4. Implemented the Unit Test Case using JUnit 
<strong>Path for Unit test</strong> : <i>\battlegame\src\test\java\com\arena\battlegame\BattlegameApplicationTests.java</i>
 - **Run Unit Test**: Run this Unit Case in Any IDE.

### 5. Custome Input 
 - "You can give custome input on url : https://localhost:8080/api/playgame"
 - Sample Json
```commandline
{
    "playerA_health": 50,
    "playerA_attack": 10,
    "playerA_strength": 5,
    "playerB_health": 100,
    "playerB_attack": 5,
    "playerB_strength": 10
}

```