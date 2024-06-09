import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  // Klasa TimeInterval
  static class TimeInterval {
    private LocalTime start;
    private LocalTime end;

    public TimeInterval(LocalTime start, LocalTime end) {
      if (start.isAfter(end)) {
        throw new IllegalArgumentException("Start time must be before end time");
      }
      this.start = start;
      this.end = end;
    }

    public boolean overlaps(TimeInterval other) {
      return !(this.end.isBefore(other.start) || this.start.isAfter(other.end));
    }

    public LocalTime getStart() {
      return start;
    }

    public LocalTime getEnd() {
      return end;
    }

    @Override
    public String toString() {
      return "TimeInterval{" + "start=" + start + ", end=" + end + '}';
    }
  }

  // Klasa Meeting
  static class Meeting {
    private String description;
    private ZonedDateTime startTime;

    public Meeting(String description, ZonedDateTime startTime) {
      this.description = description;
      this.startTime = startTime;
    }

    public ZonedDateTime getStartTime() {
      return startTime;
    }

    @Override
    public String toString() {
      return "Meeting{" + "description='" + description + '\'' + ", startTime=" + startTime + '}';
    }
  }

  public static void main(String[] args) {
    
    // Zadanie 1
    System.out.println("=== Zadanie 1: TimeInterval ===");
    TimeInterval t1 = new TimeInterval(LocalTime.of(10, 0), LocalTime.of(11, 0));
    TimeInterval t2 = new TimeInterval(LocalTime.of(10, 30), LocalTime.of(11, 30));
    System.out.println(t1 + " overlaps with " + t2 + ": " + t1.overlaps(t2));

    // Zadanie 2
    System.out.println("\n=== Zadanie 2: TimeZone Offsets ===");
    ZonedDateTime now = ZonedDateTime.now();
    Set<String> zoneIds = ZoneId.getAvailableZoneIds();

    zoneIds.stream()
        .map(ZoneId::of)
        .forEach(zoneId -> {
          ZonedDateTime zdt = now.withZoneSameInstant(zoneId);
          System.out.println(zoneId + ": " + zdt.getOffset());
        });

    // Zadanie 3
    System.out.println("\n=== Zadanie 3: Non-whole hour offsets ===");
    Set<ZoneId> nonWholeHourZones = zoneIds.stream() 
        .map(ZoneId::of)
        .filter(zoneId -> {
          int secondsOffset = zoneId.getRules().getOffset(Instant.now()).getTotalSeconds();
          return secondsOffset % 3600 != 0;
        })
        .collect(Collectors.toSet());

    nonWholeHourZones.forEach(System.out::println); 

    // Zadanie 4
    System.out.println("\n=== Zadanie 4: Flight Arrival Time ===");
    ZoneId laZone = ZoneId.of("America/Los_Angeles");
    ZoneId frankfurtZone = ZoneId.of("Europe/Berlin");

    LocalDateTime departureTimeLA = LocalDateTime.of(2024, 6, 9, 15, 5);
    ZonedDateTime departureZoned = ZonedDateTime.of(departureTimeLA, laZone);
    Duration flightDuration = Duration.ofHours(10).plusMinutes(50);

    ZonedDateTime arrivalZoned = departureZoned.plus(flightDuration).withZoneSameInstant(frankfurtZone);
    System.out.println("Arrival time in Frankfurt: " + arrivalZoned);

    // Zadanie 5
    System.out.println("\n=== Zadanie 5: Flight Duration ===");
    LocalDateTime departureTimeFrankfurt = LocalDateTime.of(2024, 6, 9, 14, 5);
    LocalDateTime arrivalTimeLA = LocalDateTime.of(2024, 6, 9, 16, 40);

    ZonedDateTime departureZonedF = ZonedDateTime.of(departureTimeFrankfurt, frankfurtZone);
    ZonedDateTime arrivalZonedLA = ZonedDateTime.of(arrivalTimeLA, laZone);

    Duration flightDurationBack = Duration.between(departureZonedF, arrivalZonedLA);
    System.out.println("Flight duration: " + flightDurationBack.toHours() + " hours and "
        + (flightDurationBack.toMinutes() % 60) + " minutes");

    // Zadanie 6
    System.out.println("\n=== Zadanie 6: Upcoming Meetings ===");
    List<Meeting> meetings = new ArrayList<>();
    meetings.add(
        new Meeting("Meeting 1", ZonedDateTime.of(LocalDateTime.now().plusMinutes(30), ZoneId.of("America/New_York"))));
    meetings
        .add(new Meeting("Meeting 2", ZonedDateTime.of(LocalDateTime.now().plusHours(2), ZoneId.of("Europe/London"))));
    meetings
        .add(new Meeting("Meeting 3", ZonedDateTime.of(LocalDateTime.now().plusMinutes(45), ZoneId.of("Asia/Tokyo"))));

    ZonedDateTime nowTime = ZonedDateTime.now();
    ZonedDateTime oneHourLater = nowTime.plusHours(1);

    meetings.stream()
        .filter(meeting -> meeting.getStartTime().isAfter(nowTime) && meeting.getStartTime().isBefore(oneHourLater))
        .forEach(System.out::println);
  }
}
