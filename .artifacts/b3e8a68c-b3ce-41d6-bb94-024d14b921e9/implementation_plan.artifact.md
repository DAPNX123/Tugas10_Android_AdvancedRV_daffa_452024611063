# Implementation Plan - Bus Schedule Management UI

This plan describes how to implement the Bus Schedule UI as shown in the reference image. This includes a form to add new schedules and a list to display them using the Advanced RecyclerView techniques (ListAdapter, multiple view types, and grid layout).

## User Review Required

> [!IMPORTANT]
> To match the reference image, the application will be updated to use a **Dark Theme**. The UI will feature an input form at the top and the schedule list below it.

## Proposed Changes

### Configuration & Styles

#### [MODIFY] [themes.xml](file:///E:/Jadwalbis20/app/src/main/res/values/themes.xml)
- Configure dark colors and material components to match the reference UI's appearance.

---

### Data Models

#### [MODIFY] [BusItem.kt](file:///E:/Jadwalbis20/app/src/main/java/com/example/jadwalbis20/model/BusItem.kt)
- Update `BusInfo` to include `destination`, `departureTime`, and `arrivalTime`.

---

### Layouts

#### [MODIFY] [activity_main.xml](file:///E:/Jadwalbis20/app/src/main/res/layout/activity_main.xml)
- Add the input form:
    - `EditText` for "Nama Bis"
    - Two `EditText` (horizontal row) for "Keberangkatan" and "Kedatangan"
    - `EditText` for "Tujuan"
    - `Button` for "Tambah Jadwal"
- Add a label "Daftar Jadwal:"
- Position the `RecyclerView` below the form.

#### [MODIFY] [item_bus.xml](file:///E:/Jadwalbis20/app/src/main/res/layout/item_bus.xml)
- Redesign the card to match the screenshot:
    - Top: Bus Name (Large text)
    - Middle: "Tujuan: [Destination]"
    - Bottom: Row with "Berangkat: [Time]" on the left and "Datang: [Time]" on the right.
- Use dark card background and light text.

---

### Adapters & Logic

#### [MODIFY] [BusListAdapter.kt](file:///E:/Jadwalbis20/app/src/main/java/com/example/jadwalbis20/adapter/BusListAdapter.kt)
- Update binding logic to support the new fields and styling.

---

### UI Implementation

#### [MODIFY] [MainActivity.kt](file:///E:/Jadwalbis20/app/src/main/java/com/example/jadwalbis20/MainActivity.kt)
- Implement logic for the "Tambah Jadwal" button to add new items to the list via `submitList`.
- Maintain the `GridLayoutManager` with `SpanSizeLookup` (Headers still supported if needed, though the screenshot shows a flat list, we will keep the advanced capability for categorization).

## Verification Plan

### Automated Tests
- Build the app using `gradle app:assembleDebug`.

### Manual Verification
- Verify the layout matches the screenshot.
- Test adding a new schedule through the form and ensure it appears correctly in the list.
- Check that the list diffing works smoothly when adding items.
