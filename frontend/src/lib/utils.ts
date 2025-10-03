import { clsx, type ClassValue } from "clsx"
import { twMerge } from "tailwind-merge"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}
// src/lib/utils.ts
export interface Activity {
  activity: string;
  reason: string;
}

export interface WeatherData {
  main: { temp: number; humidity: number };
  wind: { speed: number };
  // نضمن وجود 'main' لأن الفنكشن يستخدمها
  weather: { main: string; description?: string }[];
}

export function getSuggestedActivities(data: WeatherData): Activity[] {
  const activities: Activity[] = [];
  const temp = data.main?.temp ?? 0;
  const wind = data.wind?.speed ?? 0;
  const humidity = data.main?.humidity ?? 0;
  const weather = (data.weather?.[0]?.main || "").toLowerCase();

  if (weather.includes("clear")) {
    activities.push({ activity: "Walking in the park", reason: "Clear sky — great for outdoor activities." });
    activities.push({ activity: "Cycling", reason: "Nice weather for biking." });
  }

  if (weather.includes("rain")) {
    activities.push({ activity: "Read a book", reason: "Rainy — stay cozy inside." });
  }

  if (temp < 10) activities.push({ activity: "Hot drink", reason: "Low temp — warm up with a hot drink." });
  if (temp > 30) activities.push({ activity: "Swimming", reason: "High temp — swimming is refreshing." });
  if (wind > 15) activities.push({ activity: "Kite flying", reason: "Windy — good for kite flying." });
  if (humidity > 80) activities.push({ activity: "Indoor board games", reason: "High humidity — better indoors." });

  return activities;
}
