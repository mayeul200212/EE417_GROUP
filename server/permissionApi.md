# API List
- User Registration (`/auth/signup`): Allows new users to register.
- User Login (`/auth/signin`): Allows users to log in and receive a JWT token.
- View All Users (`/admin/all-users`): Admins can view information of all registered users.
- Delete User (`/admin/delete-user/{id}`): Admins can delete a user based on their ID.
- Access Public Resource (`/public/test`): Provides public information accessible by all users.

## Request and Response Format
- User Registration and Login: Requests should include `username` and `password` fields. Registration requests should also include a `role` field to specify the user's role (`"ROLE_USER"` or `"ROLE_ADMIN"`).
- Response Format: Responses follow a unified format using `ResultVo`, which includes `code` (status code), `message`, and `data`.

## Examples
### User Registration `/auth/signup`
Request Body Example:
```json
{
  "username": "newuser",
  "password": "password123",
  "role": "ROLE_USER"
}
```
Successful Response Example:
```json
{
  "code": 200,
  "message": "User registration successful",
  "data": true
}
```
Failure Response Example (e.g., username already exists):
```json
{
  "code": 400,
  "message": "Username already taken",
  "data": null
}
```

### User Login `/auth/signin`
Request Body Example:
```json
{
  "username": "newuser",
  "password": "password123"
}
```
Successful Response Example:
```json
{
  "code": 200,
  "message": "User login successful",
  "data": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuZX...."
}
```

### View All Users `/admin/all-users`
Note: Requires JWT token.

Successful Response Example:
```json
{
  "code": 200,
  "message": "Successfully fetched all user information",
  "data": [
    {
      "id": 1,
      "username": "admin",
      "role": {"id": 1, "name": "ROLE_ADMIN"}
    },
    {
      "id": 2,
      "username": "newuser",
      "role": {"id": 2, "name": "ROLE_USER"}
    }
  ]
}
```

### Delete User `/admin/delete-user/{id}`
Note: Requires JWT token with admin privileges.

Successful Response Example:
```json
{
  "code": 200,
  "message": "User deletion successful",
  "data": true
}
```

### Access Public Resource `/public/test`
No authentication required.

Successful Response Example:
```json
{
  "code": 200,
  "message": "Fetched public message successfully",
  "data": "This is a public message accessible by any user."
}
```

## Example Files
Two HTML example files are provided in `server/auth_example` in our project:

- `auth.html` (for user registration and login)
- `home.html` (homepage, displaying different information based on user permissions)

`auth.html` contains registration and login forms, sending requests to `/auth/signup` and `/auth/signin`. Upon successful login, the JWT token is saved in `localStorage`, and the user is redirected to `home.html`.

`home.html` displays different information based on the user's role (admin or regular user). The admin button fetches information of all users, while the regular user button fetches public information. Admins can delete users via the delete button next to each user entry.