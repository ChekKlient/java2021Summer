package ua.kpi.tef.util;

import ua.kpi.tef.model.UserMeal;
import ua.kpi.tef.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        List<UserMealWithExceed> mealWithExceedList = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
        List<UserMealWithExceed> mealWithExceedListStream = getFilteredWithExceededStream(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
        System.out.println(mealWithExceedList);
        System.out.println(mealWithExceedListStream);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDateTime, Integer> caloriesByDays = getCaloriesByDay(mealList);
        List<UserMealWithExceed> mealWithExceedList = new LinkedList<>();
        for (UserMeal userMeal :
                mealList) {
            if (userMeal.getDateTime().getHour() > startTime.getHour() && userMeal.getDateTime().getHour() < endTime.getHour())
                mealWithExceedList.add(new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), caloriesPerDay < caloriesByDays.get(userMeal.getDateTime().truncatedTo(ChronoUnit.DAYS))));
        }
        return mealWithExceedList;
    }

    public static List<UserMealWithExceed>  getFilteredWithExceededStream(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDateTime, Integer> caloriesByDays = getCaloriesByDayStream(mealList);
        List<UserMealWithExceed> mealWithExceedList =  mealList.stream()
                .filter(p -> p.getDateTime().getHour() > startTime.getHour() && p.getDateTime().getHour() < endTime.getHour())
                .map(p -> new UserMealWithExceed(p.getDateTime(), p.getDescription(), p.getCalories(), caloriesPerDay < caloriesByDays.get(p.getDateTime().truncatedTo(ChronoUnit.DAYS))))
                .collect(Collectors.toList());
        return mealWithExceedList;
    }


    public static Map<LocalDateTime, Integer> getCaloriesByDay(List<UserMeal> mealList){
        Map<LocalDateTime, Integer> caloriesByDays = new HashMap<>();
        for (UserMeal userMeal :
                mealList) {
            caloriesByDays.put(userMeal.getDateTime().truncatedTo(ChronoUnit.DAYS), userMeal.getCalories() + caloriesByDays.getOrDefault(userMeal.getDateTime().truncatedTo(ChronoUnit.DAYS), 0));
        }
        return caloriesByDays;
    }

    public static Map<LocalDateTime, Integer> getCaloriesByDayStream(List<UserMeal> mealList){
        Map<LocalDateTime, Integer> caloriesByDays = mealList.stream()
                .collect(Collectors.groupingBy(p -> p.getDateTime().truncatedTo(ChronoUnit.DAYS), Collectors.summingInt(p -> p.getCalories())))
                ;
        System.out.println(caloriesByDays.values());
        return caloriesByDays;
    }
}
