# DataDisplay App

The DataDisplay app is an Android application designed to fetch and display data from an API. The app includes a main activity with buttons to navigate to different data categories and a secondary activity that fetches and displays data from the API in a table format.

## Features

- **API Data Display**: Fetches data from an API and displays it in a table format.
- **Multiple Categories**: The main activity includes buttons to navigate to different data categories.
- **Table View**: Data fetched from the API is displayed in a table with rows and columns.
- **Responsive Layout**: The layout adjusts to different screen sizes and orientations.
- **AsyncTask**: Data fetching is performed in the background using an AsyncTask.
- **JSON Parsing**: Parses JSON data from the API response and populates the table.

## Screenshots

![Main Activity](screenshots/main_activity.png)
![Data Display Activity](screenshots/data_display_activity.png)

## How to Use

1. Launch the app, and you'll be greeted with the main activity featuring category buttons.
2. Tap on a category button to navigate to the Data Display activity.
3. The Data Display activity will fetch data from the provided API URL and display it in a table.

## Technologies Used

- Android Studio: The app is developed using Android Studio, the official IDE for Android app development.
- AsyncTask: Used for performing background tasks, such as fetching data from the API.
- JSON Parsing: JSON data from the API response is parsed to populate the table.
- Layouts: XML layout files define the app's user interface, providing responsiveness and organization.

## Setup

1. Clone the repository: `git clone https://github.com/your-username/DataDisplayApp.git`
2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or device.

## API Usage

The app fetches data from an API. Replace the API URL in the `FetchDataFromApiTask` class in the `DisplayDataActivity.java` file with the appropriate API endpoint.

```java
String apiUrl = "https://api.example.com/data"; // Replace with your API URL
```

## Conclusion
The DataDisplay app is a versatile Android application for fetching and presenting API data in a user-friendly table format. With its intuitive user interface, responsive design, and effective use of technologies like AsyncTask and JSON parsing, it offers a seamless experience. Users can effortlessly navigate through different data categories and enjoy a visually appealing presentation of information. The app's open-source nature encourages collaboration, making it a valuable tool for developers seeking to enhance their skills.



