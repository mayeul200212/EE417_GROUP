const barChartOptions = {
  series: [
      {
          data: [50, 90, 91, ],
      },
  ],
  chart: {
      type: 'bar',
      height: 350,
      toolbar: {
          show: true,
      },
  },
  colors: ['#246dec', '#cc3c43', '#367952', ],
  plotOptions: {
      bar: {
          distributed: true,
          borderRadius: 4,
          horizontal: false,
          columnWidth: '40%',
      },
  },
  dataLabels: {
      enabled: false,
  },
  legend: {
      show: true,
  },
  xaxis: {
      categories: ['Occupancy', 'Air Quality', 'Noise Level', ],
  },
  yaxis: {
      title: {
          text: 'Count%',
      },
  },
};

const barChart = new ApexCharts(
  document.querySelector('#bar-chart'),
  barChartOptions
);
barChart.render();


const areaChartOptions = {
  series: [
      {
          name: 'Noise Level',
          data: [31, 40, 28, 51, 42, 109,],
      },
      {
          name: 'Air Quality',
          data: [11, 32, 45, 32, 34, 52,],
      },
  ],
  chart: {
      height: 350,
      type: 'area',
      toolbar: {
          show: true,
      },
  },
  colors: ['#4f35a1', '#246dec'],
  dataLabels: {
      enabled: false,
  },
  stroke: {
      curve: 'smooth',
  },
  labels: ['01:00', '05:00', '09:00', '13:00', '18:00', ' 24:00', ],
  markers: {
      size: 0,
  },
  yaxis: [
      {
          title: {
              text: 'Noise Level dB',
          },
      },
      {
          opposite: true,
          title: {
              text: 'Air Quality %',
          },
      },
  ],
  tooltip: {
      shared: true,
      intersect: false,
  },
};

const areaChart = new ApexCharts(
  document.querySelector('#area-chart'),
  areaChartOptions
);
areaChart.render();


const roomData = [
  { id: 1, name: "S125", capacity: 100, airQuality: "90%", noiseLevel: "90 dB", occupancy: 50 },
  { id: 2, name: "S123", capacity: 100, airQuality: "85%", noiseLevel: "85 dB", occupancy: 40 },
  { id: 3, name: "S121", capacity: 100, airQuality: "88%", noiseLevel: "88 dB", occupancy: 60 }
];


function populateRoomNames() {
  try {
      const dropdown = document.getElementById('roomNamesDropdown');
      dropdown.innerHTML = '';
      roomData.forEach(room => {
          const option = document.createElement('option');
          option.textContent = room.name;
          option.value = room.id;
          dropdown.appendChild(option);
      });
  } catch (error) {
      console.error('Error populating room names:', error);
  }
}


async function updateRoomDetails(roomId) {
  try {
      const selectedRoom = roomData.find(room => room.id === parseInt(roomId));
      if (selectedRoom) {
          document.getElementById('roomCount').textContent = selectedRoom.name;
          document.getElementById('airQualityValue').textContent = selectedRoom.airQuality;
          document.getElementById('noiseLevelValue').textContent = selectedRoom.noiseLevel;
          document.getElementById('occupancy').textContent = selectedRoom.occupancy;

          // Update bar chart data
          const barChartData = [selectedRoom.occupancy, parseInt(selectedRoom.airQuality), parseInt(selectedRoom.noiseLevel)];
          updateBarChartData(barChartData);
      }
  } catch (error) {
      console.error('Error updating room details:', error);
  }
}


function updateBarChartData(data) {
  const newSeries = [{
      data: data
  }];
  barChart.updateOptions({
      series: newSeries
  });
}


document.getElementById('roomNamesDropdown').addEventListener('change', async function() {
  const selectedRoomId = this.value;
  await updateRoomDetails(selectedRoomId);
});


populateRoomNames();
