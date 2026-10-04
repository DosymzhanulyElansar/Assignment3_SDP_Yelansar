# Assignment 3: Bridge Pattern
- **Student Name:** Елансар Ануар
- **Group:** SE-2522
- **Topic:** Option B (Notifications)
- **Repository URL:** https://github.com/DosymzhanulyElansar/Assignment3_SDP_Yelansar
- **Base Commit Hash:** dc5ec666a391923dba1fb05ab903167c78824428

## Role Map
| Role | Class / Interface | Path |
| --- | --- | --- |
| Abstraction | `Notification` | `src/Notification.java` |
| Refined Abstraction 1 | `Reminder` | `src/Reminder.java` |
| Refined Abstraction 2 | `UrgentAlert` | `src/UrgentAlert.java` |
| Implementor | `Channel` | `src/Channel.java` |
| Concrete Implementor 1 | `EmailChannel` | `src/EmailChannel.java` |
| Concrete Implementor 2 | `SmsChannel` | `src/SmsChannel.java` |
| Concrete Implementor 3 | `PushChannel` | `src/PushChannel.java` |
| Client / Demo | `Main` | `src/Main.java` |

- **Bridge Reference Field:** `Notification.channel`
- **Execution Method:** `Notification.execute()`
- **Runtime Switch Method:** `Notification.setImplementation(Channel channel)`
- **Runtime Switch Check:** `Main.java` (T5 check)

## Standard Build and Run Commands
```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main