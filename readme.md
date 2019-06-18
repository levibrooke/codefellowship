# Lab 16: CodeFellowship Profiles

For your remaining labs before the midterm project, you’ll create an app called CodeFellowship that allows people learning to code to connect with each other and support each other on their coding journeys.

## Running
1. Clone this repo
2. Set your application settings in `application.properties` to include:
- `spring.datasource.url=jdbc:postgresql://path/to/your/psql/database`
- `spring.datasource.username=yourPSQLUser`
- `spring.jpa.hibernate.ddl-auto=auto`

2. Run the application:
`./gradlew bootRun`
3. Run tests (there are no integration tests yet)
`./gradlew test`