# Hostel Management System

A console-based Hostel Management System built in core Java, using the Collections framework for data storage and demonstrating coordination between two related entities — students and rooms.

## Overview

This application allows a warden to manage hostel operations — registering students, adding rooms, allocating and vacating rooms, and searching or removing students. Unlike a single-entity system, this project requires the service layer to coordinate two independent repositories to enforce cross-entity business rules (e.g. room capacity limits).

## Architecture

```
Main (Presentation) → HostelService (Business Logic) → StudentRepository / RoomRepository (Data Layer) → Student / Room (Model)
```

- **Model** — `Student` and `Room`: plain data classes. A `Student` holds a `roomNumber` field to track its current allocation (or "Not Allocated" if unassigned); a `Room` tracks its own `capacity` and `occupiedCount`.
- **Repository** — `StudentRepository` and `RoomRepository`: each backed by a `HashMap<String, T>` keyed by ID, providing constant-time lookups.
- **Service** — `HostelService`: holds references to both repositories and contains all business logic, including cross-entity operations like room allocation.
- **Loader** — `DataLoader`: a dedicated utility class responsible for reading and parsing the startup data files, kept separate from `HostelService` to preserve single-responsibility.
- **Main** — the console entry point; displays the menu and delegates all operations to `HostelService`.

## Features

- Add a student / add a room
- Allocate a student to a room (validates student and room existence, and available capacity)
- Vacate a student from their room (updates both the student and room records)
- Search students by name (partial match) or by ID (exact match)
- View all students / view all rooms
- Remove a student
- Bulk-load students and rooms from `.txt` files at startup

## Project Structure

```
src/
  com/hostel/model/       → Student.java, Room.java
  com/hostel/repository/  → StudentRepository.java, RoomRepository.java
  com/hostel/service/     → HostelService.java
  com/hostel/loader/      → DataLoader.java
  com/hostel/main/        → Main.java
data/
  students.txt             → sample student data loaded at startup
  rooms.txt                 → sample room data loaded at startup
```

## Data File Formats

`data/students.txt`:
```
id,name,age,contactNumber
```

`data/rooms.txt`:
```
roomNumber,capacity
```

## Tech Stack

- Java 17
- `java.util` Collections (`HashMap`, `ArrayList`, `List`, `Map`)
- Console-based I/O via `Scanner`

## Running the Project

1. Import the project into Eclipse (or any Java IDE).
2. Ensure `data/students.txt` and `data/rooms.txt` exist in the project root.
3. Run `Main.java`.

## Design Notes

- Room allocation is modeled as a single source of truth on the `Student` side (`roomNumber`), rather than maintaining a bidirectional link, to avoid data-sync issues between the two entities.
- `HashMap` was chosen over array-based storage for O(1) key lookups and to avoid manual capacity management, in contrast to the array-based Library Management System.
- Newly created rooms always start with `occupiedCount = 0`, enforced in the `Room` constructor rather than left to the caller, to guarantee data integrity.
