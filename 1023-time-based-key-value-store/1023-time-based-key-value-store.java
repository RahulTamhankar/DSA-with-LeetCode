
// class TimeStampedValue {
//   public int timestamp;
//   public String value;

//   public TimeStampedValue(int timestamp, String value) {
//     this.timestamp = timestamp;
//     this.value = value;
//   }
// }

// public class TimeMap {
//   Map<String, ArrayList<TimeStampedValue>> entriesByKey;

//   public TimeMap() {
//     // Constructor to initialize the TimeMap object
//     entriesByKey = new HashMap<>();
//   }

//   public void set(String key, String value, int timestamp) {
//     // Implementation for setting the value at a specific timestamp
//     if(!entriesByKey.containsKey(key)) {
//       entriesByKey.put(key, new ArrayList<>());
//     }
//     ArrayList<TimeStampedValue> timeStampedValues = entriesByKey.get(key);
//     timeStampedValues.add(new TimeStampedValue(timestamp, value));
//   }

//   public String get(String key, int timestamp) {
//     if(!entriesByKey.containsKey(key)) return "";

//     ArrayList<TimeStampedValue> timeStampedValues = entriesByKey.get(key);
//     Optional<TimeStampedValue> timeStamp =
//         binarySearchTimestamp(timeStampedValues, timestamp);
//     if(timeStamp.isEmpty()) {
//       return "";
//     }

//     return timeStamp.get().value;
//   }

//   private Optional<TimeStampedValue> binarySearchTimestamp(
//       ArrayList<TimeStampedValue> arr, int target) {
//     int left = 0, right = arr.size() - 1;
//     int matchIndex = -1;

//     while (left <= right) {
//       int mid = left + (right - left) / 2;
//       TimeStampedValue cur = arr.get(mid);
//       if(cur.timestamp <= target) {
//         matchIndex = mid;
//         left = mid + 1;
//       }
//       else {
//         right = mid - 1;
//       }
//     }

//     if(matchIndex == -1) {
//       return Optional.empty();
//     }
//     return Optional.of(arr.get(matchIndex));
//   }
// }
// //Without Optional, you would return null and check if (result == null) later.

// // Using Optional makes it explicit that the result might be absent.

// // It improves readability and reduces null pointer errors.

//------------------------

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TimeStampedValue {
  public int timestamp;
  public String value;

  public TimeStampedValue(int timestamp, String value) {
    this.timestamp = timestamp;
    this.value = value;
  }
}

public class TimeMap {
  Map<String, ArrayList<TimeStampedValue>> entriesByKey;

  public TimeMap() {
    entriesByKey = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!entriesByKey.containsKey(key)) {
      entriesByKey.put(key, new ArrayList<>());
    }
    ArrayList<TimeStampedValue> timeStampedValues = entriesByKey.get(key);
    timeStampedValues.add(new TimeStampedValue(timestamp, value));
  }

  public String get(String key, int timestamp) {
    if (!entriesByKey.containsKey(key)) return "";

    ArrayList<TimeStampedValue> timeStampedValues = entriesByKey.get(key);
    TimeStampedValue timeStamp = binarySearchTimestamp(timeStampedValues, timestamp);
    
    if (timeStamp == null) {
      return "";
    }

    return timeStamp.value;
  }

  private TimeStampedValue binarySearchTimestamp(ArrayList<TimeStampedValue> arr, int target) {
    int left = 0, right = arr.size() - 1;
    int matchIndex = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      TimeStampedValue cur = arr.get(mid);
      if (cur.timestamp <= target) {
        matchIndex = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    if (matchIndex == -1) {
      return null;
    }
    return arr.get(matchIndex);
  }
}




/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */