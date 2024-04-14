

In this project, I implemented permission management and user authentication using Spring Security, mainly adopting JWT (JSON Web Token) for secure verification. 

Currently, APIs for user registration (/auth/signup), user login (/auth/signin), viewing all users (/admin/all-users), and deleting a user based on their ID (/admin/delete-user/{id}) have been developed.

To continue developing new APIs, you can refer to the existing implementation patterns. For APIs that require specific permissions, it is recommended to classify them under the /admin route or use the @PreAuthorize annotation to restrict access permissions. Also, use the unified response format ResultVo to encapsulate response results, to maintain consistency and readability of API returns.

## Example: Developing a New Admin API

### Define the Route
Define the new API in AdminController, using @GetMapping or other relevant annotations to specify the HTTP method and path.

```java
@GetMapping("/new-admin-api")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<ResultVo<String>> newAdminApi() {
    // Business logic
    return ResponseEntity.ok(ResultVo.success("API call successful", "Returned data"));
}
```

### Use the Unified Return Format
Use ResultVo to encapsulate the return result for both success and failure cases.

## Example: Developing an API Open to All Users

You can add APIs accessible without specific permissions in PublicController. There is no need for the @PreAuthorize annotation here.

```java
@GetMapping("/public-api")
public ResponseEntity<ResultVo<String>> publicApi() {
    // Business logic
    return ResponseEntity.ok(ResultVo.success("Public API call successful", "Returned data"));
}
```

## Using the Unified Return Format

Use the ResultVo class to wrap data in all API responses to enhance the consistency and usability of the API. For error situations, the ResultVo.error method can be conveniently used to return error information.

```java
return ResponseEntity.ok(ResultVo.success("Operation successful", data)); // Success response
return ResponseEntity.badRequest().body(ResultVo.error(400, "Error message")); // Error response
```

