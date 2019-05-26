# Halfway API

API for Halfway application which provides data for an application that manages part-time jobs

# How to start local server (IntelliJ)

  - Pull latest changes from GIT (desired branch)
  - Open project in IntelliJ by selecting `build.gradle` or project folder
  - `Run` -> `Edit configurations` -> (green plus sign) -> select `Spring Boot`
  - Choose `Main class` as `HalfwayApplication`
  - Choose `halfway_main` as module in `Use classpath of module`
  - Install `Lombok plugin` from `Settings` -> `Plugins` (requires a restart of IntelliJ after install)
  - `Enable annotation processing` from `Settings` -> `Build, Execution, Deployment` -> `Compiler` -> `Annotation Processors`
  - Run 

# API docs
## Ping
```sh
http://localhost:8080/v1/ping (to check if server is online)
```

```sh
http://localhost:8080/api/v1
```

## Auth
```sh
/sign-in (HTTP method:POST ; Body: 'username', 'password')
```
```sh
/sign-up (HTTP method:POST ; Body: 'username', 'password', 'role'('CLIENT','PROVIDER'))
```

## Categories
```sh
/categories (GET)
```

## Jobs
```sh
/locations (GET)
```
```sh
/jobs (HTTP method: GET)
```
```sh
/jobs/location/{location} (HTTP method: GET)
```
```sh
/jobs/category/{category} (HTTP method: GET)
```
```sh
/jobs/created (HTTP method: GET)
```
```sh
/jobs/updated (HTTP method: GET)
```
```sh
/jobs/ended (HTTP method: GET)
```
```sh
/jobs/cost/asc (HTTP method: GET)
```
```sh
/jobs/cost/desc (HTTP method: GET)
```
```sh
/jobs (HTTP method: POST ; Body: 'job' : {'title', 'description', 'ends_at', 'cost', 'category', 'location' }) 
```
```sh
/jobs/{id} (HTTP method: PUT ; Body: 'job' : {'title', 'description', 'ends_at', 'cost', 'category', 'location' }) 
```
```sh
/jobs/{id} (HTTP method: DELETE)
```
```sh
/apply/job/{jobId} (HTTP method: POST)
```
```sh
/applications/user (HTTP method: GET)
```
```sh
/applications/job/{jobId} (HTTP method: GET)
```
```sh
/jobs/#{id} (HTTP method:PUT ; Body: 'id: '#id', 'job_dto_map': { 'title', 'description', 'created_at', 'updated_at', 'ends_at', 'cost', 'owner', 'category', 'location' }) 
```
```sh
/jobs/#{id} (HTTP method:DELETE ; Body: 'id: '#id') 
```
```sh
/jobs/search/#{title} (GET) 
```
```sh
/jobs/location/#{location} (GET) 
```
```sh
/jobs/category/#{category} (GET) 
```
```sh
/jobs/created (GET) 
```
```sh
/jobs/updated (GET) 
```
```sh
/jobs/ended (GET) 
```
```sh
/jobs/cost/asc (GET) 
```
```sh
/jobs/cost/desc (GET) 
```
## Profiles
```sh
/profile/client (GET)
```
```sh
/profile/provider (GET)
```
```sh
/profile/create/provider (HTTP method:POST ; Body: 'firstName', 'lastName', 'email', 'abilities[]')
```
```sh
/profile/create/client (HTTP method:POST ; Body: 'firstName', 'lastName', 'email')
```
