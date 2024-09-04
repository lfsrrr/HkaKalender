# HkaKalender

**HkaKalender** is a simple Java application that fetches and saves the academic timetable for a specific study program (`Studiengang`) from the HKA (Hochschule Karlsruhe) Raumzeit API. The application allows users to input their study program code, makes an API call using `curl`, and saves the resulting calendar data in `.ics` format. This `.ics` file can be imported into calendar applications to keep track of your class schedule.

further reading: [API Dokumentation]([https://www.genome.gov/](https://raumzeit.hka-iwi.de/api/swagger-ui/index.html))

## Features
- User-friendly command-line interface for inputting the study program (`Studiengang`).
- Fetches timetable data from the HKA Raumzeit API.
- Saves the API response as a `.ics` calendar file.
- Easy to integrate with calendar applications like Google Calendar or Outlook.

## Requirements
- Java 8 or higher
- `curl` command available in your system

## Usage
1. Clone the repository.
2. Compile and run the `Main` class.
3. Enter your `Studiengang` when prompted.
4. The application will fetch the timetable and save it as a `.ics` file, ready for import into your calendar app.

This project is a great starting point for automating timetable management and integrating it with your digital calendar. Contributions are welcome!
