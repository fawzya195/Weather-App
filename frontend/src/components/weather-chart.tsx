import React from "react";
import { Bar } from "react-chartjs-2";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

interface WeatherChartProps {
  veryHot: number;
  cloud: number;
  rain: number;
}

export const WeatherChart: React.FC<WeatherChartProps> = ({ veryHot, cloud, rain }) => {
  const data = {
    labels: ["Very Hot", "Cloud", "Rain"],
    datasets: [
      {
        label: "النسبة %",
        data: [veryHot, cloud, rain],
        backgroundColor: ["#f87171", "#60a5fa", "#34d399"],
      },
    ],
  };

  return (
    <div className="p-4 border rounded-lg bg-white dark:bg-gray-800 mt-6">
      <h3 className="text-lg font-bold mb-3">Weather Probabilities</h3>
      <Bar data={data} />
    </div>
  );
};
