# CICD-1 Coding Test — Review, Improve and Reflect

**Student ID:G00472272**  
**Examination group:** B (OpenFeign):  
**Original examination pull-request URL (`exam-work`):https://github.com/irfanefedonmez/cicd1-exam2-BookingService-G00472272/pull/1**  
**New review repository URL:https://github.com/irfanefedonmez/CICD1_Review_G00472272**

## 1. My original examination self-assessment

Review the code **as submitted in the original examination**. Do not change the original repository, branch or pull request. Check your own Group A or Group B examination paper and award marks only for evidence present in the original submission.

### Task 1 — 23/40
**My mark:23/40** 
**Evidence from the original code (files, methods, working or missing requirements):
In Task 1, I created Booking.java, BookingRequest.java and BookingResponse.java files. I used @Entity, @Id and @GeneratedValue. I added name, count, roomId and status fields. The mistakes I made in Task 1 are =
In Booking.java I used @NotBlank annotation with int and long variables.
I did not add @Size so I could not control the name length.
In @BookinResponse.java, Each room has a different capacity so using @Max(20) is wrong.
I did not use @Positive annotation in BookingRequest.java.
I used true for status instead of Active.
I gave myself 23 out of 40 because I created the model and DTO files, I added most of the needed fields and validation checks but I couldn't meet all the validation and status requirements**

### Task 2 — 15/40
**My mark:15/20**  
**Evidence from the original code:In Task 2 I created BookingController.java and used @PostMapping inside it. I created BookingService.java and created addBooking() method in it.I used bookinRepository.save(booking) so I can save the bookings. I used @FeignClient and @GetMapping("/api/rooms/{id}") in the RoomClient.java. but I couldn't finished the OpenFeign connection.
The main problems in task 2 were=
I didn't use RoomClient inside the BookingService.
I didn't check the room capacity.
BookingRoom.java was empty instead of adding room details like id and capacity.
I didn't used BookingRequest DTO or @Valid.
I managed to create Controller and Service classes and save() method. I couldn't complete OpenFeign connection and didn't check the room capacity. I gave myself 15 because I implemented the booking saving part but the main requirements were missing.
**

### Task 3 — 10/20
**My mark:10/20**  
**Evidence from the original code:I used @GetMapping("/{id}") in the BookingController.java. I created getBookingById() method. I used bookinRepository.findById(id) inside BookingService.java so I wrote the code that can search the booking in the local database.
The main problems in Task 3 were=
I didn't use the BookingResponse DTO.
I used orElse(null) instead of returning 404 Not Found.
I gave myself 10 out of 20 because I created the getBookingById() method. I implemented local database search using findById(id) but the response DTO and my error handling were missing.
**

**Total self-assessed original examination mark: 48/100**


**Checkpoint:** Commit this completed self-assessment as the **first review commit in your new repository**, before you modify or add application code. The lecturer decides the official original examination mark.

## 2. Corrections and improvements in my new project

Start from a **fresh copy of the starter template for your own exam group**, in a **new GitHub repository**. You may consult or selectively reuse your own original examination code, but the new project must demonstrate that you understand and can correct it. Do not change your original examination submission.

Describe **two or three important problems** in your original code. For each, explain what was wrong, which class or method you changed in the new project, and why the corrected approach works.

**Problem and correction 1: Missing response DTO.
The problem was in BookingController.java and BookingService.java. I used BookingResponse DTO instead of returning the Booking directly.
The API now returns the booking details using a response DTO.
**

**Problem and correction 2: Missing capacity check
In BookingService.java and RoomClient.java. I used OpenFeign to get room infos from room service. I added a check to compare atendeeCount with room capacity.
**

**Problem and correction 3 (optional):**

## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**
- Request / input: POST /api/bookings with organiserName: "John Smith", attendeeCount: 5, roomId: 1
- Expected: HTTP 201 Created. The booking should be saved with ACTIVE status.
- Actual HTTP status / body: HTTP 201 Created. id: 1, organiserName: "John Smith", attendeeCount: 5, roomId: 1, status: "ACTIVE".
- Pass / fail: PASS

**Test 2 — invalid input or excessive attendee count:**
- Request / input: POST /api/bookings with organiserName: "John Smith", attendeeCount: 30, roomId: 1
- Expected: HTTP 400 Bad Request because the room capacity is 24.
- Actual HTTP status / body: HTTP 400 Bad Request. The response body contains status: 400, error: "Bad Request", path: "/api/bookings".
- Pass / fail: PASS

**Test 3 — missing booking or room:**
- Request / input: GET /api/bookings/12345
- Expected: HTTP 404 Not Found because the booking does not exist.
- Actual HTTP status / body: HTTP 404 Not Found. The response body contains status: 404, error: "Not Found", path: "/api/bookings/12345".
- Pass / fail: PASS

**Test 4 — requirement specific to my group:**
- Request / input: GET /api/bookings/1
- Expected: HTTP 200 OK. The booking should be retrieved from the local database with the correct details.
- Actual HTTP status / body: HTTP 200 OK (if confirmed). The response body contains id: 1, organiserName: "John Smith", attendeeCount: 5, roomId: 1, status: "ACTIVE".
- Pass / fail: PASS

**Group A:** Demonstrate `GET /api/bookings/search?roomName=...` using an exact room name, bookings ordered by attendee count descending, and an empty list for no matches. Add checks if necessary to show all three behaviours.

**Group B:** Run the **provided** Room Service separately on port 8082 and the **new** Booking Service on port 8081. Demonstrate that booking creation obtains room details through OpenFeign and that booking retrieval uses the local Booking database. Do not modify the Room Service.

## 4. Reflection

**What did I understand during the examination but struggle to implement?
The hardest thing was using OpenFeign and connecting two microservices. BookingResponse DTO and error handling was also very hard.
**

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.
I understand more about OpenFeign and DTOs now. I learned how BookingService gets information from Room Service using OpenFeign.**

**What will I do differently in my next coding test or API development task?
I would do better in every way because I will practise OpenFeign, DTOs and validation more from now on. **

## Review lab assessment — 20 marks

- Honest original self-assessment with code evidence: **4 marks**
- Explanation of mistakes and Spring Boot concepts: **6 marks**
- Corrections in the new application: **4 marks**
- API testing and demonstration of understanding: **4 marks**
- Reflection and future improvement: **2 marks**

**Total: 20 marks.** Simply submitting a working solution does not demonstrate the learning required by this review.

## Proposed mark recovery — only if confirmed for CICD-1

If the same approach as OOP is adopted, the review could recover **up to 30% of marks lost** in the original examination, scaled by the review-lab mark.

**Marks recovered = (100 − official original exam mark) × 0.30 × (review lab mark ÷ 20)**

Example: exam **40/100** and review **16/20** → **14.4 recovered marks**, revised exam **54.4/100**. This is **not an approved CICD-1 policy unless confirmed by the lecturer**. The original official exam mark—not your self-awarded grade—is used in the calculation.

## Submission

Commit and push the **new review repository** with the completed README, corrected Spring Boot code and API-test evidence. Submit its GitHub URL on Moodle. **Do not push any changes to the original examination repository or `exam-work` pull request.**