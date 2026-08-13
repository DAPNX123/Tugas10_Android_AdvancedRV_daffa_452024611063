# Walkthrough - Bus Schedule Management UI

A professional Bus Schedule management interface has been implemented, featuring a dark theme and interactive form, as requested based on the reference image.

## Changes Made

### 1. Visual Design & Theme
- **Dark Theme**: Implemented a custom dark theme using colors that match the reference image:
    - Background: `#12181F`
    - Cards: `#2C343B`
    - Accent: `#81D4FA` (Light Blue)
- **Input Styling**: Created a custom background for input fields (`bg_input.xml`) with rounded corners and subtle borders.

### 2. Interactive Form
- Added a full management form in `activity_main.xml`:
    - Name field, Route (Origin/Destination) logic, and Arrival/Departure times.
    - Blue "Tambah Jadwal" button with styling matching the screenshot.
- Implemented form logic in `MainActivity.kt` to dynamically add items to the list.

### 3. Advanced List Components
- **Dynamic Content**: `BusListAdapter` now binds `destination`, `departureTime`, and `arrivalTime` fields.
- **Card Design**: `item_bus.xml` was redesigned to match the specific typography and layout in your reference:
    - Large white bus name.
    - Gray "Tujuan" label.
    - Bottom row for departure and arrival times.
- **Performance**: Retained the `ListAdapter` and `DiffUtil` logic for smooth animations when adding new schedules.

### 4. Data Integrity
- Updated `BusItem.kt` model to fully support the new schedule information.
- Updated initial dummy data to match the examples in your screenshot (Harapan Jaya, Handoyo, Budiman).

## Verification Results

### Build Status
- Build successful: `gradle app:assembleDebug` completed without errors.

### UI Verification
- Card layout successfully maps all data fields to their respective views.
- `DiffUtil` correctly handles unique IDs generated for new entries.

> [!TIP]
> To test the app, enter the bus details in the top form and click "Tambah Jadwal". The new schedule will appear instantly in the list with a smooth animation thanks to `ListAdapter`.
