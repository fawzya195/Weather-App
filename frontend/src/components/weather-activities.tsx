// components/weather-activities.tsx
import { Card, CardContent } from "@/components/ui/card";
import {
  getSuggestedActivities,
  Activity as SuggestedActivity,
  WeatherData as UtilsWeatherData,
} from "@/lib/utils";

type WeatherActivitiesProps = {
  data: UtilsWeatherData | null;
};

export function WeatherActivities({ data }: WeatherActivitiesProps) {
  // 1) حماية لو الداتا لسه مش جاهزة
  console.log("WeatherActivities received data:", data);
  if (!data) {
    return (
      
      <Card>
        <div style={{ background: "yellow", padding: "20px" }}>
      <h2>Test WeatherActivities</h2>
    </div>

        <CardContent>
          <p className="text-gray-600">No weather data available yet.</p>
        </CardContent>
      </Card>
    );
  }

  // 2) للتأكد أثناء التطوير - شغّلي الكونسل لو محتاجة تتأكدي من الشكل
  // console.log("WeatherActivities - weather data:", data);

  // 3) نستخدم الفنكشن اللي في utils (الأنواع متوافقة لأننا استوردنا WeatherData)
  const activities: SuggestedActivity[] = getSuggestedActivities(data) ?? [];

  // 4) لو الفنكشن رجّع فاضي نعرض اقتراح افتراضي
  const listToShow = activities.length > 0 ? activities : [
    { activity: "Relaxing at home", reason: "The weather looks moderate — a calm day to relax." }
  ];

  return (
    <Card>
      <CardContent className="space-y-3">
        <h2 className="text-xl font-semibold">Suggested Activities</h2>
        <ul className="list-disc pl-5 space-y-2">
          {listToShow.map((item, index) => (
            <li key={index}>
              <span className="font-medium">{item.activity}:</span>{" "}
              <span className="text-gray-600">{item.reason}</span>
            </li>
          ))}
        </ul>
      </CardContent>
    </Card>
  );
}
